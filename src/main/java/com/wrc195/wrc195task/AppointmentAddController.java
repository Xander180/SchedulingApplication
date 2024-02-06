package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentAddController implements Initializable {

    private int generatedID = 1;

    @FXML
    private TextArea apptDescriptionTxt;

    @FXML
    private DatePicker apptEndDatePicker;

    @FXML
    private Spinner<Integer> apptEndTimeSpinner;

    @FXML
    private TextField apptIDTxt;

    @FXML
    private TextField apptLocationText;

    @FXML
    private DatePicker apptStartDatePicker;

    @FXML
    private Spinner<Integer> apptStartTimeSpinner;

    @FXML
    private TextField apptTitleTxt;

    @FXML
    private TextField apptTypeTxt;

    @FXML
    private ComboBox<String> contactCBox;

    @FXML
    private ChoiceBox<Integer> customerIDCBox;

    @FXML
    private ChoiceBox<Integer> userIDCBox;

    Stage stage;
    Parent scene;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Main.jumpToPage(event, "AppointmentsView.fxml");
    }

    @FXML
    void onActionSaveAppt(ActionEvent event) {

    }

    private int generateID() {
        for (Appointments appointment : AppointmentsQuery.getAllAppointments()) {
            if (appointment.getApptID() == generatedID) {
                generatedID++;
            }
        }
        return generatedID;
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generatedID = generateID();
    }
}
