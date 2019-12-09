package aplicacion;

import java.util.Random;

public class DonkeyA {

    private static int turno;
    private double posX,posY;
    private boolean estaMuerto;
    private static boolean lanzeBarril;
    private static boolean lanzarBarrilRojo;


    public DonkeyA(double posX, double posY){
        this.posX=posX;
        this.posY=posY;
        turno=0;
        estaMuerto=false;
        lanzeBarril=false;
        lanzarBarrilRojo=false;
    }

    public void modifiqueTurno(){
        Random rand = new Random();
        int n = rand.nextInt(2);
        lanzarBarrilRojo= (n == 0);
        if (turno<93) {
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

    public static boolean getLanzarBarrilRojo(){
        return lanzarBarrilRojo;
    }

}
