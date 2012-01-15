/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import DomainModel.HabitacioId;
import DomainModel.TipusHabitacio;
import DomainModel.Hotel;
import DomainModel.Poblacio;
import DomainModel.CategoriaHotel;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import DomainModel.Habitacio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clara
 */
public class CtrlHabitacioTest {
    
    private static Session session = null;
    private static String nomCategoria = "categoria de prova";
    private static String nomPoblacio = "ciutat de prova";
    private static String nomHotel = "hotel de prova";
    private static String nomTipus = "tipus de prova";
    private static Integer numeroHabitacio = 1;
    
    public CtrlHabitacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            //Insertem instàncies via hibernate per mirar si es recuperen bé
            CategoriaHotel categoria = new CategoriaHotel(nomCategoria);
            session.persist(categoria);
            Poblacio poblacio = new Poblacio(nomPoblacio);
            session.persist(poblacio);
            Hotel hotel = new Hotel(nomHotel,"Luxós hotel al centre de la ciutat.",nomPoblacio,categoria);
            session.persist(hotel);
            TipusHabitacio tipus = new TipusHabitacio(nomTipus,2,"desc");
            session.persist(tipus);
            Habitacio habitacio = new Habitacio(new HabitacioId(nomHotel,numeroHabitacio), hotel, nomTipus);
            session.persist(habitacio);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Habitacio habitacio = (Habitacio) session.get(Habitacio.class, 
                    new HabitacioId(nomHotel,numeroHabitacio));
            session.delete(habitacio);
            TipusHabitacio tipus = (TipusHabitacio) session.get(TipusHabitacio.class, 
                    nomTipus);
            session.delete(tipus);
            Hotel hotel = (Hotel) session.get(Hotel.class, nomHotel);
            session.delete(hotel);
            Poblacio poblacio = (Poblacio) session.get(Poblacio.class, nomPoblacio);
            session.delete(poblacio);
            CategoriaHotel categoria = (CategoriaHotel) session.get(CategoriaHotel.class, nomCategoria);
            session.delete(categoria);
            session.getTransaction().commit();
        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class CtrlHabitacio.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        CtrlHabitacio instance = new CtrlHabitacio();
        Habitacio result = instance.get(numeroHabitacio, nomHotel);
        String nomHotelObtingut = result.getId().getNomHotel();
        assertEquals(nomHotel, nomHotelObtingut);
    }
}
