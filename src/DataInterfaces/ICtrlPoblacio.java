package DataInterfaces;

import DomainModel.Poblacio;
import java.util.ArrayList;

/**
 * Aquesta és la interfície que fa servir la capa de domini per interaccionar 
 * amb el controlador de poblacions de la capa de gestió de dades. Per convenció 
 * de nomenclatura, he afegit la I davant el nom, ja que és una interfície.
 * @author clara
 */
public interface ICtrlPoblacio {
    
    public Poblacio get(String nom) throws Exception;
    
    public ArrayList<Poblacio> tots();
}
