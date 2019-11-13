package aplicacion;
import java.util.*;

public class DonkeyKong {

    private ArrayList<BarrilA> barriles;
    private MarioA mario;
    private ArrayList<Jugador> jugadores;


    public DonkeyKong(int numJugadores){
        barriles = new ArrayList<>();
        jugadores = new ArrayList<>();
        mario = new MarioA(200,100);
        prepareElementos(numJugadores);
    }

    public void prepareElementos(int numJugadores) {
        for (int i=0; i<10; i++){
            barriles.add(new BarrilA());
        }
    }

    public double getPosMarioX(){
        return 0;
    }

    public double getPosMarioY(){
        return 0;
    }


}
