module com.example.assignment_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.RacketReservations to javafx.fxml;
    exports com.example.RacketReservations;
}