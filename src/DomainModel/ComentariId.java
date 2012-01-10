/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author elena
 */
public class ComentariId implements Serializable {
    String nomHotel;
    String dniClient;
    Date data;
    
    
    /**
     * 
     */
    public ComentariId(){};
    
    /**
     * 
     * @param nom
     * @param dni
     * @param d 
     */
    public ComentariId(String nom, String dni, Date d){
        this.data = d;
        this.dniClient = dni;
        this.nomHotel = nom;
    
    }
    
    /**
     * 
     * @return 
     */

    public Date getData() {
        return data;
    }
    
    /**
     * 
     * @param data 
     */

    public void setData(Date data) {
        this.data = data;
    }
    
    
    /**
     * 
     * @return 
     */

    public String getDniClient() {
        return dniClient;
    }
    
    /**
     * 
     * @param dniClient 
     */

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }
    
    /**
     * 
     * @return 
     */

    public String getNomHotel() {
        return nomHotel;
    }
    
    /**
     * 
     * @param nomHotel 
     */

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }
    
    
    
    
}
