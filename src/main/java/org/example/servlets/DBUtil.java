package org.example.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        String url = "jdbc:mysql://localhost:3306/commentdb";
        String username = "root";
        String password = "adminP@ss";
        return DriverManager.getConnection(url, username, password);
    }
}
