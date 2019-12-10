package aplicacion;


import presentacion.Escalera;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.util.*;

public class MarioA {
    private boolean estado;
    private double posX,posY;
    private int vida;
    private static boolean estaMuerto;
    private int turno,turnoMuerto;
    private static boolean estaSubiendo;
    private static int salto;
    private boolean noEstaSaltando;
    private static char sentido;



    public MarioA(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
        this.vida = 3;
        this.estaMuerto = false;
        turno=0;
        turnoMuerto=0;
        salto=-1;
        noEstaSaltando=true;
        sentido='d';
        estaSubiendo=false;
    }


    /**
     * Retorna si esta o no vivo
     *
     * @return si esta o no vivo
     */
    public static boolean isVivo() {
        return !(estaMuerto);
    }

    public void mueva(String sentido){
        if (sentido.equals("N")){
            modifiqueTurno2();
        }
        else if (sentido.equals("arriba")){
            setPosY(-1.2);
            modifiqueTurno();
        }
        else if (sentido.equals("derecha")){
            setPosX(1.2);
            this.sentido='d';
        } else{
            this.sentido='i';
            setPosX(-1.2);
        }
    }

    public void setPosX(double x) {
        if (x!=-9999) {
            modifiqueTurno();
            posX += x;
            posX = posX < 45 ? 45 : posX;
            posX = posX > 415 ? 415 : posX;
        }else if (isVivo()){
            turno=0;
        }
    }

    private void modifiqueTurno(){
        if (turno<4) {
            turno++;
        } else{
            turno=0;
        }
    }

    public void modifiqueTurno2(){
        if (turno<100){
            turno++;
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
                setPosY(-1.7);
            } else {
                setPosY(1.7);
            }
            salto++;
        }
    }

    public void modifiqueSalto() {
        salto=0;
        noEstaSaltando=false;
    }

    public void suba(boolean saltando){
        estaSubiendo=saltando;
    }


    /**
     * Revisa si es o no impactado por un barril
     *
     * @param  barril
     */
    public boolean impactado(BarrilA barril) {
        double xBarril = barril.getX();
        double yBarril = barril.getY()-15;
        return (Math.abs(posY-yBarril)<=5) && (Math.abs(posX-xBarril)<=5);
    }

    public boolean impactado(VigaA viga){
        double xViga = viga.getX();
        double yViga = viga.getY();
        return (posY>=yViga-35 && posY<=yViga+35) && (posX>=xViga-11 && posX<=xViga+11);
    }

    public boolean impactado(EscaleraA escaleraA) {
        double xEscalera = escaleraA.getX();
        double yEscalera = escaleraA.getY();
        return (posX>=xEscalera-8 && posX<=xEscalera+8) && (posY>= yEscalera-20 && posY<=yEscalera+20);
    }

    public void reinicie(){
        posX=100;
        posY=570;
    }


    /**
     * Actualizo la vida por el dano de un barril
     *
     * @return
     */
    public void Murio() {
        turno=-10;
        estaMuerto=true;
        vida--;
        if (vida==0){
            estaMuerto=true;
        }
    }


    public boolean getnoEstaSaltando() {
        return noEstaSaltando;
    }

    public static char getSentido() {
        return sentido;
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

    public static int getSalto() {
        return salto;
    }

    public int getVida() {
        return vida;
    }

    public static boolean getEstaSubiendo(){
        return estaSubiendo;
    }

    public void Reviva() {
        sentido='d';
        turno=0;
        estaMuerto=false;
    }

    public boolean getestaVivo() {
        return !estaMuerto;
    }
}
