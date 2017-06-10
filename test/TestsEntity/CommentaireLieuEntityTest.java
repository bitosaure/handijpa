/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.CommentaireLieuEntity;
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
public class CommentaireLieuEntityTest {
    
    public CommentaireLieuEntityTest() {
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
        
        CommentaireLieuEntity commentaire = new CommentaireLieuEntity();
       commentaire.setId(1L);
        CommentaireLieuEntity commentaire2 = new CommentaireLieuEntity();
        commentaire2.setId(2L);
        Boolean resu1 = commentaire.equals(commentaire);
        assertEquals(resu1, true);
        Boolean resu2 =commentaire.equals(commentaire2);
        assertEquals(resu2, false);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
