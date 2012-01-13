/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lluisgh28
 */
public class TipusHabitacio {
    String nom;
    Integer capacitat;
    String descripcio;
    Set<Habitacio> habitacions;
    
    public TipusHabitacio() {
        
    }
    
    public TipusHabitacio(String nom, Integer capacitat, String descripcio) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.descripcio = descripcio;
        this.habitacions = new HashSet<Habitacio>();
    }
    
    
    public Integer numDisp(Date dIni, Date dFi, String nomHotel, Integer numOcup) {

        int num = 0;
        if (this.capacitat >= numOcup) {
            for (Habitacio hab : habitacions) {
                if (hab.esDelHotel(nomHotel) && hab.estaDisp(dIni, dFi)) ++num;
            }
        }
        return num;
    }
    
    public Integer obteNumeroHabLliure(String nomHotel, Date dIni, Date dFi) {
        for (Habitacio h : habitacions) {
            if (h.esDelHotel(nomHotel) && h.estaDisp(dIni, dFi)) 
                return h.getNumero();
        }
        
        return null;
    }

    public Integer getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(Integer capacitat) {
        this.capacitat = capacitat;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Set<Habitacio> getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(Set<Habitacio> habitacions) {
        this.habitacions = habitacions;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
