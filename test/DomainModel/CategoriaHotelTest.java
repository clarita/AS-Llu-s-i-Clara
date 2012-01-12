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
 * @author elena_gratallops
 */
public class CategoriaHotelTest {
   static Session session = null;
    
    public CategoriaHotelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            CategoriaHotel cat = new CategoriaHotel("tres estrelles");
            session.persist(cat);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {        
        if (session != null) {
            CategoriaHotel cat = (CategoriaHotel) session.get(CategoriaHotel.class, "tres estrelles");
            session.delete(cat);
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
        CategoriaHotel cat = (CategoriaHotel) session.get(CategoriaHotel.class, "tres estrelles");
        String prova  = cat.getNom();
        assertEquals(prova, "tres estrelles");
    }  
}


