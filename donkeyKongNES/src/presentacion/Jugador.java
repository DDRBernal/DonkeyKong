package presentacion;

import aplicacion.MarioA;

public class Jugador extends personaje {
    protected Imagenes i = new Imagenes();
    protected int turno;


    public Jugador(double x, double y, int turno){
        this.turno=turno;
        this.x=x;
        this.y=y;
        estaVivo=true;
        start();
    }


    protected void start() {

        if (MarioA.getSalto()!=-1){
            frames.add(i.getImagen("marioJump.png"));
        } else if (turno==0){
            frames.add(i.getImagen("MarioStand.png"));
        } else if (turno==1){
            frames.add(i.getImagen("marioMove1.png"));
        } else if (turno==2){
            frames.add(i.getImagen("marioMove2.png"));
        } else if (turno==3){
            frames.add(i.getImagen("marioMove3.png"));
        } else if (turno==4){
            frames.add(i.getImagen("marioMove3.png"));
        }
    }

}
