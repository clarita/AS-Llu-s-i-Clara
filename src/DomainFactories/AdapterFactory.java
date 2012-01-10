/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainFactories;

import Adapters.IPagamentAdapter;
import Adapters.PagamentAdapter;

/**
 *
 * @author elena_gratallops
 */
public class AdapterFactory {
    private static AdapterFactory instance;
    private IPagamentAdapter pagAdap;
    
    /**
     * creadora
     */
    
    private AdapterFactory(){};
    
    /**
     * retorna la instància de la factoria i si no existia la crea
     * @return 
     */
    public static AdapterFactory getInstances() {
        if(instance == null) instance = new AdapterFactory();
        return instance;
    }
    
    
    /**
     * retorna la instància del IPagamentAdapter i si no existeix la crea
     * @return 
     */
    public IPagamentAdapter getPagamentAdapter() {
        if(pagAdap == null) pagAdap = new PagamentAdapter();
        return pagAdap;
    }
    
    
}

