package aplicacion;

import excepciones.DonkeyPoobExcepcion;

//Paquetes de java
import java.io.*;
import java.util.*;

public class DonkeyKong implements Serializable{

    private static final long serialVersionUID = 8799656478674716638L;
    private ArrayList<BarrilA> barriles;
    private MarioA mario;
    private ArrayList<Jugador> jugadores;
    private ArrayList<VigaA> vigas;
    private ArrayList<EscaleraA> escaleras;
    private ArrayList<SorpresaA> sorpresas;
    private DonkeyA donkeyA;
    private int turnoBarril, turnoPrincesa;
    private ArrayList<Integer> posiciones;
    private int valorBarril;




    public DonkeyKong(int numJugadores){
        barriles = new ArrayList<>();
        jugadores = new ArrayList<>();
        mario = new MarioA(100,570);
        donkeyA = new DonkeyA(88,80);
        vigas = new ArrayList<>();
        escaleras = new ArrayList<>();
        posiciones = new ArrayList<>();
        sorpresas= new ArrayList<>();
        prepareElementos(numJugadores);
        barriles.add(new BarrilAmarilloA(160,130));
        turnoBarril=0;
        turnoPrincesa=0;
        valorBarril=2;
    }
    //Elementos del Nivel
    public void prepareElementos(int numJugadores) {
        prepareVigas();
        prepareVigas2();
        prepareVigas3();
        prepareVigas4();
        prepareEscaleras();
        prepareSorpresas();
    }

    private void prepareSorpresas() {
        CorazonA corazonA = new CorazonA(410,370);
        sorpresas.add(corazonA);
    }

    /**
     * @param
     */
    private void prepareEscaleras() {
        int y = 582;
        EscaleraA escalera = new Segmentada(200, 590);
        escaleras.add(escalera);
        EscaleraA escalera11 = new Segmentada(200, 530);
        escaleras.add(escalera11);
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                y += 1;
            }
            EscaleraA escalera12 = new Completa(380, y);
            escaleras.add(escalera12);
            y -= 15;
        }
        EscaleraA escaleraN = new Completa(380, y);
        escaleras.add(escaleraN);
        posiciones.add(escaleras.size()-1);
        prepareEscaleras2();
    }

    private void prepareEscaleras2() {
        int y = 497;
        for (int i = 0; i < 5; i++) {
            EscaleraA escalera = new Completa(230, y);
            escaleras.add(escalera);
            y -= 15;
        }
        EscaleraA escaleraN = new Completa(230, y);
        escaleras.add(escaleraN);
        posiciones.add(escaleras.size()-1);
        y = 489;
        for (int j = 0; j < 5; j++) {
            EscaleraA escalera = new Completa(110, y);
            escaleras.add(escalera);
            y -= 15;
        }
        posiciones.add(escaleras.size()-1);
        prepareEscaleras3();
    }

    private void prepareEscaleras3() {
        int y = 402;
        EscaleraA escalera = new Segmentada(170, 408);
        escaleras.add(escalera);
        EscaleraA escalera11 = new Segmentada(170, 341);
        escaleras.add(escalera11);
        for (int i = 0; i < 5; i++) {
            EscaleraA escalera1 = new Completa(260, y);
            escaleras.add(escalera1);
            y -= 14;
        }EscaleraA escaleraN = new Completa(260, y);
        escaleras.add(escaleraN);
        posiciones.add(escaleras.size()-1);
        y=397;
        for (int i =0; i<4; i++) {
            EscaleraA escalera22 = new Completa(350, y);
            escaleras.add(escalera22);
            y-=14;
        }
        EscaleraA escaleraN1 = new Completa(350, y);
        escaleras.add(escaleraN1);
        posiciones.add(escaleras.size()-1);
        prepareEscaleras4();
    }

    private void prepareEscaleras4() {
        int y = 318;
        EscaleraA escalera0 = new Segmentada(321, y);
        escaleras.add(escalera0);
        EscaleraA escalera1 = new Segmentada(321, y-72);
        escaleras.add(escalera1);
        for (int i=0; i<5; i++) {
            EscaleraA escaleraA = new Completa(201,y-8);
            escaleras.add(escaleraA);
            y-=14;
        }EscaleraA escaleraN1 = new Completa(201, y-8);
        escaleras.add(escaleraN1);
        posiciones.add(escaleras.size()-1);
        for (int i=0; i<4; i++){
            EscaleraA escaleraA = new Completa(111,y+56);
            escaleras.add(escaleraA);
            y-=14;
        }EscaleraA escaleraN = new Completa(111, y+56);
        escaleras.add(escaleraN);
        posiciones.add(escaleras.size()-1);
        prepareEscaleras5();
    }

    private void prepareEscaleras5(){
        int y=218;
        for (int i=0; i<2; i++) {
            EscaleraA escaleraA = new Segmentada(261, y);
            escaleras.add(escaleraA);
            y-=50;
        } y=208;
        for (int i=0; i<4; i++){
            EscaleraA escaleraA = new Completa(411, y);
            escaleras.add(escaleraA);
            if (i<2){y-=14;}
            else{y-=8;}
        }
        prepareEscaleras6();
    }

    private void prepareEscaleras6(){
        int y=135;
        for (int i=0; i<6; i++){
            EscaleraA escaleraA = new Completa(231,y);
            escaleras.add(escaleraA);
            y-=6;
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

    /**
     * Permite que Mario salte.
     */
    public void marioSubir(){
        for (EscaleraA e : escaleras) {
            if (mario.impactado(e) && e.esEscalable()) {
                mario.suba(true);
            }
        }
    }

    /**
     * Revisa si mario colisiona con un barril.
     * @return
     */
    public boolean marioImpactoBarril(){
        boolean choco=false;
        for (BarrilA b : barriles){
            if (mario.impactado(b)){
                choco=true;
                mario.Murio();
            }
        }
        return choco;
    }

    /**
     * Revisa un barril y una escalera collisionan.
     * @param b el barril a revisar
     * @return
     */
    private boolean impactoBarrilEscalera(BarrilA b){
        boolean rta=false;
        for (EscaleraA escaleraA: escaleras) {
            if (b.impacto(escaleraA)) {
                rta=true;
                b.setPosY(0.1);
            }
        }
        return rta;
    }

    /**
     * Revisa si mario collisiona con una viga.
     * @return
     */
    public boolean marioImpactoVigas(){
        boolean choco=false;
        for (int i=0; i<vigas.size();i++){
            if (mario.impactado(vigas.get(i))){
                choco=true;
                try{
                    if (Math.abs(vigas.get(i).getY()-mario.getPosY())<35){
                        mario.setPosY(-0.6);
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){ }
            }
        }
        return choco;
    }

    /**
     * Retorna la altura de la escalera
     * @param escalera
     * @return
     */
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
        return posYs.size();
    }

    /**
     *Mueve a Mario en la direccion indicada
     * @param direccion
     */
    public void moverMario(int direccion){
        if (direccion==-1){
            mario.mueva("N");
        }
        else if (!marioImpactoVigas()){
            gravedadMario();
        }
        if (direccion==38 || EventoTeclado.isUp()){
            marioSubir();
            if (mario.getEstaSubiendo()){
                mario.mueva("arriba");
            }
            else if (mario.getnoEstaSaltando()) {
                mario.modifiqueSalto();
                mario.suba(false);
            }
        }
        else if (direccion==39 || EventoTeclado.right){
            mario.suba(false);
            mario.mueva("derecha");
        } else if (direccion==37 || EventoTeclado.left){
            mario.mueva("izquierda");
            mario.suba(false);
        } else{
            mario.setPosX(-9999);
            mario.suba(false);
        }
    }

    /**
     * Le adiciona gravedad a mario.
     */
    private void gravedadMario() {
        mario.setPosY(0.2);
    }

    /**
     *Hace que mario salte.
     */
    public void marioSaltar() {
        mario.saltar();
    }

    /**
     * Actualiza las posiciones de todos los elementos del juego
     */
    public void moverTodo(){
        if (mario.isVivo()) {
            marioImpactoBarril();
            borreBarril();
            moverMario(0);
            modifiqueBarril();
            donkeyA.modifiqueTurno();
            for (BarrilA b : barriles) {
                choqueBarrilViga(b);
            }
            if (donkeyA.getLanzeBarril()) {
                agregarBarril();

            }
        } else{
            moverMario(-1);
            reinicie();
        }
    }

    /**
     * Se agrega un nuevo barril al azar
     */
    private void agregarBarril(){
        Random rand = new Random();
        int n = rand.nextInt(6);
        if (n==0 || n==1 || n==2){
            barriles.add(new BarrilAmarilloA(160, 130));
        } else if (n==3){
            barriles.add(new BarrilVerdeA(160, 130));
        } else if (donkeyA.getLanzarBarrilRojo()){
            barriles.add(new BarrilRojoA(100, 165));
        } else{
            barriles.add(new BarrilAzulA(160, 130));
        }
    }

    /**
     * Reinicia el juego.
     */
    private void reinicie(){
        if (mario.getTurno()==100) {
            mario.reinicie();
            mario.Reviva();
            barriles.clear();
        }
    }

    /**
     * Borra barriles que estan saliendo de la pantalla.
     */
    private void borreBarril(){
        for (BarrilA b : barriles){
            if (b.getX()-8==-7.0 && b.getY()-15==570.0){
                b.setPosY(1000);
            }
        }
    }

    /**
     * Revisa si un barril choca con una viga.
     * @param b
     */
    private void choqueBarrilViga(BarrilA b){
        if (b.getPuntos()==20){
            choqueBarrilAzul(b);
        }else{
        int moverse=0;
        for (VigaA v : vigas) {
            if ((b.getX() >= v.getX() && b.getX() <= v.getX() + 30) ) {
                if (b.getY() == v.getY() - 22) {
                    b.setPosY(2);
                    moverse = 0;
                    break;
                } else if (b.getY() == v.getY() - 20) {
                    moverse = 0;
                    break;
                } else {
                    moverse = 2;
                }
            }
        }
        if (moverse == 2) {
            b.setPosY(1);
            b.setSentido();
        } else if (moverse == 0) {
            b.muevase(b.getSentido());
            b.setArray();
        }}
    }

    /**
     *Revisa si un barrilAzul choca con una viga.
     * @param b
     */
    private void choqueBarrilAzul(BarrilA b){
        int moverse=0;
        for (VigaA v : vigas) {
            if ((b.getX() >= v.getX() && b.getX() <= v.getX() + 30) && !noEstaEnlista(vigas.indexOf(v))) {
                if (b.getY() == v.getY() - 22) {
                    b.setPosY(2);
                    moverse = 0;
                    break;
                } else if (b.getY() == v.getY() - 20) {
                    moverse = 0;
                    break;
                } else{
                    moverse = 2;
                }
            }
        }
        if (moverse == 2) {
            b.setPosY(1);
            b.setSentido();
        } else if (moverse == 0) {
            b.muevase(b.getSentido());
            b.setArray();
        }
    }

    /**
     *
     * @param i
     * @return
     */
    private boolean noEstaEnlista(int i) {
        Integer[] array = {16,29,30,37,47,50,62,78};
        boolean noEsta=false;
        for (int k =0;k<array.length;k++){
            if (i==array[k]){
                noEsta=true;
            }
        }
        return noEsta;
    }

    /**
     *Modifica el turno dle barril
     */
    private void modifiqueBarril(){
        if (turnoBarril<30){
            turnoBarril++;
        }else{
            turnoBarril=0;
        }
        modifiquePrincesa();
    }

    /**
     *Modifica el turno  de la princesa.
     */
    private void modifiquePrincesa(){
        if (turnoPrincesa<30){
            turnoPrincesa++;
        } else{
            turnoPrincesa=0;
        }
    }

    /**
     *Retorna la posicion en x de mario.
     * @return
     */
    public double getPosMarioX(){
        return mario.getPosX();
    }

    /**
     *Retorna la posicion en y de mario.
     * @return
     */
    public double getPosMarioY(){
        return mario.getPosY();
    }

    /**
     *Retorna la posicion en x de donkeyKong.
     * @return
     */
    public double getPosDonkeyX() {
        return donkeyA.getPosX();
    }

    /**
     *Retorna la posicion en y de donkeyKong.
     * @return
     */
    public double getPosDonkeyY(){
        return donkeyA.getPosY();
    }

    /**
     * Retorna la posicion en x de un Barril.
     * @param i
     * @return
     */
    public double getPosBarrilX(int i){
        return barriles.get(i).getX();
    }

    /**
     * Retorna la posicion en y de un Barril.
     * @param i
     * @return
     */
    public double getPosBarrilY(int i){
        return barriles.get(i).getY();
    }

    /**
     * Retorna la coleccion de barriles.
     * @return
     */
    public ArrayList<BarrilA> getBarriles(){
        return barriles;
    }

    /**
     * Retorna el turno de mario.
     * @return
     */
    public int getTurnoMario(){
        return mario.getTurno();
    }

    /**
     * Retorna la coleccion de vigas.
     * @return
     */
    public ArrayList<VigaA> getVigas(){
        return vigas;
    }

    /**
     * Retorna la coleccion de escaleras.
     * @return
     */
    public ArrayList<EscaleraA> getEscaleras(){
        return escaleras;
    }

    /**
     * Retorna el turno de donkeyKong.
     * @return
     */
    public int getTurnoDonkey() {
        return donkeyA.getTurno();
    }

    /**
     *
     * @return
     */
    public boolean getCambiarBarril(){
        return turnoBarril<15;
    }

    /**
     * Retorna una coleccion con las posiciones.
     * @return
     */
    public ArrayList<Integer> getPosiciones(){
        return posiciones;
    }

    /**
     * Retorna la cantidad que ofrece un barril al destruirse.
     * @param barril
     * @return
     */
    public int getPuntosBarril(BarrilA barril){
        return barril.getPuntos();
    }

    /**
     * Retorna a Mario.
     * @return
     */
    public MarioA getMario(){
        return mario;
    }

    /**
     * Retorna el numero de vidas de Mario.
     * @return
     */
    public int getVidasMario(){
        return mario.getVida();
    }

    /**
     * Retorna a DonkeyKong.
     * @return
     */
    public DonkeyA getDonkey() {
        return donkeyA;
    }

    /**
     * Retorno el turno de cambio de la princesa.
     * @return
     */
    public boolean getCambiarPrincesa() {
        return turnoPrincesa<15;
    }

    /**
     * Retorna la coleccion de sorpresas.
     * @return
     */
    public ArrayList<SorpresaA> getSorpresas() {
        return sorpresas;
    }

    /**
     * Guarda el estado actual de los objetos.
     * @param archivo
     * @throws DonkeyPoobExcepcion
     * @throws IOException
     */
    public void salve(File archivo) throws DonkeyPoobExcepcion, IOException{
        ObjectOutputStream out  = new ObjectOutputStream(
                new FileOutputStream(archivo));
        out.writeObject(this);
        out.close();
        if(!obtenerExtension(archivo).equals("dat")) throw new DonkeyPoobExcepcion(DonkeyPoobExcepcion.EXTENSION_INVALIDA_OBJETOS);
    }

    /**
     * Abre un estado del juego.
     * @param archivo
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws DonkeyPoobExcepcion
     */
    public static DonkeyKong abra(File archivo) throws IOException, ClassNotFoundException, DonkeyPoobExcepcion {
        DonkeyKong game = null;
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(archivo));

        game =  (DonkeyKong) in.readObject();
        in.close();
        if(!obtenerExtension(archivo).equals("dat")) throw new DonkeyPoobExcepcion(DonkeyPoobExcepcion.EXTENSION_INVALIDA_OBJETOS);
        return game;
    }

    /**
     * Retorna la extension de un archivo.
     * @param archivo
     * @return
     */
    public static String obtenerExtension(File archivo){
        String nombre = archivo.getName();
        String apellido = "";
        if (nombre.lastIndexOf(".")!=-1 && nombre.lastIndexOf(".")!=0) apellido =  nombre.substring(nombre.lastIndexOf(".")+1);
        return apellido;
    }
}
