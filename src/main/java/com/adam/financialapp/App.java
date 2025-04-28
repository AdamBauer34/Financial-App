package com.adam.financialapp;

import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
//public class App {

//    public static void main(String[] args) {
//        Financial main = new Financial();
//        main.Financial();
//    }
//}

public class App extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        theController controller = new theController();
        Scene scene = new Scene(controller.getView());

        System.out.println("Before scene");
        stage.setScene(scene);
        System.out.println("Before stage");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}