package com.udemy.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://192.168.0.2:3306/hb-01-one-to-one-uni";
        String user = "hbstudent";
        String pass = "studenthb";

        try {
            System.out.println("Connecting to database...");
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connected!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}
