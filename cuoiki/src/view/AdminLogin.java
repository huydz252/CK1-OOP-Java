package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AdminLoginController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AdminLogin extends JFrame {
	private AdminLoginController controller;

	public AdminLoginController getController() {
		return controller;
	}

	public void setController(AdminLoginController controller) {
		this.controller = controller;
	}

	public AdminLogin(AdminLoginController controller) throws HeadlessException {
		super();
		this.controller = controller;
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		this.setTitle("Admin Login");
		this.setLocationRelativeTo(null);
		
		AdminLoginController act = new AdminLoginController(this, null);
		
		setBounds(450, 200, 694, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 680, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("                    Admin Login");
		lblAdminLogin.setBackground(new Color(0, 153, 255));
		lblAdminLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 40));
		lblAdminLogin.setBounds(0, 0, 680, 117);
		panel.add(lblAdminLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Heaven Care PetShop ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(208, 153, 269, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton buttonEdit = new JButton("Login");
		buttonEdit.addActionListener(act);
		buttonEdit.setForeground(Color.RED);
		buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonEdit.setBounds(409, 532, 103, 35);
		contentPane.add(buttonEdit);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password\r\n");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(279, 208, 122, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 20));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(219, 254, 240, 36);
		contentPane.add(textFieldPassword);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(act);
		buttonLogin.setForeground(Color.RED);
		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonLogin.setBounds(218, 300, 103, 35);
		contentPane.add(buttonLogin);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(act);
		buttonBack.setForeground(Color.RED);
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonBack.setBounds(356, 300, 103, 35);
		contentPane.add(buttonBack);
	}
}
