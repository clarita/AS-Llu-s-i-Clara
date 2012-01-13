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
    
    //Originalment teníem un String, però per poder generar-lo automàticament hem preferit un integer.
    Integer idReserva;
    
    Date dataInici;
    Date dataReserva;
    Date dataFi;
    
    Float preuTotal;
    
    /* Atributs requerits pel Hibernate */
    String dniClient;
    String nomHotel;
    Integer numeroHabitacio;

    
    public Reserva() {}
    
    public Reserva(Date dIni, Date dFi, Float preuTotal, String dniClient, String nomHotel, Integer numeroHabitacio) {
        this.dataInici = dIni;
        this.dataFi = dFi;
        this.dataReserva = new Date();
        this.preuTotal = preuTotal;
        this.nomHotel = nomHotel;
        this.numeroHabitacio = numeroHabitacio;
        this.dniClient = dniClient;
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

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Float getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(Float preuTotal) {
        this.preuTotal = preuTotal;
    }


    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }
    
    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public Integer getNumeroHabitacio() {
        return numeroHabitacio;
    }

    public void setNumeroHabitacio(Integer numeroHabitacio) {
        this.numeroHabitacio = numeroHabitacio;
    }
    
}
