package Adapters;

import ServiceLocator.ServeiPagament;
import ServiceLocator.ServiceLocator;
import java.util.Date;

/**
 *
 * @author elena
 * @author clara
 */
public class PagamentAdapter implements IPagamentAdapter{

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
    public void pagament(String numTarg, Date dCad, float preuTotal) throws Exception{
        ServiceLocator serviceLocator = ServiceLocator.getInstance();
        ServeiPagament serveiPagament = serviceLocator.find("ServeiPagament");
        
        if (!serveiPagament.autoritza(numTarg, dCad, preuTotal,new Date())) {
            throw new Exception("serveiNoDisponible");
        }
        
    } 
}
    
