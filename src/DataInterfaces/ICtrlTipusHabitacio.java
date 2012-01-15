/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterfaces;

import DomainModel.TipusHabitacio;

/**
 * Aquesta és la interfície que fa servir la capa de domini per interaccionar 
 * amb el controlador de tipus d'habitació de la capa de gestió de dades. Per
 * convenció de nomenclatura, he afegit la I davant el nom, ja que és una
 * interfície. 
 * @author lluisgh28
 */
public interface ICtrlTipusHabitacio {
    
    public TipusHabitacio get(String nom) throws Exception;
}
