/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.io.Serializable;

/**
 *
 * @author lluisgh28
 */
public class HabitacioId implements Serializable {
    
    String nomHotel;
    Integer numero;
    
    public HabitacioId() {
        
    }
    
    public HabitacioId(String nomhotel, Integer numero) {
        this.nomHotel = nomhotel;
        this.numero = numero;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomhotel) {
        this.nomHotel = nomhotel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
        
}
