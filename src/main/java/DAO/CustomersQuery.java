package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersQuery {
    /**
     * SQL query for getting all customers from the database.
     *
     * @return all customers.
     */
    public static ObservableList<Customer> getAllCustomers() {
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM customers";

            PreparedStatement getCustomers = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getCustomers.executeQuery();

            while (rs.next()) {
                int customerID = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_Name");
                String customerAddress = rs.getString("Address");
                String customerPostal = rs.getString("Postal_Code");
                String customerPhone = rs.getString("Phone");
                int divisionID = rs.getInt("Division_ID");
                Customer customer = new Customer(customerID, customerName, customerAddress, customerPostal, customerPhone, divisionID);
                allCustomers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCustomers;
    }

    /**
     *  SQL query to add new customers to the database. Customer ID is auto-generated.
     *
     * @param name Customer name
     * @param address Customer address
     * @param postal Customer postal code
     * @param phone Customer phone number
     * @param divisionID Customer associated division ID
     * @throws SQLException for unhandled SQL exceptions
     */
    public static void addCustomer(String name, String address, String postal, String phone, int divisionID) throws SQLException {
        String sql = "INSERT INTO customers(Customer_Name, Address, Postal_Code, Phone, Division_ID VALUES(?, ?, ?, ?, ?)";
        PreparedStatement addCustomer = JDBC.getConnection().prepareStatement(sql);

        addCustomer.setString(1, name);
        addCustomer.setString(2, address);
        addCustomer.setString(3, postal);
        addCustomer.setString(4, phone);
        addCustomer.setInt(5, divisionID);
        addCustomer.executeUpdate();
    }

    /**
     * SQL query for updated existing customers in the database.
     *
     * @param name Customer name
     * @param address Customer address
     * @param postal Customer postal code
     * @param phone Customer phone number
     * @param divisionID Customer associated division ID
     */
    public static void updateCustomer(int customerID, String name, String address, String postal, String phone, int divisionID) {
        try {
            String sql = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ?";
            PreparedStatement updateCustomer = JDBC.getConnection().prepareStatement(sql);

            updateCustomer.setString(1, name);
            updateCustomer.setString(2, address);
            updateCustomer.setString(3, postal);
            updateCustomer.setString(4, phone);
            updateCustomer.setInt(5, divisionID);
            updateCustomer.setInt(6, customerID);
            updateCustomer.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * SQL query for deleting customers from the database.
     *
     * @param customerID Customer ID
     */
    public static void deleteCustomer(int customerID) {
        try {
            String sql = "DELETE FROM customers WHERE Customer_ID = ?";
            PreparedStatement deleteCustomer = JDBC.getConnection().prepareStatement(sql);

            deleteCustomer.setInt(1, customerID);
            deleteCustomer.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Customer returnCustomer(int customerId) {
        try {
            String sql = "SELECT * FROM customers WHERE Customer_ID = ?";
            PreparedStatement returnCustomer = JDBC.getConnection().prepareStatement(sql);
            returnCustomer.setInt(1, customerId);
            returnCustomer.execute();
            ResultSet rs = returnCustomer.executeQuery();

            while (rs.next()) {
                int returnedCustomerId = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_Name");
                String customerAddress = rs.getString("Address");
                String customerPostal = rs.getString("Postal_Code");
                String customerPhone = rs.getString("Phone");
                int divisionID = rs.getInt("Division_ID");

                Customer customer = new Customer(returnedCustomerId, customerName, customerAddress, customerPostal, customerPhone, divisionID);
                return customer;

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
