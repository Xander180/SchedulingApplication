package com.wrc195.wrc195task;

import helper.Misc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerAddController implements Initializable {
    @FXML
    private TextField customerAddressTxt;

    @FXML
    private ComboBox<String> customerCountryCBox;

    @FXML
    private ComboBox<String> customerDivisionCBox;

    @FXML
    private TextField customerIDTxt;

    @FXML
    private TextField customerNameTxt;

    @FXML
    private TextField customerPhoneTxt;

    @FXML
    private TextField customerPostalTxt;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "CustomersView.fxml");
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

    }
}
