/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import Adapters.IPagamentAdapter;
import DataInterfaces.ICtrlClient;
import DataInterfaces.ICtrlHabitacio;
import DataInterfaces.ICtrlHotel;
import DataInterfaces.ICtrlPoblacio;
import DataInterfaces.ICtrlTipusHabitacio;
import DomainFactories.AdapterFactory;
import DomainFactories.CtrlDataFactory;
import DomainModel.Client;
import DomainModel.Habitacio;
import DomainModel.Hotel;
import DomainModel.Poblacio;
import DomainModel.Reserva;
import DomainModel.TipusHabitacio;
import Hibernate.HibernateUtil;
import TupleTypes.DadesHotel;
import TupleTypes.DadesReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import org.hibernate.Session;

/**
 * Controlador del cas d'ús Reservar Habitació.
 * @author lluisgh28
 */
public class CasUsReservarHabitacio {
    String poblacio;
    Date dataInici;
    Date dataFi;
    Integer numOcup;
    String dniClient;
    String nomHotel;
    String tipusHabitacio;
    Integer numHabitacio;
    Float preuTotal;
    
    /**
     * Creadora per defecte.
     */
    public CasUsReservarHabitacio() {};
    
    /**
     * Retorna una llista amb totes les poblacions que hi ha al sistema.
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Retorna les habitacions d'hotel de la població pob que tenen una
     * capacitat més gran o igual que numOcup i que estan disponibles entre les
     * dates dIni i dFi.
     * @param pob
     * @param dIni
     * @param dFi
     * @param numOcup
     * @return
     * @throws Exception 
     */    
    public Set<DadesHotel> buscarHabitacio(String pob, Date dIni, Date dFi, Integer numOcup) throws Exception{
        
        TxBuscarHabitacio buscar = new TxBuscarHabitacio(pob, dIni, dFi, numOcup);
        buscar.executar();
        this.poblacio = pob;
        this.dataInici = dIni;
        this.dataFi = dFi;
        
        /**
         * L'atribut numOcup no hi era al contracte original, però és còmode
         * emmagatzemar-lo per a retornar-lo amb la resta de dades.
         */
        this.numOcup = numOcup;
        return buscar.obteResultat();   
    }
    
    /**
     * Retorna les dades de l'habitació seleccionada que és de l'hotel i del
     * tipus donats.
     * @param hotel
     * @param tipusHab
     * @return
     * @throws Exception 
     */
    public DadesReserva seleccionarHabitacio(String hotel, String tipusHab) throws Exception{
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlHotel ch = cdf.getCtrlHotel();
        Hotel h = ch.get(hotel);
        ICtrlTipusHabitacio cth = cdf.getCtrlTipusHabitacio();
        TipusHabitacio th = cth.get(tipusHab);
        nomHotel = hotel;
        tipusHabitacio = tipusHab;
        numHabitacio = th.obteNumeroHabLliure(nomHotel, dataInici, dataFi);
        preuTotal = h.obtePreuTotal(tipusHabitacio, dataInici, dataFi);
        DadesReserva result = new DadesReserva();
        result.dIni = this.dataInici;
        result.dFi = this.dataFi;
        result.numOc = this.numOcup;
        result.nomHotel = this.nomHotel;
        result.nomTipusHab = this.tipusHabitacio;
        result.pob = this.poblacio;
        result.preuTotal = this.preuTotal;
        return result;
    }
    
    /**
     * Retorna les dades de la reserva, és a dir, les dades de l'habitació
     * reservada i les del client que realitza la reserva.
     * @param dni
     * @return
     * @throws Exception 
     */
    public DadesReserva introduirDni(String dni) throws Exception {
        
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlClient cc = cdf.getCtrlClient();
        Client c = cc.get(dni);
        this.dniClient = dni;
        DadesReserva result = new DadesReserva();
        result.dni = dni;
        result.nomClient = c.getNom();
        result.cognomsClient = c.getCognoms();
        result.emailClient = c.getEmail();
        result.dIni = this.dataInici;
        result.dFi = this.dataFi;
        result.numOc = this.numOcup;
        result.nomHotel = this.nomHotel;
        result.nomTipusHab = this.tipusHabitacio;
        result.pob = this.poblacio;
        result.preuTotal = this.preuTotal;
        return result;
    }
    
    /**
     * Realitza el pagament de la reserva i crea una nova reserva amb les dades
     * que s'han obtingut en la resta del cas d'ús.
     * @param numTarg
     * @param dCad
     * @throws Exception 
     */
    public void pagament(String numTarg, Date dCad) throws Exception {
        IPagamentAdapter pa = AdapterFactory.getInstance().getPagamentAdapter();
        pa.pagament(numTarg, dCad, preuTotal);
        
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlHabitacio ch = cdf.getCtrlHabitacio();
        
        Habitacio h = ch.get(numHabitacio, nomHotel);
        
        Reserva r = new Reserva(dataInici, dataFi, preuTotal, dniClient, nomHotel, numHabitacio);
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(r);
        
        //tot i que en els diagrames ho feiem des de reserva, aquesta opció no genera acoblament
        //entre Reserva i Habitació (la navegabilitat que tenim és la inversa)
        h.afReserva(r);
        session.saveOrUpdate(h);
    }
}
