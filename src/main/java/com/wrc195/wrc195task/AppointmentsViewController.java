package com.wrc195.wrc195task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AppointmentsViewController {
    @FXML
    private RadioButton allApptsRBtn;

    @FXML
    private TableColumn<?, ?> apptContactCol;

    @FXML
    private TableColumn<?, ?> apptCustomerIDCol;

    @FXML
    private TableColumn<?, ?> apptDescriptionCol;

    @FXML
    private TableColumn<?, ?> apptEndCol;

    @FXML
    private TableColumn<?, ?> apptIDCol;

    @FXML
    private TableColumn<?, ?> apptLocationCol;

    @FXML
    private TableColumn<?, ?> apptStartCol;

    @FXML
    private TableColumn<?, ?> apptTitleCol;

    @FXML
    private TableColumn<?, ?> apptTypeCol;

    @FXML
    private TableColumn<?, ?> apptUserIDCol;

    @FXML
    private TableView<?> apptsTableView;

    @FXML
    private RadioButton monthlyApptsRBtn;

    @FXML
    private RadioButton weeklyApptsRBtn;

    Stage stage;
    Parent scene;

    @FXML
    void onActionAddAppt(ActionEvent event) {

    }

    @FXML
    void onActionDeleteAppt(ActionEvent event) {

    }

    @FXML
    void onActionExit(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionModifyAppt(ActionEvent event) {

    }

    @FXML
    void selectAllApptsRBtn(ActionEvent event) {

    }

    @FXML
    void selectMonthlyApptsRBtn(ActionEvent event) {

    }

    @FXML
    void selectWeeklyApptsRBtn(ActionEvent event) {

    }
}
