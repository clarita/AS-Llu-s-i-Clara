package DataControllers;

import DataInterfaces.ICtrlPoblacio;
import DomainModel.Poblacio;
import Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


/**
 * Controlador de capa de gestió de dades encarregat de recuperar 
 * instàncies de poblacions.
 * @author clara
 */
public class CtrlPoblacio implements ICtrlPoblacio{

    @Override
    public Poblacio get(String nom) throws Exception{
        Session session = null; 
        Poblacio p = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            p = (Poblacio) session.get(Poblacio.class, nom);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw new Exception("poblacioNoExisteix");
        }
        return p;
    }

    
    @Override
    public ArrayList<Poblacio> tots() {
        ArrayList<Poblacio> resultat = new ArrayList<Poblacio>();
        Session session = null; 
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List<Poblacio> retorn = session.createQuery("from Poblacio").list();
            resultat = new ArrayList<Poblacio>(retorn);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
        return resultat;
    }
        
}
