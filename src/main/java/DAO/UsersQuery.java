package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersQuery {
    /**
     *
     * @return all user accounts in the database.
     */
    public static ObservableList<User> getAllUsers() {
        ObservableList<User> allUsers = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * from users";

            PreparedStatement getUsers = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getUsers.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt("User_ID");
                String userName = rs.getString("User_Name");
                String password = rs.getString("Password");
                User user = new User(userID, userName, password);
                allUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allUsers;
    }

    public static User returnUserID(int userId) {
        try {
            String sql = "SELECT User_ID, User_Name, Password FROM users WHERE User_ID = ?";
            PreparedStatement returnUser = JDBC.getConnection().prepareStatement(sql);
            returnUser.setInt(1, userId);
            returnUser.execute();

            ResultSet rs = returnUser.getResultSet();

            rs.next();
            int searchedUserId = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");
            String password = rs.getString("Password");

            User user = new User(searchedUserId, userName, password);
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
