/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vereinsverwaltung;

import java.util.Date;

/**
 *
 * @author lukas
 */
public class EhemaligesMitglied extends Mitglied {
    
    private Date ausgetretenAm;

    public Date getAusgetretenAm() {
        return ausgetretenAm;
    }
    
    public EhemaligesMitglied(String name, String telefon, String email, String adresse, Date ausgetretenAm) {
        super(name, telefon, email, adresse);
        this.ausgetretenAm = ausgetretenAm;
    }
    
    public EhemaligesMitglied(Mitglied mitglied, Date ausgetretenAm) {
        super(mitglied.getName(), mitglied.getTelefon(), mitglied.getEmail(), mitglied.getAdresse());
        this.ausgetretenAm = ausgetretenAm;
    }
    
}
