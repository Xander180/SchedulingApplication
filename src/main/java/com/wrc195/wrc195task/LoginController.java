package com.wrc195.wrc195task;

import DAO.UsersQuery;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Users;

import java.net.URI;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private final ObservableList<Users> allUsers = UsersQuery.allUsers();

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

    @FXML
    void onActionExit(ActionEvent event) { System.exit(0); }

    @FXML
    void onActionLogIn(ActionEvent event) {
        if (checkLogin()) {
            System.out.println("Account found.");
        } else {
            System.out.println("Account not found.");
        }

    }

    private boolean checkLogin() {
        for (Users user : allUsers) {
            if (usernameTxt.getText().equals(user.getUserName())  && passwordField.getText().equals(user.getUserPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (System.getProperty("user.language") == "fr") {
            localeTxtLbl.setText("Localité actuelle");
            passwordLbl.setText("Mot de passe");
            usernameLbl.setText("Nom d'utilisateur");
            welcomeLbl.setText("Bienvenue");
        }
    }
}