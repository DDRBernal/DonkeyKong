package aplicacion;

public class BarrilRojoA extends BarrilA {

    public BarrilRojoA(double x, double y){
        super(x, y);
        puntos=30;
    }

    public void setPosX(double x){
        posX+=0;
        setPosY(1);
    }

}
