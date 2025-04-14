/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.financialapp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author AdamB
 */
public class FinancialIncome {
    
    private double yearlyPay;
    private double monthlyPay;
    private double biweeklyPay;
    private double weeklyPay;
    
    private double yearlyAvPay;
    private double monthlyAvPay;
    private double weeklyAvPay;
    
    private double yearTotal;
    
    private double extraIncomeWeekly;
    private double extraIncomeBiweekly;
    private double extraIncomeMonthly;
    private double extraIncomeYearly;
    
    private ArrayList<Double> extraIncomeList;
    
    //private HashMap<Integer, Double> extraIncomeInside;
    private HashMap<String, extraIncome> extraIncome;
    
    private double extraIncomeSingleTotal;
            
    public FinancialIncome () {
        this.yearlyPay = yearlyPay;
        this.monthlyPay = monthlyPay;
        this.biweeklyPay = biweeklyPay;
        this.weeklyPay = weeklyPay;
        
        this.yearlyAvPay = yearlyAvPay;
        this.monthlyAvPay = monthlyAvPay;
        this.weeklyAvPay = weeklyAvPay;
        
        this.yearTotal = yearTotal;
        
        this.extraIncomeWeekly = extraIncomeWeekly;
        this.extraIncomeBiweekly = extraIncomeBiweekly;
        this.extraIncomeMonthly = extraIncomeMonthly;
        this.extraIncomeYearly = extraIncomeYearly;
        
        this.extraIncome = new HashMap<>();
        
        this.extraIncomeSingleTotal = extraIncomeSingleTotal;
    }

    
    
    //Work Income
    public double getYearly() {
        return yearlyPay;
    }

    public void setYearly(double yearly) {
        this.yearlyPay = yearly;
        yearTotal = yearlyPay;
    }

    public double getMonthly() {
        return monthlyPay;
    }

    public void setMonthly(double monthly) {
        this.monthlyPay = monthly;
        yearTotal = roundToTwo(monthlyPay*12);
    }

    public double getBiweekly() {
        return biweeklyPay;
    }

    public void setBiweekly(double biweekly) {
        this.biweeklyPay = biweekly;
        yearTotal = roundToTwo(biweeklyPay*(52/2));
    }

    public double getWeekly() {
        return weeklyPay;
    }

    public void setWeekly(double weekly) {
        this.weeklyPay = weekly;
        yearTotal = roundToTwo(weeklyPay*52);
    }
    
    public double getYearTotal(){
        return yearTotal;
    }
    
    
    //Extra Income
    public void addExtranIncome(String name, int number, double income) { 
        extraIncome.put(name, new extraIncome(name));
        extraIncome.get(name).addIncome(income, number);
    }
    
    public double getExtraIncomeWeekly() {
        return extraIncomeWeekly;
    }
    
    public void setExtraIncomeWeekly(double extraWeekly) {
        this.extraIncomeWeekly = extraWeekly;
    }
    
    
    public double roundToTwo(double number) {
        return Double.valueOf(Math.round(number * 100)) / 100;
    }
    
    
    
}
