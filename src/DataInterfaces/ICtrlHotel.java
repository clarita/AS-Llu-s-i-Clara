package DataInterfaces;

import DomainModel.Hotel;

/**
 * Aquesta és la interfície que fa servir la capa de domini per interaccionar 
 * amb el controlador d'hotels de la capa de gestió de dades. Per convenció 
 * de nomenclatura, he afegit la I davant el nom, ja que és una interfície.
 * @author clara
 */
public interface ICtrlHotel {
    
    public Hotel get(String nom) throws Exception;
    
}
