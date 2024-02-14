package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for querying contacts database.
 *
 * @author Wilson Ramirez
 */
public class ContactsQuery {
    /**
     * SQL query for getting all contacts from the database.
     * @return all contacts.
     */
    public static ObservableList<Contact> getAllContacts() {
        ObservableList<Contact> allContacts = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM contacts";

            PreparedStatement getContacts = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getContacts.executeQuery();

            while (rs.next()) {
                int contactID = rs.getInt("Contact_ID");
                String contactName = rs.getString("Contact_Name");
                String contactEmail = rs.getString("Email");
                Contact contact = new Contact(contactID, contactName, contactEmail);
                allContacts.add(contact);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allContacts;
    }

    /**
     * SQL query to return contact info for a specific contact.
     *
     * @param contactID Selected contact's ID
     * @return Selected contact
     */
    public static Contact returnContact(int contactID) {
        try {
            String sql = "SELECT * FROM contacts WHERE Contact_ID = ?";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, contactID);

            ps.execute();

            ResultSet rs = ps.getResultSet();

            rs.next();
            int searchedContactId = rs.getInt("Contact_ID");
            String contactName = rs.getString("Contact_Name");
            String contactEmail = rs.getString("Email");
            return new Contact(searchedContactId, contactName, contactEmail);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
