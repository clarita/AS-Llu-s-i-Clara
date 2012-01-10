/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import DomainFactories.CtrlDataFactory;
import java.util.Random;

/**
 *
 * @author clara
 */
public class BonsHotels {
    
    private static BonsHotels singletonObject = null;
    private int id;
    private float quotaFixa = 0;
    private float quotaVariable = 0;
    
    /**
     * Creadora privada, s'ha d'accedir des de fora a través de getInstance() 
     * però es manté pública per Hibernate
     */
    public BonsHotels() {
        
    }
    
    /**
     * Recupera la instància singleton de la classe
     * @return 
     */
    public static BonsHotels getInstance() {
        if(singletonObject == null){
            CtrlDataFactory cdf = CtrlDataFactory.getInstance();
            singletonObject = cdf.getCtrlBonsHotels().get();
        }
        return singletonObject;
    }
    
    /**
     * Getter de l'id requerit per Hibernate
     * @return 
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Setter de l'id requerit per Hibernate
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Assigna una quotaFixa
     * @param quotaFixa 
     */
    public void setQuotaFixa(float quotaFixa) {
        this.quotaFixa = quotaFixa;
    }
    
    /**
     * Getter de quota fixa
     * @return 
     */
    public float getQuotaFixa() {
        return this.quotaFixa;
    }
    
    /**
     * Assigna una quotaVariable
     * @param quotaVariable 
     */
    public void setQuotaVariable(float quotaVariable) {
        this.quotaVariable = quotaVariable;
    }
    
    /**
     * Getter de quota variable
     * @return 
     */
    public float getQuotaVariable() {
        return this.quotaVariable;
    }
    
    /**
     * Recupera l'identificador de la reserva actual
     * @return 
     */
    public String getReservationId() {
        Random generator = new Random( 19580427 );
        Integer randomNumber = generator.nextInt();
        return randomNumber.toString();
    }
}
