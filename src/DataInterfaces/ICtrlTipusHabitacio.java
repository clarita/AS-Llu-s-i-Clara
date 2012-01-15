/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterfaces;

import DomainModel.TipusHabitacio;

/**
 *
 * @author lluisgh28
 */
public interface ICtrlTipusHabitacio {
    
    public TipusHabitacio get(String nom) throws Exception;
}
