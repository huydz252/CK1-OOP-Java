package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.AdminLogin;
import view.Billing;
import view.Customer;
import view.Login;
import view.Pets;
import view.User;

public class BillController implements ActionListener, MouseListener {

    private static final int ID_COLUMN_INDEX = 0;

	public Billing bill;
	private AdminLogin adminLogin;

    Connection con = null;
    PreparedStatement pst = null;

    public BillController(Billing billing) {
        super();
        this.bill = billing;
        adminLogin = new AdminLogin();
    }

    int n = 1;
    int row = 1;
    double total = 0;

    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        if (cm.equals("Add to Bill")) {
            if(bill.textFieldPrice.getText().isEmpty() || bill.textFieldProduct.getText().isEmpty() || bill.textFieldQuantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(bill, "Fill in all fields");
            } else {
                DefaultTableModel model = (DefaultTableModel) bill.tableCutomerBill.getModel();
                DefaultTableModel productListModel = (DefaultTableModel) bill.tableProductList.getModel(); // Thêm dòng này để lấy thông tin sản phẩm từ bảng danh sách sản phẩm

                int selectedProductIndex = bill.tableProductList.getSelectedRow(); // Lấy hàng được chọn từ bảng danh sách sản phẩm
                if (selectedProductIndex != -1) {
                    int productId = Integer.parseInt(productListModel.getValueAt(selectedProductIndex, 0).toString()); // Lấy ID sản phẩm từ bảng danh sách sản phẩm
                    int quantity = Integer.parseInt(bill.textFieldQuantity.getText());
                    model.addRow(new Object[] { n, bill.textFieldProduct.getText(), bill.textFieldQuantity.getText(),
                            bill.textFieldQuantity.getText(), bill.textFieldPrice.getText(), "" });
                    row++;

                    // Gọi phương thức updateQuantity để giảm số lượng sản phẩm trong cơ sở dữ liệu
                    updateQuantity(productId, quantity);
                } else {
                    JOptionPane.showMessageDialog(bill, "Please select a product from the list.");
                }
                n++;

                // Tính tổng giá các mặt hàng trong tableCustomerBill
                int rowCount = model.getRowCount();
                total = 0.0;
                for (int i = 0; i < rowCount; i++) {
                    String price = model.getValueAt(i, 4).toString();
                    String quantity = model.getValueAt(i, 3).toString();
                    total += Double.parseDouble(price) * Double.parseDouble(quantity);
                }

                // Hiển thị tổng giá trên labelTotal
                String totalFormatted = String.format("%.2f", total); // Định dạng số với 2 chữ số thập phân
                bill.lableTotal.setText("Total: " + totalFormatted);
            }   
            
        }else if(cm.equals("Reset")) {
        	bill.textFieldProduct.setText("");
        	bill.textFieldPrice.setText("");
        	bill.textFieldQuantity.setText("");
        	bill.comboboxUserID.setSelectedIndex(-1);
        	bill.comboboxCustomer.setSelectedIndex(-1);
        	bill.dateChooser.setDate(null);
        }else if (cm.equals("Print")) {
            try {
                bill.tableCutomerBill.print();
            } catch (PrinterException e1) {
                e1.printStackTrace();
            }
        } else if (cm.equals("Save")) {
            if (bill.comboboxUserID.getSelectedIndex() == -1 || bill.comboboxCustomer.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(bill, "Missing Infomation");
            } else {
                try {
                    String userName = "root";
                    String passWord = "";
                    String databaseName = "petshopdb";
                    String url = "jdbc:mysql://localhost/" + databaseName;

                    con = DriverManager.getConnection(url, userName, passWord);

                    PreparedStatement getMaxID = con.prepareStatement("SELECT MAX(Bnum) FROM billtbl");
                    ResultSet rs = getMaxID.executeQuery();

                    int maxID = 0;
                    if (rs.next()) {
                        maxID = rs.getInt(1);
                    }
                    int newID = maxID + 1;

                    PreparedStatement save = con.prepareStatement(
                    	"INSERT INTO billtbl (BNum, BDate, CustId, UId, Amt) values (?, ?, ?, ?, ?)");
                    save.setInt(1, newID);
                    save.setString(2, bill.dateChooser.getDate().toString());
                    save.setInt(3, Integer.valueOf(bill.comboboxCustomer.getSelectedItem().toString()));
                    save.setInt(4, Integer.valueOf(bill.comboboxUserID.getSelectedItem().toString()));
                    save.setDouble(5, total);

                    int rowchange = save.executeUpdate();
                    if (rowchange > 0) {
                        JOptionPane.showMessageDialog(bill, "Bill Save");
                    } else {
                        JOptionPane.showMessageDialog(bill, "Bill can be Save");
                    }
                    bill.clear();
                    con.close(); 
                    bill.displayProductList();

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(bill, e2);
                }
            }
        }else if(cm.equals("Delete")) {
        	DefaultTableModel model = (DefaultTableModel) bill.tableCutomerBill.getModel();
        	int selectedRowIndex = bill.tableCutomerBill.getSelectedRow();
        	if (selectedRowIndex >= 0) {
        	    model.removeRow(selectedRowIndex);
        	} else {     
        	    JOptionPane.showMessageDialog(bill, "Please select the row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        }
    }

    public void updateQuantity(int productId, int quantity) {
        try {
            String userName = "root";
            String password = "";
            String databaseName = "petshopdb";
            String url = "jdbc:mysql://localhost/" + databaseName;

            con = DriverManager.getConnection(url, userName, password);

            // Lấy số lượng hiện tại từ cơ sở dữ liệu
            PreparedStatement getQuantity = con.prepareStatement("SELECT PQty FROM pettbl WHERE PId = ?");
            getQuantity.setInt(1, productId);
            ResultSet rs = getQuantity.executeQuery();

            int currentQuantity = 0;
            if (rs.next()) {
                currentQuantity = rs.getInt("PQty");
            }

            // Cập nhật số lượng mới (trừ đi số lượng đơn hàng đã thêm vào)
            int updatedQuantity = currentQuantity - quantity;

            // Kiểm tra nếu số lượng mới âm hoặc bằng 0
            if (updatedQuantity < 0) {
                JOptionPane.showMessageDialog(bill, "This item is temporarily out of stock");
                // Không thực hiện cập nhật số lượng trong trường hợp số lượng mới là âm hoặc bằng 0
                DefaultTableModel model = (DefaultTableModel) bill.tableCutomerBill.getModel();
                int rowCount = model.getRowCount();

                int maxID = -1;
                int rowIndexToDelete = -1;

                // Tìm hàng có ID cao nhất
                for (int i = 0; i < rowCount; i++) {
                    int currentID = Integer.parseInt(model.getValueAt(i, ID_COLUMN_INDEX).toString());
                    if (currentID > maxID) {
                        maxID = currentID;
                        rowIndexToDelete = i;
                    }
                }

                if (rowIndexToDelete != -1) {
                    // Xóa hàng có ID cao nhất từ TableModel
                    model.removeRow(rowIndexToDelete);
                } else {
                    // Không tìm thấy hàng nào
                    System.out.println("Không tìm thấy hàng nào để xóa.");
                }
            } else {
                // Update số lượng trong cơ sở dữ liệu
                PreparedStatement updateStmt = con.prepareStatement("UPDATE pettbl SET PQty = ? WHERE PId = ?");
                updateStmt.setInt(1, updatedQuantity);
                updateStmt.setInt(2, productId);
                updateStmt.executeUpdate();
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(bill, e);
        }
    }


    int key = 0;
    int stock = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
    	 if (e.getSource() == bill.lablePets || e.getSource() == bill.icon2 ) {
 	    	new Pets().setVisible(true);
 	    	bill.dispose();
 	    	
         }else if (e.getSource() == bill.lableUser){
         	new AdminLogin().setVisible(true);
         	
         } else if (e.getSource() == bill.lableCustomers){
         	new Customer().setVisible(true);
         	bill.dispose();
         	
         }else if (e.getSource() == bill.lableBilling){
         	new Billing().setVisible(true);
         	bill.dispose();
         	
         }else if (e.getSource() == bill.lableLogout){
        	int select = JOptionPane.showConfirmDialog(bill, "Logout?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if(select == JOptionPane.NO_OPTION) {       		
        	}else {
        	
        		new Login().setVisible(true);
        		bill.dispose();
        	}         	
         }else {
        	 DefaultTableModel model = (DefaultTableModel) bill.tableProductList.getModel();
             int myIndex = bill.tableProductList.getSelectedRow();
             key = Integer.valueOf(model.getValueAt(myIndex, 0).toString());
             bill.textFieldProduct.setText(model.getValueAt(myIndex, 1).toString());
             bill.comboboxCustomer.setSelectedItem(model.getValueAt(myIndex, 2).toString());
             // bill.textFieldQuantity.setText(model.getValueAt(myIndex, 3).toString());
             bill.textFieldPrice.setText(model.getValueAt(myIndex, 4).toString());
         }
    	
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
