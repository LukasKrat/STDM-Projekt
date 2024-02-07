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
    
    private String kompetenzBereich;

    public String getKompetenzBereich() {
        return kompetenzBereich;
    }    
    
    public Trainer(String name, String telefon, String email, String adresse, String kompetenzBereich) {
        super(name, telefon, email, adresse);
        this.kompetenzBereich = kompetenzBereich;
    }
    
    public Trainer(Mitglied mitglied, String kompetenzBereich) {
        super(mitglied.getName(), mitglied.getTelefon(), mitglied.getEmail(), mitglied.getAdresse());
        this.kompetenzBereich = kompetenzBereich;
    }
    
}
