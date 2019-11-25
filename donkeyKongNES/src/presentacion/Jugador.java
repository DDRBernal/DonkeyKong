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


    private void start() {
        if (MarioA.getEstaSubiendo()){
            if (turno%2==0) {
                frames.add(i.getImagen("marioSubiendo1.png"));
            } else{
                frames.add(i.getImagen("marioSubiendo2.png"));
            }
        }
        else if (MarioA.getSalto()!=-1){
            if (MarioA.getSentido()=='d')
                frames.add(i.getImagen("marioJump.png"));
            else{
                frames.add(i.getImagen("imarioJump.png"));
            }
        } else if (turno==0){
            if (MarioA.getSentido()=='d')
                frames.add(i.getImagen("MarioStand.png"));
            else{
                frames.add(i.getImagen("iMarioStand.png"));
            }
        } else if (turno==1){
            if (MarioA.getSentido()=='d')
                frames.add(i.getImagen("marioMove1.png"));
            else{
                frames.add(i.getImagen("imarioMove1.png"));
            }
        }start2();

    }

    private void start2(){
        if (turno==2){
            if (MarioA.getSentido()=='d')
                frames.add(i.getImagen("marioMove2.png"));
            else{
                frames.add(i.getImagen("imarioMove2.png"));
            }
        } else if (turno==3){
            if (MarioA.getSentido()=='d')
                frames.add(i.getImagen("marioMove3.png"));
            else{
                frames.add(i.getImagen("imarioMove3.png"));
            }
        } else if (turno==4){
            if (MarioA.getSentido()=='d')
                frames.add(i.getImagen("marioMove2.png"));
            else{
                frames.add(i.getImagen("imarioMove2.png"));
            }
        }
    }
}
