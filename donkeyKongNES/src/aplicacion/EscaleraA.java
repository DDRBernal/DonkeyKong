package aplicacion;

public class EscaleraA {

    private double posX;
    private double posY;



    public EscaleraA(double x, double y){
        posX=x;
        posY=y;
    }

    public void setPosX(double x) {
        posX += x;
        posX = posX < 1 ? 1 : posX;
        posX = posX > 544 ? 544 : posX;
    }

    public void setPosY(double y) {
        posY += y;
        posY = posY < 1 ? 1 : posY;
        posY = posY > 700 ? 700 : posY;
    }

    public double getX() {
        return posX;
    }

    public double getY() {
        return posY;
    }
}
