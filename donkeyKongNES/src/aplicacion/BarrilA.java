package aplicacion;

import java.util.ArrayList;

public class BarrilA {

    private double posX;
    private double posY;
    private static int turno;
    private int sentido;
    private ArrayList<Integer> array;



    public BarrilA(double x, double y){
        posX=x;
        posY=y;
        sentido=3;
        array = new ArrayList<>();
    }


    public void muevase(int numero){
        setPosX(numero);
        modifiqueTurno();
    }

    private void modifiqueTurno(){
        if (turno<4) {
            turno++;
        } else{
            turno=0;
        }
    }

    public void setPosX(double x) {
        posX += x;
        posX = posX < 1 ? 1 : posX;
        posX = posX > 544 ? 544 : posX;
    }

    public void setPosY(double y) {
        posY += y;
    }

    public double getX() {
        return posX;
    }

    public double getY() {
        return posY;
    }

    public static int getTurno(){
        return turno;
    }

    public int getSentido(){
        return sentido;
    }

    public void setSentido(){
        if (array.size()==0)sentido=-sentido;
        array.add(1);
    }

    public void setArray(){
        array.clear();
    }






}
