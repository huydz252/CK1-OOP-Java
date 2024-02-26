package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldUserName;
	public JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		this.setTitle("Login");
		
		LoginController act = new LoginController(this);
		
		setTitle("PetShop");
		setBounds(350, 150, 829, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 342, 476);
		contentPane.add(panel);
		panel.setLayout(null);
	    
	    JLabel lableBestPlace = new JLabel("BEST PLACE");
	    lableBestPlace.setFont(new Font("YouYuan", Font.BOLD, 25));
	    lableBestPlace.setBounds(105, 256, 140, 47);
	    panel.add(lableBestPlace);
	    
	    JLabel lableBestService = new JLabel("BEST SERVICE");
	    lableBestService.setFont(new Font("YouYuan", Font.BOLD, 25));
	    lableBestService.setBounds(92, 313, 169, 47);
	    panel.add(lableBestService);
	    
	    JLabel lableBestPrice = new JLabel("BEST PRICE");
	    lableBestPrice.setFont(new Font("YouYuan", Font.BOLD, 25));
	    lableBestPrice.setBounds(105, 370, 140, 47);
	    panel.add(lableBestPrice);
		
		JLabel lblNewLabel_1 = new JLabel("Heaven Care PetShop ");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblNewLabel_1.setBounds(449, 10, 275, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lableUserName = new JLabel("User Name");
		lableUserName.setForeground(new Color(255, 255, 255));
		lableUserName.setBackground(new Color(255, 255, 255));
		lableUserName.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableUserName.setBounds(375, 264, 140, 36);
		contentPane.add(lableUserName);
		
		JLabel lablePassword = new JLabel("Password");
		lablePassword.setForeground(new Color(255, 255, 255));
		lablePassword.setFont(new Font("YouYuan", Font.BOLD, 25));
		lablePassword.setBounds(375, 354, 140, 36);
		contentPane.add(lablePassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldUserName.setBounds(375, 295, 206, 36);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 20));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(375, 385, 206, 36);
		contentPane.add(textFieldPassword);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(act);
		buttonLogin.setForeground(Color.RED);
		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonLogin.setBounds(636, 316, 131, 47);
		contentPane.add(buttonLogin);
		
		JButton buttonAdmin = new JButton("Admin");
		buttonAdmin.addActionListener(act);
		buttonAdmin.setForeground(Color.RED);
		buttonAdmin.setFont(new Font("Tahoma", Font.ITALIC, 15));
		buttonAdmin.setBounds(663, 374, 81, 27);
		contentPane.add(buttonAdmin);
	    
		JLabel lablePetShop = new JLabel("");
		lablePetShop.setIcon(new ImageIcon("C:\\Users\\TGDD\\Downloads\\pet-shop.png"));
		// Kích thước mới cho icon
		int labelWidthPS = 200;
		int labelHeightPS = 158;
		ImageIcon iconPS = (ImageIcon) lablePetShop.getIcon();
		Image imgPS = iconPS.getImage();
		Image newImgPS = imgPS.getScaledInstance(labelWidthPS, labelHeightPS, Image.SCALE_SMOOTH);
		ImageIcon newIconPS = new ImageIcon(newImgPS);
		lablePetShop.setIcon(newIconPS);
		lablePetShop.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lablePetShop.setBounds(74, 77, labelWidthPS, labelHeightPS);
		panel.add(lablePetShop);
		
		JLabel lblNewLabel_2 = new JLabel(" |");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(312, 10, 38, 69);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" |");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_1.setBounds(312, 50, 38, 69);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel(" |");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_2.setBounds(312, 89, 38, 69);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel(" |");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_3.setBounds(312, 129, 38, 69);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel(" |");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_4.setBounds(312, 168, 38, 69);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel(" |");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_5.setBounds(312, 208, 38, 69);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel(" |");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_6.setBounds(312, 247, 38, 69);
		panel.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel(" |");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_7.setBounds(312, 276, 38, 69);
		panel.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel(" |");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_8.setBounds(312, 370, 38, 69);
		panel.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_9 = new JLabel(" |");
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_9.setBounds(312, 355, 38, 69);
		panel.add(lblNewLabel_2_9);
		
		JLabel lblNewLabel_2_10 = new JLabel(" |");
		lblNewLabel_2_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_10.setBounds(312, 407, 38, 69);
		panel.add(lblNewLabel_2_10);
		
		JLabel lblNewLabel_2_11 = new JLabel(" |");
		lblNewLabel_2_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_11.setBounds(312, 407, 38, 69);
		panel.add(lblNewLabel_2_11);
		
		JLabel lblNewLabel_2_12 = new JLabel(" |");
		lblNewLabel_2_12.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_12.setBounds(312, 333, 38, 69);
		panel.add(lblNewLabel_2_12);
		
		JLabel lblNewLabel_2_13 = new JLabel(" |");
		lblNewLabel_2_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_13.setBounds(312, 230, 38, 69);
		panel.add(lblNewLabel_2_13);
		
		JLabel lblNewLabel_2_14 = new JLabel(" |");
		lblNewLabel_2_14.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_14.setBounds(312, 194, 38, 69);
		panel.add(lblNewLabel_2_14);
		
		JLabel lblNewLabel_2_15 = new JLabel(" |");
		lblNewLabel_2_15.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_15.setBounds(312, 153, 38, 69);
		panel.add(lblNewLabel_2_15);
		
		JLabel lblNewLabel_2_16 = new JLabel(" |");
		lblNewLabel_2_16.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_16.setBounds(312, 114, 38, 69);
		panel.add(lblNewLabel_2_16);
		
		JLabel lblNewLabel_2_17 = new JLabel(" |");
		lblNewLabel_2_17.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_17.setBounds(312, 77, 38, 69);
		panel.add(lblNewLabel_2_17);
		
		JLabel lblNewLabel_2_18 = new JLabel(" |");
		lblNewLabel_2_18.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_18.setBounds(312, 29, 38, 69);
		panel.add(lblNewLabel_2_18);
		
		JLabel lblNewLabel_2_19 = new JLabel(" |");
		lblNewLabel_2_19.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_19.setBounds(312, 0, 38, 69);
		panel.add(lblNewLabel_2_19);
		
		JLabel lblNewLabel_2_20 = new JLabel(" |");
		lblNewLabel_2_20.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_20.setBounds(312, -14, 38, 69);
		panel.add(lblNewLabel_2_20);
		
		JLabel lblNewLabel_2_21 = new JLabel(" |");
		lblNewLabel_2_21.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21.setBounds(312, 311, 38, 69);
		panel.add(lblNewLabel_2_21);

	    
	    JLabel lableLogin = new JLabel("");
	    ImageIcon iconLG = new ImageIcon("C:\\Users\\TGDD\\Downloads\\enter.png");
		// Lấy kích thước của JLabel
		int labelWidthLG = 180;
		int labelHeightLG = 154;
		// Lấy kích thước của icon
		Image img = iconLG.getImage();
		Image newImgLG = img.getScaledInstance(labelWidthLG, labelHeightLG, Image.SCALE_SMOOTH);	
		// Tạo một ImageIcon mới từ ảnh đã thay đổi kích thước
		ImageIcon newIconLG = new ImageIcon(newImgLG);	
		lableLogin.setIcon(newIconLG);
		lableLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lableLogin.setBounds(477, 78, labelWidthLG, labelHeightLG);
		contentPane.add(lableLogin);


	

	    
	    
	}
}
