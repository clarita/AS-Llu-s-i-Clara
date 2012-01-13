/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.Calendar;
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
        Calendar cDIni = Calendar.getInstance();
        cDIni.setTime(dIni);
        Calendar cDFi = Calendar.getInstance();
        cDFi.setTime(dFi);
        Calendar cDataInici = Calendar.getInstance();
        cDataInici.setTime(dataInici);
        Calendar cDataFi = Calendar.getInstance();
        cDataFi.setTime(dataFi);
        
        //Cert si la data d'inici que ens donen es previa o te el mateix dia que la data de fi d'aquesta reserva
        boolean dIniPreDataFi;
        
        //Si l'any de la data d'inici que ens donen es previ al de fi d'aquesta reserva
        if (cDIni.get(Calendar.YEAR) < cDataFi.get(Calendar.YEAR)) 
            dIniPreDataFi = true;
        
        //Si l'any de la data d'inici que ens donen es el mateix que el de fi d'aquesta reserva
        else if (cDIni.get(Calendar.YEAR) == cDataFi.get(Calendar.YEAR)) {
            //Si, dins el mateix any, la data d'inici que ens donen es previa o igual a la data d'aquesta reserva
            if (cDIni.get(Calendar.DAY_OF_YEAR) <= cDataFi.get(Calendar.DAY_OF_YEAR))
                dIniPreDataFi = true;
            
            //Sino
            else dIniPreDataFi = false;
        }
        
        //Si l'any de la data que ens donen es poterior a la d'aquesta reserva
        else dIniPreDataFi = false;
        
        
        //Cert si la data de fi que ens donen es posterior o te el mateix dia que la data de inici d'aquesta reserva
        boolean dFiPostDataInici;
        
        //Si l'any de la data de fi que ens donen es posterior al de la data d'inici d'aquesta reserva
        if (cDFi.get(Calendar.YEAR) > cDataInici.get(Calendar.YEAR))
            dFiPostDataInici = true;
        
        //Si l'any de la data de fi que ens donen i el de la data d'aquesta reserva son el mateix
        else if (cDFi.get(Calendar.YEAR) == cDataInici.get(Calendar.YEAR)) {
            //Si, dins el mateix any, la data de fi que ens donen es posterior o igual a la data d'aquesta reserva
            if (cDFi.get(Calendar.DAY_OF_YEAR) >= cDataInici.get(Calendar.DAY_OF_YEAR))
                dFiPostDataInici = true;
            
            //Sino
            else dFiPostDataInici = false;
        }
        
        //Si l'any de la data de fi que ens donen es previ al de la data d'inici d'aquesta reserva
        else dFiPostDataInici = false;
        
        return dIniPreDataFi && dFiPostDataInici; 
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
