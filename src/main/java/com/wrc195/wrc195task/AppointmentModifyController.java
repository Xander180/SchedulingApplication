package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import DAO.ContactsQuery;
import DAO.CustomersQuery;
import DAO.UsersQuery;
import helper.Alerts;
import helper.Misc;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointment;
import model.Contact;
import model.Customer;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class AppointmentModifyController implements Initializable {
    private Appointment selectedAppt;

    private final ObservableList<Contact> allContacts = ContactsQuery.getAllContacts();
    private final ObservableList<Customer> allCustomers = CustomersQuery.getAllCustomers();
    private final ObservableList<User> allUsers = UsersQuery.getAllUsers();

    @FXML
    private TextArea apptDescriptionTxt;

    @FXML
    private DatePicker apptEndDatePicker;

    @FXML
    private Spinner<LocalTime> apptEndTimeSpinner;

    @FXML
    private TextField apptIDTxt;

    @FXML
    private TextField apptLocationText;

    @FXML
    private DatePicker apptStartDatePicker;

    @FXML
    private Spinner<LocalTime> apptStartTimeSpinner;

    @FXML
    private TextField apptTitleTxt;

    @FXML
    private TextField apptTypeTxt;

    @FXML
    private ChoiceBox<Contact> contactCBox;

    @FXML
    private ChoiceBox<Customer> customerIDCBox;

    @FXML
    private ChoiceBox<User> userIDCBox;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Alerts.getConfirmation(event,2);
    }

    @FXML
    void onActionSaveAppt(ActionEvent event) throws SQLException, IOException {
        int apptID = selectedAppt.getApptID();
        String title = apptTitleTxt.getText();
        String description = apptDescriptionTxt.getText();
        String location = apptLocationText.getText();
        String type = apptTypeTxt.getText();

        // Handle null pointer exception
        Customer customer = customerIDCBox.getValue();
        if (customer == null) {
            Alerts.getError(13);
            return;
        }
        int customerID = customerIDCBox.getValue().getCustomerID();

        // Handle null pointer exception
        Contact contact = contactCBox.getValue();
        if (contact == null) {
            Alerts.getError(14);
            return;
        }
        int contactID = contactCBox.getValue().getContactID();

        // Handle null pointer exception
        User user = userIDCBox.getValue();
        if (user == null) {
            Alerts.getError(15);
            return;
        }
        int userID = userIDCBox.getValue().getUserID();

        // Handle null pointer exception
        LocalDate startDate = apptStartDatePicker.getValue();
        LocalTime startTime = apptStartTimeSpinner.getValue();
        if (startDate == null || startTime == null) {
            Alerts.getError(11);
            return;
        }
        LocalDateTime start = LocalDateTime.of(apptStartDatePicker.getValue(), apptStartTimeSpinner.getValue());

        // Handle null pointer exception
        LocalDate endDate = apptEndDatePicker.getValue();
        LocalTime endTime = apptEndTimeSpinner.getValue();
        if (endDate == null || endTime == null) {
            Alerts.getError(12);
            return;
        }
        LocalDateTime end = LocalDateTime.of(apptEndDatePicker.getValue(), apptEndTimeSpinner.getValue());

        // Handle blank/empty text boxes, and whether appointment overlaps or outside business hours
        if (title.isEmpty() || title.isBlank()) {
            Alerts.getError(7);
        } else if (description.isEmpty() || description.isBlank()) {
            Alerts.getError(8);
        } else if (location.isEmpty() || location.isBlank()) {
            Alerts.getError(9);
        } else if (type.isEmpty() || type.isBlank()) {
            Alerts.getError(10);
        } else if (Appointment.businessHours(start, end)) {
            Alerts.getError(16);
        } else if (Appointment.checkApptOverlap(customerID, start, end)) {
        } else {
            AppointmentsQuery.updateAppointment(apptID, title, description, location, type, start, end, customerID, userID, contactID);
            Alerts.getInfo(2);
            Misc.jumpToPage(event, "AppointmentsView.fxml");
        }
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedAppt = AppointmentsViewController.getApptToModify();
        apptStartTimeSpinner.setValueFactory(Misc.factoryStart);
        apptEndTimeSpinner.setValueFactory(Misc.factoryEnd);
        contactCBox.getItems().addAll(allContacts);
        customerIDCBox.getItems().addAll(allCustomers);
        userIDCBox.getItems().addAll(allUsers);

        apptIDTxt.setText(String.valueOf(selectedAppt.getApptID()));
        apptTitleTxt.setText(String.valueOf(selectedAppt.getApptTitle()));
        apptDescriptionTxt.setText(String.valueOf(selectedAppt.getApptDescription()));
        apptLocationText.setText(String.valueOf(selectedAppt.getApptLocation()));
        apptTypeTxt.setText(String.valueOf(selectedAppt.getApptType()));
        apptStartDatePicker.setValue(selectedAppt.getApptStart().toLocalDate());
        apptStartTimeSpinner.getValueFactory().setValue(selectedAppt.getApptStart().toLocalTime().truncatedTo(ChronoUnit.HOURS));
        apptEndDatePicker.setValue(selectedAppt.getApptEnd().toLocalDate());
        apptEndTimeSpinner.getValueFactory().setValue(selectedAppt.getApptEnd().toLocalTime().truncatedTo(ChronoUnit.HOURS));
        contactCBox.setValue(ContactsQuery.returnContact(selectedAppt.getCustomerID()));
        customerIDCBox.setValue(CustomersQuery.returnCustomer(selectedAppt.getCustomerID()));
        userIDCBox.setValue(UsersQuery.returnUserID(selectedAppt.getUserID()));



    }
}
