package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.AdminLogin;
import view.Login;
import view.User;

public class AdminLoginController implements ActionListener{
	private AdminLogin adminLogin;
	
	public AdminLoginController(AdminLogin adminLogin, JFrame previousFrame) {
		super();
		this.adminLogin = adminLogin;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Login")) {
			
			if(adminLogin.textFieldPassword.getText().isEmpty()) {
				JOptionPane.showMessageDialog(adminLogin, "Enter Admin Password");				
			}else {				
				if(adminLogin.textFieldPassword.getText().equals("huydeptrai")) {
					new User().setVisible(true);
					adminLogin.dispose();
				}else {
					JOptionPane.showMessageDialog(adminLogin, "Wrong Admin Password ");
				}
			}			
		}else if (cm.equals("Back")) {
			new Login().setVisible(true);
			adminLogin.dispose();
		}
	}	
}
