package com.wrc195.wrc195task;

import DAO.UsersQuery;
import helper.Alerts;
import helper.Misc;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller for logging in.
 *
 * @author Wilson Ramirez
 */
public class LoginController implements Initializable {
    private final ObservableList<User> allUsers = UsersQuery.getAllUsers();

    private boolean isFrench;

    private static int currentUser;

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

    /**
     * Exits the program.
     *
     * @param event Exit button
     */
    @FXML
    void onActionExit(ActionEvent event) { System.exit(0); }

    /**
     * Logs into scheduling software if username and password match user info in database.
     * Login attempts are recorded in login_activity.txt.
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
            if (usernameTxt.getText().equals(user.userName()) && passwordField.getText().equals(user.userPassword()))  {
                currentUser = user.userID();
                return true;
            }
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
     *
     * @return Currently logged in user for access within other classes.
     */
    public static int getCurrentUser() { return currentUser; }

    /**
     * Interface used to acquire login activity file name for lambda on line 123.
     */
    interface LoginActivity {
        String getFileName();
    }

    /**
     * LAMBDA EXPRESSION #1: Get file name for login activity.
     */
    LoginActivity loginActivity = () -> "login_activity.txt";

    /**
     * Write to login_activity file each login attempt.
     * @throws IOException From FXMLLoader
     */
    public void setLoginActivity() throws IOException {
        FileWriter fileWriter = new FileWriter(loginActivity.getFileName(), true);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
        ZoneId.systemDefault();
        if (checkLogin()) {
            fileWriter.write("Successful login on " + dateTimeFormatter.format(LocalDateTime.now()) + ": " + usernameTxt.getText());
        } else {
            fileWriter.write("Failed login attempt on " + dateTimeFormatter.format(LocalDateTime.now()) + ": " + usernameTxt.getText());
        }
        fileWriter.write("\n");
        fileWriter.close();
    }

    /**
     * Initialize controller and change language to French if system language is French.
     * Only changes log in screen language.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Locale currentLocale = Locale.getDefault();

        //Check if system language is set to French
        // If so, change text language for log in screen and log in errors only.
        if (Objects.equals(currentLocale.getDisplayLanguage(), "français")) {
            isFrench = true;
            localeTxtLbl.setText("Localité actuelle: ");
            passwordLbl.setText("Mot de passe");
            usernameLbl.setText("Nom d'utilisateur");
            welcomeLbl.setText("Bienvenue");
            loginBtn.setText("Se connecter");
            exitBtn.setText("Sortie");
        }

        // Checks user locale and displays it accordingly.
        // Default is U.S.
        if (Objects.equals(currentLocale.getDisplayCountry(), "Canada")) {
            currentLocaleLbl.setText("Canada");
        } else if (Objects.equals(currentLocale.getDisplayCountry(), "Royaume-Uni")) {
            currentLocaleLbl.setText("U.K.");
        }
    }
}