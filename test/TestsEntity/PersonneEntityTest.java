/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.NoteUnLieuEntity;
import fr.m1.miage.sorbonne.entity.PersonneEntity;
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
public class PersonneEntityTest {

    public PersonneEntityTest() {
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

        PersonneEntity personne = new PersonneEntity();
        personne.setId(1L);
        NoteUnLieuEntity personne2 = new NoteUnLieuEntity();
        personne2.setId(2L);
        Boolean resu1 = personne.equals(personne);
        assertEquals(resu1, true);
        Boolean resu2 = personne.equals(personne2);
        assertEquals(resu2, false);

    }
    
     @Test
    public void toStringTest() {
        PersonneEntity personne = new PersonneEntity();
        personne.setId(1L);
        String attendu ="fr.sorbonne.m1.entity.PersonneEntity[ id=" + personne.getId() + " ]";
        String resul = personne.toString();
        assertEquals(resul, attendu);

    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
