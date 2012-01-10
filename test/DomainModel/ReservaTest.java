/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.Date;
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
public class ReservaTest {
    
    public ReservaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of esSolapa method, of class Reserva.
     */
    @Test
    public void testEsSolapa() {
        System.out.println("esSolapa");
        Date dIni = null;
        Date dFi = null;
        Reserva instance = new Reserva();
        boolean expResult = false;
        boolean result = instance.esSolapa(dIni, dFi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFi method, of class Reserva.
     */
    @Test
    public void testGetDataFi() {
        System.out.println("getDataFi");
        Reserva instance = new Reserva();
        Date expResult = null;
        Date result = instance.getDataFi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataFi method, of class Reserva.
     */
    @Test
    public void testSetDataFi() {
        System.out.println("setDataFi");
        Date dataFi = null;
        Reserva instance = new Reserva();
        instance.setDataFi(dataFi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataInici method, of class Reserva.
     */
    @Test
    public void testGetDataInici() {
        System.out.println("getDataInici");
        Reserva instance = new Reserva();
        Date expResult = null;
        Date result = instance.getDataInici();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataInici method, of class Reserva.
     */
    @Test
    public void testSetDataInici() {
        System.out.println("setDataInici");
        Date dataInici = null;
        Reserva instance = new Reserva();
        instance.setDataInici(dataInici);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataReserva method, of class Reserva.
     */
    @Test
    public void testGetDataReserva() {
        System.out.println("getDataReserva");
        Reserva instance = new Reserva();
        Date expResult = null;
        Date result = instance.getDataReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataReserva method, of class Reserva.
     */
    @Test
    public void testSetDataReserva() {
        System.out.println("setDataReserva");
        Date dataReserva = null;
        Reserva instance = new Reserva();
        instance.setDataReserva(dataReserva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdReserva method, of class Reserva.
     */
    @Test
    public void testGetIdReserva() {
        System.out.println("getIdReserva");
        Reserva instance = new Reserva();
        String expResult = "";
        String result = instance.getIdReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdReserva method, of class Reserva.
     */
    @Test
    public void testSetIdReserva() {
        System.out.println("setIdReserva");
        String idReserva = "";
        Reserva instance = new Reserva();
        instance.setIdReserva(idReserva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreuTotal method, of class Reserva.
     */
    @Test
    public void testGetPreuTotal() {
        System.out.println("getPreuTotal");
        Reserva instance = new Reserva();
        Float expResult = null;
        Float result = instance.getPreuTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreuTotal method, of class Reserva.
     */
    @Test
    public void testSetPreuTotal() {
        System.out.println("setPreuTotal");
        Float preuTotal = null;
        Reserva instance = new Reserva();
        instance.setPreuTotal(preuTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testFetch() {
        
    }
    
    @Test
    public void testInsert() {
        
    }
}
