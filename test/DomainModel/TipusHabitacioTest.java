/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.HashSet;
import java.util.Calendar;
import Hibernate.HibernateUtil;
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
public class TipusHabitacioTest {
    
    static Session session = null;
    
    static String nomTipus = "nomTipusProva";
    static Integer capacitat = 4;
    static String descTipus = "descTipusProva";
    
    static TipusHabitacio tipusProva = null;

    static String nomHotel = "nomHotelProva";
    static String nomCategoria = "categoriaProva";
    static String descHotel = "descHotelProva";
    static String nomPoblacio = "poblacioProva";
    
    static String dniClient = "dniProva";
    static String nomClient = "nomClientProva";
    static String cognomsClient = "cognomsClientProva";
    static String emailClient = "emailClientProva";
    
    static Integer numeroHabitacio = 1;
    
    static Integer idReserva = null;
    
    static Calendar ini = Calendar.getInstance();
    static Calendar fi = Calendar.getInstance();
    
    
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
        
        Poblacio poblacio = new Poblacio(nomPoblacio);
        session.persist(poblacio);
        
        Client client = new Client(dniClient, nomClient, cognomsClient, emailClient);
        session.persist(client);
        
        CategoriaHotel categoria = new CategoriaHotel(nomCategoria);
        session.persist(categoria);
        
        Hotel hotel = new Hotel(nomHotel, descHotel, nomPoblacio, categoria);
        session.persist(hotel);
        
        TipusHabitacio tipus = new TipusHabitacio(nomTipus, capacitat, descTipus);
        session.persist(tipus);
        
        HabitacioId id = new HabitacioId(nomHotel, numeroHabitacio);
        Habitacio habitacio = new Habitacio(id, numeroHabitacio, hotel, nomTipus);
        session.persist(habitacio);
         
        ini.set(2012, 1, 17);
        fi.set(2012, 1, 24);
        Reserva reserva = new Reserva(ini.getTime(), fi.getTime(), 1500F, dniClient, nomHotel, numeroHabitacio);
        session.persist(reserva);
        idReserva = reserva.getIdReserva();
        
        habitacio.afReserva(reserva);
        session.saveOrUpdate(habitacio);
        
        HashSet<Habitacio> habitacions = new HashSet<Habitacio>();
        habitacions.add(habitacio);
        tipus.setHabitacions(habitacions);
        session.saveOrUpdate(tipus);
        
        session.flush();
        tipusProva = tipus;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {            
                                    
            HabitacioId id = new HabitacioId(nomHotel, numeroHabitacio);
            Habitacio hab = (Habitacio) session.get(Habitacio.class, id);
            session.delete(hab);
            
            Reserva r = (Reserva) session.get(Reserva.class, idReserva);
            session.delete(r);
         
            Hotel h = (Hotel) session.get(Hotel.class, nomHotel);
            session.delete(h);
            
            TipusHabitacio t = (TipusHabitacio) session.get(TipusHabitacio.class, nomTipus);
            session.delete(t);
                        
            Client c = (Client) session.get(Client.class, dniClient);
            session.delete(c);

            Poblacio p = (Poblacio) session.get(Poblacio.class, nomPoblacio);
            session.delete(p);

            CategoriaHotel ch = (CategoriaHotel) session.get(CategoriaHotel.class, nomCategoria);
            session.delete(ch);
            
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
        assertEquals(prova, descTipus);
    }
            
    /**
     * Test of numDisp method, of class TipusHabitacio.
     */
    
    @Test
    public void testNumDisp() {
        System.out.println("numDisp");
        
        ini.set(2012, 1, 17);
        fi.set(2012, 1, 24);
        
        Integer result = tipusProva.numDisp(ini.getTime(), fi.getTime(), nomHotel, capacitat);
        assertTrue(0 == result); //0 per les dates
        
        ini.set(2012, 1, 25);
        fi.set(2012, 1, 27);
        
        result = tipusProva.numDisp(ini.getTime(), fi.getTime(), nomHotel, capacitat - 1);
        assertTrue(1 == result);
        
        result = tipusProva.numDisp(ini.getTime(), fi.getTime(), nomHotel, capacitat + 1);
        assertTrue(0 == result); //0 per la capacitat
    }
    
    @Test
    public void testObteNumHabLliure() {
        System.out.println("obteNumHabLliure");
                       
        ini.set(2012, 1, 25);
        fi.set(2012, 1, 27);

        Integer result = tipusProva.obteNumeroHabLliure(nomHotel, ini.getTime(), fi.getTime());
        
        assertTrue(result == 1);
    }
}
