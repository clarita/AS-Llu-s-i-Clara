/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import DataInterfaces.ICtrlClient;
import DataInterfaces.ICtrlHotel;
import DataInterfaces.ICtrlPoblacio;
import DomainFactories.CtrlDataFactory;
import DomainModel.Client;
import DomainModel.Hotel;
import DomainModel.Poblacio;
import TupleTypes.DadesHotel;
import TupleTypes.DadesReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author lluisgh28
 */
public class CasUsReservarHabitacio {
    String poblacio;
    Date dataInici;
    Date dataFi;
    String dniClient;
    String nomHotel;
    String tipusHabitacio;
    Integer numHabitacio;
    Float preuTotal;
    
    
    public CasUsReservarHabitacio() {};
    
    public ArrayList<String> obtePoblacions() throws Exception {
        
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlPoblacio cp = cdf.getCtrlPoblacio();
        ArrayList<Poblacio> poblacions = cp.tots();
        if(poblacions.isEmpty()){
            throw new Exception("noHiHaPoblacions");
        }
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < poblacions.size(); ++i) {
            result.add(poblacions.get(i).getNom());
        }
        if (result.isEmpty()) throw new Exception("noHiHaPoblacions");
        return result;
    }
    
        
    public Set<DadesHotel> buscarHabitacio(String pob, Date dIni, Date dFi, Integer numOcup) throws Exception{
        
        TxBuscarHabitacio buscar = new TxBuscarHabitacio(pob, dIni, dFi, numOcup);
        buscar.executar();
        return buscar.obteResultat();   
    }
    
    public DadesReserva seleccionarHabitacio(String hotel, String tipusHab) throws Exception{
        
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlHotel ch = cdf.getCtrlHotel();
        Hotel h = ch.get(hotel);
        nomHotel = hotel;
        tipusHabitacio = tipusHab;
        numHabitacio = h.obteNumeroHabLliure(nomHotel, dataInici, dataFi);
        preuTotal = h.obtePreuTotal(tipusHabitacio, dataInici, dataFi);
        DadesReserva result = new DadesReserva();
        result.dIni = this.dataInici;
        result.dFi = this.dataFi;
        result.nomHotel = this.nomHotel;
        result.nomTipusHab = this.tipusHabitacio;
        result.pob = this.poblacio;
        result.preuTotal = this.preuTotal;
        return result;
    }
    
    public DadesReserva introduirDni(String dni) throws Exception {
        
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlClient cc = cdf.getCtrlClient();
        Client c = cc.get(dni);
        DadesReserva result = null;
        result.dni = dni;
        result.nomClient = c.getNom();
        result.cognomsClient = c.getCognoms();
        result.emailClient = c.getEmail();
        result.dIni = this.dataInici;
        result.dFi = this.dataFi;
        result.nomHotel = this.nomHotel;
        result.nomTipusHab = this.tipusHabitacio;
        result.pob = this.poblacio;
        result.preuTotal = this.preuTotal;
        return result;
    }
    
    public void pagament(String numTarg, Date dCad) {
        //TODO cridar servei de pagament
    }
    
}
