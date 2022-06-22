package com.gym;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Connectivity {
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/gym";

    final static String USER = "karuchiu";
    final static String PASS = "karuchiu";

    public static Connection openConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = (Connection) DriverManager.getConnection(
                DB_URL, "karuchiu", "karuchiu");
             return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
