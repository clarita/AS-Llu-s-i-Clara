package DataControllers;

import DataInterfaces.ICtrlHotel;
import DomainModel.Hotel;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * Controlador de capa de gestió de dades encarregat de recuperar 
 * instàncies d'hotels.
 * @author clara
 */
public class CtrlHotel implements ICtrlHotel{

    @Override
    public Hotel get(String nom) throws Exception {
        Session session = null;
        Hotel hotel = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            hotel = (Hotel) session.get(Hotel.class, nom);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw new Exception("hotelNoExisteix");
        }
        return hotel;
    }
    
}
