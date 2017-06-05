/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testControleur;

import fr.m1.miage.sorbonne.controleur.AjouterDesAdministrateurControleur;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import java.util.ArrayList;
import java.util.List;
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
public class AjouterDesAdministrateurTest {
    
    public AjouterDesAdministrateurTest() {
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
        PersonneEntity pers= new PersonneEntity();
        List<PersonneEntity> list = new ArrayList<>();
        list.add(pers);
        AjouterDesAdministrateurControleur controleur = new AjouterDesAdministrateurControleur(list);
        String resu = controleur.initialiserPage();
        assertEquals("SUCCESS", resu);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
