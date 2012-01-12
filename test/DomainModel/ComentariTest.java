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
    static String nomPoblacio = "poblacio prova";
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
            Poblacio poblacio = new Poblacio(nomPoblacio);
            session.saveOrUpdate(poblacio);
            Hotel hotel = new Hotel(nomH,"descripcio","ciutat de prova",null);
            session.saveOrUpdate(hotel);
            Client client = new Client(dniC,"nom prova","cognom","email");
            session.saveOrUpdate(client);
            ComentariId id = new ComentariId(nomH, dniC,d);
            Comentari com = new Comentari(id, 7, "comentari de prova");
            session.saveOrUpdate(com);
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
            Hotel hotel = (Hotel) session.get(Hotel.class, nomH);
            session.delete(hotel);
            Poblacio poblacio = (Poblacio)session.get(Poblacio.class, nomPoblacio);
            session.delete(poblacio);
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

  
