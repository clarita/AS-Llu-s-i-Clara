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
 * @author clara
 */
public class CategoriaHotelTest {
   
    private static Session session = null;
    private static String nomCategoria = "categoria prova";
    
    public CategoriaHotelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            CategoriaHotel cat = new CategoriaHotel(nomCategoria);
            session.persist(cat);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {        
        if (session != null) {
            CategoriaHotel cat = (CategoriaHotel) session.get(CategoriaHotel.class, nomCategoria);
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
        System.out.println("testHibernateFetch");
        CategoriaHotel cat = (CategoriaHotel) session.get(CategoriaHotel.class, nomCategoria);
        String prova  = cat.getNom();
        assertEquals(prova, nomCategoria);
    }  
}


