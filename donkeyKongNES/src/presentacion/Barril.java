package presentacion;

import aplicacion.BarrilA;

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
        if (BarrilA.getTurno()==0) {
            frames2.add(i.getImagen("barrilMove1.png"));
        } else if (BarrilA.getTurno()==1){
            frames2.add(i.getImagen("barrilMove2.png"));
        } else if (BarrilA.getTurno()==2){
            frames2.add(i.getImagen("barrilMove3.png"));
        } else if (BarrilA.getTurno()==3){
            frames2.add(i.getImagen("barrilMove4.png"));
        } else if (BarrilA.getTurno()==4){
            frames2.add(i.getImagen("barrilMove3.png"));
        }
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
