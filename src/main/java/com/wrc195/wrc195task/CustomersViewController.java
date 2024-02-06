package com.wrc195.wrc195task;

import DAO.AppointmentsQuery;
import DAO.CustomersQuery;
import helper.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomersViewController implements Initializable {
    private static Customers customerToModify;

    @FXML
    private TableView<Customers> customersTableView;

    @FXML
    private TableColumn<Customers, String> customerAddressCol;

    @FXML
    private TableColumn<Customers, Integer> customerDivisionIDCol;

    @FXML
    private TableColumn<Customers, Integer> customerIDCol;

    @FXML
    private TableColumn<Customers, String> customerNameCol;

    @FXML
    private TableColumn<Customers, String> customerPhoneCol;

    @FXML
    private TableColumn<Customers, String> customerPostalCol;

    Stage stage;
    Parent scene;

    /**
     *
     * Displays a blank form to create a new customer.
     *
     * @param event App new appointment button.
     * @throws IOException
     */
    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(Main.class.getResource("CustomerAddView.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
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
        customerToModify = customersTableView.getSelectionModel().getSelectedItem();

        if (customerToModify == null) {
            Alerts.getError(6);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this customer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                AppointmentsQuery.deleteAppointment(customerToModify.getCustomerID());
                customersTableView.setItems(CustomersQuery.getAllCustomers());
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
     * Load the CustomerModifyController.
     *
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

            AppointmentModifyController AMController = loader.getController();

            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            loader.load();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
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
        customersTableView.setItems(CustomersQuery.getAllCustomers());

        customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        customerPostalCol.setCellValueFactory(new PropertyValueFactory<>("customerZip"));
        customerPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        customerDivisionIDCol.setCellValueFactory(new PropertyValueFactory<>("divisionID"));
    }
}
