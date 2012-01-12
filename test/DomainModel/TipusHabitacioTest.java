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
public class TipusHabitacioTest {
    
    static Session session = null;

    public TipusHabitacioTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        TipusHabitacio t = new TipusHabitacio("Suite", 4, "Suite per a 4 persones.");
        session.persist(t);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        if (session != null) {
            TipusHabitacio t = (TipusHabitacio) session.get(TipusHabitacio.class, "Suite");
            session.delete(t);
            session.getTransaction().commit();
        }                

    }

    
    @Test
    public void testHibernateFetch() {
        TipusHabitacio t = (TipusHabitacio) session.get(TipusHabitacio.class, "Suite");
        String prova = t.getDescripcio();
        assertEquals(prova, "Suite per a 4 persones.");
    }
            
    /**
     * Test of numDisp method, of class TipusHabitacio.
     */
    
    @Test
    public void testNumDisp() {
        System.out.println("numDisp");
        Date dIni = null;
        Date dFi = null;
        String nomHotel = "";
        Integer numOcup = null;
        TipusHabitacio instance = new TipusHabitacio();
        Integer expResult = null;
        Integer result = instance.numDisp(dIni, dFi, nomHotel, numOcup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
