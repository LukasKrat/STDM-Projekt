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
import vereinsverwaltung.data.Mitglied;
import vereinsverwaltung.data.PassivesMitglied;

/**
 *
 * @author Nikita
 */
public class SQLPassivesMitglied {
    public static ArrayList<PassivesMitglied> getAll (String[] args) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<PassivesMitglied> Result = new ArrayList<PassivesMitglied>();

        String query = "SELECT * FROM PassivMitglied pm JOIN Mitglied m ON pm.M_ID = m.M_ID;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                    int id = resultSet.getInt("pm.PM_ID");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    Date inaktivSeit = resultSet.getDate("pm.inaktivSeit");
                    int abteilungsId = resultSet.getInt("m.Abteilungs_ID");
                    String passwort = resultSet.getString("m.Passwort");
                    boolean verwalter = resultSet.getBoolean("m.Verwalter");
                    int mitgliedId = resultSet.getInt("m.M_ID");
                
                PassivesMitglied obj = new PassivesMitglied(id, inaktivSeit, vorname, nachname, telefonNr, email, adresse, abteilungsId, mitgliedId, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
    
    public static ArrayList<PassivesMitglied> getByEmail(String pEmail) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<PassivesMitglied> Result = new ArrayList<PassivesMitglied>();

        String query = "SELECT * FROM PassivMitglied pm JOIN Mitglied m ON m.M_ID = pm.M_ID WHERE `E-Mail`=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pEmail);
              
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("pm.PM_ID");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    Date inaktivSeit = resultSet.getDate("pm.inaktivSeit");
                    int abteilungsId = resultSet.getInt("m.Abteilungs_ID");
                    String passwort = resultSet.getString("m.Passwort");
                    boolean verwalter = resultSet.getBoolean("m.Verwalter");
                    int mitgliedId = resultSet.getInt("m.M_ID");
                
                PassivesMitglied obj = new PassivesMitglied(id, inaktivSeit, vorname, nachname, telefonNr, email, adresse, abteilungsId, mitgliedId, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static PassivesMitglied insert (int mitgliedId, String mitgliedEmail, Date inaktivSeit) {
        Connection connection = new SQLConnection().activeVerbindung;
        
        String query = "INSERT INTO PassivMitglied(inaktivSeit, M_ID) VALUES(?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new java.sql.Date(inaktivSeit.getTime()));
            preparedStatement.setInt(2,mitgliedId);
            preparedStatement.executeUpdate();
         
            PassivesMitglied newMitglied = getByEmail(mitgliedEmail).get(0);
            
            return newMitglied;
            
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return null;
    }
    
     public static PassivesMitglied delete (int PM_ID) {
        Connection connection = new SQLConnection().activeVerbindung;

        String query = "DELETE FROM PassivMitglied WHERE PM_ID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, PM_ID);
            preparedStatement.executeUpdate();
            System.out.println("Removal was successful");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}

