module es.ieslosmontecillos.loancalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.loancalculator to javafx.fxml;
    exports es.ieslosmontecillos.loancalculator;
}