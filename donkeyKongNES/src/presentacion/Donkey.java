package presentacion;

import aplicacion.DonkeyA;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Donkey extends Objeto {

    private ArrayList<BufferedImage> frames2 = new ArrayList<>();
    private int turno;

    public Donkey(double x, double y, int turno){
        this.x=x;
        this.y=y;
        this.turno=turno;
        carga();
    }

    public void carga(){
        if (turno==0) {
            frames2.add(i.getImagen("donkeyKong.png"));
        } else if (turno==1){
            frames2.add(i.getImagen("donkeyKong1.png"));
        } else if (turno==2){
            frames2.add(i.getImagen("donkeyKong2.png"));
        } else if (turno==3){
            frames2.add(i.getImagen("donkeyKong3.png"));
        } else if (turno==4){
            frames2.add(i.getImagen("donkeyKong4.png"));
        } else if (turno==5){
            frames2.add(i.getImagen("donkeyKong4.png"));
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
