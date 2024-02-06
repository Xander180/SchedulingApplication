package com.wrc195.wrc195task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ReportsController {
    @FXML
    private TableColumn<?, ?> appointmentCustomerID;

    @FXML
    private TableColumn<?, ?> apptContact;

    @FXML
    private TableColumn<?, ?> apptDescriptionCol;

    @FXML
    private TableColumn<?, ?> apptEnd;

    @FXML
    private TableColumn<?, ?> apptIDCol;

    @FXML
    private TableColumn<?, ?> apptLocation;

    @FXML
    private TableView<?> apptMonthTableView;

    @FXML
    private TableColumn<?, ?> apptMonthTotalsCol;

    @FXML
    private TableColumn<?, ?> apptStartCol;

    @FXML
    private TableColumn<?, ?> apptTitleCol;

    @FXML
    private TableColumn<?, ?> apptTotalsByMonthCol;

    @FXML
    private Tab apptTotalsTab;

    @FXML
    private TableColumn<?, ?> apptTotalsTypeCol;

    @FXML
    private TableColumn<?, ?> apptTypeCol;

    @FXML
    private TableView<?> apptTypeTableView;

    @FXML
    private TableColumn<?, ?> apptTypeTotalCol;

    @FXML
    private ComboBox<?> contactScheduleContactBox;

    @FXML
    private Tab contactScheduleTab;

    @FXML
    private TableView<?> contactScheduleTableView;

    @FXML
    private TableColumn<?, ?> countryNameCol;

    @FXML
    private TableColumn<?, ?> countryTotalsCol;

    @FXML
    private TableView<?> countryTotalsTableView;

    @FXML
    private Tab customerByCountryTab;

    @FXML
    private TableColumn<?, ?> tableContactID;

    @FXML
    void appointmentDataByContact(ActionEvent event) {

    }

    @FXML
    void onActionExit(ActionEvent event) throws IOException {
        Main.jumpToPage(event, "MainMenu.fxml");
    }

    @FXML
    void onSelectApptsTotals(ActionEvent event) {

    }

    @FXML
    void onSelectContactSchedule(ActionEvent event) {

    }

    @FXML
    void onSelectCustomerByCountry(ActionEvent event) {

    }
}
