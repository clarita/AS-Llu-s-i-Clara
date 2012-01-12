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
 * @author clara
 */
public class CtrlPoblacioTest {
    private static Session session;
    private static String nomPoblacio1 = "prova1";
    private static String nomPoblacio2 = "prova2";
    
    public CtrlPoblacioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Poblacio p1 = new Poblacio(nomPoblacio1);
            session.saveOrUpdate(p1);
            Poblacio p2 = new Poblacio(nomPoblacio2);
            session.saveOrUpdate(p2);
        }catch(RuntimeException e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Poblacio poblacio1 =  (Poblacio) session.get(Poblacio.class, nomPoblacio1);
            session.delete(poblacio1);
            Poblacio poblacio2 = (Poblacio) session.get(Poblacio.class, nomPoblacio2);
            session.delete(poblacio2);
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
    public void testGet() throws Exception {
        System.out.println("get");
        CtrlPoblacio instance = new CtrlPoblacio();
        Poblacio result = instance.get(nomPoblacio1);
        String nomPoblacio = result.getNom();
        assertEquals(nomPoblacio1, nomPoblacio);
    
    }
    
    
    @Test
    public void testTots() {
        System.out.println("tots");
        CtrlPoblacio instance = new CtrlPoblacio();
        ArrayList<Poblacio> poblacions = instance.tots();
        ArrayList<String> noms = new ArrayList<String>();
        for(Poblacio p : poblacions) noms.add(p.getNom());
        assertTrue(noms.contains(nomPoblacio1));
    }
}
