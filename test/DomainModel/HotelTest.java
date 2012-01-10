package DomainModel;

import org.junit.Ignore;
import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;
import Hibernate.HibernateUtil;
import org.hibernate.Session;
import TupleTypes.DadesHotel;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de proves per la classe Hotel
 * @author clara
 */
public class HotelTest {
    
    static Session session = null;
    static Hotel hotel;
    static Date dIni;
    static Date dFi;
    
    static int diesReserva = 3;
    static int preuHabitacio = 100;
    static int descompte = 50;
    static String nomTipus = "tipus petit";
    
    public HotelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //preparació de dades sense Hibernate
        hotel = new Hotel();
        TipusHabitacio tipus = new TipusHabitacio();
        tipus.setNom(nomTipus);
        AbsoluteDiscountPreuStrategy strategy = new AbsoluteDiscountPreuStrategy();
        strategy.setDescompte(descompte);
        PreuTipusHabitacio pth = new PreuTipusHabitacio();
        pth.setPreu(preuHabitacio);
        pth.setTipus(tipus);
        pth.setStrategy(strategy);
        Set<PreuTipusHabitacio> preus = new HashSet<PreuTipusHabitacio>();
        preus.add(pth);
        hotel.setPreus(preus);
        
        dIni = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dIni);
        cal.add(Calendar.DATE, diesReserva);
        dFi = cal.getTime();
        
        //preparacio de dades amb Hibernate
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            CategoriaHotel c = new CategoriaHotel("categoria de prova");
            Poblacio p = new Poblacio("ciutat de prova");
            session.persist(p);
            Hotel h = new Hotel("Hotel Prova","Hotel de luxe en el centre de Manhattan","ciutat de prova",c);
            session.persist(h);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if(session != null){
            Hotel h = (Hotel)session.get(Hotel.class, "Hotel Prova");
            session.delete(h);
            CategoriaHotel c = (CategoriaHotel)session.get(CategoriaHotel.class, "categoria de prova");
//            session.delete(c);
            Poblacio p = (Poblacio)session.get(Poblacio.class, "ciutat de prova");
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

    /**
     * Test of obtePreuTotal method, of class Hotel.
     * Without involving persistence
     */
    @Test
    public void testObtePreuTotal() {
        System.out.println("obtePreuTotal");
        
        float preuTotal = hotel.obtePreuTotal("tipus petit", dIni, dFi);
        
        float expResult = diesReserva * (preuHabitacio - descompte);
        assertEquals(expResult, preuTotal, 0.0);
    }

    /**
     * Test of obteNumeroHabLliure method, of class Hotel.
     */
    @Ignore
    @Test
    public void testObteNumeroHabLliure() {
        System.out.println("obteNumeroHabLliure");
        String tipushab = "";
        Date datainici = null;
        Date dataFi = null;
        Hotel instance = new Hotel();
        Integer expResult = null;
        Integer result = instance.obteNumeroHabLliure(tipushab, datainici, dataFi);
        assertEquals(expResult, result);
    }

    /**
     * Test of estaDisp method, of class Hotel.
     */
    @Ignore
    @Test
    public void testEstaDisp() {
        System.out.println("estaDisp");
        Date dIni = null;
        Date dFi = null;
        Integer numOc = null;
        DadesHotel dh = null;
        Hotel instance = new Hotel();
        boolean expResult = false;
        boolean result = instance.estaDisp(dIni, dFi, numOc, dh);
        assertEquals(expResult, result);
    }

}
