package com.adam.financialapp;

import java.util.HashMap;

/**
 * @author AdamB
 */

public class FinancialExpenses {

    private double totalExpenses;

    private double yearlyExpenses;
    private double monthlyExpenses;
    private double biweeklyExpenses;
    private double weeklyExpenses;

    private double yearlyAvExpenses;
    private double monthlyAvExpenses;
    private double weeklyAvExpenses;

    private double yearTotal;

    private double extraExpensesWeekly;
    private double extraExpensesBiweekly;
    private double extraExpensesMonthly;
    private double extraExpensesYearly;

    //All expenses will be put in this.
    //need a way to seperate single time use and monthly use.
    //Maybe tie it to local time, check if month is different and then add if it is.
    private HashMap<String, expenses> extraExpenses;

    public FinancialExpenses() {
        this.totalExpenses = totalExpenses;
        this.yearlyExpenses = yearlyExpenses;
        this.monthlyExpenses = monthlyExpenses;
        this.biweeklyExpenses = biweeklyExpenses;
        this.weeklyExpenses = weeklyExpenses;
        this.yearlyAvExpenses = yearlyAvExpenses;
        this.monthlyAvExpenses = monthlyAvExpenses;
        this.weeklyAvExpenses = weeklyAvExpenses;
        this.yearTotal = yearTotal;
        this.extraExpensesWeekly = extraExpensesWeekly;
        this.extraExpensesBiweekly = extraExpensesBiweekly;
        this.extraExpensesMonthly = extraExpensesMonthly;
        this.extraExpensesYearly = extraExpensesYearly;
        this.extraExpenses = new HashMap<>();
    }

    //Don't need to set up expenses like with income, yearly and such will be based off of looping through the hashmap

    public void addExpense(String name, int number, double expense) {
        //LOGIC ISSUE, Trying to keep track of expenses using time but the time isnt used within the storage of the expense
        //this means that the time being used right now is being used in the inital creation of the expense profile but not
        //where it should be, which is for each and every single expense log within the internal hashmap. Need a way to fix this
        //maybe two hashmaps that coinside, or a simple object that will take care of the number and time log at the same time
        extraExpenses.put(name, new expenses(name));
        extraExpenses.get(name).addExpense(expense, number);
    }


    public double roundToTwo(double number) {
        return Double.valueOf(Math.round(number * 100)) / 100;
    }


}

