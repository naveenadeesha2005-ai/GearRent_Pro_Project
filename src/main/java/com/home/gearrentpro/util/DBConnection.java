/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Dell
 */
public class DBConnection {
    
       private static Connection connection;

    // Private constructor (Singleton)
    private DBConnection() {
    }

    // Get database connection
    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {

            String url = "jdbc:mysql://localhost:3306/gearrent_pro";
            String username = "root";
            String password = "1n2a3j4$";

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );
        }

        return connection;
    }
}
