package presentacion;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.*;


public class Objeto {

    protected Imagenes i = new Imagenes();
    protected ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
    protected  double x,y;

    public Objeto(){
        x=0;
        y=0;
    }


    /**
     * Metodo para dibujar a partir de un ArrayList de frames
     *
     * @param g    Graphics
     * @param i		numero
     * @param tamX tamano en x
     * @param tamY tamano en y
     */
    public void draw(Graphics g, int i, int tamX, int tamY) {
        g.drawImage(frames.get(i), (int) x, (int) y, tamX, tamY, null);
    }
}
