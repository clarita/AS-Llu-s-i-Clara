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
 *
 * @author lluisgh28
 */
public class CtrlDataFactory {
    private static CtrlDataFactory instance;
    private ICtrlPoblacio ctrlPoblacio;
    private ICtrlHotel ctrlHotel;
    private ICtrlClient ctrlClient;
    private ICtrlHabitacio ctrlHabitacio;
    private ICtrlBonsHotels ctrlBonsHotels;
    private ICtrlTipusHabitacio ctrlTipusHabitacio;
    
    
    private CtrlDataFactory() {};
    
    public static CtrlDataFactory getInstance() {
        if (instance == null) instance = new CtrlDataFactory();
        return instance;
    }
    
    public ICtrlPoblacio getCtrlPoblacio() {
        if (ctrlPoblacio == null) ctrlPoblacio = new CtrlPoblacio();
        return ctrlPoblacio;
    }
    
    public ICtrlHotel getCtrlHotel() {
        if (ctrlHotel == null) ctrlHotel = new CtrlHotel();
        return ctrlHotel;
    }
    
    public ICtrlClient getCtrlClient() {
        if (ctrlClient == null) ctrlClient = new CtrlClient();
        return ctrlClient;
    }
    
    public ICtrlHabitacio getCtrlHabitacio() {
        if (ctrlHabitacio == null) ctrlHabitacio = new CtrlHabitacio();
        return ctrlHabitacio;
    }
    
    public ICtrlBonsHotels getCtrlBonsHotels() {
        if(ctrlBonsHotels == null) ctrlBonsHotels = new CtrlBonsHotels();
        return ctrlBonsHotels;
    }
    
    public ICtrlTipusHabitacio getCtrlTipusHabitacio() {
        if (ctrlTipusHabitacio == null) ctrlTipusHabitacio = new CtrlTipusHabitacio();
        return ctrlTipusHabitacio;
    }
}
