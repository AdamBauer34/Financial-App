/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.financialapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author AdamB
 */
public class FinancialAveragingTest {

    @Test
    public void getYearlyTest(){
        FinancialIncome finAv = new FinancialIncome();
        finAv.setYearly(50000.00);
        double result = finAv.getYearly();
        assertEquals(50000.00, result, "50000.00 should equal 50000.00");
        
    }
    @Test
    public void getMonthlyTest(){
        FinancialIncome finAv = new FinancialIncome();
        finAv.setMonthly(5000.00);
        double result = finAv.getMonthly();
        assertEquals(5000.00, result, "5000.00 should equal 5000.00");
        
    }
    @Test
    public void getBiweeklyTest(){
        FinancialIncome finAv = new FinancialIncome();
        finAv.setBiweekly(1000.00);
        double result = finAv.getBiweekly();
        assertEquals(1000.00, result, "1000.00 should equal 1000.00");
        
    }
    @Test
    public void getWeeklyTest(){
        FinancialIncome finAv = new FinancialIncome();
        finAv.setWeekly(500.00);
        double result = finAv.getWeekly();
        assertEquals(500.00, result, "500.00 should equal 500.00");
        
    }
    @Test
    public void RoundTwoTest(){
        FinancialIncome finAv = new FinancialIncome();
        double result1 = finAv.roundToTwo(.055);
        double result2 = finAv.roundToTwo(1.0565);
        double result3 = finAv.roundToTwo(50000.111);
        double result4 = finAv.roundToTwo(60000000.142364582);
        
        assertEquals(0.06, result1, "0.055 should round to 0.06");
        assertEquals(1.06, result2, "1.0565 should round to 1.06");
        assertEquals(50000.11, result3, "50000.111 should round to 50000.11");
        assertEquals(60000000.14, result4, "60000000.142364582 should round to 60000000.14");
    }
    @Test
    public void yearTotalTest(){
        FinancialIncome finAv1 = new FinancialIncome();
        FinancialIncome finAv2 = new FinancialIncome();
        FinancialIncome finAv3 = new FinancialIncome();
        FinancialIncome finAv4 = new FinancialIncome();
        
        finAv1.setYearly(52000.00);
        finAv2.setMonthly(4333.33);
        finAv3.setBiweekly(1500.52);
        finAv4.setWeekly(1093.63);
        
        double result1 = finAv1.getYearTotal();
        double result2 = finAv2.getYearTotal();
        double result3 = finAv3.getYearTotal();
        double result4 = finAv4.getYearTotal();
        
        assertEquals(52000.00, result1, "52000.00 yearly is equal to 52000.00");
        assertEquals(51999.96, result2, "4333.33 monthly rounds to 51999.96");
        assertEquals(39013.52, result3, "1500.52 biweekly is 39013.52 yearly");
        assertEquals(56868.76, result4, "1093.63 weekly is 56868.76 yearly");
        
    }


}
