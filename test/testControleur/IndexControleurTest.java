/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testControleur;

import fr.m1.miage.sorbonne.controleur.IndexControleur;
import fr.m1.miage.sorbonne.entity.LieuEntity;
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
public class IndexControleurTest {

    public IndexControleurTest() {
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
    public void initialiserPageTest() {
        List<LieuEntity> list = new ArrayList<LieuEntity>();
        LieuEntity lieu = new LieuEntity();
        list.add(lieu);
        IndexControleur controleur = new IndexControleur(list);

        String resu = controleur.initialiserPage();
       

        assertEquals(resu, "SUCCESS");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
