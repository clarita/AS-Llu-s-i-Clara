/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.io.Serializable;

/**
 *
 * @author lluisgh28
 */
public class HabitacioId implements Serializable {
    
    String nomHotel;
    Integer numero;
    
    public HabitacioId() {
        
    }
    
    public HabitacioId(String nomhotel, Integer numero) {
        this.nomHotel = nomhotel;
        this.numero = numero;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomhotel) {
        this.nomHotel = nomhotel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
        
    /**
     * Operacions necessaries per Hibernate
     * @param other
     * @return 
     */
    @Override
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HabitacioId) ) return false;
		 HabitacioId castOther = ( HabitacioId ) other; 
         
		 return ( (this.getNomHotel()==castOther.getNomHotel()) || ( this.getNomHotel()!=null && castOther.getNomHotel()!=null && this.getNomHotel().equals(castOther.getNomHotel()) ) )
 && (this.getNumero()==castOther.getNumero());
   }
   
    @Override
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNomHotel() == null ? 0 : this.getNomHotel().hashCode() );
         result = 37 * result + this.getNumero();
         return result;
   }
}
