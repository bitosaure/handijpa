/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.CritereEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliepisu
 */
public class CritereEntityTest {

    public CritereEntityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void equalsTest() {

        CritereEntity critere = new CritereEntity();
        critere.setCode("toto");
        CritereEntity critere2 = new CritereEntity();
        critere2.setCode("toto2");
        Boolean resu1 = critere.equals(critere);
        assertEquals(resu1, true);
        Boolean resu2 = critere.equals(critere2);
        assertEquals(resu2, false);

    }

    @Test
    public void toStringTest() {
        CritereEntity critere = new CritereEntity();
        critere.setCode("toto");
        String attendu = "fr.sorbonne.m1.entity.CritereEntity[ id=" + critere.getCode() + " ]";
        String resul = critere.toString();
        assertEquals(resul, attendu);

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
