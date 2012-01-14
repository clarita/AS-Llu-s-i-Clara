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
    
    //variables per Hibernate
    private static String nomHotel = "hotel de prova";
    private static String nomTipus = "tipus de prova";
    private static String nomCategoria = "categoria de prova";
    private static String nomPoblacio = "poblacio de prova";
    private static Integer numeroHabitacio = 1;
    private static float preu = 100;
    private static float descompte = 50;
    private static int diesReserva = 3;
    private static Date dIni;
    private static Date dFi;
    private static String dniC = "334455";
    
    public HotelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        dIni = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, diesReserva);
        dFi = cal.getTime();
        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
    
            CategoriaHotel c = new CategoriaHotel(nomCategoria);
            session.persist(c);
            Poblacio p = new Poblacio(nomPoblacio);
            session.persist(p);
            Hotel h = new Hotel(nomHotel,"Hotel de luxe en el centre de Manhattan",nomPoblacio,c);
            session.persist(h);
            PreuTipusHabitacioId id = new PreuTipusHabitacioId(nomHotel,nomTipus);
            AbsoluteDiscountPreuStrategy adps = new AbsoluteDiscountPreuStrategy(id,descompte);
            TipusHabitacio tipus = new TipusHabitacio(nomTipus,3,"desc");
            session.persist(tipus);
            PreuTipusHabitacio pth = new PreuTipusHabitacio(id,
                    preu,tipus,adps);
            Set<PreuTipusHabitacio> preus = new HashSet<PreuTipusHabitacio>();
            preus.add(pth);
            h.setPreus(preus);
            
            session.persist(pth);
            session.persist(adps);
            Habitacio habitacio = new Habitacio(new HabitacioId(nomHotel,numeroHabitacio),numeroHabitacio,h,nomTipus);
            session.persist(habitacio);
            
            Client client = new Client(dniC);
            session.persist(client);
            Comentari comentari = new Comentari(new ComentariId(nomHotel, dniC, dIni));
            session.persist(comentari);
            Set<Comentari> comentaris = new HashSet<Comentari>();
            comentaris.add(comentari);
            h.setComentaris(comentaris);
            session.saveOrUpdate(h);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if(session != null){
            Comentari comentari = (Comentari)session.get(Comentari.class, new ComentariId(nomHotel, dniC, dIni));
            session.delete(comentari);
            Client c = (Client)session.get(Client.class, dniC);
            session.delete(c);
            Habitacio hab = (Habitacio)session.get(Habitacio.class, new HabitacioId(nomHotel, numeroHabitacio));
            session.delete(hab);
            AbsoluteDiscountPreuStrategy adps = (AbsoluteDiscountPreuStrategy) 
                session.get(AbsoluteDiscountPreuStrategy.class, 
                new PreuTipusHabitacioId(nomHotel,nomTipus));
            session.delete(adps);
            PreuTipusHabitacio pth = (PreuTipusHabitacio) 
                session.get(PreuTipusHabitacio.class, 
                new PreuTipusHabitacioId(nomHotel,nomTipus));
            session.delete(pth);
            Hotel hotel = (Hotel) session.get(Hotel.class, nomHotel);
            session.delete(hotel);
            TipusHabitacio tipus = (TipusHabitacio) session.get(TipusHabitacio.class, nomTipus);
            session.delete(tipus);
            CategoriaHotel cat = (CategoriaHotel)session.get(CategoriaHotel.class, nomCategoria);
            session.delete(cat);
            Poblacio p = (Poblacio)session.get(Poblacio.class, nomPoblacio);
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
    public void hibernateFetch() {
        System.out.println("hibernateFetch");
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        String nomHotelObtingut = hotel.getNom();
        assertEquals(nomHotelObtingut,nomHotel);
    }
    
    @Test
    public void hibernateAssociationToCategoria() {
        System.out.println("hibernateAssociationToCategoria");
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        CategoriaHotel catObtinguda = hotel.getCategoria();
        assertTrue(catObtinguda != null);
    }
    
    @Test
    public void hibernateAssociationToPreuTipusHabitacio() {
        System.out.println("hibernateAssociationToPreuTipusHabitacio");
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        int numPTHs = hotel.getPreus().size();
        assertEquals(numPTHs,1);
    }
    
    @Test
    public void hibernateAssociationToComentari() {
        System.out.println("hibernateAssociationToComentari");
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        int numComentaris = hotel.getComentaris().size();
        assertEquals(numComentaris,1);
    }

    /**
     * Test of obtePreuTotal method, of class Hotel.
     */
    @Test
    public void testObtePreuTotal() {
        System.out.println("obtePreuTotal");
        
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        float preuTotal = hotel.obtePreuTotal(nomTipus, dIni, dFi);
        
        float expResult = diesReserva * (preu - descompte);
        assertEquals(expResult, preuTotal, 0.0);
    }

    /**
     * Test of obteNumeroHabLliure method, of class Hotel.
     */
    @Ignore
    @Test
    public void testObteNumeroHabLliure() {
        System.out.println("obteNumeroHabLliure");
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        int obtingutsPerTipus = pth.obteNumeroHabLliure(nomHotel, dIni, dFi);
        int obtingutsPerHotel = hotel.obteNumeroHabLliure(nomTipus, dIni, dFi);
        
        assertEquals(obtingutsPerTipus, obtingutsPerHotel);
    }

    /**
     * Test of estaDisp method, of class Hotel.
     */
    @Ignore
    @Test
    public void testEstaDisp() {
        System.out.println("estaDisp");
        Hotel hotel = (Hotel)session.get(Hotel.class, nomHotel);
        boolean resultat = hotel.estaDisp(dIni, dFi, numeroHabitacio, new DadesHotel());
        assertTrue(resultat);
    }

}
