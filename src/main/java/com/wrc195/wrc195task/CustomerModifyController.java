package com.wrc195.wrc195task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CustomerModifyController {
    @FXML
    private TableColumn<?, ?> assocApptContactCol;

    @FXML
    private TableColumn<?, ?> assocApptDescCol;

    @FXML
    private TableColumn<?, ?> assocApptEndCol;

    @FXML
    private TableColumn<?, ?> assocApptIDCol;

    @FXML
    private TableColumn<?, ?> assocApptLocationCol;

    @FXML
    private TableColumn<?, ?> assocApptStartCol;

    @FXML
    private TableColumn<?, ?> assocApptTitleCol;

    @FXML
    private TableColumn<?, ?> assocApptTypeCol;

    @FXML
    private TableColumn<?, ?> assocApptUserIDCol;

    @FXML
    private TableView<?> assocApptsTableView;

    @FXML
    private TextField customerAddressTxt;

    @FXML
    private ComboBox<?> customerCountryCBox;

    @FXML
    private ComboBox<?> customerDivisionCBox;

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
    void onActionRemoveAssocAppt(ActionEvent event) {

    }

    @FXML
    void onActionSaveCustomer(ActionEvent event) {

    }
}
