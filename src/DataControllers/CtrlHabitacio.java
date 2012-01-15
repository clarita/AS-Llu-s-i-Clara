package DataControllers;

import DataInterfaces.ICtrlHabitacio;
import DomainModel.Habitacio;
import DomainModel.HabitacioId;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * Controlador de capa de gestió de dades encarregat de recuperar 
 * instàncies d'habitacions.
 * @author clara
 */
public class CtrlHabitacio implements ICtrlHabitacio {

    @Override
    public Habitacio get(Integer numero, String nomHotel) throws Exception {
        Session session = null; 
        Habitacio h = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            HabitacioId id = new HabitacioId(nomHotel, numero);
            h = (Habitacio) session.get(Habitacio.class, id);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw new Exception("habitacioNoExisteix");
        }
        return h;
    }    
}
