package aplicacion;

import presentacion.Donkey;

import java.util.ArrayList;

public class DonkeyA {

    private static int turno;
    private double posX,posY;
    private boolean estaMuerto;
    private static boolean lanzeBarril;
    private static ArrayList<Integer> yaLanzo;


    public DonkeyA(double posX, double posY){
        this.posX=posX;
        this.posY=posY;
        turno=0;
        estaMuerto=false;
        lanzeBarril=false;
        yaLanzo=new ArrayList<>();
    }

    public void modifiqueTurno(){
        if (turno<=93) {
            turno++;
            setLanzeBarril(false);
        } else{
            lanzeBarril(true);
            turno=0;
        }
    }

    public static boolean lanzeBarril(boolean lanze){
        lanzeBarril=lanze;
        return lanzeBarril;
    }

    public void setLanzeBarril(boolean lanzeBarril){
        this.lanzeBarril=lanzeBarril;
    }

    public static boolean getLanzeBarril(){
        return lanzeBarril;
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public static int getTurno(){
        return turno;
    }

}
