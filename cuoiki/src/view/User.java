package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.UserController;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textFieldUserName;
	public JTextField textFieldPassword;
	public JTable tableUserList;
	private Connection con;
	public JLabel lablePets;
	public JLabel lableUser;
	public JLabel lableCustomers;
	public JLabel lableBilling;
	public JLabel lableLogout;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		this.setTitle("User");
		
		UserController act = new UserController(this);
		
		setBounds(210, 90, 1111, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(264, 0, 833, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lableManageUser = new JLabel("Manage User");
		lableManageUser.setBackground(new Color(255, 255, 255));
		lableManageUser.setForeground(new Color(0, 0, 0));
		lableManageUser.setBounds(10, 10, 173, 28);
		lableManageUser.setFont(new Font("YouYuan", Font.BOLD, 25));
		panel.add(lableManageUser);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblName.setBounds(239, 58, 149, 28);
		panel.add(lblName);
		
		JLabel lablePasword = new JLabel("Password");
		lablePasword.setForeground(new Color(255, 255, 255));
		lablePasword.setFont(new Font("YouYuan", Font.BOLD, 25));
		lablePasword.setBounds(413, 58, 122, 28);
		panel.add(lablePasword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldUserName.setBounds(239, 83, 149, 28);
		panel.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(413, 83, 149, 28);
		panel.add(textFieldPassword);
		
		JButton buttonSave = new JButton("Save");
		buttonSave.addActionListener(act);
		buttonSave.setForeground(Color.RED);
		buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSave.setBounds(340, 144, 103, 35);
		panel.add(buttonSave);
		
		JButton buttonEdit = new JButton("Edit");
		buttonEdit.addActionListener(act);
		buttonEdit.setForeground(Color.RED);		
		buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonEdit.setBounds(188, 144, 103, 35);
		panel.add(buttonEdit);
		
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.addActionListener(act);
		buttonDelete.setForeground(Color.RED);			
		buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonDelete.setBounds(489, 144, 103, 35);
		panel.add(buttonDelete);
		
		JLabel lableProductList = new JLabel("User List");
		lableProductList.setFont(new Font("YouYuan", Font.BOLD | Font.ITALIC, 25));
		lableProductList.setBounds(319, 201, 143, 28);
		panel.add(lableProductList);	
		
		tableUserList = new JTable();
		tableUserList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableUserList.addMouseListener(act);
		tableUserList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Password"
			}
		));
		JScrollPane scrollPane = new JScrollPane(tableUserList);
		scrollPane.setBounds(10, 239, 813, 371);
		panel.add(scrollPane);

		JLabel icon1 = new JLabel("");
		icon1.setIcon(new ImageIcon("C:\\Users\\TGDD\\Downloads\\customer-support.png"));
		// Kích thước mới cho icon
		int labelWidth1 = 156;
		int labelHeight1 = 150;
		ImageIcon icon = (ImageIcon) icon1.getIcon();
		Image img1 = icon.getImage();
		Image newImg1 = img1.getScaledInstance(labelWidth1, labelHeight1, Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
		icon1.setIcon(newIcon1);
		icon1.setForeground(new Color(0, 0, 0));
		icon1.setBounds(49, 10, 156, 150);
		contentPane.add(icon1);

				
		JLabel icon2 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\TGDD\\Downloads\\pets.png");
		Image image2 = imageIcon.getImage();
		Image newImage2 = image2.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newImage2);
		icon2.setIcon(newIcon2);
		icon2.setBounds(10, 184, 95, 70);
		contentPane.add(icon2);
	
		JLabel icon3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\customer-support.png");
		Image image3 = imageIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImage3);
		icon3.setIcon(newIcon3);
		icon3.setBounds(10, 265, 95, 70);
		contentPane.add(icon3);
	
		JLabel icon4 = new JLabel("");
		ImageIcon imageIcon4 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\user.png");
		Image image4 = imageIcon4.getImage();
		Image newImage4 = image4.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newImage4);
		icon4.setIcon(newIcon4);
		icon4.setBounds(10, 360, 95, 70);
		contentPane.add(icon4);
					
		JLabel icon5 = new JLabel("");
		ImageIcon imageIcon5 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\invoice.png");
		Image image5 = imageIcon5.getImage();
		Image newImage5 = image5.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon5 = new ImageIcon(newImage5);
		icon5.setIcon(newIcon5);
		icon5.setBounds(10, 452, 95, 70);
		contentPane.add(icon5);
	
		JLabel icon6 = new JLabel("");
		ImageIcon imageIcon6 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\logout (1).png");
		Image image6 = imageIcon6.getImage();
		Image newImage6 = image6.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon6 = new ImageIcon(newImage6);
		icon6.setIcon(newIcon6);
		icon6.setBounds(20, 540, 95, 70);
		contentPane.add(icon6);
		
		lablePets = new JLabel("Pets");
		lablePets.setForeground(new Color(255, 255, 255));
		lablePets.addMouseListener(act);
		lablePets.setFont(new Font("YouYuan", Font.BOLD, 25));
		lablePets.setBounds(123, 214, 77, 28);
		contentPane.add(lablePets);
		
		lableUser = new JLabel("User");
		lableUser.setForeground(new Color(255, 255, 255));
		lableUser.addMouseListener(act);
		lableUser.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableUser.setBounds(123, 299, 84, 28);
		contentPane.add(lableUser);
		
		lableCustomers = new JLabel("Customers");
		lableCustomers.setForeground(new Color(255, 255, 255));
		lableCustomers.addMouseListener(act);
		lableCustomers.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableCustomers.setBounds(123, 385, 124, 28);
		contentPane.add(lableCustomers);
		
		lableBilling = new JLabel("Billing");
		lableBilling.setForeground(new Color(255, 255, 255));
		lableBilling.addMouseListener(act);
		lableBilling.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableBilling.setBounds(123, 476, 109, 28);
		contentPane.add(lableBilling);
		
		lableLogout = new JLabel("Logout");
		lableLogout.setForeground(new Color(255, 255, 255));
		lableLogout.addMouseListener(act);
		lableLogout.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableLogout.setBounds(125, 564, 95, 28);
		contentPane.add(lableLogout);
		
		JLabel lblNewLabel_2_21_2 = new JLabel(" |");
		lblNewLabel_2_21_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2.setBounds(241, -26, 38, 69);
		contentPane.add(lblNewLabel_2_21_2);
		
		JLabel lblNewLabel_2_21_2_1 = new JLabel(" |");
		lblNewLabel_2_21_2_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_1.setBounds(241, 10, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_1);
		
		JLabel lblNewLabel_2_21_2_2 = new JLabel(" |");
		lblNewLabel_2_21_2_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_2.setBounds(241, 34, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_2);
		
		JLabel lblNewLabel_2_21_2_3 = new JLabel(" |");
		lblNewLabel_2_21_2_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_3.setBounds(241, 63, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_3);
		
		JLabel lblNewLabel_2_21_2_4 = new JLabel(" |");
		lblNewLabel_2_21_2_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_4.setBounds(241, 89, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_4);
		
		JLabel lblNewLabel_2_21_2_5 = new JLabel(" |");
		lblNewLabel_2_21_2_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_5.setBounds(241, 113, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_5);
		
		JLabel lblNewLabel_2_21_2_6 = new JLabel(" |");
		lblNewLabel_2_21_2_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_6.setBounds(241, 142, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_6);
		
		JLabel lblNewLabel_2_21_2_7 = new JLabel(" |");
		lblNewLabel_2_21_2_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_7.setBounds(241, 168, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_7);
		
		JLabel lblNewLabel_2_21_2_8 = new JLabel(" |");
		lblNewLabel_2_21_2_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_8.setBounds(241, 192, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_8);
		
		JLabel lblNewLabel_2_21_2_9 = new JLabel(" |");
		lblNewLabel_2_21_2_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_9.setBounds(241, 225, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_9);
		
		JLabel lblNewLabel_2_21_2_10 = new JLabel(" |");
		lblNewLabel_2_21_2_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_10.setBounds(241, 247, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_10);
		
		JLabel lblNewLabel_2_21_2_11 = new JLabel(" |");
		lblNewLabel_2_21_2_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_11.setBounds(241, 265, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_11);
		
		JLabel lblNewLabel_2_21_2_12 = new JLabel(" |");
		lblNewLabel_2_21_2_12.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_12.setBounds(241, 299, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_12);
		
		JLabel lblNewLabel_2_21_2_13 = new JLabel(" |");
		lblNewLabel_2_21_2_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_13.setBounds(241, 326, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_13);
		
		JLabel lblNewLabel_2_21_2_14 = new JLabel(" |");
		lblNewLabel_2_21_2_14.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_14.setBounds(241, 360, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_14);
		
		JLabel lblNewLabel_2_21_2_15 = new JLabel(" |");
		lblNewLabel_2_21_2_15.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_15.setBounds(241, 396, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_15);
		
		JLabel lblNewLabel_2_21_2_16 = new JLabel(" |");
		lblNewLabel_2_21_2_16.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_16.setBounds(241, 396, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_16);
		
		JLabel lblNewLabel_2_21_2_17 = new JLabel(" |");
		lblNewLabel_2_21_2_17.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_17.setBounds(241, 423, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_17);
		
		JLabel lblNewLabel_2_21_2_18 = new JLabel(" |");
		lblNewLabel_2_21_2_18.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_18.setBounds(241, 453, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_18);
		
		JLabel lblNewLabel_2_21_2_19 = new JLabel(" |");
		lblNewLabel_2_21_2_19.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_19.setBounds(241, 487, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_19);
		
		JLabel lblNewLabel_2_21_2_20 = new JLabel(" |");
		lblNewLabel_2_21_2_20.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_20.setBounds(241, 515, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_20);
		
		JLabel lblNewLabel_2_21_2_21 = new JLabel(" |");
		lblNewLabel_2_21_2_21.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_21.setBounds(241, 540, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_21);
		
		JLabel lblNewLabel_2_21_2_22 = new JLabel(" |");
		lblNewLabel_2_21_2_22.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_22.setBounds(241, 575, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_22);
		
		this.displayUser();
		
	}
	
	public void displayUser() {
		String userName = "root";
        String password = "";
        String DatabaseName = "petshopdb";
        String url = "jdbc:mysql://localhost/" + DatabaseName;
        
        try {
			con = DriverManager.getConnection(url, userName, password);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usertbl");
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");	//them cot vao mo hinh
			model.addColumn("Name");
			model.addColumn("Password");
			
			while(rs.next()) {
				Object[] row = {
					rs.getInt("UId"),
					rs.getString("UName"),
					rs.getString("UPass")
				};
				model.addRow(row);
			}
			tableUserList.setModel(model);
			
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {
		this.textFieldUserName.setText("");
		this.textFieldPassword.setText("");
	}
	
}




