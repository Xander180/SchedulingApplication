package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import helper.Alerts;
import helper.Misc;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import model.Appointment;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
    ObservableList<Appointment> allAppointments = AppointmentsQuery.getUserAppointments(LoginController.getCurrentUser());

    /**
     * Open the appointments page.
     *
     * @param event Appointments button
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionAppointments(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "AppointmentsView.fxml");
    }

    /**
     * Open the Customers page.
     *
     * @param event Customers button
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionCustomers(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "CustomersView.fxml");
    }

    /**
     * Return to the login page.
     *
     * @param event Log out button
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionLogOut(ActionEvent event) throws IOException {
        Alerts.getConfirmation(event, 1);
    }

    /**
     * Open the Reports page.
     *
     * @param event Reports button
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionReports(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "ReportsView.fxml");
    }

    /**
     * Initialize controller and display a notification for whether an appointment is upcoming
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDateTime currentTime = LocalDateTime.now();
        ZonedDateTime LDTConversion = currentTime.atZone(ZoneId.systemDefault());
        LocalDateTime currentTimePlus15 = LocalDateTime.now().plusMinutes(15);
        LDTConversion.withZoneSameInstant(ZoneId.of("Etc/UTC"));

        boolean isValid = false;
        for (Appointment appointment : allAppointments) {
            LocalDateTime startTime = appointment.getApptStart();
            if (startTime.isAfter(currentTime) || startTime.isEqual(currentTimePlus15) &&
                    (startTime.isBefore(currentTimePlus15) || startTime.isEqual(currentTime))) {
                Alert upcomingAppt = new Alert(Alert.AlertType.WARNING);
                upcomingAppt.setTitle("Upcoming Apopointment");
                upcomingAppt.setContentText("Appointment " + appointment.getApptID() + " " + appointment.getApptTitle() + " is set to begin at"
                + "\n" + appointment.getApptStart().toString());
                upcomingAppt.showAndWait();
                isValid = true;
            }
        }
        if (!isValid) {
            Alerts.getInfo(7);
        }
    }
}
