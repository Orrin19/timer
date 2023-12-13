module app {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;

    opens app to javafx.fxml;
    exports app;
}
