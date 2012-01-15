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
    /**
     * Pels canvis en el disseny del cas d'ús ReservarHabitació,
     * TipusHabitació té navegabilitat cap a les seves habitacions.
     */
    Set<Habitacio> habitacions;
    
    /**
     * Creadora per defecte. Requerida per Hibernate.
     */
    public TipusHabitacio() {      
    }
    
    /**
     * Creadora amb els paràmetres necessaris per a inicialitzar tots els
     * atributs.
     * @param nom
     * @param capacitat
     * @param descripcio 
     */
    public TipusHabitacio(String nom, Integer capacitat, String descripcio) {
        this.nom = nom;
        this.capacitat = capacitat;
        this.descripcio = descripcio;
        this.habitacions = new HashSet<Habitacio>();
    }
    
    /**
     * Retorna el número d'habitacions disponibles d'aquests tipus a l'hotel
     * nomHotel, entre les dates indicades i per al nombre d'ocupants donat.
     * Aquest mètode no apareixia al disseny del primer lliurament. És necessari
     * degut als canvis en el disseny del cas d'ús ReservarHabitació.
     * @param dIni
     * @param dFi
     * @param nomHotel
     * @param numOcup
     * @return
     */
    public Integer numDisp(Date dIni, Date dFi, String nomHotel, Integer numOcup) {
        int num = 0;
        if (this.capacitat >= numOcup) {
            for (Habitacio hab : habitacions) {
                if (hab.esDelHotel(nomHotel) && hab.estaDisp(dIni, dFi)) ++num;
            }
        }
        return num;
    }
    
    /**
     * Retorna el numero d'una habitacio del tipus que és de l'hotel nomHotel
     * i està disponible entre les dates dIni i dFi.
     * Aquest mètode no apareixia al disseny del primer lliurament. És necessari
     * degut als canvis en el disseny del cas d'ús ReservarHabitació.
     * @param nomHotel
     * @param dIni
     * @param dFi
     * @return 
     */
    public Integer obteNumeroHabLliure(String nomHotel, Date dIni, Date dFi) {
        for (Habitacio h : habitacions) {
            if (h.esDelHotel(nomHotel) && h.estaDisp(dIni, dFi)) 
                return h.getNumero();
        }
        return null;
    }

    /**
     * Getter de la capacitat. Requerit per Hibernate.
     * Degut als canvis en el disseny del cas d'ús ReservarHabitació, aquesta
     * operació només és necessària per al Hibernate.
     * @return 
     */
    public Integer getCapacitat() {
        return capacitat;
    }

    /**
     * Setter de la capacitat. Requerit per Hibernate. 
     * @param capacitat 
     */
    public void setCapacitat(Integer capacitat) {
        this.capacitat = capacitat;
    }

    /**
     * Getter de la descripció. Requerit per Hibernate.
     * @return 
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Setter de la descripció. Requerit per Hibernate.
     * @param descripcio 
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * Getter de les habitacions associades. Requerit per Hibernate.
     * @return 
     */
    public Set<Habitacio> getHabitacions() {
        return habitacions;
    }

    /**
     * Setter de les habitacions associades. Requerit per Hibernate.
     * @param habitacions 
     */
    public void setHabitacions(Set<Habitacio> habitacions) {
        this.habitacions = habitacions;
    }

    /**
     * Getter del nom.
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter del nom. Requerit per Hibernate.
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
