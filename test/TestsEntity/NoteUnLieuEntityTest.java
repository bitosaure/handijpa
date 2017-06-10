/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.LieuEntity;
import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
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
public class NoteUnLieuEntityTest {
    
    public NoteUnLieuEntityTest() {
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
        
        NoteUnLieuEntity noteUnLieu = new NoteUnLieuEntity();
        noteUnLieu.setId(1L);
        NoteUnLieuEntity noteUnLieu2 = new NoteUnLieuEntity();
        noteUnLieu2.setId(2L);
        Boolean resu1 = noteUnLieu.equals(noteUnLieu);
        assertEquals(resu1, true);
        Boolean resu2 =noteUnLieu.equals(noteUnLieu2);
        assertEquals(resu2, false);
        
    }

     @Test
    public void toStringTest() {
        NoteUnLieuEntity noteUnLieu = new NoteUnLieuEntity();
        noteUnLieu.setId(1L);
        String attendu ="fr.sorbonne.m1.entity.NoteUnLieuEntity[ id=" + noteUnLieu.getId() + " ]";
        String resul = noteUnLieu.toString();
        assertEquals(resul, attendu);

    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
