package Presentation;

import DomainControllers.CasUsReservarHabitacio;
import DomainControllers.TxInserirDades;
import TupleTypes.DadesHotel;
import TupleTypes.DadesReserva;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clara 
 */
public class ReservarHabitacioController {
    
    private static ReservarHabitacioController singletonObject = null;
    private CasUsReservarHabitacio domini;
    private ReservarHabitacioView vista;
    
    /**
     * Creadora encarregada de crear les instàncies de domini i vista
     * @author clara
     */
    private ReservarHabitacioController() {
        domini = new CasUsReservarHabitacio();
        vista = new ReservarHabitacioView(this);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                preparaPoblacions();
            }
        });
    }
    
    /**
     * Funció per obtenir la instància singleton
     * @return 
     * @author clara
     */
    public static ReservarHabitacioController getInstance() {
        if(singletonObject == null){
            singletonObject = new ReservarHabitacioController();
        }
        return singletonObject;
    }
    
    /**
     * Obté les poblacions a mostrar en la primera pantalla, i si no en troba 
     * carrega la pantalla d'error
     * @author clara
     */
    private void preparaPoblacions() {
        try {
            ArrayList<String> poblacions = domini.obtePoblacions();
            vista.mostraPoblacions(poblacions);
        }
        catch(Exception e){
            if(e.getMessage() != null && e.getMessage().equals("noHiHaPoblacions")){
                vista.mostraNoHiHaPoblacions();
            }
            else e.printStackTrace();
        }
        
    }
    
    /**
     * Ordena inserir a la BD dades amb les que poder provar l'aplicació
     * @author clara
     */
    public void carregaDadesDeProva() {
        TxInserirDades transaccio = new TxInserirDades();
        transaccio.executar();
        preparaPoblacions();
    }
    
    /**
     * Transició entre la pantalla 1 i 2
     * @param pob
     * @param dIni
     * @param dFi
     * @param numOcup 
     * @author clara
     */
    public void PrOkObteHabitacions(String pob, Date dIni, Date dFi, int numOcup) {
        //comprovació de les dates
        Calendar c = Calendar.getInstance();
        c.setTime(dIni);
        long dataIni = c.getTimeInMillis();
        c.setTime(dFi);
        long dataFi = c.getTimeInMillis();
        if((dataFi < dataIni) || dataFi-dataIni < 1000){
            vista.mostraMissatge("Dates incorrectes",1);
            return;
        }
        
        //comprovació del nombre d'ocupants
        //com hem implementat un spinner amb els valors 1-9, no es pot donar un valor incorrecte
        /*if(numOcup <= 0){
            vista.mostraMissatge("Número d'ocupants incorrecte");
            return;
        }*/
        
        //intentem aconseguir les dades dels hotels
        try {
            Set<DadesHotel> resultat = domini.buscarHabitacio(pob, dIni, dFi, numOcup);
            DadesReserva basicData = new DadesReserva();
            basicData.pob = pob;
            basicData.dIni = dIni;
            basicData.dFi = dFi;
            basicData.numOc = numOcup;
            vista.mostraHabitacions(basicData, resultat);
        }
        catch (Exception e) {
            //capturem les excepcions de domini
            if(e.getMessage() != null && e.getMessage().equals("hotelsNoDisp")){
                vista.mostraMissatge("No hi ha hotels disponibles en aquesta població",1);
            }
            else e.printStackTrace();
        }
        
        
    }
    
    /**
     * Transició entre la pantalla 2 i 3
     * @param hotel
     * @param tipusHab 
     * @author elena i clara
     */
    public void PrOkSeleccionarHabitacio(String hotel, String tipusHab) {
        try {
            DadesReserva res = domini.seleccionarHabitacio(hotel, tipusHab);
            vista.mostraPreu(res);
        } catch (Exception ex) {
            Logger.getLogger(ReservarHabitacioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Transició entre la pantalla 3 i 4
     * @param dni 
     * @author elena 
     */
    public void PrOkIntroduirDni(String dni) {
        try {
            DadesReserva c = domini.introduirDni(dni);
            vista.mostraDadesClient(c);
            //mostra la info de les finestres anteriors
        }catch(Exception e){
           if(e.getMessage() != null && "clientNoExisteix".equals(e.getMessage())){
                vista.mostraMissatge("No hi ha cap client al sistema amb aquest DNI",3);
           }
           else {
               e.printStackTrace();
           }
        }
        
    }
    
    /**
     * Transició entre la pantalla 4 i 5
     * @param numTarg
     * @param dCad 
     * @author elena 
     */
    public void PrOkRealitzaPagament(String numTarg, Date dCad){
         try {
            domini.pagament(numTarg, dCad);
            vista.mostraMissatgeFi();
        }catch(Exception e){
           if(e.getMessage().equals("serveiNoDisponible")){
                vista.mostraMissatge("Error en el pagament",4);
           }
           
        }
        
    }
    
    /**
     * Confirmació de final
     * @author clara
     */
    public void PrOkMissatgeFi() {
        vista.tanca();
    }
    
    /**
     * Petició de cancel·lació
     * @author clara
     */
    public void PrCancel() {
        vista.tanca();
    }
}
