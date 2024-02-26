package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame {
	public AdminLogin adminLogin;
	public Login login;
    private JPanel contentPane;
    private JProgressBar myProgress;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Splash frame = new Splash();
                    frame.setVisible(true);
                    frame.getSplash();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Splash() {
    	this.login = new Login();
    	
    	this.adminLogin = new AdminLogin();
    		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(300, 130, 871, 523);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(102, 153, 255));
	    panel.setBounds(0, 0, 857, 486);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon("C:\\Users\\TGDD\\Downloads\\pet-shop (1).png"); // Đường dẫn tới tấm ảnh
	    Image image = imageIcon.getImage();
	    Image newImage = image.getScaledInstance(207, 221, Image.SCALE_SMOOTH); // Kích thước mới cho hình ảnh (207x221)
	    ImageIcon newIcon = new ImageIcon(newImage);
	    lblNewLabel.setIcon(newIcon);

	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
	    lblNewLabel.setBounds(315, 77, 207, 221); // Kích thước của JLabel
	    panel.add(lblNewLabel);
    
	    JLabel lblNewLabel_1 = new JLabel("Heaven Care PetShop ");
	    lblNewLabel_1.setForeground(new Color(255, 255, 255));
	    lblNewLabel_1.setBackground(new Color(255, 255, 255));
	    lblNewLabel_1.setFont(new Font("YouYuan", Font.BOLD, 25));
	    lblNewLabel_1.setBounds(288, 27, 269, 47);
	    panel.add(lblNewLabel_1);
	    
	    myProgress = new JProgressBar();
	    myProgress.setBounds(0, 457, 857, 29);
	    panel.add(myProgress);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Loangding...");
	    lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
	    lblNewLabel_1_1.setFont(new Font("YouYuan", Font.BOLD, 25));
	    lblNewLabel_1_1.setBounds(333, 354, 171, 47);
	    panel.add(lblNewLabel_1_1);
	    
	    this.getSplash();
	}

    public void getSplash() {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(80);
                        publish(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                for (Integer value : chunks) {
                    myProgress.setValue(value);
                }
            }

            @Override
            protected void done() {
                login.setVisible(true); 
                dispose(); 
            }
        };

        worker.execute();
    }
}
