/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vereinsverwaltung.data;

import java.util.Date;

/**
 *
 * @author lukas
 */
public class EhemaligesMitglied extends Mitglied {
    private int id;
    private Date ausgetretenAm;

    public Date getAusgetretenAm() {
        return ausgetretenAm;
    }

    public int getId() {
        return id;
    }

    public EhemaligesMitglied(int id, Date ausgetretenAm, String vorname, String nachname, String telefon, String email, String adresse, int abteilung_id, int mitglied_id, boolean istVerwalter, String passwort) {
        super(vorname, nachname, telefon, email, adresse, abteilung_id, mitglied_id, istVerwalter, passwort);
        this.id = id;
        this.ausgetretenAm = ausgetretenAm;
    }

    public EhemaligesMitglied(Mitglied mitglied, Date ausgetretenAm, int id) {
        super(mitglied.getVorname(), mitglied.getNachname(), mitglied.getTelefon(), mitglied.getEmail(), mitglied.getAdresse(), mitglied.getAbteilung_id(), mitglied.getId(), mitglied.getIstVerwalter(), mitglied.getPasswort());
        this.ausgetretenAm = ausgetretenAm;
        this.id = id;
    }
    
}
