module es.ieslosmontecillos.loancalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens es.ieslosmontecillos.loancalculator to javafx.fxml;
    exports es.ieslosmontecillos.loancalculator;
}