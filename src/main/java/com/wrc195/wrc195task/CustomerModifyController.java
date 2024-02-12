package com.wrc195.wrc195task;

import DAO.CountriesQuery;
import DAO.FirstLevelDivisionsQuery;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Country;
import model.Customer;
import model.FirstLevelDivision;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerModifyController implements Initializable {

    private final ObservableList<Country> allCountries = CountriesQuery.getAllCountries();

    private final ObservableList<FirstLevelDivision> allDivisions = FirstLevelDivisionsQuery.getAllDivisions();
    private Customer selectedCustomer;

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

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @FXML
    void onActionSaveCustomer(ActionEvent event) {

    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCustomer = CustomersViewController.getCustomerToModify();
        customerCountryCBox.getItems().addAll(allCountries);
        customerDivisionCBox.getItems().addAll(allDivisions);

        customerIDTxt.setText(String.valueOf(selectedCustomer.getCustomerID()));
        customerNameTxt.setText(String.valueOf(selectedCustomer.getCustomerName()));
        customerAddressTxt.setText(String.valueOf(selectedCustomer.getCustomerAddress()));
        customerPostalTxt.setText(String.valueOf(selectedCustomer.getCustomerZip()));
        customerPhoneTxt.setText(String.valueOf(selectedCustomer.getCustomerPhone()));
        customerCountryCBox.setValue(CountriesQuery.returnCountry(selectedCustomer.getCountryID()));
        customerDivisionCBox.setValue(FirstLevelDivisionsQuery.returnDivison(selectedCustomer.getDivisionID()));


    }
}
