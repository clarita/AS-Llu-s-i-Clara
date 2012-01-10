package Adapters;

import java.util.Date;

/**
 *
 * @author elena_gratallops
 * @author clara
 */
public interface IPagamentAdapter {
    
    /**
     * realitza el pagament de la reserva
     * @param numTarg
     * @param dCad
     * @param preuTotal 
     */
    public void pagament(String numTarg, Date dCad, float preuTotal) throws Exception;
    
}