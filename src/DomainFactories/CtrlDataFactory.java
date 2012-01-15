/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainFactories;

import DataControllers.CtrlBonsHotels;
import DataControllers.CtrlClient;
import DataControllers.CtrlHabitacio;
import DataControllers.CtrlHotel;
import DataControllers.CtrlPoblacio;
import DataControllers.CtrlTipusHabitacio;
import DataInterfaces.ICtrlBonsHotels;
import DataInterfaces.ICtrlClient;
import DataInterfaces.ICtrlHabitacio;
import DataInterfaces.ICtrlHotel;
import DataInterfaces.ICtrlPoblacio;
import DataInterfaces.ICtrlTipusHabitacio;

/**
 * Classe singleton encarregada de crear i fer accessibles tots els controladors
 * de la capa de gestió de dades.
 * @author lluisgh28
 */
public class CtrlDataFactory {
    private static CtrlDataFactory instance;
    private ICtrlPoblacio ctrlPoblacio;
    private ICtrlHotel ctrlHotel;
    private ICtrlClient ctrlClient;
    private ICtrlHabitacio ctrlHabitacio;
    private ICtrlBonsHotels ctrlBonsHotels;
    /**
     * No apareixia al disseny del lliurament 1. Necessaris pels canvis al cas
     * d'ús ReservarHabitació.
     */
    private ICtrlTipusHabitacio ctrlTipusHabitacio;
    
    /**
     * Creadora per defecte.
     */
    private CtrlDataFactory() {};
    
    /**
     * Retorna la instància (singleton) de la factoria.
     * @return 
     */
    public static CtrlDataFactory getInstance() {
        if (instance == null) instance = new CtrlDataFactory();
        return instance;
    }
    
    /**
     * Retorna el controlador de Poblacio de la capa de gestió de dades.
     * @return 
     */
    public ICtrlPoblacio getCtrlPoblacio() {
        if (ctrlPoblacio == null) ctrlPoblacio = new CtrlPoblacio();
        return ctrlPoblacio;
    }
    
    /**
     * Retorna el controlador d'Hotel de la capa de gestió de dades.
     * @return 
     */
    public ICtrlHotel getCtrlHotel() {
        if (ctrlHotel == null) ctrlHotel = new CtrlHotel();
        return ctrlHotel;
    }
    
    /**
     * Retorna el controlador de Client de la capa de gestió de dades.
     * @return 
     */
    public ICtrlClient getCtrlClient() {
        if (ctrlClient == null) ctrlClient = new CtrlClient();
        return ctrlClient;
    }
    
    /**
     * Retorna el controlador d'Habitació de la capa de gestió de dades.
     * @return 
     */
    public ICtrlHabitacio getCtrlHabitacio() {
        if (ctrlHabitacio == null) ctrlHabitacio = new CtrlHabitacio();
        return ctrlHabitacio;
    }
    
    /**
     * Retorna el controlador de BonsHotels de la capa de gestió de dades.
     * @return 
     */
    public ICtrlBonsHotels getCtrlBonsHotels() {
        if(ctrlBonsHotels == null) ctrlBonsHotels = new CtrlBonsHotels();
        return ctrlBonsHotels;
    }
    
    /**
     * Retorna el controlador de TipusHabitació de la capa de gestió de dades.
     * @return 
     */
    public ICtrlTipusHabitacio getCtrlTipusHabitacio() {
        if (ctrlTipusHabitacio == null) ctrlTipusHabitacio = new CtrlTipusHabitacio();
        return ctrlTipusHabitacio;
    }
}
