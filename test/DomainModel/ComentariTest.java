/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import org.hibernate.Session;
import java.util.Date;
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
public class ComentariTest {
    
    static Session session = null;
    static String nomH = "Hotel prova";
    static String dniC = "39476969S";
    static Date d = new Date();
  
    
    public ComentariTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception { 
        //ComentariId id = new ComentariId(nomH, dniC,d);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //CategoriaHotel c = new CategoriaHotel("tres estrelles");
            //Hotel h = new Hotel("Hotel Prova",nomH,"ciutat de prova",c);
            ComentariId id = new ComentariId(nomH, dniC,d);
            //session.saveOrUpdate(id);
            //session.persist(id);
            Comentari com = new Comentari(7, "comentari de prova", d,id);
            session.persist(com);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }

        
        
        

    }

    @AfterClass
    public static void tearDownClass() throws Exception {        
        if (session != null) {
            Comentari com =(Comentari) session.get(Comentari.class,new ComentariId(nomH,dniC,d));
            session.delete(com);
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
        Comentari comentari = (Comentari) session.get(CategoriaHotel.class, new ComentariId(nomH,dniC,d));
        String prova  = comentari.getDescripcio();
        assertEquals(prova,"comentari de prova");
    }

  
}

  
