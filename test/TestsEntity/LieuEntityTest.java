/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestsEntity;

import fr.m1.miage.sorbonne.entity.LieuEntity;
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
public class LieuEntityTest {

    public LieuEntityTest() {
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

        LieuEntity lieu = new LieuEntity();
        lieu.setId(1L);
        LieuEntity lieu2 = new LieuEntity();
        lieu2.setId(2L);
        Boolean resu1 = lieu.equals(lieu);
        assertEquals(resu1, true);
        Boolean resu2 = lieu.equals(lieu2);
        assertEquals(resu2, false);

    }

    @Test
    public void adressTest() {
        LieuEntity lieu = new LieuEntity();
        lieu.setNumRue(15);
        lieu.setRue("rue des vignes");
        lieu.setCodePostal(91160);
        lieu.setVille("longjumeau");
        lieu.setPays("France");
        String attendu = lieu.getNumRue() + " " + lieu.getRue() + " " + lieu.getCodePostal() + " " + lieu.getVille() + " " + lieu.getPays();
        String resul = lieu.adresse();

        assertEquals(resul, attendu);

    }

    @Test
    public void toStringTest() {
        LieuEntity lieu = new LieuEntity();
        lieu.setId(1L);
        String attendu = "fr.sorbonne.m1.entity.LieuEntity[ id=" + lieu.getId() + " ]";
        String resul = lieu.toString();
        assertEquals(resul, attendu);

    }

    @Test
    public void cheminImageTest() {
        LieuEntity lieu = new LieuEntity();
        lieu.setImage("louvre.jpg");
        String attendu="../../images/louvre.jpg";
        String resu= lieu.cheminImage();
        assertEquals(attendu, resu);
                
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
