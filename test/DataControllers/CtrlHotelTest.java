/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import DomainModel.CategoriaHotel;
import DomainModel.Poblacio;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import DomainModel.Hotel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe per provar el controlador de dades de població
 * @author clara
 */
public class CtrlHotelTest {
    
    private static Session session = null;
    
    public CtrlHotelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            //Insertem instàncies via hibernate per mirar si es recuperen bé
            CategoriaHotel categoria = new CategoriaHotel("categoria de prova");
            session.persist(categoria);
            Poblacio poblacio = new Poblacio("Ciutat de prova");
            session.persist(poblacio);
            Hotel hotel = new Hotel("Hotel de prova","Luxós hotel al centre de la ciutat.","Ciutat de prova",categoria);
            session.persist(hotel);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Hotel hotel = (Hotel) session.get(Hotel.class, "Hotel de prova");
            session.delete(hotel);
            Poblacio poblacio = (Poblacio) session.get(Poblacio.class, "Ciutat de prova");
            session.delete(poblacio);
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
     * Test of get method, of class CtrlHotel.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String nom = "Hotel de prova";
        CtrlHotel instance = new CtrlHotel();
        Hotel result = instance.get(nom);
        String nomHotel = result.getNom();
        assertEquals(nom, nomHotel);
    }
}
