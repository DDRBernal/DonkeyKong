package aplicacion;

public class BarrilA {

    private double posX;
    private double posY;
    private static int turno;



    public BarrilA(double x, double y){
        posX=x;
        posY=y;
    }


    public void muevase(){
        setPosX(3);
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
        posY = y;
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






}
