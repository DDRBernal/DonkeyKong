package aplicacion;

import java.io.Serializable;

public class Jugador implements Serializable {

    private static final long serialVersionUID = 8799656478674716638L;
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
