package DataInterfaces;

import DomainModel.Habitacio;

/**
 * Aquesta és la interfície que fa servir la capa de domini per interaccionar 
 * amb el controlador de habitacions de la capa de gestió de dades. Per 
 * convenció de nomenclatura, he afegit la I davant el nom, ja que és una 
 * interfície.
 * @author clara
 */
public interface ICtrlHabitacio {
    
    /**
     * Recupera una habitacio a partir del nom de l'hotel i el numero de 
     * l'habitacio
     * @param numero
     * @param nomHotel
     * @return 
     */
    public Habitacio get(Integer numero, String nomHotel) throws Exception;
}
