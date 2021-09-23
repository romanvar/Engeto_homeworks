package com.engeto.pokusy;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("ahoj");
        Connection dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_eshop", "my_eshop_user", "Ferda123.");
        System.out.println("Connection to db was established");
        Statement statement = dbconnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM my_eshop.ITEM;");
        while(resultSet.next()){
        System.out.println("Jmeno je:" + resultSet.getNString(4));
            System.out.println("Description je: "+resultSet.getNString("description"));
        System.out.println("Cena je:" + resultSet.getBigDecimal("price"));
    }

        dbconnection.close();
    }
}
