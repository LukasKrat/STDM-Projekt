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
    private int id;
    private String vorname;
    private String nachname;
    private String telefon;
    private String email;
    private int abteilung_id;
    private String adresse;
    private boolean istVerwalter;
    private String passwort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAbteilung_id() {
        return abteilung_id;
    }

    public void setAbteilung_id(int abteilung_id) {
        this.abteilung_id = abteilung_id;
    }

    public boolean getIstVerwalter() {
        return istVerwalter;
    }

    public void setIstVerwalter(boolean istVerwalter) {
        this.istVerwalter = istVerwalter;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public Mitglied(String vorname, String nachname, String telefon, String email, String adresse, int abteilung_id, int id, boolean istVerwalter, String passwort) {
        this.vorname = vorname;
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
        this.abteilung_id = abteilung_id;
        this.id = id;
        this.istVerwalter = istVerwalter;
        this.passwort = passwort;
        this.nachname = nachname;
    }
}
