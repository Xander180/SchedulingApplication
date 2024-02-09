package com.wrc195.wrc195task;

import DAO.CountriesQuery;
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
import java.util.ResourceBundle;

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

    @FXML
    void onActionSaveCustomer(ActionEvent event) {
        String name = customerNameTxt.getText();
        String address = customerAddressTxt.getText();
        String postal = customerPostalTxt.getText();
        String phone = customerPhoneTxt.getText();



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
            if (division.getCountryID() == selectedCountry.getCountryID()) {
                loadedDivisions.add(division);
            }
        }
        customerDivisionCBox.getItems().clear();
        customerDivisionCBox.getItems().addAll(loadedDivisions);
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerCountryCBox.getItems().addAll(allCountries);
    }
}
