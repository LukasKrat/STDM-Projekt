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
public class PassivesMitglied extends Mitglied {
    private Date inaktivSeit;

    public Date getInaktivSeit() {
        return inaktivSeit;
    }
    
    public PassivesMitglied(String name, String telefon, String email, String adresse, Date inaktivSeit) {
        super(name, telefon, email, adresse);
        this.inaktivSeit = inaktivSeit;
    }
    
    public PassivesMitglied(Mitglied mitglied, Date inaktivSeit) {
        super(mitglied.getName(), mitglied.getTelefon(), mitglied.getEmail(), mitglied.getAdresse());
        this.inaktivSeit = inaktivSeit;
    }
}
