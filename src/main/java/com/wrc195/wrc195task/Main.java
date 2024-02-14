package com.wrc195.wrc195task;

import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Scheduling program implement an application for managing
 * customer records and associated appointments scheduled.
 *
 *
 *
 * Javadoc is located in /src/main/javadoc
 * .fxml form files are located in src/main/resources/com/wrc195/wrc195task
 *
 * Lambda expression #1 is located in LoginController at line 135
 * Lambda expression #2 is located in AppointmentsViewController at line 188
 * Lambda expression #3 is located in AppointmentsViewController at line 215
 *
 * @author Wilson Ramirez
 */
public class Main extends Application {
    public static Stage stage;
    public static Parent scene;

    /**
     * Start method to create the FXML stage and load the initial scene.
     *
     * @param stage Stage
     * @throws IOException From FXMLLoader
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Scheduling System");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Entry point of the application.
     *
     * @param args Launch arguments
     */
    public static void main(String[] args) {
        JDBC.openConnection();
        launch(args);
        JDBC.closeConnection();

    }

}