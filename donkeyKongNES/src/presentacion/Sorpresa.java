package presentacion;

import aplicacion.SorpresaA;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Sorpresa extends Objeto {

    protected ArrayList<BufferedImage> frames2 = new ArrayList<>();

    public Sorpresa(double x, double y){
        this.x=x;
        this.y=y;
//        x= sorpresaA.getX();
//        y= sorpresaA.getY();
    }

    public abstract void carga();

    /**
     * Dibujar las imagenes
     *
     * @param g    Graphics
     * @param i    numero
     * @param tamX tamano en x
     * @param tamY tamano en y
     */
    public void draw2(Graphics g, int i, int tamX, int tamY) {
        g.drawImage(frames2.get(i), (int) x, (int) y, tamX, tamY, null);
    }
}
