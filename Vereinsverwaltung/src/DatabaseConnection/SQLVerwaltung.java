/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConnection;
import static DatabaseConnection.SQLPassivesMitglied.getByEmail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import vereinsverwaltung.data.PassivesMitglied;
import vereinsverwaltung.data.VereinsAbteilung;

/**
 *
 * @author Nikita
 */
public class SQLVerwaltung {
    public static ArrayList<VereinsAbteilung> getAll () {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<VereinsAbteilung> Result = new ArrayList<VereinsAbteilung>();

        String query = "SELECT * FROM VereinsAbteilung;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int vaId = resultSet.getInt("VA_ID");
                String name = resultSet.getString("Name");
                
                VereinsAbteilung obj = new VereinsAbteilung(vaId, name);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
    
    public static ArrayList<VereinsAbteilung> getByName(String pName) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<VereinsAbteilung> Result = new ArrayList<VereinsAbteilung>();

        String query = "SELECT * FROM VereinsAbteilung WHERE Name=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pName);
              
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("VA_ID");
                    String name = resultSet.getString("Name");
                
                    VereinsAbteilung obj = new VereinsAbteilung(id, name);
                    
                    Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static ArrayList<VereinsAbteilung> getById(int pID) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<VereinsAbteilung> Result = new ArrayList<VereinsAbteilung>();

        String query = "SELECT * FROM VereinsAbteilung WHERE VA_ID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pID);
              
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("VA_ID");
                    String name = resultSet.getString("Name");
                
                    VereinsAbteilung obj = new VereinsAbteilung(id, name);
                    
                    Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static VereinsAbteilung insert (String name) {
        Connection connection = new SQLConnection().activeVerbindung;
        
        String query = "INSERT INTO VereinsAbteilung(Name) VALUES(?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
         
            VereinsAbteilung newMitglied = getByName(name).get(0);
            
            return newMitglied;
            
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return null;
    }
    
    public static VereinsAbteilung delete (int VA_ID) {
        Connection connection = new SQLConnection().activeVerbindung;

        String query = "DELETE FROM VereinsAbteilung WHERE VA_ID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, VA_ID);
            preparedStatement.executeUpdate();
            System.out.println("Removal was successful");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}

