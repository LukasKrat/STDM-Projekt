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
                    Date inaktivSeit = resultSet.getDate("inaktivSeit");
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
}

