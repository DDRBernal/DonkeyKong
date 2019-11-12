package presentacion;

public class Jugador extends personaje {
    protected Imagenes i = new Imagenes();



    public Jugador(double x, double y){
        this.x=x;
        this.y=y;
        estaVivo=true;
        start();
    }


    protected void start(){
        frames.add(i.getImagen("MarioStand.png"));
    }

}
