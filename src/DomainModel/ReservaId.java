/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author lluisgh28
 */
public class ReservaId {
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
    
}
