/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vereinsverwaltung.data;

/**
 *
 * @author lukas
 */
public class Trainer extends Mitglied {
    private int id;
    private String kompetenzBereich;

    public String getKompetenzBereich() {
        return kompetenzBereich;
    }    
  
    public int getId() {
        return id;
    }

    public Trainer(int id, String kompetenzBereich, String vorname, String nachname, String telefon, String email, String adresse, int abteilung_id, int mitglied_id, boolean istVerwalter, String passwort) {
        super(vorname, nachname, telefon, email, adresse, abteilung_id, mitglied_id, istVerwalter, passwort);
        this.id = id;
        this.kompetenzBereich = kompetenzBereich;
    }
    
    
    
    public Trainer(Mitglied mitglied, String kompetenzBereich, int id) {
        super(mitglied.getVorname(), mitglied.getNachname(), mitglied.getTelefon(), mitglied.getEmail(), mitglied.getAdresse(), mitglied.getAbteilung_id(), mitglied.getId(), mitglied.getIstVerwalter(), mitglied.getPasswort());
        this.kompetenzBereich = kompetenzBereich;
        this.id = id;
    }
    
}
