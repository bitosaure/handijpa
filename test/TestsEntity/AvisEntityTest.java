/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.AvisEntity;
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
public class AvisEntityTest {
    
    public AvisEntityTest() {
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
    
    public void equalsTest(){
        
        AvisEntity avis = new AvisEntity();
        avis.setId(1L);
        AvisEntity avis2 = new AvisEntity();
        avis.setId(2L);
        Boolean resu1 = avis.equals(avis);
        assertEquals(resu1, true);
        Boolean resu2 =avis.equals(avis2);
        assertEquals(resu2, false);
        
    }
    
    @Test
    public void toStringTest(){
        AvisEntity avis = new AvisEntity();
        avis.setId(1L);
        String attendu ="fr.sorbonne.m1.entity.AvisEntity[ id=" + avis.getId() + " ]";
        String resul=avis.toString();
        assertEquals(resul, attendu);
        
    }

    //  add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
