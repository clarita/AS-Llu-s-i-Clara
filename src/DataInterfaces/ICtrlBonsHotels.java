/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterfaces;

import DomainModel.BonsHotels;

/**
 * Aquesta interficie no constava al lliurament 1, pero es necessaria si volem 
 * recuperar les dades de BonsHotels de la base de dades (tot i que en aquest 
 * prototipus no es fan servir)
 * @author clara
 */
public interface ICtrlBonsHotels {
    
    /**
     * Recupera les dades de BonsHotels
     * @return
     * @throws Exception 
     */
    public BonsHotels get();
}
