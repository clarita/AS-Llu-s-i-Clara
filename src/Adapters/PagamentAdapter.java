/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import ServiceLocator.ServeiPagament;
import ServiceLocator.ServiceLocator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elena
 */
public class PagamentAdapter implements IPagamentAdapter{
    private ServiceLocator sl;
    private String id;
    
    /**
     * creadora
     */
    public PagamentAdapter(){};
    
    
    
    /**
     * realitza el pagament de la reserva feta
     * @param numTarg numero de la targeta del client 
     * @param dCad data de caducitat de la targeta del client
     * @param preuTotal preu de la reserva 
     * @return true si el pagament s'ha executat amb èxit 
     */
    @Override
    public boolean pagament(String numTarg, Date dCad, float preuTotal) {
        //throw new UnsupportedOperationException("Not supported yet.");
            ServeiPagament spag = sl.find(this.id);
            if (spag == null) try {
            throw new Exception("hotelsNoDisp");
            } catch (Exception ex) {
            Logger.getLogger(PagamentAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date d = new Date();
            return spag.autoritza(numTarg, dCad, preuTotal,d);
        
        } 
}
    
