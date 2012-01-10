package DomainModel;

import TupleTypes.DadesHotel;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author elena
 * @author clara
 */
public class Poblacio {
    
    String nom;
    Set<Hotel> hotels = new HashSet<Hotel>();
    
    
    public Poblacio(){};
    
    /**
     * creadora
     * @param nom és el nom de la població  
     */
    public Poblacio(String nom){
        this.nom = nom;
        this.hotels = new HashSet<Hotel>();
    }
    
    /**
     * retorna el nom de la Població
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * 
     * @param n 
     */
    
    public void setNom(String n){
        this.nom = n;
    }
    
    /**
     * 
     * @return 
     */
    public Set<Hotel> getHotels() {
        return hotels;
    }
    
    /**
     * 
     * @param hotels 
     */

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
    
    /**
     * retorna una tupla amb la informació de l'hotel disponible entre les dates dIni i dFi, i les seves habitacions disponibles
     * que tinguin capacitat per a NumOcup
     * @param dIni 
     * @param dFi
     * @param NumOcup
     * @return res
     */
    
    public Set<DadesHotel> getDisponibles(Date dIni, Date dFi, Integer NumOcup) throws Exception{
        Set<DadesHotel> dadesDisponibles = new HashSet<DadesHotel>();
        for(Hotel h: hotels){
            DadesHotel dadesHotel = new DadesHotel();
            if(h.estaDisp(dIni, dFi, NumOcup, dadesHotel)){
                dadesDisponibles.add(dadesHotel);
            }
        }
        if (dadesDisponibles.isEmpty()) throw new Exception("hotelsNoDisp");
        return dadesDisponibles;
        
    }
    
    
    
    
    
    
    
    
    
}
