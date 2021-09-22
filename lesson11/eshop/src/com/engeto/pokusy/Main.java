package com.engeto.pokusy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("ahoj");
        Connection dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_eshop","my_eshop_user","Ferda123.");
        System.out.println("Connection to db was established");
        dbconnection.close();
    }
}
