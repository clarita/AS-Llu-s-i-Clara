/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import java.util.ArrayList;
import DomainModel.Poblacio;
import Hibernate.HibernateUtil;
import org.hibernate.classic.Session;
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
public class CtrlPoblacioTest {
    private static Session session;
    
    public CtrlPoblacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Poblacio p1 = new Poblacio("Gratallops");
            session.persist(p1);
            Poblacio p2 = new Poblacio("Falset");
            session.persist(p2);
        }catch(RuntimeException e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        
    
    
    
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Poblacio poblacio =  (Poblacio) session.get(Poblacio.class, "Gratallops");
            session.delete(poblacio);
            Poblacio po = (Poblacio) session.get(Poblacio.class, "Falset");
            session.delete(po);
            session.getTransaction().commit();
        }
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        String nom = "Gratallops";
        CtrlPoblacio instance = new CtrlPoblacio();
        Poblacio result = instance.get(nom);
        String nomPoblacio = result.getNom();
        assertEquals(nom, nomPoblacio);
    
    }
    
    
    @Test
    public void testTots() {
        System.out.println("tots");
        CtrlPoblacio instance = new CtrlPoblacio();
        ArrayList<Poblacio> poblacions = new ArrayList<Poblacio>();
        Poblacio p1 = new Poblacio("Gratallops");
        Poblacio p2 = new Poblacio("Falset");
        poblacions.add(p2);
        poblacions.add(p1);
        ArrayList<Poblacio> pobl = instance.tots();
        assertEquals(poblacions, pobl);
    }
    
    
    
    
}
