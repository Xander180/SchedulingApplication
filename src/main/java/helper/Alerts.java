package helper;

import javafx.scene.control.Alert;
import model.Appointments;

import java.time.format.DateTimeFormatter;

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
                errorAlert.setTitle("");
                errorAlert.setHeaderText("Outside of Business Hours");
                errorAlert.setContentText(String.format("Appointment is outside of business hours: 8:00AM to 10:00PM EST\n" +
                        "Please schedule between " + Appointments.localStart().format(DateTimeFormatter.ofPattern("hh:mm")) + " - " + Appointments.localEnd().format(DateTimeFormatter.ofPattern("hh:mm")) + "PM local time."));
                errorAlert.showAndWait();
                break;

        }
    }

    public static void getInfo(int infoType) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
    }

    public static void getConfirmation(int confirmType) {
        Alert confirmAlert = new Alert((Alert.AlertType.CONFIRMATION));

        switch (confirmType) {
            case 1:

        }
    }




}
