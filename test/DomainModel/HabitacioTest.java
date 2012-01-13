/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import Hibernate.HibernateUtil;
import org.hibernate.Session;
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
public class HabitacioTest {
    
    static Session session = null;
    
    static Habitacio habProves = null;
    
    static String nomHotel = "provaNomHotel";
    static String desc = "provaDesc";
    static String poblacio = "provaPoblacio";
    static String nomCategoria = "provaNomCategoria";
    static Integer numeroHabitacio = 28;
    
    static Date dIni = new Date();
    static Date dFi = new Date();
    
    static Float preuReserva = 1500F;
    static String dniClient = "dniProva";
    
    static String nomTipusHab = "tipusProva";
    static Integer capacitat = 4;
    static String descTipus = "provaDesc";
    
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
        
        TipusHabitacio t = new TipusHabitacio(nomTipusHab, capacitat, descTipus);
        session.persist(t);
        
        Habitacio hab = new Habitacio(id, numeroHabitacio, h, nomTipusHab);
        session.persist(hab);
        
        habProves = new Habitacio(id, numeroHabitacio, h, nomTipusHab);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Habitacio h = (Habitacio) session.get(Habitacio.class, new HabitacioId(nomHotel, numeroHabitacio));
            session.delete(h);
            
            Hotel ho = (Hotel) session.get(Hotel.class, nomHotel);
            session.delete(ho);
            
            Poblacio p = (Poblacio) session.get(Poblacio.class, poblacio);
            session.delete(p);
            
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
    
    @Test
    public void testEstaDisp() {
        //TODO: fer-ho amb dates dels casos límit (anys diferents i tal) i donant els valors d'any, dia, etc.
        Reserva r = new Reserva(dIni, dFi, preuReserva, dniClient, nomHotel, numeroHabitacio);
        habProves.afReserva(r);
        
        Boolean result = habProves.estaDisp(dIni, dFi);
        assertFalse(result);
        
        result = habProves.estaDisp(new Date(), new Date());
        assertTrue(result);
    }
    
    /**
     * Test of afReserva method, of class Habitacio.
     */
    
    @Test
    public void testAfReserva() {
        System.out.println("afReserva");
        Reserva r = new Reserva(new Date(), new Date(), preuReserva, dniClient, nomHotel, numeroHabitacio);
        Integer initialSize = habProves.getReserves().size();
        habProves.afReserva(r);
        Integer finalSize = habProves.getReserves().size();
        assertTrue(initialSize + 1 == finalSize);
    }

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
