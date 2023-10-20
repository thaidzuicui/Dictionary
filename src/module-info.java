module dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens graphic_version to javafx.fxml;
    exports graphic_version;
    exports cmd_version;
    opens cmd_version to javafx.fxml;
}