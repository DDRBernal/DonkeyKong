package presentacion;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

public class Barril extends Objeto{
    private ArrayList<BufferedImage> frames2 = new ArrayList<>();

    public Barril(double x, double y){
        this.x=x;
        this.y=y;
        carga();
    }

    public void carga(){
        frames2.add(i.getImagen("barril.png"));
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
