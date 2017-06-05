/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testControleur;

import fr.m1.miage.sorbonne.controleur.AjouterLieuControleur;
import fr.m1.miage.sorbonne.controleur.AuthentificationControleur;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author emiliepisu
 */

public class AuthentificationControleurTest {
    
    public AuthentificationControleurTest() {
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
    public void initialiserPageTest(){
        AuthentificationControleur controleur = new AuthentificationControleur();
        String resu=controleur.initialiserPage();
        assertEquals(resu, "SUCCESS");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
