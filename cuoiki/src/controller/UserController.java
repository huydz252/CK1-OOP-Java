package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.AdminLogin;
import view.Billing;
import view.Customer;
import view.Login;
import view.Pets;
import view.User;

public class UserController implements ActionListener, MouseListener {
    User user;
    AdminLogin adminLogin;
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;

    public UserController(User user) {
        super();
        this.user = user;
        this.adminLogin = new AdminLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        
        if (cm.equals("Edit")) {
            if (user.textFieldUserName.getText().isEmpty() || user.textFieldPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(user, "Missing Infomation");
            } else {
                try {
                    String userName = "root";
                    String passWord = "";
                    String databaseName = "petshopdb";
                    String url = "jdbc:mysql://localhost/" + databaseName;

                    con = DriverManager.getConnection(url, userName, passWord);

                    PreparedStatement edit = con.prepareStatement("UPDATE usertbl set UName=?, UPass=? where UId=?");
                    
                    edit.setString(1, user.textFieldUserName.getText());
                    edit.setString(2, user.textFieldPassword.getText());
                    edit.setInt(3, key);

                    int rowchange = edit.executeUpdate();
                    if (rowchange > 0) {
                        JOptionPane.showMessageDialog(user, "User Edited");
                    } else {
                        JOptionPane.showMessageDialog(user, "User can be Editted");
                    }
                    user.clear();
                    user.displayUser();
	                con.close();

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(user, e2);
                }
            }
        }

        else if (cm.equals("Save")) {
            if (user.textFieldUserName.getText().isEmpty() || user.textFieldPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(user, "Missing Infomation");
            } else {
                try {
                    String userName = "root";
                    String passWord = "";
                    String databaseName = "petshopdb";
                    String url = "jdbc:mysql://localhost/" + databaseName;

                    con = DriverManager.getConnection(url, userName, passWord);

                    PreparedStatement getMaxID = con.prepareStatement("SELECT MAX(UId) FROM usertbl");
                    ResultSet rs = getMaxID.executeQuery();
                    int maxID = 0;
                    if (rs.next()) {
                        maxID = rs.getInt(1);
                    }
                    int newID = maxID + 1;

                    PreparedStatement save = con.prepareStatement("INSERT into usertbl (UId, UName, UPass) values (?, ?, ?)");
                    save.setInt(1, newID);
                    save.setString(2, user.textFieldUserName.getText());
                    save.setString(3, user.textFieldPassword.getText());

                    int rowchange = save.executeUpdate();
                    if (rowchange > 0) {
                        JOptionPane.showMessageDialog(user, "User Added");
                    } else {
                        JOptionPane.showMessageDialog(user, "Select a User");
                    }
                    user.clear();
                    user.displayUser();
                    con.close();
                    rs.close();
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(user, e2);
                }
            }
        }
        else if (cm.equals("Delete")) {
	    	if (key == -1) {
	    		JOptionPane.showMessageDialog(user, "Select a User");
	    	}else {
	    		try {
	    			String userName = "root";
	                String passWord = "";
	                String databaseName = "petshopdb";
	                String url = "jdbc:mysql://localhost/" + databaseName;

	                con = DriverManager.getConnection(url, userName, passWord);

	                PreparedStatement delete = con.prepareStatement("DELETE from usertbl where UId=?");
	                
	                delete.setInt(1, key);                
	                
	                int soDongBiAnhHuong = delete.executeUpdate();
	                if (soDongBiAnhHuong > 0) {
	                    JOptionPane.showMessageDialog(user, "User deleted");
	                } else {
	                    JOptionPane.showMessageDialog(user, "Select a User");
	                }
	                user.clear();
	                user.displayUser();
	                con.close();
	            } catch (Exception e2) {
	                JOptionPane.showMessageDialog(user, e2);
	            }
	    	}
	    }
    }

    int key = 0;
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		 if (e.getSource() == user.lablePets) {
		    	new Pets().setVisible(true);
		    	user.dispose();
		    	
	        }else if (e.getSource() == user.lableUser){
	        	new User().setVisible(true);
	        	user.dispose();
	        	
	        } else if (e.getSource() == user.lableCustomers){
	        	new Customer().setVisible(true);
	        	user.dispose();
	        	
	        }else if (e.getSource() == user.lableBilling){
	        	new Billing().setVisible(true);
	        	user.dispose();
	        	
	        }else if (e.getSource() == user.lableLogout){
	        	int select = JOptionPane.showConfirmDialog(user, "Logout?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        	if(select == JOptionPane.NO_OPTION) {       		
	        	}else {
	        		new Login().setVisible(true);
	        		user.dispose();
	        		
	        	}
	        }else {
	        	DefaultTableModel model = (DefaultTableModel) user.tableUserList.getModel();
	    		int myIndex = user.tableUserList.getSelectedRow();
	    		key = Integer.valueOf(model.getValueAt(myIndex, 0).toString());
	    		user.textFieldUserName.setText(model.getValueAt(myIndex, 1).toString());
	    		user.textFieldPassword.setText(model.getValueAt(myIndex, 2).toString());
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
