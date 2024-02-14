package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for querying countries database.
 *
 * @author Wilson Ramirez
 */
public class CountriesQuery {

    /**
     * SQL query for getting all countries from the database.
     *
     * @return all countries.
     */
    public static ObservableList<Country> getAllCountries() {
        ObservableList<Country> allCountries = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM countries";

            PreparedStatement getCountries = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = getCountries.executeQuery();

            while(rs.next()) {
                int countryID = rs.getInt("Country_ID");
                String countryName = rs.getString("Country");
                Country country = new Country(countryID, countryName);
                allCountries.add(country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allCountries;
    }

    /**
     * SQL query for returning a specific country.
     *
     * @param countryID Selected country's ID
     * @return Selected country
     */
    public static Country returnCountry(int countryID) {
        try {
            String sql = "SELECT * FROM countries WHERE Country_ID = ?";
            PreparedStatement returnCountry = JDBC.getConnection().prepareStatement(sql);
            returnCountry.setInt(1, countryID);
            returnCountry.execute();
            ResultSet rs = returnCountry.executeQuery();


            int id = rs.getInt("Country_ID");
            String countryName = rs.getString("Country");
            return new Country(id, countryName);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * SQL query to return a list of countries and a count of how many customers are in that country.
     *
     * @return A count of how many customers in each country
     */
    public static ObservableList<Country> getCustomersByCountry() {
        ObservableList<Country> countryList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT countries.Country, COUNT(*) AS customerCount FROM customers INNER JOIN first_level_divisions " +
                    "ON customers.Division_ID = first_level_divisions.Division_ID INNER JOIN countries " +
                    "ON countries.Country_ID = first_level_divisions.Country_ID WHERE customers.Division_ID = first_level_divisions.Division_ID " +
                    "GROUP BY first_level_divisions.Country_ID ORDER BY count(*) desc";
            PreparedStatement getCustomerCount = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = getCustomerCount.executeQuery();
            while (rs.next()) {
                String countryName = rs.getString("Country");
                int customerCount = rs.getInt("customerCount");
                Country results = new Country(countryName, customerCount);
                countryList.add(results);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return countryList;
    }
}
