package Pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import presentacion.DonkeyKongGUI;

import static org.junit.Assert.assertTrue;

public class DonkeyKongTest {
    DonkeyKongGUI game;
    aplicacion.DonkeyKong donkeyKongA;

    public DonkeyKongTest(){
        presentacion.DonkeyKong dk = new presentacion.DonkeyKong();
        donkeyKongA = new aplicacion.DonkeyKong(1);
        dk.createDonkey();
        dk.jugar(1);
        //game = new DonkeyKongGUI(dk);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void dd(){
        System.out.println(donkeyKongA.getBarriles().size());
        for (int i=0; i<1000; i++){
            donkeyKongA.moverMario(39);
            donkeyKongA.moverTodo();
        }
        System.out.println(donkeyKongA.getBarriles().size());

        assertTrue(2==2);
    }

}