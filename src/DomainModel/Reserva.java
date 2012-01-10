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
public class Reserva {
    Date dataInici;
    Date dataReserva;
    Date dataFi;
    String idReserva;
    Float preuTotal;
    
    /* Atributs requerits pel Hibernate */
    
    ReservaId id;
    
    public Reserva() {}
    
    public Reserva(Date dIni, Date dFi, String idR, Float preuTotal) {
        this.dataInici = dIni;
        this.dataFi = dFi;
        this.dataReserva = new Date();
        this.idReserva = idR;
        this.preuTotal = preuTotal;
    }
    
    public void afegirAHabitacio(Habitacio hab) {
        hab.afReserva(this);
    }
    
    public boolean esSolapa(Date dIni, Date dFi) {        
        return dIni.before(dataFi) && dFi.after(dataInici); 
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public void setDataInici(Date dataInici) {
        this.dataInici = dataInici;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Float getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(Float preuTotal) {
        this.preuTotal = preuTotal;
    }

    public ReservaId getId() {
        return id;
    }

    public void setId(ReservaId id) {
        this.id = id;
    }    
}
