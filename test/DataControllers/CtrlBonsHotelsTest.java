/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import Hibernate.HibernateUtil;
import org.hibernate.Session;
import DomainModel.BonsHotels;
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
public class CtrlBonsHotelsTest {
    
    private static Session session = null;
    private static float quotaFixa = 0.05F;
    //crearem un BonsHotels amb id != 1, que és la id de la instància bona, per 
    //si ja existeix a la base de dades no entrar en conflicte
    private static int bonsHotelsId = 5;
    
    public CtrlBonsHotelsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            //Insertem una instància via hibernate per mirar si es recupera bé
            BonsHotels bh = new BonsHotels();
            bh.setId(bonsHotelsId);
            bh.setQuotaFixa(quotaFixa);
            bh.setQuotaVariable(0.05F);
            session.persist(bh);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            BonsHotels bh = (BonsHotels) session.get(BonsHotels.class, bonsHotelsId);
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

    /**
     * Test of get method, of class CtrlBonsHotels.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        CtrlBonsHotels instance = new CtrlBonsHotels();
        
        //fem això per evitar accedir a la instància bona, amb id = 1
        instance.changeDefaultId(bonsHotelsId);
        
        BonsHotels result = instance.get();
        float resultQuotaFixa = result.getQuotaFixa();
        assertTrue("quota correcta", quotaFixa == resultQuotaFixa);
    }
}
