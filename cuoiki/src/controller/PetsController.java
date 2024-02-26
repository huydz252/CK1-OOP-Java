package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale.Category;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.AdminLogin;
import view.Billing;
import view.Customer;
import view.Login;
import view.Pets;
import view.User;

public class PetsController implements ActionListener, MouseListener {

	private Pets pets;
	private AdminLogin adminLogin;
	Connection con = null;
    PreparedStatement pst = null;
	
	public PetsController(Pets pets) {
		super();
		this.pets = pets;
		adminLogin = new AdminLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Edit")) {
			if (pets.textFieldName.getText().isEmpty() || pets.comboBoxCategory.getSelectedItem() == null 
    				|| pets.textFieldQuantity.getText().isEmpty() || pets.textFieldPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pets, "Missing Infomation");
            } else {
                try {
                    String userName = "root";
                    String passWord = "";
                    String databaseName = "petshopdb";
                    String url = "jdbc:mysql://localhost/" + databaseName;

                    con = DriverManager.getConnection(url, userName, passWord);

                    PreparedStatement edit = con.prepareStatement("UPDATE pettbl set PName=?, PCat=?, PQty=?, PPrice=? where PId =?");                    
                    edit.setString(1, pets.textFieldName.getText()); 
                    edit.setString(2, String.valueOf(pets.comboBoxCategory.getSelectedItem().toString()));
                    edit.setInt(3, Integer.valueOf(pets.textFieldQuantity.getText()));
                    edit.setInt(4, Integer.valueOf(pets.textFieldPrice.getText()));
                    edit.setInt(5, key);

                    int rowchange = edit.executeUpdate();
                    if (rowchange > 0) {
                        JOptionPane.showMessageDialog(pets, "Pets Edited");
                    } else {
                        JOptionPane.showMessageDialog(pets, "Pets can be Editted");
                    }
                    pets.clear();
                    pets.displayPets();
	                con.close();

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(pets, e2);
                }
            }
		}else if (cm.equals("Save")) {
            if (pets.textFieldName.getText().isEmpty() || pets.comboBoxCategory.getSelectedItem() == null 
    				|| pets.textFieldQuantity.getText().isEmpty() || pets.textFieldPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pets, "Missing Infomation");
            } else {
                try {
                    String userName = "root";
                    String passWord = "";
                    String databaseName = "petshopdb";
                    String url = "jdbc:mysql://localhost/" + databaseName;

                    con = DriverManager.getConnection(url, userName, passWord);
                    
                    PreparedStatement getMaxID = con.prepareStatement("SELECT MAX(PId) FROM pettbl");
                    ResultSet rs = getMaxID.executeQuery();
                    int maxID = 0;
                    if (rs.next()) {
                        maxID = rs.getInt(1);
                    }
                    int newID = maxID + 1;
                    
                    PreparedStatement save = con.prepareStatement("INSERT INTO pettbl (PId, PName, PCat, PQty, PPrice) values (?, ?, ?, ?, ?)");                    
                    save.setInt(1, newID);
                    save.setString(2, pets.textFieldName.getText());
                    save.setString(3, String.valueOf(pets.comboBoxCategory.getSelectedItem().toString()));
                    save.setInt(4, Integer.valueOf(pets.textFieldQuantity.getText()));
                    save.setInt(5, Integer.valueOf(pets.textFieldPrice.getText()));
                    
                    int rowchange = save.executeUpdate();
                    if (rowchange > 0) {
                        JOptionPane.showMessageDialog(pets, "Pet Added");
                    } else {
                        JOptionPane.showMessageDialog(pets, "Pet can be Added");
                    }
                    pets.clear();
                    pets.displayPets();
	                con.close();

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(pets, e2);
                }
            }
        }else if (cm.equals("Delete")) {
        	if (pets.textFieldName.getText().isEmpty() || pets.comboBoxCategory.getSelectedItem() == null 
    				|| pets.textFieldQuantity.getText().isEmpty() || pets.textFieldPrice.getText().isEmpty()) {
                JOptionPane.showMessageDialog(pets, "Select a Pet");
                }else {
                    try {
                        String userName = "root";
                        String passWord = "";
                        String databaseName = "petshopdb";
                        String url = "jdbc:mysql://localhost/" + databaseName;

                        con = DriverManager.getConnection(url, userName, passWord);

                        PreparedStatement edit = con.prepareStatement("delete from Pettbl where PId = ?");
                        edit.setInt(1, key);               

                        int rowchange = edit.executeUpdate();
                        if (rowchange > 0) {
                            JOptionPane.showMessageDialog(pets, "Pets Deleted");
                        } else {
                            JOptionPane.showMessageDialog(pets, "Pets can be Deleted");
                        }
                        pets.clear();
                        pets.displayPets();
    	                con.close();

                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(pets, e2);
                    }
                }
    	}
	}
	
	int key = 0;
	int stock = 0;
	

	@Override
	public void mouseClicked(MouseEvent e) {
	  	    
	    if (e.getSource() == pets.lablePets) {
	    	new Pets().setVisible(true);
	    	pets.dispose();
	    	
        }else if (e.getSource() == pets.lableUser){
        	new AdminLogin().setVisible(true);
        	
        } else if (e.getSource() == pets.lableCustomers){
        	new Customer().setVisible(true);
        	pets.dispose();
        	
        }else if (e.getSource() == pets.lableBilling){
        	new Billing().setVisible(true);
        	pets.dispose();
        	
        }else if (e.getSource() == pets.lableLogout){
        	int select = JOptionPane.showConfirmDialog(pets, "Logout?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if(select == JOptionPane.NO_OPTION) {       		
        	}else {
        		
        		new Login().setVisible(true);
        		pets.dispose();
        	}
        }else if (e.getSource() == pets.lableCategoryClick){
        	new view.Category().setVisible(true);
        	pets.dispose();
        }else {
        	DefaultTableModel model = (DefaultTableModel) pets.tableProductList.getModel();
    	    int myIndex = pets.tableProductList.getSelectedRow();
    	    key = Integer.valueOf(model.getValueAt(myIndex, 0).toString());
    	    pets.textFieldName.setText(model.getValueAt(myIndex, 1).toString());
    	    String categoryValue = model.getValueAt(myIndex, 2).toString();
    	    setCategoryComboBox(categoryValue);
    	    pets.textFieldQuantity.setText(model.getValueAt(myIndex, 3).toString());
    	    pets.textFieldPrice.setText(model.getValueAt(myIndex, 4).toString()); 
        }
	    
	}

	// Phương thức để đặt mục đã chọn trong comboBoxCategory
	private void setCategoryComboBox(String categoryValue) {
	    for (int i = 0; i < pets.comboBoxCategory.getItemCount(); i++) {
	        Object item = pets.comboBoxCategory.getItemAt(i);
	        if (item.toString().equals(categoryValue)) {
	            pets.comboBoxCategory.setSelectedItem(item);
	            break;
	        }
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
