/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator;

/**
 *
 * @author clara
 */
public class ServiceLocator {
    
    private ServeiPagament sp;

    private static ServiceLocator instance;

    private ServiceLocator()  {
    }
    
    /**
     * 
     * @return
     */
    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }
    
    /**
     * retorna un ServeiPagament
     * @param Id identificador del servei 
     * @return 
     */
    public ServeiPagament find(String Id) {
        if(this.sp == null) this.sp = new ServeiPagament();
        return this.sp;
    }
          
}
