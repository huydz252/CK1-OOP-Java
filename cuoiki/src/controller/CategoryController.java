package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.AdminLogin;
import view.Billing;
import view.Category;
import view.Customer;
import view.Login;
import view.Pets;
import view.User;

public class CategoryController implements ActionListener, MouseListener{
	private Category category;
	private AdminLogin adminLogin;
	
	Connection con = null;
    PreparedStatement pst = null;
	
	public CategoryController(Category category) {
		super();
		this.category = category;
		adminLogin = new AdminLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		 if (cm.equals("Edit")) {
	            if (category.textFieldName.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(category, "Missing Infomation");
	            } else {
	                try {
	                    String userName = "root";
	                    String passWord = "";
	                    String databaseName = "petshopdb";
	                    String url = "jdbc:mysql://localhost/" + databaseName;

	                    con = DriverManager.getConnection(url, userName, passWord);

	                    PreparedStatement edit = con.prepareStatement("UPDATE categorytbl set CatDes=? where CatId=?");
	                    
	                    edit.setString(1, category.textFieldName.getText());                   
	                    edit.setInt(2, key);

	                    int rowchange = edit.executeUpdate();
	                    if (rowchange > 0) {
	                        JOptionPane.showMessageDialog(category, "Category Edited");
	                    } else {
	                        JOptionPane.showMessageDialog(category, "Category can be Editted");
	                    }
	                    category.clear();
	                    category.displayCategory();
		                con.close();

	                } catch (Exception e2) {
	                    JOptionPane.showMessageDialog(category, e2);
	                }
	            }
	        }else if (cm.equals("Save")) {
	            if (category.textFieldName.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(category, "Missing Infomation");
	            } else {
	                try {
	                    String userName = "root";
	                    String passWord = "";
	                    String databaseName = "petshopdb";
	                    String url = "jdbc:mysql://localhost/" + databaseName;

	                    con = DriverManager.getConnection(url, userName, passWord);
	                    
	                    PreparedStatement getMaxID = con.prepareStatement("SELECT MAX(CatId) FROM categorytbl");
	                    ResultSet rs = getMaxID.executeQuery();
	                    int maxID = 0;
	                    if (rs.next()) {
	                        maxID = rs.getInt(1);
	                    }
	                    int newID = maxID + 1;
	                    
	                    PreparedStatement save = con.prepareStatement("INSERT INTO categorytbl (CatId, CatDes) values (?, ?)");                    
	                    save.setInt(1, newID);
	                    save.setString(2, category.textFieldName.getText());                   
	                    
	                    int rowchange = save.executeUpdate();
	                    if (rowchange > 0) {
	                        JOptionPane.showMessageDialog(category, "Category Added");
	                    } else {
	                        JOptionPane.showMessageDialog(category, "Category can be Added");
	                    }
	                    category.clear();
	                    category.displayCategory();
		                con.close();

	                } catch (Exception e2) {
	                    JOptionPane.showMessageDialog(category, e2);
	                }
	            }
	        }else if (cm.equals("Delete")) {
	            if (category.textFieldName.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(category, "Select a Category");
	            } else {
	                try {
	                    String userName = "root";
	                    String passWord = "";
	                    String databaseName = "petshopdb";
	                    String url = "jdbc:mysql://localhost/" + databaseName;

	                    con = DriverManager.getConnection(url, userName, passWord);

	                    PreparedStatement delete = con.prepareStatement("delete from categorytbl where CatId=?");              
	                    delete.setInt(1, key);

	                    int rowchange = delete.executeUpdate();
	                    if (rowchange > 0) {
	                        JOptionPane.showMessageDialog(category, "Category deleted");
	                    } else {
	                        JOptionPane.showMessageDialog(category, "Category cant be deleted");
	                    }
	                    category.clear();
	                    category.displayCategory();
		                con.close();

	                } catch (Exception e2) {
	                    JOptionPane.showMessageDialog(category, e2);
	                }
	            }
	}
}	
	int key = 0;
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		if (e.getSource() == category.labelPets) {
	    	new Pets().setVisible(true);
	    	category.dispose();
	    	
        }else if (e.getSource() == category.labelUser){
        	new AdminLogin().setVisible(true);
        	
        } else if (e.getSource() == category.labelCustomers){
        	new Customer().setVisible(true);
        	category.dispose();
        	
        }else if (e.getSource() == category.labelBilling){
        	new Billing().setVisible(true);
        	category.dispose();
        	
        }else if (e.getSource() == category.labelLogout){
        	int select = JOptionPane.showConfirmDialog(category, "Logout?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if(select == JOptionPane.NO_OPTION) {       		
        	}else {        		
        		new Login().setVisible(true);
        		category.dispose();
        	}
        }else {
        	DefaultTableModel model = (DefaultTableModel) category.tableCategoryList.getModel();
    		int myIndex = category.tableCategoryList.getSelectedRow();
    		key = Integer.valueOf(model.getValueAt(myIndex, 0).toString());
    		category.textFieldName.setText(model.getValueAt(myIndex, 1).toString());
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