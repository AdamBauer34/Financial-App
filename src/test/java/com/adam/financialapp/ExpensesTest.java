package com.adam.financialapp;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;



public class ExpensesTest {

    @Test
    public void getNameTest() {
        expenses ex = new expenses("Name");
        String result = ex.getName();
        assertEquals("Name", result, "Name should equal Name");
    }

    @Test
    public void getTotalOfMonthTest() {
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);

        double result = ex.getTotalOfMonth(year, month);

        assertEquals(10.41, result, "2.5+3.66+4.25 should be 10.41");
    }
    @Test
    public void getTotalOfYearTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);

        double result = ex.getTotalOfYear(year);

        assertEquals(10.41, result, "2.5+3.66+4.25 should be 10.41");
    }
    @Test
    public void getTotalMultipleYearTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);

        int year1 = 2000;
        int year2 = Integer.valueOf(year);

        double result = ex.getTotalMultipleYear(year1, year2);

        assertEquals(10.41, result, "2.5+3.66+4.25 should be 10.41");
    }
    @Test
    public void getTotalMultipleMonthTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);

        int month1 = Integer.valueOf(month);
        int month2 = 12;
        int year1 = Integer.valueOf(year);

        double result = ex.getTotalMultipleMonth(month1, month2, year);

        assertEquals(10.41, result, "2.5+3.66+4.25 should be 10.41");
    }

    @Test
    public void getTotalChargesMonthTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);

        double result = ex.getTotalChargesMonth(month, year);

        assertEquals(3, result, "There were only 3 charges charged to the month");
    }
    @Test
    public void getTotalChargesYearTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);
        ex.addToStorage(5.0);

        double result = ex.getTotalChargesYear(year);

        assertEquals(4, result, "There were only 4 charges charged to the month");
    }

    @Test
    public void getTotalChargesMultipleMonthTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);
        ex.addToStorage(5.0);

        double result = ex.getTotalChargesMultipleMonths(1,12,year);

        assertEquals(4, result, "There were only 4 charges charged to the month");
    }

    @Test
    public void getTotalChargesMultipleYearsTest(){
        expenses ex = new expenses("Name");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatY = DateTimeFormatter.ofPattern("YYYY");
        DateTimeFormatter formatM = DateTimeFormatter.ofPattern("MM");
        String year = now.format(formatY);
        String month = now.format(formatM);
        int year1 = Integer.valueOf(year);

        ex.addToStorage(2.5);
        ex.addToStorage(3.66);
        ex.addToStorage(4.25);
        ex.addToStorage(5.0);

        double result = ex.getTotalChargesMultipleYears(2020, year1);

        assertEquals(4, result, "There were only 4 charges charged to the month");
    }
}
