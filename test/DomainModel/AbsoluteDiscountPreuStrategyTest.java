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
 * Classe per provar la estratègia absoluta
 * @author clara
 */
public class AbsoluteDiscountPreuStrategyTest {
    
    private static Session session = null;
    
    
    //variables per Hibernate
    private static String nomHotel = "hotel de prova";
    private static String nomTipus = "tipus de prova";
    private static float preu = 100;
    private static float descompte = 50;
    
    public AbsoluteDiscountPreuStrategyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
    
            AbsoluteDiscountPreuStrategy adps = new AbsoluteDiscountPreuStrategy(descompte);
            Hotel hotel = new Hotel();
            hotel.setNom(nomHotel);
            session.saveOrUpdate(hotel);
            TipusHabitacio tipus = new TipusHabitacio();
            tipus.setNom(nomTipus);
            PreuTipusHabitacio pth = new PreuTipusHabitacio();
            pth.setTipus(tipus);
            PreuTipusHabitacioId id = new PreuTipusHabitacioId(nomHotel,nomTipus);
            pth.setId(id);
            pth.setPreu(preu);
            adps.setId(id);
            pth.setStrategy(adps);
            session.saveOrUpdate(tipus);
            session.saveOrUpdate(pth);
            session.saveOrUpdate(adps);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
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
     * Test of calculaPreu method, of class AbsoluteDiscountPreuStrategy.
     * Sense Hibernate
     */
    @Test
    public void testCalculaPreu() {
        System.out.println("calculaPreu");
        PreuTipusHabitacio p = new PreuTipusHabitacio();
        p.setPreu(preu);
        AbsoluteDiscountPreuStrategy instance = new AbsoluteDiscountPreuStrategy();
        instance.setDescompte(descompte);
        float expResult = (preu-descompte);
        float result = instance.calculaPreu(p);
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of calculaPreu method, of class AbsoluteDiscountPreuStrategy.
     * Amb Hibernate
     */
    @Test
    public void testCalculaPreuH() {
        System.out.println("calculaPreu");
        PreuTipusHabitacio p = (PreuTipusHabitacio) session.get(
                PreuTipusHabitacio.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        AbsoluteDiscountPreuStrategy instance = (AbsoluteDiscountPreuStrategy) session.get(
                AbsoluteDiscountPreuStrategy.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        float expResult = (preu-descompte);
        float result = instance.calculaPreu(p);
        assertEquals(expResult, result, 0.0);
    }
}
