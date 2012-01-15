package DomainModel;

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
 * @author clara
 */
public class PercentDiscountPreuStrategyTest {
    
    private static Session session = null;
    
    
    //variables per Hibernate
    private static String nomHotel = "hotel de prova";
    private static String nomTipus = "tipus de prova";
    private static String nomPoblacio = "poblacio prova";
    private static String nomCategoria = "categoria prova";
    private static float preu = 100;
    private static float perc = 0.7F;
    
    public PercentDiscountPreuStrategyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
    
            PreuTipusHabitacioId id = new PreuTipusHabitacioId(nomHotel,nomTipus);
            PercentDiscountPreuStrategy pdps = new PercentDiscountPreuStrategy(id,perc);
            Poblacio p = new Poblacio(nomPoblacio);
            session.persist(p);
            CategoriaHotel ch = new CategoriaHotel(nomCategoria);
            session.persist(ch);
            Hotel hotel = new Hotel(nomHotel, "desc", nomPoblacio, ch);
            session.persist(hotel);
            TipusHabitacio tipus = new TipusHabitacio(nomTipus,3,"desc");
            session.persist(tipus);
            PreuTipusHabitacio pth = new PreuTipusHabitacio(id,
                    preu,tipus,pdps);
            session.saveOrUpdate(pth);
            session.saveOrUpdate(pdps);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            PercentDiscountPreuStrategy adps = (PercentDiscountPreuStrategy) 
                session.get(PercentDiscountPreuStrategy.class, 
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
    
    @Test
    public void hibernateFetch() {
        System.out.println("hibernateFetch");
        PercentDiscountPreuStrategy instance = (PercentDiscountPreuStrategy) session.get(
                PercentDiscountPreuStrategy.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        float expResult = perc;
        float result = instance.getPerc();
        assertEquals(expResult, result, 0.0);
        
        String nomHotelObtingut = instance.getId().getNomhotel();
        assertEquals(nomHotelObtingut, nomHotel);
        
    }

    /**
     * Test of calculaPreu method, of class PercentDiscountPreuStrategy.
     * Sense Hibernate
     */
    @Test
    public void testCalculaPreu() {
        System.out.println("calculaPreu");
        PreuTipusHabitacio p = new PreuTipusHabitacio();
        p.setPreu(preu);
        PercentDiscountPreuStrategy instance = new PercentDiscountPreuStrategy();
        instance.setPerc(perc);
        float expResult = (preu*perc);
        float result = instance.calculaPreu(p);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of calculaPreu method, of class PercentDiscountPreuStrategy.
     * Amb Hibernate
     */
    @Test
    public void testCalculaPreuH() {
        System.out.println("calculaPreu");
        PreuTipusHabitacio p = (PreuTipusHabitacio) session.get(
                PreuTipusHabitacio.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        PercentDiscountPreuStrategy instance = (PercentDiscountPreuStrategy) session.get(
                PercentDiscountPreuStrategy.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        float expResult = (preu*perc);
        float result = instance.calculaPreu(p);
        assertEquals(expResult, result, 0.0);
    }
}
