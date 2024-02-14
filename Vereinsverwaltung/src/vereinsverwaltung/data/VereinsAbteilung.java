/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vereinsverwaltung.data;

/**
 *
 * @author lukas
 */
public class VereinsAbteilung {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    public VereinsAbteilung(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
