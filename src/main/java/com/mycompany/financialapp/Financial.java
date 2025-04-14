/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financialapp;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author AdamB
 */
public class Financial {

    private Gson gson;
    private FinancialIncome FinIn;
    private FinancialExpenses FinEx;

    public void Financial() {
        start();

    }

    public void start() {
        System.out.println("Start");
        load();
    }

    public void load() {
        String incomePath = "Income.json";
        String expensePath = "Expense.json";
        File incomeFile = new File(incomePath);
        File expenseFile = new File(expensePath);

        if (incomeFile.exists()) {
            try (Reader reader = new FileReader(incomePath)) {
                FinIn = gson.fromJson(reader, FinancialIncome.class);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Income Load Failed");
            }
        } else {
            FinIn = new FinancialIncome();
        }

        if (expenseFile.exists()) {
            try (Reader reader = new FileReader(expensePath)) {
                FinEx = gson.fromJson(reader, FinancialExpenses.class);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Expense Load Failed");
            }
        } else {
            FinIn = new FinancialIncome();
        }

    }

    public void save() {
        
        try (Writer writer = new FileWriter("Income.json")) {
            gson.toJson(FinIn, writer);
        } catch (IOException e) {
            System.out.println("Income Save Failed");
            throw new RuntimeException(e);
        }
        
        try (Writer writer = new FileWriter("Expense.json")) {
            gson.toJson(FinIn, writer);
        } catch (IOException e) {
            System.out.println("Expense Save Failed");
            throw new RuntimeException(e);
        }

    }
}
