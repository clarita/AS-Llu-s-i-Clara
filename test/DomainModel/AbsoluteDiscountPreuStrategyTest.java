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
    private static String nomPoblacio = "poblacio prova";
    private static String nomCategoria = "categoria prova";
    private static float preu = 100;
    private static float descompte = 50;
    
    public AbsoluteDiscountPreuStrategyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
    
            PreuTipusHabitacioId id = new PreuTipusHabitacioId(nomHotel,nomTipus);
            AbsoluteDiscountPreuStrategy adps = new AbsoluteDiscountPreuStrategy(id,descompte);
            Poblacio p = new Poblacio(nomPoblacio);
            session.persist(p);
            CategoriaHotel ch = new CategoriaHotel(nomCategoria);
            session.persist(ch);
            Hotel hotel = new Hotel(nomHotel, "desc", nomPoblacio, ch);
            session.persist(hotel);
            TipusHabitacio tipus = new TipusHabitacio(nomTipus,3,"desc");
            session.persist(tipus);
            PreuTipusHabitacio pth = new PreuTipusHabitacio(id,
                    preu,tipus,adps);
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
        AbsoluteDiscountPreuStrategy instance = (AbsoluteDiscountPreuStrategy) session.get(
                AbsoluteDiscountPreuStrategy.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        float expResult = descompte;
        float result = instance.getDescompte();
        assertEquals(expResult, result, 0.0);
        
        String nomHotelObtingut = instance.getId().getNomhotel();
        assertEquals(nomHotelObtingut, nomHotel);
        
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
        System.out.println("calculaPreuHibernate");
        PreuTipusHabitacio p = (PreuTipusHabitacio) session.get(
                PreuTipusHabitacio.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        AbsoluteDiscountPreuStrategy instance = (AbsoluteDiscountPreuStrategy) session.get(
                AbsoluteDiscountPreuStrategy.class, new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        float expResult = (preu-descompte);
        float result = instance.calculaPreu(p);
        assertEquals(expResult, result, 0.0);
    }
}
