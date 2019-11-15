package aplicacion;


import java.util.*;

public class MarioA {
    protected boolean estado;
    protected double posX,posY;
    protected int vida;
    protected boolean estaMuerto;
    protected int turno;
    protected int turno2;



    public MarioA(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
        this.vida = 10;
        this.estaMuerto = false;
        turno=0;
    }


    public int getVida() {
        return vida;
    }

    /**
     * Retorna si esta o no vivo
     *
     * @return si esta o no vivo
     */
    public boolean isVivo() {
        return !(this.estaMuerto);
    }

    public void setPosX(double x) {
        if (x!=-9999) {
            modifiqueTurno();
            posX += x;
            posX = posX < 1 ? 1 : posX;
            posX = posX > 544 ? 544 : posX;
        }else{
            turno=0;
        }
    }

    private void modifiqueTurno(){
        if (turno<3) {
            turno++;
        } else{
            turno=0;
        }
    }

    public void setPosY(double y) {
        this.posY += y;
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public int getTurno(){
        return turno;
    }

    /**
     * Revisa si es o no impactado por un barril
     *
     * @param  barril
     */
    public void impactado(BarrilA barril) {
        double xBala = barril.getX();
        double yBala = barril.getY();

        if (isLess(this.posX, xBala) && isLess(this.posY, yBala)) {
            update();
        }
    }

    private boolean isLess(double r1, double r2) {
        return (r1 <= r2 && r2 <= (r1 + 50));
    }


    /**
     * Actualizo la vida por el dano de una bala
     *
     * @return
     */
    public void update() {
        vida --;
        if (vida == 0) {
            estaMuerto = true;
        }
    }
}
