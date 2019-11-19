package aplicacion;

import presentacion.Donkey;

public class DonkeyA {

    private static int turno;
    private double posX,posY;
    private boolean estaMuerto;


    public DonkeyA(double posX, double posY){
        this.posX=posX;
        this.posY=posY;
        turno=0;
        estaMuerto=false;
    }

    public void modifiqueTurno(){
        if (turno<4) {
            turno++;
        } else{
            turno=0;
        }
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
