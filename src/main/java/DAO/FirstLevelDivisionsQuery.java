package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FirstLevelDivision;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for querying first level divisions database.
 *
 * @author Wilson Ramirez
 */
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allDivisions;
    }

    /**
     * SQL query for returning a specific first level division.
     *
     * @param divisionID Selected division's ID
     * @return Selected division
     */
    public static FirstLevelDivision returnDivision(int divisionID) {
        try {
            String sql = "SELECT * FROM first_level_divisions WHERE Division_ID = ?";
            PreparedStatement returnDivision = JDBC.getConnection().prepareStatement(sql);
            returnDivision.setInt(1, divisionID);
            returnDivision.execute();
            ResultSet rs = returnDivision.executeQuery();
        while (rs.next()) {
            int returnedDivisionID = rs.getInt("Division_ID");
            String returnedDivisionName = rs.getString("Division");
            int countryID = rs.getInt("Country_ID");
            return new FirstLevelDivision(returnedDivisionID, returnedDivisionName, countryID);
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
