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
    
    
    /**
     * Funcions necessaries per Hibernate
     * @param other
     * @return 
     */
    @Override
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ComentariId) ) return false;
		 ComentariId castOther = ( ComentariId ) other; 
         
		 return ( (this.getNomHotel()==castOther.getNomHotel()) || ( this.getNomHotel()!=null && castOther.getNomHotel()!=null && this.getNomHotel().equals(castOther.getNomHotel()) ) )
 && ( (this.getDniClient()==castOther.getDniClient()) || ( this.getDniClient()!=null && castOther.getDniClient()!=null && this.getDniClient().equals(castOther.getDniClient()) ) )
 && ( (this.getData()==castOther.getData()) || ( this.getData()!=null && castOther.getData()!=null && this.getData().equals(castOther.getData()) ) );
   }
   
    @Override
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNomHotel() == null ? 0 : this.getNomHotel().hashCode() );
         result = 37 * result + ( getDniClient() == null ? 0 : this.getDniClient().hashCode() );
         result = 37 * result + ( getData() == null ? 0 : this.getData().hashCode() );
         return result;
   }
}
