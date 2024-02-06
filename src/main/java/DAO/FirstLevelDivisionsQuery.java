package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.FirstLevelDivisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstLevelDivisionsQuery {
    /**
     * SQL query for getting all first level divisions from the database.
     * @return all first level divisions.
     */
    public static ObservableList<FirstLevelDivisions> getAllDivisions() {
        ObservableList<FirstLevelDivisions> allDivisions = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM first_level_divisions";

            PreparedStatement getContacts = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getContacts.executeQuery();

            while (rs.next()) {
                int divisionID = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                int countryID = rs.getInt("Country_ID");
                FirstLevelDivisions firstLevelDivision = new FirstLevelDivisions(divisionID, divisionName, countryID);
                allDivisions.add(firstLevelDivision);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allDivisions;
    }
}
