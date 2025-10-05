module com.adam.financialapp {
    requires javafx.controls;
    requires javafx.fxml;
    //requires com.google.gson;
    requires jdk.compiler;
    requires java.sql;
    requires java.desktop;


    opens com.adam.financialapp to javafx.fxml;
    exports com.adam.financialapp;
}