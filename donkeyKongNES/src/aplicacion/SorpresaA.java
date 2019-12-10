package aplicacion;

import java.io.Serializable;

public abstract class SorpresaA implements Serializable {

    private static final long serialVersionUID = 8799656478674716638L;
    private double posX,posY;

    public SorpresaA(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getX() {
        return posX;
    }

    public double getY(){
        return posY;
    }
}
