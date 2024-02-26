package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.AdminLogin;
import view.Billing;
import view.Customer;
import view.Login;
import view.Pets;
import view.User;

public class CustomerController implements ActionListener, MouseListener {

    private Customer customer;
    private JFrame previousFrame; // Tham chiếu đến frame trước đó

    public CustomerController(Customer customer, JFrame previousFrame) {
        this.customer = customer;
        this.previousFrame = previousFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();

        if ("Save".equals(cm)) {
            handleSave();
        } else if ("Edit".equals(cm)) {
            handleEdit();
        } else if ("Delete".equals(cm)) {
            handleDelete();
        }
    }

    private void handleSave() {
        if (customer.textFieldName.getText().isEmpty() || customer.textFieldAddress.getText().isEmpty()
                || customer.textFieldPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(customer, "Missing Information");
        } else {
            try {
                try (Connection con = DatabaseConnector.getConnection();
                        PreparedStatement save = con.prepareStatement(
                                "INSERT INTO customertbl (custID, CustName, CustAdd, CustPhone) VALUES (?, ?, ?, ?)")) {

                    int newID = getMaxCustomerId(con) + 1;

                    save.setInt(1, newID);
                    save.setString(2, customer.textFieldName.getText());
                    save.setString(3, customer.textFieldAddress.getText());
                    save.setString(4, customer.textFieldPhone.getText());

                    int rowsAffected = save.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(customer, "Customer Added");
                    } else {
                        JOptionPane.showMessageDialog(customer, "Unable to add customer");
                    }

                    customer.clear();
                    customer.displayCustomer();
                }
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(customer, e2);
            }
        }
    }

    private int getMaxCustomerId(Connection con) throws SQLException {
        try (PreparedStatement getMaxID = con.prepareStatement("SELECT MAX(custID) FROM customertbl");
                ResultSet rs = getMaxID.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }

    private void handleEdit() {
        if (customer.textFieldName.getText().isEmpty() || customer.textFieldAddress.getText().isEmpty()
                || customer.textFieldPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(customer, "Missing Information");
        } else {
            try {
                try (Connection con = DatabaseConnector.getConnection();
                        PreparedStatement edit = con.prepareStatement(
                                "UPDATE customertbl SET CustName=?, CustAdd=?, CustPhone=? WHERE CustID=?")) {

                    edit.setInt(4, key);
                    edit.setString(1, customer.textFieldName.getText());
                    edit.setString(2, customer.textFieldAddress.getText());
                    edit.setString(3, customer.textFieldPhone.getText());

                    int rowsAffected = edit.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(customer, "Customer Edited");
                    } else {
                        JOptionPane.showMessageDialog(customer, "Customer can't be Edited");
                    }

                    customer.clear();
                    customer.displayCustomer();
                }
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(customer, e2);
            }
        }
    }

    private void handleDelete() {
        if (customer.textFieldName.getText().isEmpty() || customer.textFieldAddress.getText().isEmpty()
                || customer.textFieldPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(customer, "Select a Customer");
        } else {
            try {
                try (Connection con = DatabaseConnector.getConnection();
                        PreparedStatement delete = con.prepareStatement("DELETE FROM customertbl WHERE CustID=?")) {

                    delete.setInt(1, key);

                    int rowsAffected = delete.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(customer, "Customer deleted");
                    } else {
                        JOptionPane.showMessageDialog(customer, "Customer can't be deleted");
                    }

                    customer.clear();
                    customer.displayCustomer();
                }
            } catch (SQLException e2) {
                JOptionPane.showMessageDialog(customer, e2);
            }
        }
    }

    int key = 0;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == customer.lablePets) {
            new Pets().setVisible(true);
            customer.dispose();
        } else if (e.getSource() == customer.lableUser) {
            new AdminLogin().setVisible(true);
            if (previousFrame != null) {
                previousFrame.dispose(); // Đóng frame trước đó nếu tồn tại
            }
        } else if (e.getSource() == customer.lableCustomers) {
            new Customer().setVisible(true);
            customer.dispose();
        } else if (e.getSource() == customer.lableBilling) {
            new Billing().setVisible(true);
            customer.dispose();
        } else if (e.getSource() == customer.lableLogout) {
            int select = JOptionPane.showConfirmDialog(customer, "Logout?", "WARNING", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (select == JOptionPane.NO_OPTION) {
            } else {
                new Login().setVisible(true);
                customer.dispose();
            }
        } else {
            DefaultTableModel model = (DefaultTableModel) customer.tableCustomerList.getModel();
            int myIndex = customer.tableCustomerList.getSelectedRow();
            key = Integer.valueOf(model.getValueAt(myIndex, 0).toString());
            customer.textFieldName.setText(model.getValueAt(myIndex, 1).toString());
            customer.textFieldAddress.setText(model.getValueAt(myIndex, 2).toString());
            customer.textFieldPhone.setText(model.getValueAt(myIndex, 3).toString());
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

    // Đoạn mã để khởi tạo Connection Pooling
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class DatabaseConnector {
        private static final String userName = "root";
        private static final String passWord = "";
        private static final String databaseName = "petshopdb";
        private static final String url = "jdbc:mysql://localhost/" + databaseName;

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, userName, passWord);
        }
    }
}
