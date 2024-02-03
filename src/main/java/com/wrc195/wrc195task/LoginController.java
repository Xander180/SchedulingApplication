package com.wrc195.wrc195task;

import DAO.UsersQuery;
import helper.Alerts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Users;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private final ObservableList<Users> allUsers = UsersQuery.allUsers();

    private boolean isFrench;


    @FXML
    private Label currentLocaleLbl;

    @FXML
    private Button exitBtn;

    @FXML
    private Label localeTxtLbl;

    @FXML
    private Button loginBtn;

    @FXML
    private Label passwordLbl;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label usernameLbl;

    @FXML
    private TextField usernameTxt;

    @FXML
    private Label welcomeLbl;

    Stage stage;
    Parent scene;

    @FXML
    void onActionExit(ActionEvent event) { System.exit(0); }

    /**
     * Logs into scheduling software if username and password match user info in database.
     * Displays error if account information is incorrect in English or French.
     *
     * @param event Log In button.
     * @throws IOException From FXMLLoader.
     */
    @FXML
    void onActionLogIn(ActionEvent event) throws IOException {
        if (checkLogin()) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(Main.class.getResource("MainMenu.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        } else if (isFrench){
            Alerts.getError(2);
        } else {
            Alerts.getError(1);
        }

    }

    /**
     *
     * @return true if account is found or false if not.
     */
    private boolean checkLogin() {
        for (Users user : allUsers) {
            if (usernameTxt.getText().equals(user.getUserName())  && passwordField.getText().equals(user.getUserPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Initialize controller and change lanuage to French if system language is French.
     * Only changes log in screen language.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale currentLocale = Locale.getDefault();

        /**
         * Check if system language is set to French
         * If so, change text language for log in screen only.
         */
        if (currentLocale.getDisplayLanguage() == "français") {
            isFrench = true;
            localeTxtLbl.setText("Localité actuelle: ");
            passwordLbl.setText("Mot de passe");
            usernameLbl.setText("Nom d'utilisateur");
            welcomeLbl.setText("Bienvenue");
            loginBtn.setText("Se connecter");
            exitBtn.setText("Sortie");
        }

        /**
         * Checks user locale and displays it accordingly.
         * Default is U.S.
         */
        if (currentLocale.getDisplayCountry() == "Canada") {
            currentLocaleLbl.setText("Canada");
        } else if (currentLocale.getDisplayCountry() == "Royaume-Uni") {
            currentLocaleLbl.setText("U.K.");
        }
    }
}