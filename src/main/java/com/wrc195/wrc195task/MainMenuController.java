package com.wrc195.wrc195task;

import helper.Alerts;
import helper.Misc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
    Stage stage;
    Parent scene;
    @FXML
    void onActionAppointments(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "AppointmentsView.fxml");
    }

    @FXML
    void onActionCustomers(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "CustomersView.fxml");
    }

    @FXML
    void onActionLogOut(ActionEvent event) throws IOException {
        Alerts.getConfirmation(event, 1);
    }

    @FXML
    void onActionReports(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "ReportsView.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
