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
import vereinsverwaltung.data.EhemaligesMitglied;

/**
 *
 * @author lukas
 */
public class SQLEhemaligesMitglied {
    /*
    'EM_ID' INT NOT NULL PRIMARY KEY,
	'ausgetretenAm' date NOT NULL,
	'M_ID' INT NOT NULL,
    */
    
    
    public static ArrayList<EhemaligesMitglied> getAll () {
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<EhemaligesMitglied> Result = new ArrayList<EhemaligesMitglied>();

        String query = "SELECT * FROM EhemaligesMitglied pm JOIN Mitglied m ON pm.M_ID = m.M_ID;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                    int id = resultSet.getInt("pm.EM_ID");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("m.Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    Date ausgetretenAm = resultSet.getDate("m.ausgetretenAm");
                    int abteilungsId = resultSet.getInt("m.Abteilungs_ID");
                    String passwort = resultSet.getString("m.Passwort");
                    boolean verwalter = resultSet.getBoolean("m.Verwalter");
                    int mitglied_id = resultSet.getInt("m.id");
                
                EhemaligesMitglied obj = new EhemaligesMitglied(id, ausgetretenAm, vorname, nachname, telefonNr, email, adresse, abteilungsId, mitglied_id, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
    
    public static ArrayList<EhemaligesMitglied> getByEmail(String pEmail){
        Connection connection = new SQLConnection().activeVerbindung;
        ArrayList<EhemaligesMitglied> Result = new ArrayList<EhemaligesMitglied>();

        String query = "SELECT * FROM EhemaligesMitglied em JOIN Mitglied m ON m.M_ID = em.M_ID WHERE `E-Mail`=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pEmail);
             ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    int id = resultSet.getInt("em.PM_ID");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    Date ausgetretenAm = resultSet.getDate("em.ausgetretenAm");
                    int abteilungsId = resultSet.getInt("m.Abteilungs_ID");
                    String passwort = resultSet.getString("m.Passwort");
                    boolean verwalter = resultSet.getBoolean("m.Verwalter");
                    int mitgliedId = resultSet.getInt("m.M_ID");
                EhemaligesMitglied obj = new EhemaligesMitglied(id, ausgetretenAm, vorname, nachname, telefonNr, email, adresse, abteilungsId, mitgliedId, verwalter, passwort);
                Result.add(obj);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
                }
        return Result;
    }
    
    public static EhemaligesMitglied insert(Date ausgetretenAm, int M_ID, String email){
        Connection connection = new SQLConnection().activeVerbindung;
        
        String query = "INSERT INTO EhemaligesMitglied(ausgetretenAm, M_ID) VALUES(?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1,new java.sql.Date(ausgetretenAm.getTime()));
            preparedStatement.setInt(2, M_ID);
            preparedStatement.executeUpdate();
         
            EhemaligesMitglied newMitglied = getByEmail(email).get(0);
            
            return newMitglied;
           
            
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return null;
    }
}
