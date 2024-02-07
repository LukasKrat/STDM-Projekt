/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Nikita
 */
public class SQLConnection {
        public static Connection connect(String dbPath) {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite successful");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}
