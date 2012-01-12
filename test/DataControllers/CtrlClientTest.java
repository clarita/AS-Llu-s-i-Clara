/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataControllers;

import Hibernate.HibernateUtil;
import org.hibernate.Session;
import DomainModel.Client;
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
public class CtrlClientTest {
    
    private static Session session = null;
    private static String dni = "dni prova";

    public CtrlClientTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            //Insertem instàncies via hibernate per mirar si es recuperen bé
            Client client = new Client(dni,"nom prova","cognom prova","email prova");
            session.saveOrUpdate(client);
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (session != null) {
            Client poblacio = (Client) session.get(Client.class, dni);
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

    /**
     * Test of get method, of class CtrlClient.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        CtrlClient instance = new CtrlClient();
        Client result = instance.get(dni);
        String dniClient = result.getDni();
        assertEquals(dni, dniClient);
    }
}
