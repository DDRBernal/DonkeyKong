package presentacion;

import java.awt.*;

public class Corazon extends Sorpresa {

    public Corazon(double x, double y){
        super(x,y);
        carga();
    }
    public void carga(){
        frames2.add(i.getImagen("corazonSorpresa.png"));
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
