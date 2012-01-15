package DataControllers;

import DataInterfaces.ICtrlClient;
import DomainModel.Client;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * Controlador de capa de gestió de dades encarregat de recuperar 
 * instàncies de clients.
 * @author clara
 */
public class CtrlClient implements ICtrlClient{

    @Override
    public Client get(String dni) throws Exception {
        Session session = null; 
        Client c = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            c = (Client) session.get(Client.class, dni);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw new Exception("clientNoExisteix");
        }
        return c;
    }    
}
