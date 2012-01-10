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
    
    String nomhotel;
    Integer numero;
    
    public HabitacioId() {
        
    }
    
    public HabitacioId(String nomhotel, Integer numero) {
        this.nomhotel = nomhotel;
        this.numero = numero;
    }

    public String getNomhotel() {
        return nomhotel;
    }

    public void setNomhotel(String nomhotel) {
        this.nomhotel = nomhotel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
        
}
