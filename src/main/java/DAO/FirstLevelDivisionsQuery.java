package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FirstLevelDivision;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstLevelDivisionsQuery {
    /**
     * SQL query for getting all first level divisions from the database.
     * @return all first level divisions.
     */
    public static ObservableList<FirstLevelDivision> getAllDivisions() {
        ObservableList<FirstLevelDivision> allDivisions = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM first_level_divisions";

            PreparedStatement getContacts = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getContacts.executeQuery();

            while (rs.next()) {
                int divisionID = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                int countryID = rs.getInt("Country_ID");
                FirstLevelDivision firstLevelDivision = new FirstLevelDivision(divisionID, divisionName, countryID);
                allDivisions.add(firstLevelDivision);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allDivisions;
    }
}
