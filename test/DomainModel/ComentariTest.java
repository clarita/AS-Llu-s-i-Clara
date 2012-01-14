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
 * @author clara
 * @author elena_gratallops
 */
public class ComentariTest {
    
    static Session session = null;
    static String nomH = "Hotel prova";
    static String nomPoblacio = "poblacio prova";
    static String dniC = "39476969S";
    static String descripcio = "comentari de prova";
    static Date d = new Date();
  
    public ComentariTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception { 
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Poblacio poblacio = new Poblacio(nomPoblacio);
            session.persist(poblacio);
            Hotel hotel = new Hotel(nomH,"descripcio",nomPoblacio,null);
            session.persist(hotel);
            Client client = new Client(dniC,"nom prova","cognom","email");
            session.persist(client);
            Comentari com = new Comentari(new ComentariId(nomH, dniC,d), 7, descripcio);
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
            Client client = (Client) session.get(Client.class, dniC);
            session.delete(client);
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
        Comentari comentari = (Comentari) session.get(Comentari.class, new ComentariId(nomH,dniC,d));
        String prova  = comentari.getDescripcio();
        assertEquals(prova,descripcio);
    }

  
}

  
