package com.wrc195.wrc195task;

import DAO.UsersQuery;
import helper.Alerts;
import helper.Misc;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private final ObservableList<User> allUsers = UsersQuery.getAllUsers();

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
        setLoginActivity();
        if (checkLogin()) {
            Misc.jumpToPage(event, "MainMenu.fxml");
        }
    }

    /**
     *
     * @return false if fields are empty or account not found, else true.
     */
    private boolean checkLogin() {

        if (!validateEmptyFields()) return false;

        for (User user : allUsers) {
            if (usernameTxt.getText().equals(user.getUserName()) || passwordField.getText().equals(user.getUserPassword()))  return true;
        }
        if (isFrench) {
            Alerts.getError(2);
        } else Alerts.getError(1);
        return false;
    }

    /**
     *
     * @return false if username or password field is empty, else true.
     */
    private boolean validateEmptyFields() {
        if (usernameTxt.getText().isEmpty() || passwordField.getText().isEmpty()) {
            if (isFrench) {
                Alerts.getError(4);
            } else Alerts.getError(3);

            return false;
        }
        return true;
    }

    /**
     * Interface used to acquire login activity file name for lambda on line 123.
     */
    interface LoginActivity {
        public String getFileName();
    }

    /**
     * LAMBDA EXPRESSION #1: Get file name for login activity.
     */
    LoginActivity loginActivity = () -> "login_activity.txt";

    /**
     * Write to login_activity file each login attempt.
     *
     * @throws IOException
     */
    public void setLoginActivity() throws IOException {
        FileWriter fileWriter = new FileWriter(loginActivity.getFileName(), true);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
        ZoneId localZone = ZoneId.systemDefault();
        if (checkLogin()) {
            fileWriter.write("Successful login on " + dateTimeFormatter.format(LocalDateTime.now()) + ": " + usernameTxt.getText());
        } else {
            fileWriter.write("Failed login attempt on " + dateTimeFormatter.format(LocalDateTime.now()) + ": " + usernameTxt.getText());
        }
        fileWriter.write("\n");
        fileWriter.close();
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
         * If so, change text language for log in screen and log in errors only.
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