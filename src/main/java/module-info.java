module com.example.tmr {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.tmr to javafx.fxml;
    exports com.example.tmr;
}