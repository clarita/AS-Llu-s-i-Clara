/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import DataInterfaces.ICtrlBonsHotels;
import DomainModel.BonsHotels;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author clara
 */
public class CtrlBonsHotels implements ICtrlBonsHotels {

    private int id = 1;
    
    @Override
    public BonsHotels get() {
        Session session = null; 
        BonsHotels bh = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            bh = (BonsHotels) session.get(BonsHotels.class, id);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            bh = new BonsHotels();
        }
        return bh;
    }
    
    public void changeDefaultId(int i) {
        this.id = i;
    }
    
}
