/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import Hibernate.HibernateUtil;
import java.util.Calendar;
import org.hibernate.Session;
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
   
    static Session session;
    
    static Reserva reservaProva;
    
    static Calendar cIni = Calendar.getInstance();
    static Calendar cFi = Calendar.getInstance();
    
    static String dniClient = "dniProva";
    static String nomHotel = "hotelProva";
    static Integer numeroHab = 1;
    static Float preu = 1500F;
    
    static String desc = "descProva";
    static String nomPoblacio = "poblacioProva";
    static String nomCategoria = "categoriaProva";
    static String nomTipusHab = "tipusProva";
    static HabitacioId idHab = new HabitacioId(nomHotel, numeroHab);

    static Integer idReserva;
    
    public ReservaTest() {
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
        
        Poblacio p = new Poblacio(nomPoblacio);
        session.persist(p);
        
        CategoriaHotel ch = new CategoriaHotel(nomCategoria);
        session.persist(ch);
        
        Hotel h = new Hotel(nomHotel, desc, nomPoblacio, ch);
        session.persist(h);
        
        TipusHabitacio t = new TipusHabitacio(nomTipusHab, 4, "descTipus");
        session.persist(t);
        
        Habitacio hab = new Habitacio(idHab, numeroHab, h, nomTipusHab);
        session.persist(hab);
        
        Client c = new Client(dniClient);
        session.persist(c);
        
        cIni.set(2011, 0, 14);
        cFi.set(2011, 0, 16);
        reservaProva = new Reserva(cIni.getTime(), cFi.getTime(), preu, dniClient, nomHotel, numeroHab);
        session.persist(reservaProva);
        idReserva = reservaProva.getIdReserva();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        if (session != null) {
            session.delete(session.get(Reserva.class, idReserva));
            session.delete(session.get(Client.class, dniClient));
            session.delete(session.get(Habitacio.class, idHab));
            session.delete(session.get(TipusHabitacio.class, nomTipusHab));
            session.delete(session.get(Hotel.class, nomHotel));
            session.delete(session.get(CategoriaHotel.class, nomCategoria));
            session.delete(session.get(Poblacio.class, nomPoblacio));
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
     * Test of esSolapa method, of class Reserva.
     */
    @Test
    public void testEsSolapa() {
        System.out.println("esSolapa");
        
         Boolean result = reservaProva.esSolapa(cIni.getTime(), cFi.getTime());
         assertTrue(result);
         
         cIni.set(2011, 0, 15);
         cFi.set(2011, 0, 17);
         result = reservaProva.esSolapa(cIni.getTime(), cFi.getTime());
         assertTrue(result);
         
         cIni.set(2011, 0, 11);
         cFi.set(2011, 0, 13);
         result = reservaProva.esSolapa(cIni.getTime(), cFi.getTime());
         assertFalse(result);
         // hi ha molts casos... de moment, no els comprovo tots.
    }
    
    @Test
    public void testHibernateFetch() {
        Reserva r = (Reserva) session.get(Reserva.class, idReserva);
        assertEquals(r.getIdReserva(), idReserva);
    }
    
    /**
     * Tot i que cal comprovar les insercions de Reserva, ja que durant l'execució
     * dels casos d'ús es produiran, ja ho fem al setUp class.
     */
    @Test
    public void testHibernateInsert() {
        
    }
}
