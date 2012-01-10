package DomainModel;

/**
 * Aquesta classe representa l'identificador compost de PreuTipusHabitacio. 
 * També s'utilitza a les estratègies, ja que s'identifiquen pel PreuTipusHabitacio.
 * @author clara
 */
public class PreuTipusHabitacioId implements java.io.Serializable  {
    private String nomhotel;
    private String nomtipus;

    /**
     * Creadora buida requerida per Hibernate
     */
    public PreuTipusHabitacioId() {
    }

    /**
     * Creadora amb paràmetres per facilitar la inicialització
     * @param nomhotel
     * @param nomtipus 
     */
    public PreuTipusHabitacioId(String nomhotel, String nomtipus) {
       this.nomhotel = nomhotel;
       this.nomtipus = nomtipus;
    }
   
    /**
     * Getter del nom de l'hotel
     * @return 
     */
    public String getNomhotel() {
        return this.nomhotel;
    }
    
    /**
     * Setter del nom de l'hotel
     * @param nomhotel 
     */
    public void setNomhotel(String nomhotel) {
        this.nomhotel = nomhotel;
    }
    
    /**
     * Getter del tipus d'habitació
     * @return 
     */
    public String getNomtipus() {
        return this.nomtipus;
    }
    
    /**
     * Setter del tipus d'habitació
     * @param nomtipus 
     */
    public void setNomtipus(String nomtipus) {
        this.nomtipus = nomtipus;
    }


    /**
     * Funció de comparació requerida per Hibernate per a claus compostes
     * @param other
     * @return 
     */
     public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( (other == null ) ) return false;
        if ( !(other instanceof PreuTipusHabitacioId) ) return false;
        PreuTipusHabitacioId castOther = ( PreuTipusHabitacioId ) other; 
         
	return ( (this.getNomhotel()==castOther.getNomhotel()) || 
                ( this.getNomhotel()!=null && castOther.getNomhotel()!=null && 
                this.getNomhotel().equals(castOther.getNomhotel()) ) ) && 
                ( (this.getNomtipus()==castOther.getNomtipus()) || 
                ( this.getNomtipus()!=null && castOther.getNomtipus()!=null && 
                this.getNomtipus().equals(castOther.getNomtipus()) ) );
    }
   
    /**
    * Funció requerida per Hibernate
    * @return 
    */
    public int hashCode() {
        int result = 17;
         
        result = 37 * result + ( getNomhotel() == null ? 0 : this.getNomhotel().hashCode() );
        result = 37 * result + ( getNomtipus() == null ? 0 : this.getNomtipus().hashCode() );
        return result;
    }   
}
