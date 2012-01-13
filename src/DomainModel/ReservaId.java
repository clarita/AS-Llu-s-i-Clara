/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lluisgh28
 */
public class ReservaId implements Serializable {
    HabitacioId habitacioId;
    Date dataInici;

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public HabitacioId getHabitacioId() {
        return habitacioId;
    }

    public void setHabitacioId(HabitacioId habitacioId) {
        this.habitacioId = habitacioId;
    }
    
    public String getNomHotel() {
        return this.habitacioId.getNomHotel();
    }
    
    public void setNomHotel(String nomHotel) {
        this.habitacioId.setNomHotel(nomHotel);
    }
    
    public Integer getNumeroHabitacio() {
        return this.habitacioId.getNumero();
    }
    
    public void setNumeroHabitacio(Integer numeroHabitacio) {
        this.habitacioId.setNumero(numeroHabitacio);
    }
}
