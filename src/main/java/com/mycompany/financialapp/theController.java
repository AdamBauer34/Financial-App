/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financialapp;

import java.util.Scanner;
import javafx.scene.layout.Region;
import javafx.util.Builder;

/**
 *
 * @author AdamB
 */
public class theController {

    //private final Builder<Region> view;

    public theController() {

        Financial model = new Financial();
        //view = new View(model);
    }

    public Region getView() {
        System.out.println("Before view.build");
        return null; //view.build();
    }
}
