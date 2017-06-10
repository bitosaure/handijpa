/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.CategorieEntity;
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
public class CategorieEntityTest {
    
    public CategorieEntityTest() {
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
    public void equalsTest(){
        
        CategorieEntity categorie = new CategorieEntity();
        categorie.setCode("toto");
        CategorieEntity categorie2 = new CategorieEntity();
        categorie.setCode("toto2");
        Boolean resu1 = categorie.equals(categorie);
        assertEquals(resu1, true);
        Boolean resu2 =categorie.equals(categorie2);
        assertEquals(resu2, false);
        
    }
  
    @Test
    public void toStringTest(){
        CategorieEntity categorie = new CategorieEntity();
        categorie.setLibelle("Musée");
        String attendu ="Musée";
        String resul=categorie.toString();
        assertEquals(resul, attendu);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
