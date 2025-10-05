package com.adam.financialapp;

import java.awt.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import com.sun.tools.javac.Main;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setColumnSpan;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author AdamB
 */
public class View implements Builder<Region> {

    private final Financial model;
    private BorderPane bPane;
    private String url;

    public View(Financial model) {
        this.model = model;
        this.bPane = new BorderPane();
        this.url = "jdbc:sqlite:data.db";
    }

    @Override
    public Region build() {
        bPane.setPrefSize(1024, 768);
        bPane.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/styleSheet.css")).toExternalForm());
        /*if(model.getFinProf() == false){
            bPane.setCenter(profileStart());
        } else {
            bPane.setLeft(MainMenu());
        }*/
        bPane.setLeft(MainMenu());
        return bPane;
    }

    private Node MainMenu() {
        VBox box = new VBox();
        box.getChildren().addAll(homeButton(), moneyButton(), historyButton());
        box.getStyleClass().add("main-menu");
        box.setSpacing(20);
        box.setPadding(new Insets(20));
        return box;
    }

    private Node profileStart(){
        Label name = new Label("What's your name?");
        TextField nameText = new TextField("");
        nameText.getStyleClass().add("text-field");
        name.getStyleClass().add("general-text");
        nameText.setPrefWidth(150);
        nameText.setMinWidth(150);

        Button enter = profileEnterButton();

        enter.setOnAction(event -> {
            String temp = String.valueOf(nameText);
            System.out.println("Shit");
            //model.saveProfile(temp);
            //SAVE NEEDS ADDED
            System.out.println("oh");
            bPane.setCenter(null);
            bPane.setLeft(MainMenu());
            System.out.println("Fuck");
        });

        VBox box = new VBox();
        HBox box2 = new HBox();
        box2.getChildren().addAll(nameText, enter);
        box2.setSpacing(15);
        box2.setAlignment(Pos.CENTER);
        box.getChildren().addAll(name, box2);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));
        box.setSpacing(15);
        return box;
    }

    // Select between income or expense
    private Node moneyScreenOne(){
        Button addIncome = new Button("Add Income");
        Button addExpense = new Button("Add Expense");

        //Find a better way, don't want check if tables are made each time
        model.startTables();

        addIncome.setOnAction((evt -> {
            bPane.setCenter(moneyIncomeList());
            bPane.setRight(moneyAddIncomeButtons());
        }));

        addExpense.setOnAction((evt -> {
            bPane.setCenter(moneyAddExpense());
        }));

        addIncome.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        addIncome.setEffect(dropShadow());
                    }
                });
        addIncome.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        addIncome.setEffect(null);
                    }
                });


        addExpense.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        addExpense.setEffect(dropShadow());
                    }
                });
        addExpense.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        addExpense.setEffect(null);
                    }
                });


        HBox box = new HBox();
        addIncome.getStyleClass().add("money-buttons");
        addExpense.getStyleClass().add("money-buttons");
        box.setAlignment(Pos.TOP_CENTER);
        box.setPadding(new Insets(100));
        box.getChildren().addAll(addIncome, addExpense);
        box.setSpacing(50);
        return box;
    }

    private Node moneyAddIncomeButtons(){
        Button addIncome = new Button("Add New Income");
        addIncome.setOnAction((evt -> {
            bPane.setCenter(moneyAddIncome());
        }));
        //Button editIncome = new Button("Edit Existing Income");
        addIncome.getStyleClass().add("money-buttons");
        HBox box = new HBox();

        box.getChildren().addAll(addIncome);
        box.setPadding(new Insets(50));
        box.setSpacing(50);

        return box;
    }

    //For entering information on the Income, will add to both objects and income table
    private Node moneyAddIncome(){
        Button enter = new Button("Enter");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        ColumnConstraints colum1 = new ColumnConstraints();
        colum1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);

        Label nameLabel = new Label("Name:");
        TextField nameTF = new TextField("");
        pane.add(nameLabel, 0, 1);
        pane.add(nameTF, 1,1);

        Label costLabel = new Label("Value:");
        TextField costTF = new TextField("");
        pane.add(costLabel, 0, 2);
        pane.add(costTF, 1,2);

        Label repeatingLabel = new Label("Repeating?");
        CheckBox repeatingCheck = new CheckBox("");
        pane.add(repeatingLabel, 0, 3);
        pane.add(repeatingCheck, 1,3);

        pane.add(enter,2,4);

        pane.getStyleClass().add("general-text");

        int repeat = 0;
        if(repeatingCheck.isSelected()){

        }

        enter.setOnAction(( evt -> {
            model.addIncome(nameTF.getText(), Double.valueOf(costTF.getText()),repeatingCheck.isSelected());
        }));

        //type is 0
        //month and year be added in SQLtable

        return pane;
    }
    //Lists already in use income
    private Node moneyIncomeList(){
        var objectInfo = "SELECT * FROM objects WHERE type = " + 0;
        GridPane pane = new GridPane();
        int index = 0;
        int col = 0;
        int row = 0;
        //List<Button> incomeButtons = new Button();
        try (var conn = DriverManager.getConnection(url)) {
            var stmt = conn.createStatement();
            var rs = stmt.executeQuery(objectInfo);
            if(conn != null) {
                while (rs.next()) {
                    if((index == 10)){
                        col += 1;
                    }
                    if((index == 20)){
                        col += 1;
                    }
                    if((index == 30)){
                        col += 1;
                    } //need a new way to do this to extend it further and forever
                    Button button = new Button(rs.getString("name"));
                    button.getStyleClass().add("money-buttons");
                    button.setOnAction(evt -> {
                        try {
                            System.out.println(rs.getString("name"));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });

                    button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button.setEffect(dropShadow());
                                }
                            });
                    button.addEventHandler(MouseEvent.MOUSE_EXITED,
                            new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button.setEffect(null);
                                }
                            });

                    pane.add(button, col, row);
                    index++;
                    row++;
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //pane.getStylesheets().add("money-buttons");
        return pane;
    }

    //Shows options for history screen, Income Expense total (maybe try dropdown to keep it all on one page?)
    private Node historyScreenOne(){
        //Options for viewing all by month or year
        //Viewing meaning from one month to another month or year to another year
        //option to view specific expenses/income and their totals
        return null;
    }

    private Node moneyAddExpense(){
        return null;
    }

    private Node moneyExpenseList(){
        return null;
    }

    //Buttons
    private Button profileEnterButton(){
        Button enter = new Button("Enter");
        enter.setMinWidth(75);
        enter.getStyleClass().add("general-buttons");
        enter.setOnAction(event ->{
            System.out.println("damn");
        });

        enter.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        enter.setEffect(dropShadow());
                    }
                });
        enter.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        enter.setEffect(null);
                    }
                });

        return enter;
    }
    private Button homeButton(){
        Button home = new Button();
        Image house = new Image("file:src/main/resources/com/Icons/Home.png");
        home.setGraphic(new ImageView(house));
        home.setMinWidth(50);
        home.getStyleClass().add("main-menu-buttons");

        home.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        home.setEffect(dropShadow());
                    }
                });
        home.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        home.setEffect(null);
                    }
                });

        return home;
    }

    private Button moneyButton(){
        Button money = new Button();
        Image house = new Image("file:src/main/resources/com/Icons/Dollar.png");
        money.setGraphic(new ImageView(house));
        money.setMinWidth(50);
        money.getStyleClass().add("main-menu-buttons");

        money.setOnAction((evt -> {
            bPane.setCenter(moneyScreenOne());
        }));

        money.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        money.setEffect(dropShadow());
                    }
                });
        money.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        money.setEffect(null);
                    }
                });

        return money;
    }

    private Button historyButton(){
        Button history = new Button();
        Image house = new Image("file:src/main/resources/com/Icons/Book.png");
        history.setGraphic(new ImageView(house));
        history.setMinWidth(50);
        history.getStyleClass().add("main-menu-buttons");

        history.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        history.setEffect(dropShadow());
                    }
                });
        history.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        history.setEffect(null);
                    }
                });

        return history;
    }

    public DropShadow dropShadow(){
        DropShadow shadow = new DropShadow();
        return shadow;
    }

}