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
                    int id = resultSet.getInt("M_ID");
                    String vorname = resultSet.getString("m.Vorname");
                    String nachname = resultSet.getString("Nachname");
                    String telefonNr = resultSet.getString("m.TelefonNR");
                    String email = resultSet.getString("m.E-Mail");
                    String adresse = resultSet.getString("m.Adresse");
                    java.sql.Date inaktivSeit = resultSet.getDate("inaktivSeit");
                    int abteilungsId = resultSet.getInt("Abteilungs_ID");
                    String passwort = resultSet.getString("Passwort");
                    int verwalter = resultSet.getInt("Verwalter");
                
                PassivesMitglied obj = new PassivesMitglied(0, inaktivSeit, vorname, telefonNr, email, adresse, 0, 0, true, adresse)
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return Result;
    }
}

