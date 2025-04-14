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
public class extraIncome {

    private String name;
    private double income;
    private int index;
    private double totalIncome;
    private HashMap<Integer, Double> incomeStorage;
    private LocalDateTime now;
    private String timeNow;

    public extraIncome(String name) {
        this.name = name;
        this.income = income;
        this.index = 0;
        this.totalIncome = totalIncome;
        this.incomeStorage = new HashMap<>();
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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getIndex() {
        return index;
    }

//    public double getTotalIncome() {
//        return totalIncome;
//    }

    public void addIncome(double inc, int number) {
        this.income = inc;
        for (int i = 0; i < number; i++) {
            incomeStorage.put(index, income);
            this.index = index + 1;
        }
    }

    public double getIncomeAtIndex(int i) {
        return incomeStorage.get(i);
    }

    public double getIncomeTotal() {
        double tempTotal = 0;
        for (int i = 0; i < incomeStorage.size(); i++) {
            tempTotal = tempTotal + incomeStorage.get(i);
        }
        totalIncome = roundToTwo(tempTotal);
        return totalIncome;
    }

    public double roundToTwo(double number) {
        return Double.valueOf(Math.round(number * 100)) / 100;
    }

}
