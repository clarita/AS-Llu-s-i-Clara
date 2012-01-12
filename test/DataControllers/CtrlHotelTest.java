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
    private static String nomCategoria = "categoria de prova";
    private static String nomPoblacio = "ciutat de prova";
    private static String nomHotel = "hotel de prova";
    
    public CtrlHotelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            //Insertem instàncies via hibernate per mirar si es recuperen bé
            CategoriaHotel categoria = new CategoriaHotel(nomCategoria);
            session.saveOrUpdate(categoria);
            Poblacio poblacio = new Poblacio(nomPoblacio);
            session.saveOrUpdate(poblacio);
            Hotel hotel = new Hotel(nomHotel,"Luxós hotel al centre de la ciutat.","Ciutat de prova",categoria);
            session.saveOrUpdate(hotel);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
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
     * Test of get method, of class CtrlHotel.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String nom = nomHotel;
        CtrlHotel instance = new CtrlHotel();
        Hotel result = instance.get(nom);
        String nomHotel = result.getNom();
        assertEquals(nom, nomHotel);
    }
}
