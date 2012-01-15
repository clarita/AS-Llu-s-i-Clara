/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import DataInterfaces.ICtrlTipusHabitacio;
import DomainModel.TipusHabitacio;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * Controlador de capa de gestió de dades encarregat de recuperar
 * instàncies de tipus d'habitació.
 * @author lluisgh28
 */
public class CtrlTipusHabitacio implements ICtrlTipusHabitacio{

    @Override
    public TipusHabitacio get(String nom) throws Exception {
        Session session = null; 
        TipusHabitacio t = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            t = (TipusHabitacio) session.get(TipusHabitacio.class, nom);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw new Exception("poblacioNoExisteix");
        }
        return t;
    }
}
