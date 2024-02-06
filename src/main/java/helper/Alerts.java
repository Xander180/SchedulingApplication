package helper;

import javafx.scene.control.Alert;

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
