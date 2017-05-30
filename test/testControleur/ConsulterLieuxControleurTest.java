/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testControleur;

import fr.m1.miage.sorbonne.controleur.ConsulterLieuxControleur;
import fr.m1.miage.sorbonne.entity.CritereEntity;
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
public class ConsulterLieuxControleurTest {
    
    public ConsulterLieuxControleurTest() {
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
    public void noterSur5LesCritereTest(){
       
        List<CritereEntity>listC=new ArrayList<>();
        CritereEntity cri = new CritereEntity();
        cri.setNbEtoiles(15.0);
        cri.setNbPersonnes(3);
        
        listC.add(cri);
         ConsulterLieuxControleur consu=new ConsulterLieuxControleur(listC);
         List<CritereEntity>listCresu= consu.noterSur5LesCritere();
         listC.get(0).setNbEtoiles(5.0);
         System.out.println("taille " + listC.size() +" taille "+listCresu.size());
         assertEquals(listC.size(), listCresu.size());
         
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
