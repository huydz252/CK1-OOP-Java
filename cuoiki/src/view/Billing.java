package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.toedter.calendar.JDateChooser;

import controller.BillController;
import com.toedter.calendar.JDayChooser;

public class Billing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public JTable tableProductList;
	public JTable tableCutomerBill;
	
	public JTextField textFieldProduct;
	public JTextField textFieldPrice;
	public JTextField textFieldQuantity;
	
	public JLabel lableTotal;
	
	private Connection con;
	public JComboBox comboboxUserID;
	public JComboBox comboboxCustomer;
	public JDateChooser dateChooser;
	public JLabel lablePets;
	public JLabel lableCustomers;
	public JLabel lableBilling;
	public JLabel lableLogout;
	public JLabel lableUser;
	public JLabel icon2;
	public JLabel icon3;
	public JLabel icon4;
	public JLabel icon5;
	public JLabel icon6;

	/**

	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing frame = new Billing();
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
	public Billing() {

		this.setTitle("Billing");
		
		BillController act = new BillController(this);

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
		
		JLabel lableBill = new JLabel("Billing");
		lableBill.setForeground(new Color(0, 0, 0));
		lableBill.setBounds(10, 10, 137, 28);
		lableBill.setFont(new Font("YouYuan", Font.BOLD, 25));
		panel.add(lableBill);
		
		JLabel lableBingg1 = new JLabel("Customer ");
		lableBingg1.setForeground(new Color(255, 255, 255));
		lableBingg1.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableBingg1.setBounds(664, 59, 137, 28);
		panel.add(lableBingg1);
		
		JLabel lableProductList = new JLabel("Product List");
		lableProductList.setFont(new Font("YouYuan", Font.BOLD | Font.ITALIC, 25));
		lableProductList.setBounds(123, 240, 209, 28);
		panel.add(lableProductList);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setForeground(new Color(255, 255, 255));
		lblUserId.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblUserId.setBounds(407, 59, 103, 28);
		panel.add(lblUserId);
		
		comboboxUserID = new JComboBox();
		comboboxUserID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboboxUserID.setBounds(448, 86, 160, 33);
		panel.add(comboboxUserID);
		
		comboboxCustomer = new JComboBox();
		comboboxCustomer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboboxCustomer.setBounds(664, 86, 160, 33);
		panel.add(comboboxCustomer);
		
		JLabel lblQuantity = new JLabel("Product");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblQuantity.setBounds(10, 59, 116, 28);
		panel.add(lblQuantity);
		
		textFieldProduct = new JTextField();
		textFieldProduct.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldProduct.setColumns(10);
		textFieldProduct.setBounds(10, 85, 160, 35);
		panel.add(textFieldProduct);
		
		JLabel lblUserId_1 = new JLabel("Date");
		lblUserId_1.setForeground(new Color(255, 255, 255));
		lblUserId_1.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblUserId_1.setBounds(217, 148, 72, 28);
		panel.add(lblUserId_1);
		
		JButton buttonAddtoBilll = new JButton("Add to Bill");
		buttonAddtoBilll.addActionListener(act);
		buttonAddtoBilll.setForeground(Color.RED);
		buttonAddtoBilll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonAddtoBilll.setBounds(664, 175, 160, 35);
		panel.add(buttonAddtoBilll);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblPrice.setBounds(217, 59, 81, 28);
		panel.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(217, 85, 160, 35);
		panel.add(textFieldPrice);
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(act);
		buttonReset.setForeground(Color.RED);
		buttonReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonReset.setBounds(449, 175, 159, 35);
		panel.add(buttonReset);
				
		tableProductList = new JTable();
		tableProductList.addMouseListener(act);
		DefaultTableModel model = new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ID", "Name", "Category", "Quantity", "Price" }
		);
		tableProductList.setModel(model);

		// Thiết lập độ rộng ưu tiên cho các cột
		tableProductList.getColumnModel().getColumn(0).setPreferredWidth(30); // ID
		tableProductList.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
		tableProductList.getColumnModel().getColumn(2).setPreferredWidth(70); // Category
		tableProductList.getColumnModel().getColumn(3).setPreferredWidth(100); // Quantity
		tableProductList.getColumnModel().getColumn(4).setPreferredWidth(100); // Price

		JScrollPane scrollPane = new JScrollPane(tableProductList);
		scrollPane.setBounds(10, 277, 428, 333);
		panel.add(scrollPane);

		
		
		tableCutomerBill = new JTable();
		tableCutomerBill.addMouseListener(act);
		tableCutomerBill.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product", "Quantity", "Price", "Total"
			}
		));
		tableCutomerBill.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableCutomerBill.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableCutomerBill.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableCutomerBill.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableCutomerBill.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		JScrollPane scrollPane_1 = new JScrollPane(tableCutomerBill);
		scrollPane_1.setBounds(448, 277, 376, 237);
		panel.add(scrollPane_1);
		
		JButton buttonSave = new JButton("Save");
		
		buttonSave.addActionListener(act);
		buttonSave.setForeground(Color.RED);
		buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonSave.setBounds(505, 575, 103, 35);
		panel.add(buttonSave);
		
		JButton buttonPrint = new JButton("Print");
		buttonPrint.addActionListener(act);
		buttonPrint.setForeground(Color.RED);
		buttonPrint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPrint.setBounds(669, 575, 103, 35);
		panel.add(buttonPrint);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setForeground(new Color(255, 255, 255));
		lblQuantity_1.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblQuantity_1.setBounds(10, 148, 128, 28);
		panel.add(lblQuantity_1);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(10, 175, 160, 35);
		panel.add(textFieldQuantity);
		
		JLabel lblCustomerBill = new JLabel("Customer Bill");
		lblCustomerBill.setFont(new Font("YouYuan", Font.BOLD | Font.ITALIC, 25));
		lblCustomerBill.setBounds(629, 240, 209, 28);
		panel.add(lblCustomerBill);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(217, 175, 160, 35);
		panel.add(dateChooser);
		
		lableTotal = new JLabel("Grand Total:");
		lableTotal.setFont(new Font("Tahoma", Font.BOLD, 23));
		lableTotal.setBounds(448, 537, 347, 28);
		panel.add(lableTotal);
		
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.addActionListener(act);
		buttonDelete.setForeground(Color.RED);
		buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonDelete.setBounds(829, 550, 103, 35);
		panel.add(buttonDelete);

		JLabel icon1 = new JLabel("");
		icon1.setIcon(new ImageIcon("C:\\\\Users\\\\TGDD\\\\Downloads\\\\invoice.png"));
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
		icon2.addMouseListener(act);
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\TGDD\\Downloads\\pets.png");
		Image image2 = imageIcon.getImage();
		Image newImage2 = image2.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon2 = new ImageIcon(newImage2);
		icon2.setIcon(newIcon2);
		icon2.setBounds(10, 184, 95, 70);
		contentPane.add(icon2);
	
		icon3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\customer-support.png");
		Image image3 = imageIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImage3);
		icon3.setIcon(newIcon3);
		icon3.setBounds(10, 265, 95, 70);
		contentPane.add(icon3);
	
		icon4 = new JLabel("");
		ImageIcon imageIcon4 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\user.png");
		Image image4 = imageIcon4.getImage();
		Image newImage4 = image4.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newImage4);
		icon4.setIcon(newIcon4);
		icon4.setBounds(10, 360, 95, 70);
		contentPane.add(icon4);
					
		icon5 = new JLabel("");
		ImageIcon imageIcon5 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\invoice.png");
		Image image5 = imageIcon5.getImage();
		Image newImage5 = image5.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon5 = new ImageIcon(newImage5);
		icon5.setIcon(newIcon5);
		icon5.setBounds(10, 452, 95, 70);
		contentPane.add(icon5);
	
		icon6 = new JLabel("");
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
		

		
		this.displayProductList();
		this.getCustomer();
		this.getUser();
		this.clear();
		
				
	}		
	public void displayProductList() {
		
		try {
	        String userName = "root";
	        String password = "";
	        String DatabaseName = "petshopdb";
	        String url = "jdbc:mysql://localhost/" + DatabaseName;

	        con = DriverManager.getConnection(url, userName, password);
	        
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from pettbl");
	        
	        DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ID");
	        model.addColumn("Name");  // Thêm cột ID vào mô hình
	        model.addColumn("Category");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	       
	        while (rs.next()) {
	            Object[] row = {
	                rs.getInt("PId"),        // Thêm ID từ cơ sở dữ liệu
	                rs.getString("PName"),   // Sử dụng tên cột thực tế trong cơ sở dữ liệu
	                rs.getString("PCat"),
	                rs.getString("PQty"),
	                rs.getString("PPrice")
	            };
	            model.addRow(row);
	        }

	        tableProductList.setModel(model);

	        rs.close();
	        st.close();
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(this, e);
	    }
	}
	
	public void getCustomer() {
		comboboxCustomer.addItem("");
		try {
	        String userName = "root";
	        String password = "";
	        String DatabaseName = "petshopdb";
	        String url = "jdbc:mysql://localhost/" + DatabaseName;

	        con = DriverManager.getConnection(url, userName, password);
	        
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from customertbl");
	        
	        while(rs.next()){
	        	int custId = rs.getInt("CustId");
	        	comboboxCustomer.addItem(custId);
	        }
	        	
	    }catch (Exception e) {
	    	JOptionPane.showMessageDialog(this, e);
		}	        
	}
	
	public void getUser() {
		comboboxUserID.addItem(" ");
		try {
	        String userName = "root";
	        String password = "";
	        String DatabaseName = "petshopdb";
	        String url = "jdbc:mysql://localhost/" + DatabaseName;

	        con = DriverManager.getConnection(url, userName, password);
	        
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from usertbl");
	        
	        while(rs.next()){
	        	int userId = rs.getInt("UId");
	        	comboboxUserID.addItem(userId); 
	        }
	        	
	    }catch (Exception e) {
	    	JOptionPane.showMessageDialog(this, e);
		}	        
	}
	
	public void clear() {
		this.textFieldProduct.setText("");
		this.comboboxUserID.setSelectedItem(null);
		this.comboboxCustomer.setSelectedItem(null);
		this.textFieldPrice.setText("");
		this.textFieldQuantity.setText("");
	}
}





