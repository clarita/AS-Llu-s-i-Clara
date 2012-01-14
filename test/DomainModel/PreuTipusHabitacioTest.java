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
 * Classe per provar PreuTipusHabitacio
 * @author clara
 */
public class PreuTipusHabitacioTest {
    
    private static Session session = null;
        
    //dades amb Hibernate
    private static String nomTipus = "tipus de prova";
    private static String nomHotel = "Hotel de prova";
    private static String nomCategoria = "categoria de prova";
    private static String nomPoblacio = "poblacio de prova";
    private static float preu = 100;
    private static float descompte = 50;

    
    public PreuTipusHabitacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            CategoriaHotel c = new CategoriaHotel(nomCategoria);
            Poblacio p = new Poblacio(nomPoblacio);
            session.saveOrUpdate(p);
            Hotel h = new Hotel(nomHotel,"Hotel de luxe en el centre de Manhattan",nomPoblacio,c);
            session.saveOrUpdate(h);
            TipusHabitacio t = new TipusHabitacio(nomTipus,1,"desc");
            PreuTipusHabitacio preuth = new PreuTipusHabitacio();
            PreuTipusHabitacioId id = new PreuTipusHabitacioId(nomHotel,nomTipus);
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
    
    @Test
    public void hibernateFetch() {
        System.out.println("hibernateFetch");
        
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class,
                new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        String nomTipusObtingut = pth.getNomTipus();
        assertEquals(nomTipusObtingut, nomTipus);
    }
    
    @Test
    public void hibernateAssociationToTipus() {
        System.out.println("hibernateAssociationToTipus");
        
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class,
                new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        TipusHabitacio th = pth.getTipus();
        assertTrue(th != null);
    }
    
    @Test
    public void hibernateAssociationToStrategy() {
        System.out.println("hibernateAssociationToStrategy");
        
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class,
                new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        IPreuStrategy th = pth.getStrategy();
        assertTrue(th != null);
    }

    /**
     * Test of calculaPreu method, of class PreuTipusHabitacio.
     */
    @Test
    public void testCalculaPreu() {
        System.out.println("calculaPreu");
        
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class,
                new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        float expResult = (preu-descompte);
        float result = pth.calculaPreu();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isOfType method, of class PreuTipusHabitacio.
     */
    @Test
    public void testIsOfType() {
        System.out.println("isOfType");
        
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class,
                new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        boolean expResult = true;
        boolean result = pth.isOfType(nomTipus);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomTipus method, of class PreuTipusHabitacio.
     */
    @Test
    public void testGetNomTipus() {
        System.out.println("getNomTipus");
        
        PreuTipusHabitacio pth = (PreuTipusHabitacio)session.get(
                PreuTipusHabitacio.class,
                new PreuTipusHabitacioId(nomHotel,nomTipus));
        
        String expResult = nomTipus;
        String result = pth.getNomTipus();
        assertEquals(expResult, result);
    }
    
    
}
