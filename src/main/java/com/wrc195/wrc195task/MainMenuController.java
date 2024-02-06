package com.wrc195.wrc195task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
    Stage stage;
    Parent scene;
    @FXML
    void onActionAppointments(ActionEvent event) throws IOException {
        Main.jumpToPage(event, "AppointmentsView.fxml");
    }

    @FXML
    void onActionCustomers(ActionEvent event) throws IOException {
        Main.jumpToPage(event, "CustomersView.fxml");
    }

    @FXML
    void onActionLogOut(ActionEvent event) throws IOException {
        Main.jumpToPage(event, "LoginView.fxml");

    }

    @FXML
    void onActionReports(ActionEvent event) throws IOException {
        Main.jumpToPage(event, "ReportsView.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
