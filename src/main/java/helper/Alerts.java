package helper;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import model.Appointments;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Alerts {

    public static void getError(int errorType) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);

        switch (errorType) {
            case 1:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Username or password is incorrect.");
                errorAlert.showAndWait();
                break;
            case 2:
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText("Le nom d'utilisateur ou le mot de passe est incorrecte.");
                errorAlert.showAndWait();
                break;
            case 3:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Username and password must not be empty.");
                errorAlert.showAndWait();
                break;
            case 4:
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText("Le nom d'utilisateur et le mot de passe ne doivent pas être vides");
                errorAlert.showAndWait();
                break;
            case 5:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("No appointment selected.");
                errorAlert.showAndWait();
                break;
            case 6:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("No customer selected.");
                errorAlert.showAndWait();
                break;
            case 7:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment title cannot be left blank.");
                errorAlert.showAndWait();
                break;
            case 8:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment description cannot be left blank.");
                errorAlert.showAndWait();
                break;
            case 9:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment must have a location.");
                errorAlert.showAndWait();
                break;
            case 10:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Please enter an appointment type.");
                errorAlert.showAndWait();
                break;
            case 11:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment must have a start date/time.");
                errorAlert.showAndWait();
                break;
            case 12:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment must have an end date/time.");
                errorAlert.showAndWait();
                break;
            case 13:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment must have an associated customer ID.");
                errorAlert.showAndWait();
                break;
            case 14:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment must have an associated contact.");
                errorAlert.showAndWait();
                break;
            case 15:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Appointment must have an associated user ID.");
                errorAlert.showAndWait();
                break;
            case 16:
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("Outside of Business Hours");
                errorAlert.setContentText(String.format("Appointment is outside of business hours: 8:00AM to 10:00PM EST\n" +
                        "Please schedule between " + Appointments.localStart().format(DateTimeFormatter.ofPattern("hh:mm")) + " - " + Appointments.localEnd().format(DateTimeFormatter.ofPattern("hh:mm")) + "PM local time."));
                errorAlert.showAndWait();
                break;

        }
    }

    public static void getInfo(int infoType) {

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);

        switch (infoType) {
            case 1:
                infoAlert.setTitle("Appointment Confirmed");
                infoAlert.setHeaderText("New appointment has been created.");
                infoAlert.showAndWait();
                break;
            case 2:

        }
    }

    public static void getConfirmation(Event event, int confirmType) throws IOException {
        Alert confirmAlert;
        Optional<ButtonType> result;

        switch (confirmType) {
            case 1:
                confirmAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to log out?");
                result = confirmAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    Misc.jumpToPage(event, "LoginView.fxml");
                }
            case 2:
                confirmAlert = new Alert(Alert.AlertType.CONFIRMATION, "Data for this form will not be saved. Are you sure?");
                result = confirmAlert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    Misc.jumpToPage(event, "AppointmentsView.fxml");
                }
            case 3:

        }
    }

    public static void getWarning(int warningType) {
        Alert warningAlert = new Alert(Alert.AlertType.WARNING);

        switch (warningType) {
            case 1:
                warningAlert.setTitle("Warning");
                warningAlert.setContentText("Appointment cannot start or end at the same time as an existing appointment.");
                warningAlert.showAndWait();
                break;
            case 2:
                warningAlert.setTitle("Warning");
                warningAlert.setContentText("Appointment cannot start during an an existing appointment.");
                warningAlert.showAndWait();
                break;
            case 3:
                warningAlert.setTitle("Warning");
                warningAlert.setContentText("Appointment cannot end during an an existing appointment.");
                warningAlert.showAndWait();
        }
    }




}
