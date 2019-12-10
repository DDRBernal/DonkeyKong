package Pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import presentacion.DonkeyKongGUI;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DonkeyKongTest {
    aplicacion.DonkeyKong donkeyKongA;
    presentacion.DonkeyKong dk;

    public DonkeyKongTest(){
        dk = new presentacion.DonkeyKong(false);
        dk.noHacerVisible();
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
    public void noDeberiaSubirMario(){
        double posYinicial = donkeyKongA.getMario().getPosY();
        for (int i=0; i<79; i++){
            if (i<79) {
                donkeyKongA.moverMario(39);
            } else{
                donkeyKongA.moverMario(38);
            }
            donkeyKongA.moverTodo();
        }
        double posYFinal = donkeyKongA.getMario().getPosY();
        assertTrue(Math.abs(posYFinal-posYinicial)<1);
    }

    @Test
    public void deberiaSubirMario(){
        double posYinicial = donkeyKongA.getMario().getPosY();
        for (int i=0; i<250; i++){
            if (i<177) {
                donkeyKongA.moverMario(39);
            } else{
                donkeyKongA.moverMario(38);
            }
            donkeyKongA.moverTodo();
        }
        double posYFinal = donkeyKongA.getMario().getPosY();
        assertFalse(Math.abs(posYFinal-posYinicial)<1);
    }

    @Test
    public void deberiaMorirMario(){
        double posXinicial = donkeyKongA.getPosMarioX();
        for (int i=0; i<4000; i++){
            if (i<177) {
                donkeyKongA.moverMario(39);
            }
            donkeyKongA.moverTodo();
        }
        double posXFinal = donkeyKongA.getPosMarioX();
        assertTrue(posXFinal==posXinicial);

    }

    @Test
    public void noDeberiaMorirMario(){
        for (int i=0; i<600; i++){
            if (i<177){
                donkeyKongA.moverMario(39);
            }
            donkeyKongA.moverMario(38);
            donkeyKongA.moverTodo();
        }
        assertTrue(donkeyKongA.getMario().getVida()==3);
    }

    @Test
    public void NoDeberiaTenerVidas(){
        for (int i=0; i<4000; i++){
            donkeyKongA.moverTodo();
        }
        assertTrue(donkeyKongA.getMario().getVida()<=1);
    }

    @Test
    public void deberiaLlegarALaCima() {
        for (int i = 0; i < 600; i++) {
            if (i < 229) {
                donkeyKongA.moverMario(39);
            } else {
                donkeyKongA.moverMario(38);
            }
        }
        assertTrue(donkeyKongA.getPosMarioY()>=30);
    }

    @Test
    public void NoDeberiaCaerse(){
        double posXAlcanzada=0;
        for (int i=0; i<1000; i++){
            if (i<170) {
                donkeyKongA.moverMario(39);
            } else if(i<500) {
                donkeyKongA.moverMario(38);
            } else{
                donkeyKongA.moverMario(39);
            }
            posXAlcanzada=donkeyKongA.getPosMarioX();
        }
        double alcanceMaximo=415.0;
        assertTrue(posXAlcanzada==alcanceMaximo);
    }


}