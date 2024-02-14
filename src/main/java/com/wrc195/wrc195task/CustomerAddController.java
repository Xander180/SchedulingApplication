package com.wrc195.wrc195task;

import DAO.CountriesQuery;
import DAO.CustomersQuery;
import DAO.FirstLevelDivisionsQuery;
import helper.Alerts;
import helper.Misc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Country;
import model.FirstLevelDivision;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Controller for adding customers.
 *
 * @author Wilson Ramirez
 */
public class CustomerAddController implements Initializable {

    private final ObservableList<Country> allCountries = CountriesQuery.getAllCountries();

    private final ObservableList<FirstLevelDivision> allDivisions = FirstLevelDivisionsQuery.getAllDivisions();

    @FXML
    private TextField customerAddressTxt;

    @FXML
    private ComboBox<Country> customerCountryCBox;

    @FXML
    private ComboBox<FirstLevelDivision> customerDivisionCBox;

    @FXML
    private TextField customerIDTxt;

    @FXML
    private TextField customerNameTxt;

    @FXML
    private TextField customerPhoneTxt;

    @FXML
    private TextField customerPostalTxt;

    /**
     * Cancel current form
     * Display a confirmation dialog box
     *
     * @param event Cancel form button
     * @throws IOException From FXMLoader
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Alerts.getConfirmation(event, 3);
    }

    /**
     * Create a new customer entry in the database.
     * Check for blank/empty text boxes, as well as unselected choice boxes.
     *
     * @param event Save customer button.
     * @throws SQLException For unhandled SQL exceptions.
     * @throws IOException For FXMLLoader.
     */
    @FXML
    void onActionSaveCustomer(ActionEvent event) throws SQLException, IOException {
        String name = customerNameTxt.getText();
        String address = customerAddressTxt.getText();
        String postal = customerPostalTxt.getText();
        String phone = customerPhoneTxt.getText();

        // Handle null pointer exception
        Country country = customerCountryCBox.getValue();
        if (country == null) {
            Alerts.getError(21);
            return;
        }

        FirstLevelDivision FLD = customerDivisionCBox.getValue();
        if (FLD == null) {
            Alerts.getError(22);
            return;
        }
        int customerDivision = FLD.divisionID();

        // Handle blank/empty text boxes
        if (name.isEmpty() || name.isBlank()) {
            Alerts.getError(17);
        } else if (address.isEmpty() || address.isBlank()) {
            Alerts.getError(18);
        } else if (postal.isEmpty() || postal.isBlank()) {
            Alerts.getError(19);
        } else if (phone.isEmpty() || phone.isBlank()) {
            Alerts.getError(20);
        } else {
            CustomersQuery.addCustomer(name, address, postal, phone, customerDivision);
            Alerts.getInfo(3);
            Misc.jumpToPage(event, "CustomersView.fxml");
        }
    }

    /**
     * Loads first level divisions based on country selected.
     *
     * @param event Country choice box
     */
    @FXML
    void onActionChangeCountry(ActionEvent event) {
        Country selectedCountry = customerCountryCBox.getValue();
        ObservableList<FirstLevelDivision> loadedDivisions = FXCollections.observableArrayList();

        for (FirstLevelDivision division : allDivisions) {
            if (division.countryID() == selectedCountry.getCountryID()) {
                loadedDivisions.add(division);
            }
        }
        customerDivisionCBox.getItems().clear();
        customerDivisionCBox.getItems().addAll(loadedDivisions);
    }

    /**
     * Initialize controller and populate Country choicebox
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerCountryCBox.getItems().addAll(allCountries);
    }
}
