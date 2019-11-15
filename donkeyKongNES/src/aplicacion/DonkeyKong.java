package aplicacion;
import java.util.*;

public class DonkeyKong {

    private ArrayList<BarrilA> barriles;
    private MarioA mario;
    private ArrayList<Jugador> jugadores;


    public DonkeyKong(int numJugadores){
        barriles = new ArrayList<>();
        jugadores = new ArrayList<>();
        mario = new MarioA(100,570);
        prepareElementos(numJugadores);
    }

    public void prepareElementos(int numJugadores) {
        for (int i=0; i<10; i++){
            barriles.add(new BarrilA());
        }
    }

    public void moverMario(Integer key){
        if (key==39){
            mario.setPosX(0.6);
        } else if (key==37){
            mario.setPosX(-0.6);
        } else{
            mario.setPosX(-9999);
        }
    }

    public double getPosMarioX(){
        return mario.getPosX();
    }

    public double getPosMarioY(){
        return mario.getPosY();
    }

    public int getTurnoMario(){
        return mario.getTurno();
    }


}
