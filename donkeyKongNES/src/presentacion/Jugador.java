package presentacion;

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
        if (turno==0){
            frames.add(i.getImagen("MarioStand.png"));
        } else if (turno%2!=0){
            frames.add(i.getImagen("marioMove1.png"));
        } else if (turno%2==0){
            frames.add(i.getImagen("marioMove2.png"));
        }
    }

}
