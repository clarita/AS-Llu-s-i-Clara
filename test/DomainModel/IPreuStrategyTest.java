package DomainModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de prova de la interfície
 * @author clara
 */
public class IPreuStrategyTest {
    
    public IPreuStrategyTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of calculaPreu method, of class IPreuStrategy.
     */
    @Test
    public void testCalculaPreu() {
        System.out.println("calculaPreu");
        PreuTipusHabitacio p = null;
        IPreuStrategy instance = new IPreuStrategyImpl();
        float expResult = 0.0F;
        float result = instance.calculaPreu(p);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Classe de prova que implementa la interficie
     */
    public class IPreuStrategyImpl implements IPreuStrategy {

        public PreuTipusHabitacioId getId() {
            return null;
        }

        public void setId(PreuTipusHabitacioId id) {
        }

        public float calculaPreu(PreuTipusHabitacio p) {
            return 0.0F;
        }
    }
}
