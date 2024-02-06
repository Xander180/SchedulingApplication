package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import helper.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentsViewController implements Initializable {

    private static Appointments apptToModify;

    @FXML
    private RadioButton allApptsRBtn;

    @FXML
    private TableColumn<Appointments, Integer> apptContactCol;

    @FXML
    private TableColumn<Appointments, Integer> apptCustomerIDCol;

    @FXML
    private TableColumn<Appointments, String> apptDescriptionCol;

    @FXML
    private TableColumn<Appointments, Timestamp> apptEndCol;

    @FXML
    private TableColumn<Appointments, String> apptIDCol;

    @FXML
    private TableColumn<Appointments, String> apptLocationCol;

    @FXML
    private TableColumn<Appointments, Timestamp> apptStartCol;

    @FXML
    private TableColumn<Appointments, String> apptTitleCol;

    @FXML
    private TableColumn<Appointments, String> apptTypeCol;

    @FXML
    private TableColumn<Appointments, Integer> apptUserIDCol;

    @FXML
    private TableView<Appointments> apptsTableView;

    @FXML
    private RadioButton monthlyApptsRBtn;

    @FXML
    private RadioButton weeklyApptsRBtn;

    @FXML
    private ToggleGroup sortAppts;

    Stage stage;
    Parent scene;

    /**
     * Displays a blank form to create a new appointment.
     *
     * @param event App new appointment button.
     * @throws IOException
     */
    @FXML
    void onActionAddAppt(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("AppointmentAddView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Delete the selected appointment.
     * Displays a confirmation dialog box before appointment deletion.
     *
     * @param event Delete Appointment button.
     */
    @FXML
    void onActionDeleteAppt(ActionEvent event) {
        apptToModify = apptsTableView.getSelectionModel().getSelectedItem();

        if (apptToModify == null) {
            Alerts.getError(5);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this appointment?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                AppointmentsQuery.deleteAppointment(apptToModify.getApptID());
                apptsTableView.setItems(AppointmentsQuery.getAllAppointments());
            }
        }
    }

    /**
     *
     * @param event Back button to return to main menu
     * @throws IOException
     */
    @FXML
    void onActionExit(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Load the AppointmentModifyController.
     *
     * Display an error if no appointment is selected.
     *
     * @param event Appointment modify button action.
     * @throws IOException From FXMLLoader.
     */
    @FXML
    void onActionModifyAppt(ActionEvent event) throws IOException {
        apptToModify = apptsTableView.getSelectionModel().getSelectedItem();

        if (apptToModify == null) {
            Alerts.getError(5);
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AppointmentModifyView.fxml"));

            AppointmentModifyController AMController = loader.getController();

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            loader.load();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    /**
     * Display all appointments in the database.
     *
     * @param event Sort by all appointments radio button.
     */
    @FXML
    void selectAllApptsRBtn(ActionEvent event) {
        try {
            ObservableList<Appointments> allAppointments = AppointmentsQuery.getAllAppointments();

            if (allAppointments != null) {
                for (Appointments appointments : allAppointments) {
                    apptsTableView.setItems(allAppointments);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sort appointments to only display those that are set for the current week.
     *
     * @param event Sort by month radio button.
     */
    @FXML
    void selectMonthlyApptsRBtn(ActionEvent event) {
        try {
            ObservableList<Appointments> allAppointments = AppointmentsQuery.getAllAppointments();
            ObservableList<Appointments> appointmentsByMonth = FXCollections.observableArrayList();

            LocalDateTime currentMonthStart = LocalDateTime.now().minusMonths(1);
            LocalDateTime currentMonthEnd = LocalDateTime.now().plusMonths(1);

            if (allAppointments != null) {
                allAppointments.forEach(appointments -> {
                    if (appointments.getApptEnd().isAfter(currentMonthStart) && appointments.getApptEnd().isBefore(currentMonthEnd)) {
                        appointmentsByMonth.add(appointments);
                    }
                    apptsTableView.setItems(appointmentsByMonth);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sort appointments to only display those that are set for the current week.
     *
     * @param event Sort by week radio button.
     */
    @FXML
    void selectWeeklyApptsRBtn(ActionEvent event) {
        try {
            ObservableList<Appointments> allAppointments = AppointmentsQuery.getAllAppointments();
            ObservableList<Appointments> appointmentsByWeek = FXCollections.observableArrayList();

            LocalDateTime currentWeekStart = LocalDateTime.now().minusWeeks(1);
            LocalDateTime currentWeekEnd = LocalDateTime.now().plusWeeks(1);

            if (allAppointments != null) {
                allAppointments.forEach(appointments -> {
                    if (appointments.getApptEnd().isAfter(currentWeekStart) && appointments.getApptEnd().isBefore(currentWeekEnd)) {
                        appointmentsByWeek.add(appointments);
                    }
                    apptsTableView.setItems(appointmentsByWeek);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Initialize controller and populate table view.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allApptsRBtn.setSelected(true);

        apptsTableView.setItems(AppointmentsQuery.getAllAppointments());

        apptIDCol.setCellValueFactory(new PropertyValueFactory<>("apptID"));
        apptTitleCol.setCellValueFactory(new PropertyValueFactory<>("apptTitle"));
        apptDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("apptDescription"));
        apptLocationCol.setCellValueFactory(new PropertyValueFactory<>("apptLocation"));
        apptTypeCol.setCellValueFactory(new PropertyValueFactory<>("apptType"));
        apptStartCol.setCellValueFactory(new PropertyValueFactory<>("apptStart"));
        apptEndCol.setCellValueFactory(new PropertyValueFactory<>("apptEnd"));
        apptCustomerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        apptUserIDCol.setCellValueFactory(new PropertyValueFactory<>("userID"));
        apptContactCol.setCellValueFactory(new PropertyValueFactory<>("contactID"));
    }
}
