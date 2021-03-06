package presentacion;

import aplicacion.EscaleraA;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Escalera extends Objeto {

    private ArrayList<BufferedImage> frames2 = new ArrayList<>();

    public Escalera(EscaleraA e){
        x=e.getX();
        y=e.getY();
        carga();
    }

    public void carga(){
        frames2.add(i.getImagen("escalera.jpg"));
    }

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
