package com.adam.financialapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Scanner;
import javafx.scene.layout.Region;
import javafx.util.Builder;

/**
 *
 * @author AdamB
 */
public class theController {

    private final Builder<Region> view;

    public theController() {

        Financial model = new Financial();
        view = new View(model);
    }

    public Region getView() {
        System.out.println("Before view.build");
        return view.build();
    }
}