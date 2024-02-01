package com.wrc195.wrc195task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AppointmentsViewController {
    @FXML
    private RadioButton allApptsRBtn;

    @FXML
    private TableColumn<?, ?> apptContactCol;

    @FXML
    private TableColumn<?, ?> apptCustomerIDCol;

    @FXML
    private TableColumn<?, ?> apptDescriptionCol;

    @FXML
    private TableColumn<?, ?> apptEndCol;

    @FXML
    private TableColumn<?, ?> apptIDCol;

    @FXML
    private TableColumn<?, ?> apptLocationCol;

    @FXML
    private TableColumn<?, ?> apptStartCol;

    @FXML
    private TableColumn<?, ?> apptTitleCol;

    @FXML
    private TableColumn<?, ?> apptTypeCol;

    @FXML
    private TableColumn<?, ?> apptUserIDCol;

    @FXML
    private TableView<?> apptsTableView;

    @FXML
    private RadioButton monthlyApptsRBtn;

    @FXML
    private RadioButton weeklyApptsRBtn;

    @FXML
    void onActionAddAppt(ActionEvent event) {

    }

    @FXML
    void onActionDeleteAppt(ActionEvent event) {

    }

    @FXML
    void onActionExit(ActionEvent event) {

    }

    @FXML
    void onActionModifyAppt(ActionEvent event) {

    }

    @FXML
    void selectAllApptsRBtn(ActionEvent event) {

    }

    @FXML
    void selectMonthlyApptsRBtn(ActionEvent event) {

    }

    @FXML
    void selectWeeklyApptsRBtn(ActionEvent event) {

    }
}
