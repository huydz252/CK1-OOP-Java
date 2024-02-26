package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import view.AdminLogin;
import view.Login;
import view.Pets;
import view.User;

public class LoginController implements ActionListener, MouseListener{
	private Login login;
	AdminLogin adminLogin;
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	public LoginController(Login login) {
		super();
		this.login = login;
		adminLogin = new AdminLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Login")) {
			if (login.textFieldUserName.getText().isEmpty() || login.textFieldPassword.getText().isEmpty()) {
				JOptionPane.showMessageDialog(login, "Missing Infomation!");
			}else {
				
				String query = "select * from usertbl where Uname = '" + login.textFieldUserName.getText()+"' and Upass = '" + login.textFieldPassword.getText() + "'";
				try {
					String userName = "root";
	                String passWord = "";
	                String databaseName = "petshopdb";
	                String url = "jdbc:mysql://localhost/" + databaseName;

	                con = DriverManager.getConnection(url, userName, passWord);
	                st = con.createStatement();
	                rs = st.executeQuery(query);
	                
	                if (rs.next() == true) {
	    				
	                	new Pets().setVisible(true);
	                	login.dispose();
	                }else {
	                	JOptionPane.showMessageDialog(login, "Wrong UserName or Password!");
	                	login.textFieldUserName.setText("");
	                	login.textFieldPassword.setText("");
	                }
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(login, e);
				}
			}
		}else if (cm.equals("Admin")) {
			new AdminLogin().setVisible(true);
			login.dispose();
			
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
