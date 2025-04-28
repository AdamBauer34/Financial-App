package com.adam.financialapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author AdamB
 */
public class expenses {

    private String name;
    private double expenses;
    private int index;
    private double totalExpenses;
    private HashMap<Integer, Double> expensesStorage;
    private LocalDateTime now;
    private String timeNow;

    private String timeMonth;

    private String timeYear;
    private String year;
    private String month;
    private int repeatCheck;

    private HashMap<String, HashMap<String, List<Double>>> dateStorage;

    private DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
    private DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("YYYY");

    public expenses(String name) {
        this.name = name;
        this.expenses = expenses;
        this.index = 0;
        this.totalExpenses = totalExpenses;
        this.expensesStorage = new HashMap<>();
        this.now = LocalDateTime.now();

        this.dateStorage = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        //DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");

        //DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");
        setTime();
    }


    //if repeach check is 0 it does not repeat, if its 1 let it repeat. Do it via a check loop?

    public void setTime() {
        this.now = LocalDateTime.now();
        this.timeYear = now.format(formatterYear);
        this.timeMonth = now.format(formatterMonth);
    }

    public void addToStorage(double expense) {
        this.now = LocalDateTime.now();
        if (!dateStorage.containsKey(timeYear)) {
            dateStorage.put(timeYear, new HashMap<String, List<Double>>());
        }
        if (!dateStorage.get(timeYear).containsKey(timeMonth)) {
            dateStorage.get(timeYear).put(timeMonth, new ArrayList<Double>());
        }
        dateStorage.get(timeYear).get(timeMonth).add(expense);
    }
    public double getTotalOfMonth(String year, String month) {
        double total = 0.0;

        if(!dateStorage.containsKey(year)){
            return 0.0;
        }
        if(!dateStorage.get(year).containsKey(month)){
            return 0.0;
        }

        for (int i = 0; i < dateStorage.get(year).get(month).size(); i++) {
            total = total + dateStorage.get(year).get(month).get(i);
        }
        return total;
    }
    public double getTotalOfYear(String year) {
        double total = 0.0;
        if(!dateStorage.containsKey(year)){
            return 0.0;
        }

            for (var m : dateStorage.get(year).entrySet()) {
                String month = m.getKey();
                for (int i = 0; i < m.getValue().size(); i++) {
                    total = total + m.getValue().get(i);
                }
            }
            return total;

    }
    public double getTotalMultipleYear(int year1, int year2){
        double total = 0.0;
        int index = year1;
        while(index <= year2){
            String year = Integer.toString(index);
            total = total + getTotalOfYear(year);
            index++;
        }
        return total;
    }
    public double getTotalMultipleMonth(int month1, int month2, String year){
        double total = 0.0;
        int index = month1;
        while(index <= month2){
            String month = Integer.toString(index);
            if(index < 10){
                String months = Integer.toString(index);
                String temp = "0" + months;
                month = temp;
            }
            total = total + getTotalOfMonth(year, month);
            index++;
        }
        return total;
    }
    //new
    public int getTotalChargesMonth(String month, String year) {
        if(!dateStorage.containsKey(year)){
            return 0;
        }
        if(!dateStorage.get(year).containsKey(month)) {
            return 0;
        }
        return dateStorage.get(year).get(month).size();
    }

    public int getTotalChargesYear(String year){
        int total = 0;
        if(!dateStorage.containsKey(year)) {
            return 0;
        }
        for(var m : dateStorage.get(year).entrySet()) {
            total = total + m.getValue().size();
        }
        return total;
    }

    public int getTotalChargesMultipleMonths(int month1, int month2, String year){
        int total = 0;
        int index = month1;
        while(index <= month2){
            String month = Integer.toString(index);
            if(index <= 10){
                String months = Integer.toString(index);
                String temp = "0" + months;
                month = temp;
            }
            total = total + getTotalChargesMonth(month, year);
            index++;
        }
        return total;
    }

    public int getTotalChargesMultipleYears(int year1, int year2){
        int total = 0;
        int index = year1;
        while(index <= year2){
            String year = Integer.toString(index);
            total = total + getTotalChargesYear(year);
            index++;
        }
        return total;
    }

    public void setRepeatChecker(int check) {
        this.repeatCheck = check;
    }

    public int repeatChecker() {
        return repeatCheck;
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

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public int getIndex() {
        return index;
    }

    //Number meaning how many times this expense was done at once
    public void addExpense(double exp, int number) {
        this.expenses = exp;
        for (int i = 0; i < number; i++) {
            expensesStorage.put(index, expenses);
            this.index = index + 1;
        }
    }

    public double getExpnesesAtIndex(int i) {
        return expensesStorage.get(i);
    }

    public double getIncomeTotal() {
        double tempTotal = 0;
        for (int i = 0; i < expensesStorage.size(); i++) {
            tempTotal = tempTotal + expensesStorage.get(i);
        }
        totalExpenses = roundToTwo(tempTotal);
        return totalExpenses;
    }

    public double roundToTwo(double number) {
        return Double.valueOf(Math.round(number * 100)) / 100;
    }
}
