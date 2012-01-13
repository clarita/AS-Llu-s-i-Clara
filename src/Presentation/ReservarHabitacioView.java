package Presentation;

import TupleTypes.DadesHotel;
import TupleTypes.DadesReserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.swing.JTextField;

/**
 *
 * @author clara i elena 
 */
public class ReservarHabitacioView {
    
    private ReservarHabitacioController controlador;
    private static LoadingWindow loadingWindow;
    private static CarregarDadesInicials windowNoPoblacions;
    private static Window1 window1;
    private static Window2 window2;
    private static Window3 window3;
    private static Window4 window4;
    private static Window5 window5;
    
    /**
     * Funció necessària per permetre que aparegui la primera pantalla abans no 
     * es tanqui l'aplicació
     */
    private static void createAndShowGUI1() {
        //Mostrar la finestra de loading
        loadingWindow.setVisible(true);
        
    }
    
    public ReservarHabitacioView(ReservarHabitacioController controlador){
        this.controlador = controlador;
        
        loadingWindow = new LoadingWindow();
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI1();
            }
        });
        
    }
    
    /**
     * Mostra la pantalla que indica que no hi ha dades al sistema i permet 
     * carregar-ne
     * @author clara
     */
    public void mostraNoHiHaPoblacions() {
        loadingWindow.setVisible(false);
        windowNoPoblacions = new CarregarDadesInicials(this);
        windowNoPoblacions.setVisible(true);
    }
    
    /**
     * Carrega les dades a la base de dades per poder utilitzar l'aplicació
     * @author clara
     */
    public void carregaDadesInicials() {
        controlador.carregaDadesDeProva();
    }
    
    /**
     * Mostra la primera pantalla
     * @param poblacions 
     * @author clara
     */
    public void mostraPoblacions(ArrayList<String> poblacions) {
        loadingWindow.setVisible(false);
        window1 = new Window1(this);
        window1.loadPoblacions(poblacions);
        window1.setVisible(true);
    }
    
    /**
     * Funció per rebre l'event de quan es selecciona acceptar a la pantalla 1
     * @param poblacio
     * @param dIni
     * @param dFi
     * @param numOcup 
     * @author clara
     */
    public void confirmacioWindow1(String poblacio, Date dIni, Date dFi, int numOcup) {
        controlador.PrOkObteHabitacions(poblacio, dIni, dFi, numOcup);
    }
    
    /**
     * mostra les dades dels hotels i les seves habitacions disponibles 
     * @param basicData
     * @param dades 
     * @author clara
     */
    public void mostraHabitacions(DadesReserva basicData, Set<DadesHotel> dades) {
        window1.setVisible(false);
        window2 = new Window2(this);
        window2.loadData(basicData, dades);
        window2.setVisible(true);
    }
    
    public void confirmacioWindow2(String nomHotel, String nomTipus) {
        controlador.PrOkSeleccionarHabitacio(nomHotel, nomTipus);
    }
    
    /**
     * mostra el preu total de la reserva i les dades acumulades sobre la rserva 
     * @param dades 
     * @author elena
     */
    public void mostraPreu(DadesReserva dades) {
        window2.setVisible(false);
        window3 = new Window3();
        window3.mostraDades(dades);
        window3.setVisible(true);
    }
    
    /**
     * mostra les dades del client i totes les dades acumulades de la reserva
     * @param dades 
     * @author elena
     */
    public void mostraDadesClient(DadesReserva dades) {
        window3.setVisible(false);
        window4 = new Window4();
        //window4.mostraClient(dades);
        window4.setVisible(true);
    }
    
    /**
     * Pantalla de finalització on es mostra el missatge de confirmació del pagament.
     * @author elena
     */
    public void mostraMissatgeFi() {
        window4.setVisible(false);
        window5 = new Window5();
        window5.setVisible(true);
    }
    
    /**
     * Mostra el missatge corresponent a la message area
     * @param missatge 
     * @author clara i elena  
     */
    public void mostraMissatge(String missatge, int windowIndex) {
        if(windowIndex == 1){
            window1.mostraMissatge(missatge);
        }
        else if(windowIndex == 3) window3.mostraError(missatge);
       // else window4.mostraError(missatge);
    }
    
    /**
     * Tanca la finestra de l'aplicació
     * @author clara
     */
    public void tanca() {
        System.exit(0);
    }

    /**
     * crida a la funcio del controlador per a canviar de pantalla de la 3 a la 4 i li passa el dni que han introduït
     * com a nova informació 
     * @param Tdni
     * @author elena & clara
     */
    void confirmacioWindow3(String dni) {
        //throw new UnsupportedOperationException("Not yet implemented");
        controlador.PrOkIntroduirDni(dni);
    }
    
    
}
