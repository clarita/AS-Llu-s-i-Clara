/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import java.util.Date;

/**
 *
 * @author elena_gratallops
 */
public interface IPagamentAdapter {
    
    /**
     * realitza el pagament de la reserva
     * @param numTarg
     * @param dCad
     * @param preuTotal 
     */
    
    public boolean pagament(String numTarg, Date dCad, float preuTotal);
    
}