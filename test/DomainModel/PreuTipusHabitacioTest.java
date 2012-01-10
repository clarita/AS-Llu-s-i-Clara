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
 * Classe per provar PreuTipusHabitacio, tant amb Hibernate com sense
 * @author clara
 */
public class PreuTipusHabitacioTest {
    
    static Session session = null;
    
    //dades sense Hibernate
    static PreuTipusHabitacio pth;
    
    static float preu = 100;
    static float descompte = 50;
    static String nomTipus = "tipus petit";
    
    //dades amb Hibernate
    static String nomTipusH = "tipus de prova";
    static String nomHotelH = "Hotel de prova";
    
    public PreuTipusHabitacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //preparació de dades sense Hibernate
        TipusHabitacio tipus = new TipusHabitacio();
        tipus.setNom(nomTipus);
        AbsoluteDiscountPreuStrategy strategy = new AbsoluteDiscountPreuStrategy();
        strategy.setDescompte(descompte);
        pth = new PreuTipusHabitacio();
        pth.setPreu(preu);
        pth.setTipus(tipus);
        pth.setStrategy(strategy);
        
        //preparacio de dades amb Hibernate
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            CategoriaHotel c = new CategoriaHotel("categoria de prova");
            Poblacio p = new Poblacio("ciutat de prova");
            session.saveOrUpdate(p);
            Hotel h = new Hotel(nomHotelH,"Hotel de luxe en el centre de Manhattan","ciutat de prova",c);
            session.saveOrUpdate(h);
            TipusHabitacio t = new TipusHabitacio(nomTipusH,1,"desc");
            PreuTipusHabitacio preuth = new PreuTipusHabitacio();
            PreuTipusHabitacioId id = new PreuTipusHabitacioId(nomHotelH,nomTipusH);
            preuth.setId(id);
            preuth.setPreu(preu);
            preuth.setTipus(t);
            AbsoluteDiscountPreuStrategy str = new AbsoluteDiscountPreuStrategy();
            str.setId(id);
            str.setDescompte(descompte);
            preuth.setStrategy(str);
            session.saveOrUpdate(preuth);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculaPreu method, of class PreuTipusHabitacio.
     * Sense Hibernate
     */
    @Test
    public void testCalculaPreu() {
        System.out.println("calculaPreu");
        
        float expResult = (preu-descompte);
        float result = pth.calculaPreu();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isOfType method, of class PreuTipusHabitacio.
     * Sense Hibernate
     */
    @Test
    public void testIsOfType() {
        System.out.println("isOfType");
        
        boolean expResult = true;
        boolean result = pth.isOfType(nomTipus);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomTipus method, of class PreuTipusHabitacio.
     * Sense Hibernate
     */
    @Test
    public void testGetNomTipus() {
        System.out.println("getNomTipus");
        
        String expResult = nomTipus;
        String result = pth.getNomTipus();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calculaPreu method, of class PreuTipusHabitacio.
     * Amb Hibernate
     */
    @Test
    public void testCalculaPreuH() {
        System.out.println("calculaPreu");
        
        PreuTipusHabitacio preuth = (PreuTipusHabitacio) session.get(PreuTipusHabitacio.class, 
                new PreuTipusHabitacioId(nomHotelH,nomTipusH));
        float expResult = (preu-descompte);
        float result = preuth.calculaPreu();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isOfType method, of class PreuTipusHabitacio.
     * Amb Hibernate
     */
    @Test
    public void testIsOfTypeH() {
        System.out.println("isOfType");
        
        PreuTipusHabitacio preuth = (PreuTipusHabitacio) session.get(PreuTipusHabitacio.class, 
                new PreuTipusHabitacioId(nomHotelH,nomTipusH));
        boolean expResult = true;
        boolean result = preuth.isOfType(nomTipusH);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomTipus method, of class PreuTipusHabitacio.
     * Amb Hibernate
     */
    @Test
    public void testGetNomTipusH() {
        System.out.println("getNomTipus");
        
        PreuTipusHabitacio preuth = (PreuTipusHabitacio) session.get(PreuTipusHabitacio.class, 
                new PreuTipusHabitacioId(nomHotelH,nomTipusH));
        String expResult = nomTipusH;
        String result = preuth.getNomTipus();
        assertEquals(expResult, result);
    }
}
