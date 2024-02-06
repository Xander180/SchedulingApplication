module com.wrc195.wrc195task {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;


    opens com.wrc195.wrc195task to javafx.fxml, javafx.base;
    opens model to javafx.fxml, javafx.base;
    exports com.wrc195.wrc195task;
    exports model;
}