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
    Set<Reserva> reserves;
    
    /* Atributs requerits pel Hibernate */
    HabitacioId id;
    
    public Habitacio() {
        
    }
    
    public Habitacio(HabitacioId id, Integer numero, Hotel hotel) {
        this.id = id;
        this.numero = numero;
        this.hotel = hotel;
        this.reserves = new HashSet<Reserva>();
    }
        
    public boolean estaDisp(Date dataInici, Date dataFi) {
        for (Reserva r : reserves) {
            if (r.esSolapa(dataInici, dataFi)) return false;
        }
        return true;
    }

    public void afReserva(Reserva r) {
        reserves.add(r);
    }

    boolean esDelHotel(String nomHotel) {
        return this.hotel.getNom().equals(nomHotel);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Set<Reserva> getReserves() {
        return reserves;
    }

    public void setReserves(Set<Reserva> reserves) {
        this.reserves = reserves;
    }

    public HabitacioId getId() {
        return id;
    }

    public void setId(HabitacioId id) {
        this.id = id;
    }
}
