module com.example.databrase {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.mysql.databrase to javafx.fxml;
    exports com.mysql.databrase;
}