package aplicacion;
import presentacion.Barril;
import presentacion.Escalera;
import presentacion.Viga;

import java.util.*;

public class DonkeyKong {

    private ArrayList<BarrilA> barriles;
    private MarioA mario;
    private ArrayList<Jugador> jugadores;
    private ArrayList<VigaA> vigas;
    private ArrayList<EscaleraA> escaleras;
    private DonkeyA donkeyA;
    private int turnoBarril;


    public DonkeyKong(int numJugadores){
        barriles = new ArrayList<>();
        jugadores = new ArrayList<>();
        mario = new MarioA(100,570);
        donkeyA = new DonkeyA(88,80);
        vigas = new ArrayList<>();
        escaleras = new ArrayList<>();
        prepareElementos(numJugadores);
        barriles.add(new BarrilA(160,130));
        turnoBarril=0;
    }

    public void prepareElementos(int numJugadores) {
        prepareVigas();
        prepareVigas2();
        prepareVigas3();
        prepareVigas4();
        prepareEscaleras();
    }

    /**
     * @param
     */
    private void prepareEscaleras() {
        int y = 582;
        EscaleraA escalera = new EscaleraA(200, 590);
        escaleras.add(escalera);
        EscaleraA escalera11 = new EscaleraA(200, 530);
        escaleras.add(escalera11);
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                y += 1;
            }
            EscaleraA escalera12 = new EscaleraA(380, y);
            escaleras.add(escalera12);
            y -= 15;
        }
        prepareEscaleras2();
    }

    private void prepareEscaleras2() {
        int y = 497;
        for (int i = 0; i < 5; i++) {
            EscaleraA escalera = new EscaleraA(230, y);
            escaleras.add(escalera);
            y -= 15;
        }
        y = 489;
        for (int j = 0; j < 4; j++) {
            EscaleraA escalera = new EscaleraA(110, y);
            escaleras.add(escalera);
            y -= 15;
        }
        prepareEscaleras3();
    }

    private void prepareEscaleras3() {
        int y = 402;
        EscaleraA escalera = new EscaleraA(170, 408);
        escaleras.add(escalera);
        EscaleraA escalera11 = new EscaleraA(170, 341);
        escaleras.add(escalera11);
        for (int i = 0; i < 5; i++) {
            EscaleraA escalera1 = new EscaleraA(260, y);
            escaleras.add(escalera1);
            y -= 14;
        } y=397;
        for (int i =0; i<4; i++) {
            EscaleraA escalera22 = new EscaleraA(350, y);
            escaleras.add(escalera22);
            y-=14;
        }
        prepareEscaleras4();
    }

    private void prepareEscaleras4() {
        int y = 318;
        EscaleraA escalera0 = new EscaleraA(321, y);
        escaleras.add(escalera0);
        EscaleraA escalera1 = new EscaleraA(321, y-72);
        escaleras.add(escalera1);
        for (int i=0; i<5; i++) {
            EscaleraA escaleraA = new EscaleraA(201,y-8);
            escaleras.add(escaleraA);
            y-=14;
        }
        for (int i=0; i<4; i++){
            EscaleraA escaleraA = new EscaleraA(111,y+56);
            escaleras.add(escaleraA);
            y-=14;
        }
        prepareEscaleras5();
    }

    private void prepareEscaleras5(){
        int y=218;
        for (int i=0; i<2; i++) {
            EscaleraA escaleraA = new EscaleraA(261, y);
            escaleras.add(escaleraA);
            y-=50;
        } y=208;
        for (int i=0; i<4; i++){
            EscaleraA escaleraA = new EscaleraA(411, y);
            escaleras.add(escaleraA);
            if (i<2){y-=14;}
            else{y-=8;}
        }

    }

    private void prepareVigas4(){
        int pox = 50;
        int poy = 150;
        for (int i = 0; i < 13; i++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            if (i >= 9) {
                poy += 2;
            }
            pox += 30;
        }
        pox = 230;
        poy = 85;
        for (int i = 0; i < 4; i++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            pox += 30;
        }
    }

    private void prepareVigas3() {
        int pox = 50;
        int poy = 315;
        for (int i = 0; i < 13; i++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            pox += 30;
            poy += 2;
        }
        pox = 440;
        poy = 220;
        for (int i = 0; i < 13; i++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            pox -= 30;
            poy += 2;
        }

    }

    private void prepareVigas2() {
        int pox = 440;
        int poy = 405;
        for (int i = 0; i < 13; i++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            pox -= 30;
            poy += 2;
        }
    }


    private void prepareVigas() {
        int pox = 50;
        int poy = 605;
        for (int i = 0; i < 14; i++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            if (i >= 6) {
                poy -= 2;
            }
            pox += 30;
        }
        pox = 50;
        poy = 500;
        for (int j = 0; j < 13; j++) {
            VigaA viga = new VigaA(pox, poy);
            vigas.add(viga);
            pox += 30;
            poy += 2;
        }
    }


    public void marioSubir(){
        //System.out.println(mario.getPosX()+" "+mario.getPosY()+" sss");
        for (EscaleraA e : escaleras) {
            //System.out.println(e.getX()+" "+e.getY()+" aaa");
            if (mario.impactado(e) /*&& alturaEscaleras(e)>2*/) {
                System.out.println(2222);
            }
        }
    }

    public void marioImpactoVigas(){
        for (VigaA v: vigas){
            if (mario.impactado(v)){
                try{
                    if (vigas.get(vigas.indexOf(v)).getY()<vigas.get(vigas.indexOf(v)-1).getY() && mario.getSentido()=='d'){
                        mario.setPosY(-0.6);
                    } else if (vigas.get(vigas.indexOf(v)).getY()<vigas.get(vigas.indexOf(v)+1).getY() && mario.getSentido()=='i'){
                        mario.setPosY(0.6);
                    }
//                    else if (vigas.get(vigas.indexOf(v)).getY()>vigas.get(vigas.indexOf(v)+1).getY()){
//                        mario.setPosY(0.6);
//                    }
                }
                catch (ArrayIndexOutOfBoundsException e){ }

            }
        }
    }


    private int alturaEscaleras(EscaleraA escalera){
        int suma=0;
        double conta= escaleras.get(escaleras.indexOf(escalera)).getY();
        ArrayList<Double> posYs = new ArrayList<>();
        for (int i=escaleras.indexOf(escalera)+1; i<escaleras.size() ;i++){
            if (conta>escaleras.get(i).getY()){
                posYs.add(conta);
                conta=escaleras.get(i).getY();
            } else{
                break;
            }
        }
//        for (Double d: posYs){
//            suma+=d;
//        }
        return posYs.size();
    }

    public void moverMario(Integer key){
        marioSubir();
        marioImpactoVigas();
        if (key==38){
            //marioSubir();
            if (mario.getnoEstaSaltando()) {
                mario.modifiqueSalto();
            }
        }
        if (key==39){
            //System.out.println(mario.getPosX()+" "+mario.getPosY());
            mario.mueva("derecha");
        } else if (key==37){
            mario.mueva("izquierda");
        } else{
            mario.setPosX(-9999);
        }
    }

    public void marioSaltar() {
        mario.saltar();
    }

    public void moverTodo(){
        modifiqueBarril();
        donkeyA.modifiqueTurno();
        for (BarrilA b : barriles){
            choqueBarrilViga(b);
        }
        if (donkeyA.getLanzeBarril()){
            barriles.add(new BarrilA(160,130));
        }
    }

    private void choqueBarrilViga(BarrilA b){
        int moverse=0;
        for (VigaA v: vigas){
            if ((b.getX()>=v.getX() && b.getX()<=v.getX()+30)) {
                if (b.getY() == v.getY() - 22) {
                    b.setPosY(2);
                    moverse = 0;
                    break;
                } else if (b.getY() == v.getY() - 20){
                    moverse=0;
                    break;
                }else{
                    moverse=2;
                }
            }
            //System.out.println(barriles.get(0).getX()+" "+v.getX()+" "+barriles.get(0).getY()+" "+v.getY());
        }

        if (moverse==2){
            b.setPosY(1);
            b.setSentido();
        } else if (moverse==0){
            b.muevase(b.getSentido());
            b.setArray();
        }
    }

    private void modifiqueBarril(){
        if (turnoBarril<30){
            turnoBarril++;
        }else{
            turnoBarril=0;
        }
    }

    public double getPosMarioX(){
        return mario.getPosX();
    }

    public double getPosMarioY(){
        return mario.getPosY();
    }

    public double getPosDonkeyX() {
        return donkeyA.getPosX();
    }

    public double getPosDonkeyY(){
        return donkeyA.getPosY();
    }


    public double getPosBarrilX(int i){
        return barriles.get(i).getX();
    }

    public double getPosBarrilY(int i){
        return barriles.get(i).getY();
    }

    public ArrayList<BarrilA> getBarriles(){
        return barriles;
    }

    public int getTurnoMario(){
        return mario.getTurno();
    }

    public ArrayList<VigaA> getVigas(){
        return vigas;
    }

    public ArrayList<EscaleraA> getEscaleras(){
        return escaleras;
    }

    public int getTurnoDonkey() {
        return donkeyA.getTurno();
    }

    public boolean getCambiarBarril(){
        return turnoBarril<15;
    }
}
