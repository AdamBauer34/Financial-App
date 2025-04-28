package com.adam.financialapp;

import java.util.ArrayList;
import java.util.Objects;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

/**
 *
 * @author AdamB
 */
public class View implements Builder<Region> {

    private final Financial model;

    public View(Financial model) {
        this.model = model;
    }

    @Override
    public Region build() {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(1024, 768);
        return pane;
    }

}