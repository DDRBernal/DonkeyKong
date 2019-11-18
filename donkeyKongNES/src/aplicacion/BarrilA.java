package aplicacion;

public class BarrilA {

    protected double posX;
    protected double posY;



    public BarrilA(double x, double y){
        posX=x;
        posY=y;
    }


    public void muevase(){
        setPosX(3);
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
