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
import org.sqlite.SQLiteConnection;
import vereinsverwaltung.data.Mitglied;

/**
 *
 * @author Nikita
 */
public class SQLMitglied {
    public static ArrayList<Mitglied> getAll () {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<Mitglied> Result = new ArrayList<Mitglied>();

        String query = "SELECT * FROM Mitglied;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                    int id = resultSet.getInt("M_ID");
                    String vorname = resultSet.getString("Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("TelefonNR");
                    String email = resultSet.getString("Email");
                    String adresse = resultSet.getString("Adresse");
                    int abteilungsId = resultSet.getInt("Abteilungs_ID");
                    String passwort = resultSet.getString("Passwort");
                    boolean verwalter = resultSet.getBoolean("Verwalter");
                
                Mitglied obj = new Mitglied(vorname, nachname, telefonNr, email, adresse, abteilungsId, id, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
    
    public static ArrayList<Mitglied> getByEmail(String pEmail) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<Mitglied> Result = new ArrayList<Mitglied>();

        String query = "SELECT * FROM Mitglied WHERE Email=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pEmail);
              
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("M_ID");
                    String vorname = resultSet.getString("Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("TelefonNR");
                    String email = resultSet.getString("Email");
                    String adresse = resultSet.getString("Adresse");
                    int abteilungsId = resultSet.getInt("Abteilungs_ID");
                    String passwort = resultSet.getString("Passwort");
                    boolean verwalter = resultSet.getBoolean("Verwalter");
                
                Mitglied obj = new Mitglied(vorname, nachname, telefonNr, email, adresse, abteilungsId, id, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static ArrayList<Mitglied> getById(int pId) {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<Mitglied> Result = new ArrayList<Mitglied>();

        String query = "SELECT * FROM Mitglied WHERE M_ID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pId);
              
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("M_ID");
                    String vorname = resultSet.getString("Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("TelefonNR");
                    String email = resultSet.getString("Email");
                    String adresse = resultSet.getString("Adresse");
                    int abteilungsId = resultSet.getInt("Abteilungs_ID");
                    String passwort = resultSet.getString("Passwort");
                    boolean verwalter = resultSet.getBoolean("Verwalter");
                
                Mitglied obj = new Mitglied(vorname, nachname, telefonNr, email, adresse, abteilungsId, id, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static Mitglied insert (String vorname, String nachname, String telNr, String email, String adresse, int abteilungsId, String passwort, boolean istVerwalter) {
        Connection connection = new SQLConnection().activeVerbindung;
        
        String query = "INSERT INTO Mitglied(Vorname, Nachname, TelefonNR, Email, Adresse, Abteilungs_ID, Passwort, Verwalter) VALUES(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vorname);
            preparedStatement.setString(2, nachname);
            preparedStatement.setString(3, telNr);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, adresse);
            preparedStatement.setInt(6, abteilungsId);
            preparedStatement.setString(7, passwort);
            preparedStatement.setBoolean(8, istVerwalter);
            preparedStatement.executeUpdate();
         
            Mitglied newMitglied = getByEmail(email).get(0);
            
            return newMitglied;
            
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return null;
    }
    
    public static Boolean update(int M_ID, String vorname, String nachname, String telNr, String email, String adresse, int abteilungsId, String passwort, boolean istVerwalter){
        
        Connection connection = new SQLConnection().activeVerbindung;
        
        String query = "UPDATE MITGLIED SET Vorname = ?, Nachname = ?, TelefonNR = ?, Email = ?, Adresse = ?, Abteilungs_ID = ?, passwort = ?, Verwalter = ? WHERE M_ID = ?";
        
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vorname);
            preparedStatement.setString(2, nachname);
            preparedStatement.setString(3, telNr);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, adresse);
            preparedStatement.setInt(6, abteilungsId);
            preparedStatement.setString(7, passwort);
            preparedStatement.setBoolean(8, istVerwalter);
            preparedStatement.setInt(9, M_ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public static Mitglied delete (int M_ID) {
        Connection connection = new SQLConnection().activeVerbindung;

        String query = "DELETE FROM Mitglied WHERE M_ID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, M_ID);
            preparedStatement.executeUpdate();
            System.out.println("Removal was successful");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}

