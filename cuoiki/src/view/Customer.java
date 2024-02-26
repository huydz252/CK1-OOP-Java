package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.CustomerController;

public class Customer extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textFieldName;
	public JTextField textFieldAddress;
	public JTextField textFieldPhone;
	public JTable tableCustomerList;
	private Connection con;
	public JLabel lablePets;
	public JLabel lableUser;
	public JLabel lableCustomers;
	public JLabel lableBilling;
	public JLabel lableLogout;
	
	public JLabel icon2;
	public JLabel icon3;
	public JLabel icon4;
	public JLabel icon5;
	public JLabel icon6;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Customer() {
		this.setTitle("Customer");
				
		CustomerController act = new CustomerController(this,null);

		setBounds(210, 90, 1111, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(263, 0, 834, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lableManagerPets = new JLabel("Manage Customer ");
		lableManagerPets.setForeground(new Color(255, 255, 255));
		lableManagerPets.setBounds(10, 10, 243, 28);
		lableManagerPets.setFont(new Font("YouYuan", Font.BOLD, 25));
		panel.add(lableManagerPets);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblName.setBounds(83, 58, 71, 28);
		panel.add(lblName);
		
		JLabel lableCategory = new JLabel("Address");
		lableCategory.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableCategory.setBounds(321, 58, 122, 28);
		panel.add(lableCategory);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldName.setBounds(83, 83, 191, 28);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(319, 83, 149, 28);
		panel.add(textFieldAddress);
		
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
		buttonDelete.addActionListener(act) ;
		buttonDelete.setForeground(Color.RED);					
		buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonDelete.setBounds(489, 144, 103, 35);
		panel.add(buttonDelete);
		
		JLabel lableProductList = new JLabel("Customer List");
		lableProductList.setFont(new Font("YouYuan", Font.BOLD | Font.ITALIC, 25));
		lableProductList.setBounds(295, 201, 176, 28);
		panel.add(lableProductList);
		
		tableCustomerList = new JTable();
		tableCustomerList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableCustomerList.addMouseListener(act);
		tableCustomerList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Address", "Phone"
			}
		));
		JScrollPane scrollPane = new JScrollPane(tableCustomerList);
		scrollPane.setBounds(10, 239, 814, 371);
		panel.add(scrollPane);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblPhone.setBounds(510, 58, 71, 28);
		panel.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(510, 83, 149, 28);
		panel.add(textFieldPhone);

		JLabel icon1 = new JLabel("");
		icon1.setIcon(new ImageIcon("C:\\Users\\TGDD\\Downloads\\user.png"));
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

				
		icon2 = new JLabel("");
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\TGDD\\Downloads\\pets.png");
		Image image2 = imageIcon.getImage();
		Image newImage2 = image2.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newImage2);
		icon2.setIcon(newIcon2);
		icon2.setBounds(10, 170, 95, 70);
		contentPane.add(icon2);
	
		icon3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\customer-support.png");
		Image image3 = imageIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImage3);
		icon3.setIcon(newIcon3);
		icon3.setBounds(10, 250, 95, 70);
		contentPane.add(icon3);
	
		icon4 = new JLabel("");
		ImageIcon imageIcon4 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\user.png");
		Image image4 = imageIcon4.getImage();
		Image newImage4 = image4.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newImage4);
		icon4.setIcon(newIcon4);
		icon4.setBounds(10, 345, 95, 70);
		contentPane.add(icon4);
					
		icon5 = new JLabel("");
		ImageIcon imageIcon5 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\invoice.png");
		Image image5 = imageIcon5.getImage();
		Image newImage5 = image5.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon5 = new ImageIcon(newImage5);
		icon5.setIcon(newIcon5);
		icon5.setBounds(10, 447, 95, 70);
		contentPane.add(icon5);
	
		icon6 = new JLabel("");
		ImageIcon imageIcon6 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\logout (1).png");
		Image image6 = imageIcon6.getImage();
		Image newImage6 = image6.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon6 = new ImageIcon(newImage6);
		icon6.setIcon(newIcon6);
		icon6.setBounds(18, 540, 95, 70);
		contentPane.add(icon6);
		
		lablePets = new JLabel("Pets");
		lablePets.setForeground(new Color(255, 255, 255));
		lablePets.addMouseListener(act);
		lablePets.setFont(new Font("YouYuan", Font.BOLD, 25));
		lablePets.setBounds(124, 204, 79, 28);
		contentPane.add(lablePets);
		
		lableUser = new JLabel("User");
		lableUser.setForeground(new Color(255, 255, 255));
		lableUser.addMouseListener(act);
		lableUser.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableUser.setBounds(125, 286, 109, 28);
		contentPane.add(lableUser);
		
		lableCustomers = new JLabel("Customers");
		lableCustomers.setForeground(new Color(255, 255, 255));
		lableCustomers.addMouseListener(act);
		lableCustomers.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableCustomers.setBounds(122, 371, 135, 28);
		contentPane.add(lableCustomers);
		
		lableBilling = new JLabel("Billing");
		lableBilling.setForeground(new Color(255, 255, 255));
		lableBilling.addMouseListener(act);
		lableBilling.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableBilling.setBounds(123, 470, 124, 28);
		contentPane.add(lableBilling);
		
		lableLogout = new JLabel("Logout");
		lableLogout.setForeground(new Color(255, 255, 255));
		lableLogout.addMouseListener(act);
		lableLogout.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableLogout.setBounds(123, 563, 99, 28);
		contentPane.add(lableLogout);
		
		JLabel lblNewLabel_2_21_2 = new JLabel(" |");
		lblNewLabel_2_21_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2.setBounds(242, -19, 38, 69);
		contentPane.add(lblNewLabel_2_21_2);
		
		JLabel lblNewLabel_2_21_2_1 = new JLabel(" |");
		lblNewLabel_2_21_2_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_1.setBounds(242, 10, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_1);
		
		JLabel lblNewLabel_2_21_2_2 = new JLabel(" |");
		lblNewLabel_2_21_2_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_2.setBounds(242, 39, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_2);
		
		JLabel lblNewLabel_2_21_2_3 = new JLabel(" |");
		lblNewLabel_2_21_2_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_3.setBounds(242, 60, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_3);
		
		JLabel lblNewLabel_2_21_2_4 = new JLabel(" |");
		lblNewLabel_2_21_2_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_4.setBounds(242, 89, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_4);
		
		JLabel lblNewLabel_2_21_2_5 = new JLabel(" |");
		lblNewLabel_2_21_2_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_5.setBounds(242, 118, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_5);
		
		JLabel lblNewLabel_2_21_2_6 = new JLabel(" |");
		lblNewLabel_2_21_2_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_6.setBounds(242, 139, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_6);
		
		JLabel lblNewLabel_2_21_2_7 = new JLabel(" |");
		lblNewLabel_2_21_2_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_7.setBounds(242, 170, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_7);
		
		JLabel lblNewLabel_2_21_2_8 = new JLabel(" |");
		lblNewLabel_2_21_2_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_8.setBounds(242, 204, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_8);
		
		JLabel lblNewLabel_2_21_2_9 = new JLabel(" |");
		lblNewLabel_2_21_2_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_9.setBounds(242, 233, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_9);
		
		JLabel lblNewLabel_2_21_2_10 = new JLabel(" |");
		lblNewLabel_2_21_2_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_10.setBounds(242, 261, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_10);
		
		JLabel lblNewLabel_2_21_2_11 = new JLabel(" |");
		lblNewLabel_2_21_2_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_11.setBounds(242, 286, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_11);
		
		JLabel lblNewLabel_2_21_2_12 = new JLabel(" |");
		lblNewLabel_2_21_2_12.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_12.setBounds(242, 312, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_12);
		
		JLabel lblNewLabel_2_21_2_13 = new JLabel(" |");
		lblNewLabel_2_21_2_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_13.setBounds(242, 345, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_13);
		
		JLabel lblNewLabel_2_21_2_14 = new JLabel(" |");
		lblNewLabel_2_21_2_14.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_14.setBounds(242, 382, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_14);
		
		JLabel lblNewLabel_2_21_2_15 = new JLabel(" |");
		lblNewLabel_2_21_2_15.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_15.setBounds(242, 409, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_15);
		
		JLabel lblNewLabel_2_21_2_16 = new JLabel(" |");
		lblNewLabel_2_21_2_16.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_16.setBounds(242, 434, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_16);
		
		JLabel lblNewLabel_2_21_2_17 = new JLabel(" |");
		lblNewLabel_2_21_2_17.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_17.setBounds(242, 461, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_17);
		
		JLabel lblNewLabel_2_21_2_18 = new JLabel(" |");
		lblNewLabel_2_21_2_18.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_18.setBounds(242, 481, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_18);
		
		JLabel lblNewLabel_2_21_2_19 = new JLabel(" |");
		lblNewLabel_2_21_2_19.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_19.setBounds(242, 513, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_19);
		
		JLabel lblNewLabel_2_21_2_20 = new JLabel(" |");
		lblNewLabel_2_21_2_20.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_20.setBounds(242, 540, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_20);
		
		JLabel lblNewLabel_2_21_2_21 = new JLabel(" |");
		lblNewLabel_2_21_2_21.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2_21.setBounds(242, 574, 38, 69);
		contentPane.add(lblNewLabel_2_21_2_21);
		
		this.displayCustomer();
		
	}
	
	public void displayCustomer() {
	    try {
	        String userName = "root";
	        String password = "";
	        String DatabaseName = "petshopdb";
	        String url = "jdbc:mysql://localhost/" + DatabaseName;

	        con = DriverManager.getConnection(url, userName, password);
	        
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from customertbl");
	        
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ID");  // Thêm cột ID vào mô hình
	        model.addColumn("Name");
	        model.addColumn("Address");
	        model.addColumn("Phone");

	        while (rs.next()) {
	            Object[] row = {
	                rs.getInt("CustID"),        // Thêm ID từ cơ sở dữ liệu
	                rs.getString("CustName"),   // Sử dụng tên cột thực tế trong cơ sở dữ liệu
	                rs.getString("CustAdd"),    // Sử dụng tên cột thực tế trong cơ sở dữ liệu
	                rs.getString("CustPhone")   // Sử dụng tên cột thực tế trong cơ sở dữ liệu
	            };
	            model.addRow(row);
	        }

	        tableCustomerList.setModel(model);

	        rs.close();
	        st.close();
	    } catch (SQLException e) {
	        // Xử lý hoặc ghi log cho lỗi SQL
	        e.printStackTrace();
	    }
	}


	public void clear() {
		this.textFieldName.setText("");
		this.textFieldAddress.setText("");
		this.textFieldPhone.setText("");
	}

	
	
}














