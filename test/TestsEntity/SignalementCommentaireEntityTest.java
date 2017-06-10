/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
import fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity;
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
public class SignalementCommentaireEntityTest {
    
    public SignalementCommentaireEntityTest() {
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

        SignalementCommentaireEntity signalement = new SignalementCommentaireEntity();
        signalement.setId(1L);
        SignalementCommentaireEntity signalement2 = new SignalementCommentaireEntity();
        signalement2.setId(2L);
        Boolean resu1 = signalement.equals(signalement);
        assertEquals(resu1, true);
        Boolean resu2 = signalement.equals(signalement2);
        assertEquals(resu2, false);

    }
    
     @Test
    public void toStringTest() {
        SignalementCommentaireEntity signalement = new SignalementCommentaireEntity();
        signalement.setId(1L);
        String attendu ="fr.m1.miage.sorbonne.entity.SignalementCommentaireEntity[ id=" + signalement.getId() + " ]";
        String resul = signalement.toString();
        assertEquals(resul, attendu);

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
