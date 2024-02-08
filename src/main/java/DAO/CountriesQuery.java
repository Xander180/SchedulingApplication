package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CountriesQuery {

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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCountries;
    }

    public static void checkDateConversion() {
        System.out.println("CREATE DATA TEST");
        String sql = "SELECT Create_Date FROM countries";
        try {
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("Create_Date");
                System.out.println("CD: " + ts.toLocalDateTime().toString());
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
