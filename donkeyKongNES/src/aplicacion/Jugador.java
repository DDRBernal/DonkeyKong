package aplicacion;

public class Jugador {

    protected int puntos;
    protected int vidas;

    public Jugador(){
        this.vidas=3;
        this.puntos=0;
    }

    /**
     * Anado puntuacion al jugador
     *
     * @param puntos puntos
     */
    public void addPuntuacion(int puntos) {
        this.puntos += puntos;
    }

    /**
     * Quito vidas al jugador
     */
    public void morir() {
        this.vidas--;
    }

    public int getVidas() {
        return this.vidas;
    }

    public int getPuntos() {
        return this.puntos;
    }
}
