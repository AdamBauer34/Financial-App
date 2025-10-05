package com.adam.financialapp;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SQLtables {

    private String url;
    private LocalDateTime now;
    private DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
    private DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("YYYY");

    private String timeMonth;
    private String timeYear;

    public SQLtables() {
        this.url = "jdbc:sqlite:data.db";
        File file = new File("data.db");
        if(!file.exists()){
            System.out.println("Didn't exists");
            setTables();
        } else {
            System.out.println("Database file exsists");
        }
    }

    public void addObject(String name, int type) {
        String sql = "INSERT INTO objects(type,name) VALUES(?,?)";
        try (var conn = DriverManager.getConnection(url)) {
            if(conn != null) {
                PreparedStatement pStat = conn.prepareStatement(sql);
                pStat.setInt(1,type);
                pStat.setString(2,name);
                pStat.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void addIncome(Double cost, String name, int type, int repeating) {
        int month = Integer.valueOf(getMonthNow());
        int year = Integer.valueOf(getYearNow());
        //var maxID = "SELECT MAX(id) AS max_id FROM objects";
        String names = "'" + name + "'";
        var objectID = "SELECT * FROM objects WHERE name = " + names + " and type = " + type;
        String sql = "INSERT INTO income(year,month,costs,repeating,object_id) VALUES(?,?,?,?,?)";
        try (var conn = DriverManager.getConnection(url)) {
            if(conn != null) {

                var stmt = conn.createStatement();
                var ID = stmt.executeQuery(objectID);

                PreparedStatement pStat = conn.prepareStatement(sql);
                pStat.setInt(1,year);
                pStat.setInt(2,month);
                pStat.setDouble(3,cost);
                pStat.setInt(4,repeating);
                pStat.setInt(5,ID.getInt("id"));
                pStat.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addExpense(Double cost, String name, int type, int repeating) {
        int month = Integer.valueOf(getMonthNow());
        int year = Integer.valueOf(getYearNow());
        String names = "'" + name + "'";
        var objectID = "SELECT * FROM objects WHERE name = " + names + " and type = " + type;
        String sql = "INSERT INTO expense(year,month,costs,repeating,object_id) VALUES(?,?,?,?,?)";
        try (var conn = DriverManager.getConnection(url)) {
            if(conn != null) {

                var stmt = conn.createStatement();
                var ID = stmt.executeQuery(objectID);

                PreparedStatement pStat = conn.prepareStatement(sql);
                pStat.setInt(1,year);
                pStat.setInt(2,month);
                pStat.setDouble(3,cost);
                pStat.setInt(4,repeating);
                pStat.setInt(5,ID.getInt("id"));
                pStat.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public String getYearNow() {
        this.now = LocalDateTime.now();
        this.timeYear = now.format(formatterYear);
        return timeYear;
    }

    public String getMonthNow() {
        this.now = LocalDateTime.now();
        this.timeMonth = now.format(formatterMonth);
        return timeMonth;
    }

    public void setTables() {
        var objects = "CREATE TABLE IF NOT EXISTS objects"
                + "(id INTEGER PRIMARY  KEY     NOT NULL,"
                + "type             INT         NOT NULL,"
                + "name             STRING      NOT NULL)";
        // type, 0 is income 1 is expense

        var income = "CREATE TABLE IF NOT EXISTS income "
                + "(id INTEGER PRIMARY  KEY      NOT NULL,"
                + "year             INT          NOT NULL,"
                + "month            INT          NOT NULL,"
                + "costs            DOUBLE       NOT NULL,"
                + "repeating        INT          NOT NULL,"
                + "object_id        INT          NOT NULL,"
                + "FOREIGN KEY(object_id) REFERENCES objects(id))";
        // repeating, 0 no 1 is yes

        var expense = "CREATE TABLE IF NOT EXISTS expense "
                + "(id INTEGER PRIMARY  KEY      NOT NULL,"
                + "year             INT          NOT NULL,"
                + "month            INT          NOT NULL,"
                + "costs            DOUBLE       NOT NULL,"
                + "repeating        INT          NOT NULL,"
                + "object_id        INT          NOT NULL,"
                + "FOREIGN KEY(object_id) REFERENCES objects(id))";

        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var stmt = conn.createStatement();
                stmt.execute(objects);
                stmt.execute(income);
                stmt.execute(expense);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void pullDataAtDateExpenses(int year, int month, String name) {

    }

    public void getAllAtNameExpense(String name){

    }

    public String getObjectName(int id){
        String get = "SELECT * FROM objects WHERE id = " + id;
        String name = null;
        try (var conn = DriverManager.getConnection(url)) {
            if(conn != null) {
                var stmt = conn.createStatement();
                var getName = stmt.executeQuery(get);
                name = getName.getString("name");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return name;
    }

}
