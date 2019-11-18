package aplicacion;


import presentacion.Escalera;

import java.util.*;

public class MarioA {
    private boolean estado;
    private double posX,posY;
    private int vida;
    private boolean estaMuerto;
    private int turno;
    private boolean estaSubiendo;
    private static int salto;
    private boolean noEstaSaltando;



    public MarioA(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
        this.vida = 10;
        this.estaMuerto = false;
        turno=0;
        salto=-1;
        noEstaSaltando=true;
    }

    public static int getSalto() {
        return salto;
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

    public void mueva(String sentido){
        if (sentido=="derecha"){
            setPosX(0.6);
        } else{
            setPosX(-0.6);
        }
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

    public void saltar() {
        if (salto==30){
            salto=-1;
            noEstaSaltando=true;
        } if (salto!=-1) {
            if (salto < 15) {
                setPosY(-1.1);
            } else {
                setPosY(1.1);
            }
            salto++;
        }
    }

    public void modifiqueSalto() {
        salto=0;
        noEstaSaltando=false;
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
        double xBarril = barril.getX();
        double yBarril = barril.getY();

        if (isLess(this.posX, xBarril) && isLess(this.posY, yBarril)) {
            update();
        }
    }

    public boolean impactado(EscaleraA escaleraA) {
        double xEscalera = escaleraA.getX();
        double yEscalera = escaleraA.getY();

        return isLess(this.posX, xEscalera) && isLess(this.posY, yEscalera);
    }

    private boolean isLess(double r1, double r2) {
        return (r1 <= r2 && r2 <= (r1 + 20));
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


    public boolean getnoEstaSaltando() {
        return noEstaSaltando;
    }
}
