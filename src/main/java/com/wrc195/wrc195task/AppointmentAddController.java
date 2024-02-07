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
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Appointments;
import model.Contacts;
import model.Customers;
import model.Users;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AppointmentAddController implements Initializable {

    private ObservableList<Contacts> allContacts = ContactsQuery.getAllContacts();
    private ObservableList<Customers> allCustomers = CustomersQuery.getAllCustomers();
    private ObservableList<Users> allUsers = UsersQuery.getAllUsers();

    private int generatedID = 1;

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
    private ChoiceBox<Contacts> contactCBox;

    @FXML
    private ChoiceBox<Customers> customerIDCBox;

    @FXML
    private ChoiceBox<Users> userIDCBox;

    Stage stage;
    Parent scene;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "AppointmentsView.fxml");
    }

    @FXML
    void onActionSaveAppt(ActionEvent event) {
        String title = apptTitleTxt.getText();
        String description = apptDescriptionTxt.getText();
        String location = apptLocationText.getText();
        String type = apptTypeTxt.getText();

        Customers customer = customerIDCBox.getValue();
        if (customer == null) {
            Alerts.getError(13);
            return;
        }
        int customerID = customerIDCBox.getValue().getCustomerID();

        Contacts contact = contactCBox.getValue();
        if (contact == null) {
            Alerts.getError(14);
            return;
        }
        int contactID = contactCBox.getValue().getContactID();

        Users user = userIDCBox.getValue();
        if (user == null) {
            Alerts.getError(15);
            return;
        }
        int userID = userIDCBox.getValue().getUserID();

        LocalDate startDate = apptStartDatePicker.getValue();
        LocalTime startTime = apptStartTimeSpinner.getValue();
        if (startDate == null || startTime == null) {
            Alerts.getError(11);
            return;
        }
        LocalDateTime start = LocalDateTime.of(apptStartDatePicker.getValue(), apptStartTimeSpinner.getValue());

        LocalDate endDate = apptEndDatePicker.getValue();
        LocalTime endTime = apptEndTimeSpinner.getValue();
        if (endDate == null || endTime == null) {
            Alerts.getError(12);
            return;
        }
        LocalDateTime end = LocalDateTime.of(apptEndDatePicker.getValue(), apptEndTimeSpinner.getValue());

        if (title.isEmpty() || title.isBlank()) {
            Alerts.getError(7);
        } else if (description.isEmpty() || description.isBlank()) {
            Alerts.getError(8);
        } else if (location.isEmpty() || location.isBlank()) {
            Alerts.getError(9);
        } else if (type.isEmpty() || type.isBlank()) {
            Alerts.getError(10);
        } else if (Appointments.businessHours(start, end)) {
            Alerts.getError(16);
        }


    }

    private int generateID() {
        for (Appointments appointment : AppointmentsQuery.getAllAppointments()) {
            if (appointment.getApptID() == generatedID) {
                generatedID++;
            }
        }
        return generatedID;
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generatedID = generateID();

        contactCBox.getItems().addAll(allContacts);
        customerIDCBox.getItems().addAll(allCustomers);
        userIDCBox.getItems().addAll(allUsers);
        apptStartTimeSpinner.setValueFactory(Misc.factoryStart);
        apptEndTimeSpinner.setValueFactory(Misc.factoryEnd);


    }
}
