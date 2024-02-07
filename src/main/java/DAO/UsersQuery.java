package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersQuery {
    /**
     *
     * @return all user accounts in the database.
     */
    public static ObservableList<Users> getAllUsers() {
        ObservableList<Users> allUsers = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * from users";

            PreparedStatement getUsers = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getUsers.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("User_ID");
                String userName = rs.getString("User_Name");
                String password = rs.getString("Password");
                Users user = new Users(userID, userName, password);
                allUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allUsers;
    }
}
