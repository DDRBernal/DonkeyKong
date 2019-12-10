package aplicacion;

import java.io.Serializable;

public class VigaA implements Serializable {

    private static final long serialVersionUID = 8799656478674716638L;
    protected double posX;
    protected double posY;



    public VigaA(double x, double y){
        posX=x;
        posY=y;
    }

    public void muevase(){
        setPosX(0.6);
    }

    public void setPosX(double x) {
        posX += x;
        posX = posX < 1 ? 1 : posX;
        posX = posX > 544 ? 544 : posX;
    }

    public void setPosY(double y) {
        posY = y;
    }

    public double getX() {
        return posX;
    }

    public double getY() {
        return posY;
    }

}
