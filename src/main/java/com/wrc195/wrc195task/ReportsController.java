package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import DAO.ContactsQuery;
import DAO.CountriesQuery;
import helper.Misc;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointment;
import model.Contact;
import model.Country;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * Controller for viewing all reports.
 *
 * @author Wilson Ramirez
 */
public class ReportsController implements Initializable {
    private final ObservableList<Contact> allContacts = ContactsQuery.getAllContacts();

    @FXML
    private TableColumn<Appointment, Integer> apptCustomerIDCol;

    @FXML
    private TableColumn<Appointment, String> apptDescriptionCol;

    @FXML
    private TableColumn<Appointment, LocalDateTime> apptEndCol;

    @FXML
    private TableColumn<Appointment, Integer> apptIDCol;

    @FXML
    private TableColumn<Appointment, String> apptLocationCol;

    @FXML
    private TableView<Appointment> apptMonthTableView;

    @FXML
    private TableColumn<Appointment, Integer> apptMonthTotalsCol;

    @FXML
    private TableColumn<Appointment, LocalDateTime> apptStartCol;

    @FXML
    private TableColumn<Appointment, String> apptTitleCol;

    @FXML
    private TableColumn<Appointment, Integer> apptMonthCol;

    @FXML
    private Tab apptTotalsTab;

    @FXML
    private TableColumn<Appointment, String> apptTotalsTypeCol;

    @FXML
    private TableColumn<Appointment, String> apptTypeCol;

    @FXML
    private TableView<Appointment> apptTypeTableView;

    @FXML
    private TableColumn<Appointment, Integer> apptTypeTotalCol;

    @FXML
    private ComboBox<Contact> contactCBox;

    @FXML
    private Tab contactScheduleTab;

    @FXML
    private TableView<Appointment> contactScheduleTableView;

    @FXML
    private TableColumn<Country, String> countryNameCol;

    @FXML
    private TableColumn<Country, Integer> countryTotalsCol;

    @FXML
    private TableView<Country> countryTotalsTableView;

    @FXML
    private Tab customerByCountryTab;

    @FXML
    private TableColumn<Appointment, Integer> apptContactIDCol;

    @FXML
    private TabPane reportsTabPane;


    /**
     * Reports active appointments based on selected contact.
     *
     * @param event Sort by selected contact combo box.
     */
    @FXML
    void onActionSortByContact(ActionEvent event) {
        int contactID = contactCBox.getValue().contactID();

        contactScheduleTableView.setItems(AppointmentsQuery.getUserAppointments(contactID));

        apptIDCol.setCellValueFactory(new PropertyValueFactory<>("apptID"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("apptTitle"));
        apptDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("apptDescription"));
        apptLocationCol.setCellValueFactory(new PropertyValueFactory<>("apptLocation"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        apptStartCol.setCellValueFactory(new PropertyValueFactory<>("apptStart"));
        apptEndCol.setCellValueFactory(new PropertyValueFactory<>("apptEnd"));
        apptCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        apptContactIDCol.setCellValueFactory(new PropertyValueFactory<>("contactID"));

    }

    /**
     *
     * @param event Back button to return to main menu
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionExit(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "MainMenu.fxml");
    }

    /**
     *
     * @param event Appointment totals tab
     */
    @FXML
    void onSelectApptsTotals(Event event) {

    }

    /**
     *
     * @param event Contact schedule tab.
     */
    @FXML
    void onSelectContactSchedule(Event event) {

    }

    /**
     *
     * @param event Customers by country tab.
     */
    @FXML
    void onSelectCustomerByCountry(Event event) {

    }

    /**
     * Initialize controller and populate all report information.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contactCBox.getItems().addAll(allContacts);

        apptTypeTableView.setItems(AppointmentsQuery.getAppointmentType());
        apptTotalsTypeCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        apptTypeTotalCol.setCellValueFactory(new PropertyValueFactory<>("apptTypeTotal"));

        apptMonthTableView.setItems(AppointmentsQuery.getAppointmentMonth());
        apptMonthCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        apptMonthTotalsCol.setCellValueFactory(new PropertyValueFactory<>("apptTypeTotal"));

        countryTotalsTableView.setItems(CountriesQuery.getCustomersByCountry());
        countryNameCol.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        countryTotalsCol.setCellValueFactory(new PropertyValueFactory<>("customerCountByCountry"));
    }
}
