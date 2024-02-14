package helper;

import com.wrc195.wrc195task.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Misc {

    /**
     * Used to display hours in Spinner type variables.
     */
    public static SpinnerValueFactory<LocalTime> factoryStart = new SpinnerValueFactory<>() {

        {
            setValue(defaultValue());
        }

        private LocalTime defaultValue() {
            return LocalTime.now().truncatedTo(ChronoUnit.HOURS);
        }

        @Override
        public void decrement(int steps) {
            LocalTime value = getValue();
            setValue(value == null ? defaultValue() : value.minusHours(steps));
        }

        @Override
        public void increment(int steps) {
            LocalTime value = getValue();
            setValue(value == null ? defaultValue() : value.plusHours(steps));
        }


    };

    public static SpinnerValueFactory<LocalTime> factoryEnd = new SpinnerValueFactory<>() {

        {
            setValue(defaultValue());
        }

        private LocalTime defaultValue() {
            return LocalTime.now().truncatedTo(ChronoUnit.HOURS);
        }

        @Override
        public void decrement(int steps) {
            LocalTime value = getValue();
            setValue(value == null ? defaultValue() : value.minusHours(steps));
        }

        @Override
        public void increment(int steps) {
            LocalTime value = getValue();
            setValue(value == null ? defaultValue() : value.plusHours(steps));
        }


    };

    /**
     * Used to jump between .fxml scenes.
     *
     * @param event Event triggered, such as a button press.
     * @param pageName .fxml scene to switch to.
     * @throws IOException From FXMLLoader.
     */
    public static void jumpToPage(ActionEvent event, String pageName) throws IOException {
        Main.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.scene = FXMLLoader.load(Main.class.getResource(pageName));
        Main.stage.setScene(new Scene(Main.scene));
        Main.stage.centerOnScreen();
        Main.stage.show();
    }
}
