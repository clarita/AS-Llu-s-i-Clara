/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import org.hibernate.Session;
import Hibernate.HibernateUtil;
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
public class ClientTest {
    
    static Session session = null;
    
    public ClientTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        Client c = new Client("5", "nom", "cognoms", "email");
        session.persist(c); 
    }

    @AfterClass
    public static void tearDownClass() throws Exception {        
        if (session != null) {
            Client c = (Client) session.get(Client.class, "5");
            session.delete(c);
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
        Client c = (Client) session.get(Client.class, "5");
        String prova  = c.getCognoms();
        assertEquals(prova, "cognoms");
    }
}
