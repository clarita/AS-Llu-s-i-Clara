/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * En veritat, no hi ha res que testejar de la classe BonsHotels
 * @author clara
 */
public class BonsHotelsTest {
    
    private static Session session = null;
    
    
    //variables per Hibernate
    private static int id = 7;
    private static float quotaFixa = 0.5F;
    private static float quotaVariable = 0.7F;
    
    
    public BonsHotelsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
    
            BonsHotels bh = new BonsHotels(id,quotaFixa,quotaVariable);
            session.persist(bh);
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            BonsHotels bh = (BonsHotels)session.get(BonsHotels.class, id);
            session.delete(bh);
            
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
        BonsHotels bh = (BonsHotels)session.get(BonsHotels.class, id);
        float quotaFixaObtinguda = bh.getQuotaFixa();
        assertEquals(quotaFixaObtinguda, quotaFixa, 0.0);
    }

}
