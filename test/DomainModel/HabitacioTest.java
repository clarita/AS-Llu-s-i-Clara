/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import Hibernate.HibernateUtil;
import org.hibernate.Session;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lluisgh28
 */
public class HabitacioTest {
    
    static Session session = null;
    
    static Habitacio habProves = null;
    
    static String nomHotel = "provaNomHotel";
    static String desc = "provaDesc";
    static String poblacio = "provaPoblacio";
    static String nomCategoria = "provaNomCategoria";
    static Integer numeroHabitacio = 28;
    
    public HabitacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
         
        Poblacio p = new Poblacio(poblacio);
        session.persist(p);
        
        CategoriaHotel categoria = new CategoriaHotel(nomCategoria);
        Hotel h = new Hotel(nomHotel, desc, poblacio, categoria);
        session.persist(h);
        HabitacioId id = new HabitacioId(nomHotel, numeroHabitacio);
        Habitacio hab = new Habitacio(id, numeroHabitacio, h);
        session.persist(hab);
        
        habProves = new Habitacio(id, numeroHabitacio, h);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Habitacio h = (Habitacio) session.get(Habitacio.class, new HabitacioId(nomHotel, numeroHabitacio));
            session.delete(h);
            
            Hotel ho = (Hotel) session.get(Hotel.class, nomHotel);
            session.delete(ho);
            session.getTransaction().commit();
        }

    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testHibernateFetch() {
        HabitacioId id = new HabitacioId(nomHotel, numeroHabitacio);
        Habitacio h = (Habitacio) session.get(Habitacio.class, id);
        String prova = h.getHotel().getNom();
        assertEquals(prova, nomHotel);
    }
    

    /**
     * Test of estaDisp method, of class Habitacio.
     */
    /*
    @Test
    public void testEstaDisp() {
        System.out.println("estaDisp");
        Date dataInici = null;
        Date dataFi = null;
        Habitacio instance = new Habitacio();
        boolean expResult = false;
        boolean result = instance.estaDisp(dataInici, dataFi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     * 
     */

    /**
     * Test of afReserva method, of class Habitacio.
     */
    /*
    @Test
    public void testAfReserva() {
        System.out.println("afReserva");
        Reserva r = null;
        Habitacio instance = new Habitacio();
        instance.afReserva(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of esDelHotel method, of class Habitacio.
     */
    @Test
    public void testEsDelHotel() {
        System.out.println("esDelHotel");
        boolean result = habProves.esDelHotel(nomHotel);
        assertTrue(result);
        result = habProves.esDelHotel("Ritz");
        assertFalse(result);
    }
}
