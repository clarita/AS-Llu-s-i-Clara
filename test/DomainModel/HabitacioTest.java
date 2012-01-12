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
        CategoriaHotel categoria = new CategoriaHotel("Luxe");
        Hotel h = new Hotel("palace", "pijo", "Barcelona", categoria);
        HabitacioId id = new HabitacioId("palace", 1);
        Habitacio hab = new Habitacio(id, 1, h);
        session.persist(hab);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Habitacio h = (Habitacio) session.get(Habitacio.class, new HabitacioId("palace", 1));
            session.delete(h);
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
        HabitacioId id = new HabitacioId("palace", 1);
        Habitacio h = (Habitacio) session.get(Habitacio.class, id);
        String prova = h.getHotel().getNom();
        assertEquals(prova, "palace");
    }

    /**
     * Test of estaDisp method, of class Habitacio.
     */
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

    /**
     * Test of afReserva method, of class Habitacio.
     */
    @Test
    public void testAfReserva() {
        System.out.println("afReserva");
        Reserva r = null;
        Habitacio instance = new Habitacio();
        instance.afReserva(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esDelHotel method, of class Habitacio.
     */
    @Test
    public void testEsDelHotel() {
        System.out.println("esDelHotel");
        String nomHotel = "";
        Habitacio instance = new Habitacio();
        boolean expResult = false;
        boolean result = instance.esDelHotel(nomHotel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHotel method, of class Habitacio.
     */
    @Test
    public void testGetHotel() {
        System.out.println("getHotel");
        Habitacio instance = new Habitacio();
        Hotel expResult = null;
        Hotel result = instance.getHotel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHotel method, of class Habitacio.
     */
    @Test
    public void testSetHotel() {
        System.out.println("setHotel");
        Hotel hotel = null;
        Habitacio instance = new Habitacio();
        instance.setHotel(hotel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Habitacio.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Habitacio instance = new Habitacio();
        Integer expResult = null;
        Integer result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Habitacio.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        Integer numero = null;
        Habitacio instance = new Habitacio();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReserves method, of class Habitacio.
     */
    @Test
    public void testGetReserves() {
        System.out.println("getReserves");
        Habitacio instance = new Habitacio();
        Set expResult = null;
        Set result = instance.getReserves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReserves method, of class Habitacio.
     */
    @Test
    public void testSetReserves() {
        System.out.println("setReserves");
        Set<Reserva> reserves = null;
        Habitacio instance = new Habitacio();
        instance.setReserves(reserves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Habitacio.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Habitacio instance = new Habitacio();
        HabitacioId expResult = null;
        HabitacioId result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Habitacio.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        HabitacioId id = null;
        Habitacio instance = new Habitacio();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
