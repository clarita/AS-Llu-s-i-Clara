/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.HashSet;
import java.util.Calendar;
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
    
    static String nomTipus = "provaTipus";
    static Integer capacitat = 4;
    static String desc = "provaDesc";
    
    static TipusHabitacio tipusProva = null;

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
        TipusHabitacio t = new TipusHabitacio(nomTipus, capacitat, desc);
        session.persist(t);
        
        tipusProva = new TipusHabitacio(nomTipus, capacitat, desc);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            TipusHabitacio t = (TipusHabitacio) session.get(TipusHabitacio.class, nomTipus);
            session.delete(t);
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
        TipusHabitacio t = (TipusHabitacio) session.get(TipusHabitacio.class, nomTipus);
        String prova = t.getDescripcio();
        assertEquals(prova, desc);
    }
            
    /**
     * Test of numDisp method, of class TipusHabitacio.
     */
    
    @Test
    public void testNumDisp() {
        System.out.println("numDisp");
        //Cal crear una habitacio amb reserves del tipus tipusProva
        
        CategoriaHotel c = new CategoriaHotel("luxeprova");
        Hotel h = new Hotel("prova", "caaar", "BCN", c);
        
        HabitacioId id = new HabitacioId("prova", 1);
        Habitacio hab = new Habitacio(id, 1, h, nomTipus);
        
        
        Calendar ini = Calendar.getInstance();
        Calendar fi = Calendar.getInstance();
        ini.set(2012, 1, 17);
        fi.set(2012, 1, 24);
        
        Reserva r = new Reserva(ini.getTime(), fi.getTime(), 1500F, "dniclient", "prova", 1);

        hab.afReserva(r);
        HashSet<Habitacio> habitacions = new HashSet<Habitacio>();
        habitacions.add(hab);
        tipusProva.setHabitacions(habitacions);
        
        Integer result = tipusProva.numDisp(ini.getTime(), fi.getTime(), "prova", 4);
        assertTrue(0 == result); //0 per les dates
        
        ini.set(2012, 1, 25);
        fi.set(2012, 1, 27);
        result = tipusProva.numDisp(ini.getTime(), fi.getTime(), "prova", 3);
        assertTrue(1 == result);
        
        result = tipusProva.numDisp(ini.getTime(), fi.getTime(), "prova", 5);
        assertTrue(0 == result); //0 per la capacitat
    }
    
    @Test
    public void testObteNumHabLliure() {
        
    }
}
