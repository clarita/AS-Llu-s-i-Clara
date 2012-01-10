/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.ArrayList;
import TupleTypes.DadesHotel;
import java.util.Set;
import java.util.Date;
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
public class PoblacioTest {
    private static Session session;
 
    public PoblacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception { 
        //ComentariId id = new ComentariId(nomH, dniC,d);
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Poblacio pob = new Poblacio("Gratallops");
            
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }  

    }

    @AfterClass
    public static void tearDownClass() throws Exception {        
        if (session != null) {
            Poblacio p = (Poblacio) session.get(Poblacio.class, "Gratallops");
            session.delete(p);
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
        Poblacio poblacio = (Poblacio) session.get(Poblacio.class, "Gratallops");
        String nom = poblacio.getNom();
        assertEquals(nom, "Gratallops");
    }
    
    
    
    @Test
    public void testgetDisponibles() throws Exception {
        System.out.println("getDisponibles");
        Integer numOc = null;
        Date dIni = null;
        Date dFi = null;
        Poblacio pob = new Poblacio();
        Set<DadesHotel> result = pob.getDisponibles(dIni, dFi, numOc);
        ArrayList<DadesHotel> r = null;
        Object[] res = result.toArray();
        assertEquals(r, res);
    }
}