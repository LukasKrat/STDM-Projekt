/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import org.sqlite.JDBC;

/**
 *
 * @author Nikita
 */
public class SQLConnection {
        public static String dbPath = "./../Datenbank/Vereinsverwaltung.db"; //must write the path 
        public static Connection activeVerbindung = null;
        
        private Connection connect(String dbPath) {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            Class.forName(JDBC.class.getName());
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite successful");
        } catch (Exception e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
        public SQLConnection (){
            if(activeVerbindung == null){
                activeVerbindung = connect(dbPath);
            }
        }
}
