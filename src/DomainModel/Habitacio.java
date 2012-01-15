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
public class Habitacio {
    Integer numero;
    Hotel hotel;
    Set<Reserva> reserves = new HashSet<Reserva>();
    
    /* Atributs requerits pel Hibernate */
    HabitacioId id;
    String nomTipus;
    
    /**
     * Creadora per defecte
     */
    public Habitacio() {    
    }
    
    /**
     * Creadora amb els paràmetres necessaris per a inicialitzar tots els
     * atributs.
     * @param id
     * @param numero
     * @param hotel
     * @param nomTipus 
     */
    public Habitacio(HabitacioId id, Integer numero, Hotel hotel, String nomTipus) {
        this.id = id;
        this.numero = numero;
        this.hotel = hotel;
        this.nomTipus = nomTipus;
    }
    
    /**
     * Retorna si una habitació està disponible entre les dates donades.
     * @param dataInici
     * @param dataFi
     * @return cert si està disponible, fals si no ho està.
     */
    public boolean estaDisp(Date dataInici, Date dataFi) {
        for (Reserva r : reserves) {
            if (r.esSolapa(dataInici, dataFi)) return false;
        }
        return true;
    }
    
    /**
     * Afegeix la reserva donada al conjunt de reserves de l'habitació.
     * @param r 
     */
    public void afReserva(Reserva r) {
        reserves.add(r);
    }

    /**
     * Retorna si una habitació és de l'hotel amb el nom donat.
     * @param nomHotel
     * @return cert si és de l'hotel nomHotel, fals si no ho és.
     */
    boolean esDelHotel(String nomHotel) {
        return this.hotel.getNom().equals(nomHotel);
    }

    /**
     * Getter de l'hotel associat. Requerit per Hibernate.
     * @return 
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Setter de l'hotel associat. Requerit per Hibernate.
     * @param hotel 
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Getter del número.
     * @return 
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Setter del número. Requerit per Hibernate.
     * @param numero 
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Getter del conjunt de reserves. Requerit per Hibernate.
     * @return 
     */
    public Set<Reserva> getReserves() {
        return reserves;
    }

    /**
     * Setter del conjunt de reserves. Requerit per Hibernate.
     * @param reserves 
     */
    public void setReserves(Set<Reserva> reserves) {
        this.reserves = reserves;
    }

    /**
     * Getter de l'identificador requerit per Hibernate.
     * @return 
     */
    public HabitacioId getId() {
        return id;
    }

    /**
     * Setter de l'identificador requerit per Hibernate.
     * @param id 
     */
    public void setId(HabitacioId id) {
        this.id = id;
    }
    
    /**
     * Getter del nom del TipusHabitacio associat requerit per Hibernate.
     * Apareixia als diagrames del primer lliurament, però, degut als canvis
     * en el disseny del cas d'ús ReservarHabitació, deixava de ser necessari.
     * @return 
     */
    public String getNomTipus() {
        return nomTipus;
    }

    /**
     * Setter del nom del TipusHabitació associat requerit per Hibernate.
     * @param nomTipus 
     */
    public void setNomTipus(String nomTipus) {
        this.nomTipus = nomTipus;
    }
    
    /**
     * L'operació esDeltipus(String tipus) que apareixia al primer lliurament
     * no està implementada, ja que no és necessària degut als canvis en el
     * disseny del cas d'ús ReservarHabitacio.
     */
}
