/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author elena
 */
public class ServiceLocator {
    private InitialContext ic;
    private Map cache;
    private ServeiPagament sp;

    private static ServiceLocator me;
    
    static {
        try {
            me = new ServiceLocator();
        } catch(ServiceLocatorException se) {
            System.err.println(se);
            se.printStackTrace(System.err);
        }
    }
    private ServiceLocator() throws ServiceLocatorException  {
        try {
            ic = new InitialContext();
            cache = Collections.synchronizedMap(new HashMap());
        } catch (NamingException ne) {
            throw new ServiceLocatorException(ne);
        }
    }
    
    /**
     * retorna la intància del ServiceLocator
     * @return
     * @throws ServiceLocatorException 
     */
    
    public static ServiceLocator getInstance() throws ServiceLocatorException {
        if (me == null) {
        me = new ServiceLocator();
        }
        return me;
    }
    
    /**
     * retorna una intància del ServeiPagament
     * @param Id identificador del servei 
     * @return 
     */
    public ServeiPagament find(String Id) {
        return this.sp;
    }
          
}
