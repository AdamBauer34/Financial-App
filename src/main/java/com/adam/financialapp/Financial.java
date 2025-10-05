package com.adam.financialapp;

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

    private FinancialIncome FinIn;
    private FinancialExpenses FinEx;
    private FinancialProfile FinProf;
    private SQLtables sqltables;

    public Financial() {
        start();
        this.sqltables = new SQLtables();
    }

    public void start() {
        System.out.println("Start");
        //saveProfile("name");
        System.out.println("end");
    }

    public void startTables(){
        sqltables.setTables();
    }

    public void addIncome(String name, Double value, Boolean repeating) {
        int repeat = 0;
        int type = 0;
        if (repeating == true){
            repeat = 1;
        }
        sqltables.addObject(name, type);
        sqltables.addIncome(value, name, type, repeat);
    }

    /*public void load() {
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
            FinEx = new FinancialExpenses();
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
    public Boolean getFinProf(){
        if(FinProf==null) {
            return false;
        } else {
            return true;
        }
    }

    public void saveProfile(String name){
        FinProf = new FinancialProfile(name);
        try (Writer writer = new FileWriter("Profile.json")) {
            gson.toJson(FinProf, writer);
        } catch (IOException e) {
            System.out.println("Income Save Failed");
            throw new RuntimeException(e);
        }
    }*/
}