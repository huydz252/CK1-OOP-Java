package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PetsController;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Pets extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldName;
	public JTextField textFieldQuantity;
	public JTextField textFieldPrice;
	public JTable tableProductList;
	private Connection con;
	public JComboBox<String> comboBoxCategory;
	public JLabel lablePets;
	public JLabel lableUser;
	public JLabel lableCustomers;
	public JLabel lableBilling;
	public JLabel lableLogout;
	public JLabel Category;
	public JLabel lableCategoryClick;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pets frame = new Pets();
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
	public Pets() {
		this.setTitle("Pets");
		
		PetsController act = new PetsController(this);
		
		setBounds(210, 90, 1111, 657);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 51, 255));
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(256, 0, 841, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lableManagerPets = new JLabel("Manage Pets");
		lableManagerPets.setBackground(new Color(255, 255, 255));
		lableManagerPets.setForeground(new Color(0, 0, 0));
		lableManagerPets.setBounds(10, 10, 173, 28);
		lableManagerPets.setFont(new Font("YouYuan", Font.BOLD, 25));
		panel.add(lableManagerPets);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblName.setBounds(10, 58, 71, 28);
		panel.add(lblName);
		
		JLabel lableCategory = new JLabel("Category");
		lableCategory.setForeground(new Color(255, 255, 255));
		lableCategory.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableCategory.setBounds(210, 58, 122, 28);
		panel.add(lableCategory);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setFont(new Font("YouYuan", Font.BOLD, 25));
		lblQuantity.setBounds(424, 58, 114, 28);
		panel.add(lblQuantity);
		
		JLabel lablePrice = new JLabel("Price");
		lablePrice.setForeground(new Color(255, 255, 255));
		lablePrice.setFont(new Font("YouYuan", Font.BOLD, 25));
		lablePrice.setBounds(621, 58, 85, 28);
		panel.add(lablePrice);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldName.setBounds(10, 96, 133, 28);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(424, 96, 141, 28);
		panel.add(textFieldQuantity);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(621, 96, 133, 28);
		panel.add(textFieldPrice);
		
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
		
		JLabel lableProductList = new JLabel("Product List");
		lableProductList.setFont(new Font("YouYuan", Font.BOLD | Font.ITALIC, 25));
		lableProductList.setBounds(311, 201, 173, 28);
		panel.add(lableProductList);
		
		tableProductList = new JTable();
		tableProductList.addMouseListener(act);
		tableProductList.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableProductList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Category", "Quantity", "Price"
			}
		));
		tableProductList.setDefaultRenderer(getClass(), null);
		JScrollPane scrollPane = new JScrollPane(tableProductList);
		scrollPane.setBounds(10, 239, 821, 371);
		panel.add(scrollPane);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.setBounds(212, 96, 133, 29);
		comboBoxCategory.addItem("");
		comboBoxCategory.setFont(new Font("Arial",Font.PLAIN, 20));
		panel.add(comboBoxCategory);
		
		lableCategoryClick = new JLabel("Category");
		lableCategoryClick.addMouseListener(act);
		lableCategoryClick.setForeground(new Color(0, 0, 0));
		lableCategoryClick.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableCategoryClick.setBounds(195, 10, 124, 28);
		panel.add(lableCategoryClick);
		
		JLabel lblNewLabel_2_5_1 = new JLabel(" |");
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_5_1.setBounds(158, -15, 38, 69);
		panel.add(lblNewLabel_2_5_1);
		
		JLabel icon1 = new JLabel("");
		icon1.setIcon(new ImageIcon("C:\\Users\\TGDD\\Downloads\\paw.png"));
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
		icon2.setBounds(10, 170, 95, 70);
		contentPane.add(icon2);
	
		JLabel icon3 = new JLabel("");
		ImageIcon imageIcon3 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\customer-support.png");
		Image image3 = imageIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImage3);
		icon3.setIcon(newIcon3);
		icon3.setBounds(10, 250, 95, 70);
		contentPane.add(icon3);
	
		JLabel icon4 = new JLabel("");
		ImageIcon imageIcon4 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\user.png");
		Image image4 = imageIcon4.getImage();
		Image newImage4 = image4.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon4 = new ImageIcon(newImage4);
		icon4.setIcon(newIcon4);
		icon4.setBounds(10, 345, 95, 70);
		contentPane.add(icon4);
					
		JLabel icon5 = new JLabel("");
		ImageIcon imageIcon5 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\invoice.png");
		Image image5 = imageIcon5.getImage();
		Image newImage5 = image5.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon5 = new ImageIcon(newImage5);
		icon5.setIcon(newIcon5);
		icon5.setBounds(10, 447, 95, 70);
		contentPane.add(icon5);
	
		JLabel icon6 = new JLabel("");
		ImageIcon imageIcon6 = new ImageIcon("C:\\Users\\TGDD\\Downloads\\logout (1).png");
		Image image6 = imageIcon6.getImage();
		Image newImage6 = image6.getScaledInstance(95, 70, Image.SCALE_SMOOTH);
		ImageIcon newIcon6 = new ImageIcon(newImage6);
		icon6.setIcon(newIcon6);
		icon6.setBounds(18, 540, 95, 70);
		contentPane.add(icon6);

		
		lablePets = new JLabel("Pets");
		lablePets.setForeground(new Color(255, 255, 255));
		lablePets.setBackground(new Color(255, 255, 255));
		lablePets.addMouseListener(act);
		lablePets.setFont(new Font("YouYuan", Font.BOLD, 25));
		lablePets.setBounds(123, 199, 61, 28);
		contentPane.add(lablePets);
		
		lableUser = new JLabel("User");
		lableUser.setForeground(new Color(255, 255, 255));
		lableUser.addMouseListener(act);
		lableUser.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableUser.setBounds(123, 280, 72, 28);
		contentPane.add(lableUser);
		
		lableCustomers = new JLabel("Customers");
		lableCustomers.setForeground(new Color(255, 255, 255));
		lableCustomers.addMouseListener(act);
		lableCustomers.addMouseListener(act);
		lableCustomers.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableCustomers.setBounds(123, 371, 124, 28);
		contentPane.add(lableCustomers);
		
		lableBilling = new JLabel("Billing");
		lableBilling.setForeground(new Color(255, 255, 255));
		lableBilling.addMouseListener(act);
		lableBilling.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableBilling.setBounds(123, 474, 109, 28);
		contentPane.add(lableBilling);
		
		lableLogout = new JLabel("Logout");
		lableLogout.setForeground(new Color(255, 255, 255));
		lableLogout.addMouseListener(act);
		lableLogout.setFont(new Font("YouYuan", Font.BOLD, 25));
		lableLogout.setBounds(130, 565, 102, 28);
		contentPane.add(lableLogout);
		
		JLabel lblNewLabel_2 = new JLabel(" |");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(235, 0, 38, 69);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" |");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_1.setBounds(235, 40, 38, 69);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel(" |");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_2.setBounds(235, -18, 38, 69);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel(" |");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_3.setBounds(235, 22, 38, 69);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel(" |");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_4.setBounds(235, 80, 38, 69);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel(" |");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_5.setBounds(235, 119, 38, 69);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel(" |");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_6.setBounds(235, 148, 38, 69);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel(" |");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_7.setBounds(235, 170, 38, 69);
		contentPane.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel(" |");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_8.setBounds(235, 199, 38, 69);
		contentPane.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_9 = new JLabel(" |");
		lblNewLabel_2_9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_9.setBounds(235, 101, 38, 69);
		contentPane.add(lblNewLabel_2_9);
		
		JLabel lblNewLabel_2_10 = new JLabel(" |");
		lblNewLabel_2_10.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_10.setBounds(235, 61, 38, 69);
		contentPane.add(lblNewLabel_2_10);
		
		JLabel lblNewLabel_2_11 = new JLabel(" |");
		lblNewLabel_2_11.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_11.setBounds(235, 227, 38, 69);
		contentPane.add(lblNewLabel_2_11);
		
		JLabel lblNewLabel_2_12 = new JLabel(" |");
		lblNewLabel_2_12.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_12.setBounds(235, 251, 38, 69);
		contentPane.add(lblNewLabel_2_12);
		
		JLabel lblNewLabel_2_13 = new JLabel(" |");
		lblNewLabel_2_13.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_13.setBounds(235, 278, 38, 69);
		contentPane.add(lblNewLabel_2_13);
		
		JLabel lblNewLabel_2_14 = new JLabel(" |");
		lblNewLabel_2_14.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_14.setBounds(235, 306, 38, 69);
		contentPane.add(lblNewLabel_2_14);
		
		JLabel lblNewLabel_2_15 = new JLabel(" |");
		lblNewLabel_2_15.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_15.setBounds(235, 330, 38, 69);
		contentPane.add(lblNewLabel_2_15);
		
		JLabel lblNewLabel_2_16 = new JLabel(" |");
		lblNewLabel_2_16.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_16.setBounds(235, 357, 38, 69);
		contentPane.add(lblNewLabel_2_16);
		
		JLabel lblNewLabel_2_17 = new JLabel(" |");
		lblNewLabel_2_17.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_17.setBounds(235, 385, 38, 69);
		contentPane.add(lblNewLabel_2_17);
		
		JLabel lblNewLabel_2_18 = new JLabel(" |");
		lblNewLabel_2_18.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_18.setBounds(235, 411, 38, 69);
		contentPane.add(lblNewLabel_2_18);
		
		JLabel lblNewLabel_2_19 = new JLabel(" |");
		lblNewLabel_2_19.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_19.setBounds(235, 433, 38, 69);
		contentPane.add(lblNewLabel_2_19);
		
		JLabel lblNewLabel_2_20 = new JLabel(" |");
		lblNewLabel_2_20.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_20.setBounds(235, 464, 38, 69);
		contentPane.add(lblNewLabel_2_20);
		
		JLabel lblNewLabel_2_21 = new JLabel(" |");
		lblNewLabel_2_21.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21.setBounds(235, 491, 38, 69);
		contentPane.add(lblNewLabel_2_21);
		
		JLabel lblNewLabel_2_22 = new JLabel(" |");
		lblNewLabel_2_22.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_22.setBounds(235, 501, 38, 69);
		contentPane.add(lblNewLabel_2_22);
		
		JLabel lblNewLabel_2_21_1 = new JLabel(" |");
		lblNewLabel_2_21_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_1.setBounds(235, 524, 38, 69);
		contentPane.add(lblNewLabel_2_21_1);
		
		JLabel lblNewLabel_2_21_2 = new JLabel(" |");
		lblNewLabel_2_21_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_2.setBounds(235, 551, 38, 69);
		contentPane.add(lblNewLabel_2_21_2);
		
		JLabel lblNewLabel_2_21_3 = new JLabel(" |");
		lblNewLabel_2_21_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2_21_3.setBounds(235, 565, 38, 69);
		contentPane.add(lblNewLabel_2_21_3);

		this.displayPets();
		this.getCategory();
	}
	
	
	
	public void displayPets() {
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
	                rs.getInt("PQty"),
	                rs.getInt("PPrice")
	            };
	            model.addRow(row);
	        }

	        tableProductList.setModel(model);
	        
	        con.close();
	        rs.close();
	        st.close();
	    } catch (SQLException e) {
	    	JOptionPane.showMessageDialog(this, e);
	    }
	}
	
	public void getCategory() {
		try {
	        String userName = "root";
	        String password = "";
	        String DatabaseName = "petshopdb";
	        String url = "jdbc:mysql://localhost/" + DatabaseName;

	        con = DriverManager.getConnection(url, userName, password);
	        
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("select * from categorytbl");
	        
	        while(rs.next()){
	        	String catDes = rs.getString("CatDes");
	        	comboBoxCategory.addItem(catDes);
	        }
	        con.close();	
	    }catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void clear() {
		this.textFieldName.setText("");
		this.comboBoxCategory.setSelectedItem(null);
		this.textFieldPrice.setText("");
		this.textFieldQuantity.setText("");
	}
}
