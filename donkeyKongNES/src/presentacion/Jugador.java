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
        if (!MarioA.isVivo()){
            start3();
        }
        else if (MarioA.getEstaSubiendo()){
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

    private void start3(){
        if (turno<=5) {
            frames.add(i.getImagen("marioMuerto0.png"));
        }else if (turno>5 && turno<=10) {
            frames.add(i.getImagen("marioMuerto1.png"));
        }else if (turno>15 && turno<=20) {
            frames.add(i.getImagen("marioMuerto2.png"));
        }else if (turno>25 && turno<=30) {
            frames.add(i.getImagen("marioMuerto3.png"));
        }else if (turno>35 && turno<=40) {
            frames.add(i.getImagen("marioMuerto0.png"));
        }else if (turno>40 && turno<=50) {
            frames.add(i.getImagen("marioMuerto1.png"));
        } else if (turno>50 && turno<=60) {
            frames.add(i.getImagen("marioMuerto2.png"));
        }else if (turno>60 && turno<=70) {
            frames.add(i.getImagen("marioMuerto3.png"));
        }else if (turno>70 && turno<=100) {
            frames.add(i.getImagen("marioMuerto4.png"));
        }
        else{
            frames.add(i.getImagen("marioMuerto4.png"));
        }
    }
}
