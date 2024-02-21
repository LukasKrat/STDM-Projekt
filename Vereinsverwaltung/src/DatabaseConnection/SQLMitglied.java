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
import vereinsverwaltung.data.Mitglied;

/**
 *
 * @author Nikita
 */
public class SQLMitglied {
    public static ArrayList<Mitglied> getAll (String[] args) {
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
                    String email = resultSet.getString("E-Mail");
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
}

