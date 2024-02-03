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
            case 2:
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText("Le nom d'utilisateur ou le mot de passe est incorrecte.");
                errorAlert.showAndWait();
        }
    }

    public static void getInfo(int infoType) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
    }

    public static void getConfirmation(int confirmType) {
        Alert confirmAlert = new Alert((Alert.AlertType.CONFIRMATION));
    }




}
