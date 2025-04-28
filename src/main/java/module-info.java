module com.adam.financialapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.adam.financialapp to javafx.fxml;
    exports com.adam.financialapp;
}