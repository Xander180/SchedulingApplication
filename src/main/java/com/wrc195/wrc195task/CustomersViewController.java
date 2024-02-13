package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import DAO.CustomersQuery;
import helper.Alerts;
import helper.Misc;
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
import model.Appointment;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomersViewController implements Initializable {
    private static Customer customerToModify;

    @FXML
    private TableView<Customer> customersTableView;

    @FXML
    private TableColumn<Customer, String> customerAddressCol;

    @FXML
    private TableColumn<Customer, Integer> customerDivisionIDCol;

    @FXML
    private TableColumn<Customer, Integer> customerIDCol;

    @FXML
    private TableColumn<Customer, String> customerNameCol;

    @FXML
    private TableColumn<Customer, String> customerPhoneCol;

    @FXML
    private TableColumn<Customer, String> customerPostalCol;

    Stage stage;

    /**
     *
     * Displays a blank form to create a new customer.
     *
     * @param event App new appointment button.
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "CustomerAddView.fxml");
    }

    /**
     * Delete the selected customer.
     * Displays a confirmation dialog box before customer deletion.
     * Customer appointments must be deleted in order to delete customer.
     *
     * @param event Delete Appointment button.
     */
    @FXML
    void onActionDeleteCustomer(ActionEvent event) {
        int totalAppointments = 0;
        customerToModify = customersTableView.getSelectionModel().getSelectedItem();
        ObservableList<Appointment> appointmentsList = AppointmentsQuery.getAllAppointments();

        if (customerToModify == null) {
            Alerts.getError(6);
            return;
        }

        int customerID = customerToModify.getCustomerID();
        for (Appointment appointment : appointmentsList) {
            if (appointment.getCustomerID() == customerID) {
                totalAppointments++;
            }
        }
        if (totalAppointments > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "There are " + totalAppointments + " appointments associated with this customer.\n" +
                    "Press OK to delete customer along with all associated appointments\n" +
                    "or press Cancel to return");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                for (Appointment appointment : appointmentsList) {
                    if (appointment.getCustomerID() == customerID) {
                        AppointmentsQuery.deleteAppointment(appointment.getApptID());
                    }
                }
                Alerts.getInfo(5);
                CustomersQuery.deleteCustomer(customerID);
                customersTableView.setItems(CustomersQuery.getAllCustomers());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this customer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Alerts.getInfo(5);
                CustomersQuery.deleteCustomer(customerToModify.getCustomerID());
                customersTableView.setItems(CustomersQuery.getAllCustomers());
            }
        }
    }

    /**
     *
     * @param event Back button to return to main menu
     * @throws IOException From FXMLLoader
     */
    @FXML
    void onActionExit(ActionEvent event) throws IOException {
        Misc.jumpToPage(event, "MainMenu.fxml");

    }

    /**
     * Load the CustomerModifyController.
     * Display an error if no appointment is selected.
     *
     * @param event Appointment modify button action.
     * @throws IOException From FXMLLoader.
     */
    @FXML
    void onActionModifyCustomer(ActionEvent event) throws IOException {
        customerToModify = customersTableView.getSelectionModel().getSelectedItem();

        if (customerToModify == null) {
            Alerts.getError(6);
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("CustomerModifyView.fxml"));

            loader.getController();

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            loader.load();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    public static Customer getCustomerToModify() { return customerToModify; }

    /**
     * Initialize controller and populate table view.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customersTableView.setItems(CustomersQuery.getAllCustomers());

        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customerPostalCol.setCellValueFactory(new PropertyValueFactory<>("customerZip"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        customerDivisionIDCol.setCellValueFactory(new PropertyValueFactory<>("divisionID"));
    }
}
