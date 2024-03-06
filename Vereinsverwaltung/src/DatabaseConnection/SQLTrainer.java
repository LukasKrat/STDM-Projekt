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
import vereinsverwaltung.data.Trainer;

/**
 *
 * @author Nikita
 */
public class SQLTrainer {
    public static ArrayList<Trainer> getAll (String[] args) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<Trainer> Result = new ArrayList<Trainer>();

        String query = "SELECT * FROM Trainer pm JOIN Mitglied m ON pm.M_ID = m.M_ID;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                    int id = resultSet.getInt("T_ID");
                    String kompBereich = resultSet.getString("kompBereich");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    int abteilungsId = resultSet.getInt("Abteilungs_ID");
                    String passwort = resultSet.getString("Passwort");
                    boolean verwalter = resultSet.getBoolean("Verwalter");
                    int mId = resultSet.getInt("M_ID");
                
                Trainer obj = new Trainer(id, kompBereich, vorname, nachname, telefonNr, email, adresse, abteilungsId, mId, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
    public static ArrayList<Trainer> getByEmail(String pEmail) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<Trainer> Result = new ArrayList<Trainer>();

        String query = "SELECT * FROM Trainer t JOIN Mitglied m ON m.M_ID = t.M_ID WHERE `E-Mail`=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pEmail);
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("t.T_ID");
                    String kompBereich = resultSet.getString("kompBereich");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    int abteilungsId = resultSet.getInt("m.Abteilungs_ID");
                    String passwort = resultSet.getString("m.Passwort");
                    boolean verwalter = resultSet.getBoolean("m.Verwalter");
                    int mitgliedId = resultSet.getInt("m.M_ID");
                Trainer obj = new Trainer(id, kompBereich, vorname, nachname, telefonNr, email, adresse, abteilungsId, mitgliedId, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static Trainer insert(String kompBereich, int M_ID, String email) {
        Connection connection = new SQLConnection().activeVerbindung;
        
        String query = "INSERT INTO Trainer(kompBereich, M_ID) VALUES(?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,kompBereich);
            preparedStatement.setInt(2, M_ID);
            preparedStatement.executeUpdate();
         
            Trainer newMitglied = getByEmail(email).get(0);
            
            return newMitglied;
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return null;
    }
    
        
     public static Trainer delete (int T_ID) {
        Connection connection = new SQLConnection().activeVerbindung;

        String query = "DELETE FROM Trainer WHERE T_ID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, T_ID);
            preparedStatement.executeUpdate();
            System.out.println("Removal was successful");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}

