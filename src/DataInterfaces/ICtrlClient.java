package DataInterfaces;

import DomainModel.Client;

/**
 * Aquesta és la interfície que fa servir la capa de domini per interaccionar 
 * amb el controlador de clients de la capa de gestió de dades. Per convenció 
 * de nomenclatura, he afegit la I davant el nom, ja que és una interfície.
 * @author clara
 */
public interface ICtrlClient {
    
    /**
     * Recupera un client a partir del seu dni
     * @param dni
     * @return 
     */
    public Client get(String dni) throws Exception;
}
