/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financialapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 *
 * @author AdamB
 */
public class Expenses {

    private String name;
    private double expenses;
    private int index;
    private double totalExpenses;
    private HashMap<Integer, Double> expensesStorage;
    private LocalDateTime now;
    private String timeNow;

    public Expenses(String name) {
        this.name = name;
        this.expenses = expenses;
        this.index = 0;
        this.totalExpenses = totalExpenses;
        this.expensesStorage = new HashMap<>();
        this.now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyy HH:mm:ss");
        this.timeNow = now.format(formatter);
    }
    
    public String getName() {
        return name;
    }
    
    public String getTime() {
        return timeNow;
    }
    
    public double getExpenses() {
        return expenses;
    }
    
    public void setExpenses( double expenses) {
        this.expenses = expenses;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void addExpense(double exp, int number) {
        this.expenses = exp;
        for(int i = 0; i < number; i++) {
            expensesStorage.put(index, expenses);
            this.index = index + 1;
        }
    }
    
    public double getExpnesesAtIndex(int i){
        return expensesStorage.get(i);
    }
    
    public double getIncomeTotal() {
        double tempTotal = 0;
        for(int i = 0; i < expensesStorage.size(); i++){
            tempTotal= tempTotal + expensesStorage.get(i);
        }
        totalExpenses = roundToTwo(tempTotal);
        return totalExpenses;
    }

    public double roundToTwo(double number) {
        return Double.valueOf(Math.round(number * 100)) / 100;
    }
}
