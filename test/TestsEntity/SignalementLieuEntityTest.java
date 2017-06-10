/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.SignalementLieuEntity;
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
public class SignalementLieuEntityTest {
    
    public SignalementLieuEntityTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
     @Test
    public void equalsTest() {

        SignalementLieuEntity signalement = new SignalementLieuEntity();
        signalement.setId(1L);
        SignalementLieuEntity signalement2 = new SignalementLieuEntity();
        signalement2.setId(2L);
        Boolean resu1 = signalement.equals(signalement);
        assertEquals(resu1, true);
        Boolean resu2 = signalement.equals(signalement2);
        assertEquals(resu2, false);

    }
    
    @Test
    public void toStringTest() {
        SignalementLieuEntity signalement = new SignalementLieuEntity();
        signalement.setId(1L);
        String attendu ="fr.m1.miage.sorbonne.entity.SignalementLieuEntity[ id=" + signalement.getId() + " ]";
        String resul = signalement.toString();
        assertEquals(resul, attendu);

    }
}
