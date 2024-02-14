/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vereinsverwaltung.data;

/**
 *
 * @author lukas
 */
public class Mitglied {
    private String name;
    private String telefon;
    private String email;
    private VereinsAbteilung abteilung;
    private String adresse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VereinsAbteilung getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(VereinsAbteilung abteilung) {
        this.abteilung = abteilung;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public Mitglied(String name, String telefon, String email, String adresse) {
        this.name = name;
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
    }
}
