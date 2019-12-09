package aplicacion;

public class BarrilAzulA extends BarrilA {

    public BarrilAzulA(int x, int y){
        super(x,y);
        puntos=20;
    }

    public void setPosX(double x) {
        posX += x;
        posX = posX < 1 ? 1 : posX;
        posX = posX > 544 ? 544 : posX;
    }

    public boolean impacto(EscaleraA escaleraA){
        double xEscalera = escaleraA.getX();
        double yEscalera = escaleraA.getY();
        return (posX>=xEscalera-8 && posX<=xEscalera+8) && (posY> yEscalera-5 && posY<=yEscalera+15);
    }
}
