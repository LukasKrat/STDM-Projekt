/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import vereinsverwaltung.data.VereinsAbteilung;

/**
 *
 * @author Nikita
 */
public class SQLVerwaltung {
    public static ArrayList<VereinsAbteilung> getAll (String[] args) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<VereinsAbteilung> Result = new ArrayList<VereinsAbteilung>();

        String query = "SELECT * FROM VereinsAbteilung;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int vaId = resultSet.getInt("VA_ID");
                String name = resultSet.getString("Name");
                
                VereinsAbteilung obj = new VereinsAbteilung(vaId, name);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
}

