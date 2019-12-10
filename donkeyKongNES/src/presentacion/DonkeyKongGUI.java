package presentacion;
import aplicacion.*;

import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.BufferedImage;



public class DonkeyKongGUI extends JFrame {

    private boolean running, end;
    private aplicacion.DonkeyKong donkeyKongA;
    private DonkeyKongGame game;
    private JButton jugar;
    private ImageIcon img;
    private final Set<Integer> pressed = new HashSet<Integer>();
    private DonkeyKong dk;

    public DonkeyKongGUI(DonkeyKong dk){
        super("DonkeyKong");
        this.dk=dk;
        donkeyKongA=new aplicacion.DonkeyKong(1);
        game=new DonkeyKongGame(donkeyKongA);
        prepareElementos();
        prepareAcciones();
    }



    /**
     * define el tamaño de el jFrame
     */
    private void prepareElementos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(544,700);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(game,BorderLayout.CENTER);
        setBounds(0,0,544,700);
        setLocationRelativeTo(null);
        //preparePantallaPrincipal();
    }

    /**
     * realizar la pantalla principal
     */
    public void preparePantallaPrincipal() {
        jugar = new JButton();
        ImageIcon imgf = new ImageIcon("resources/button1player.jpg");
        jugar.setIcon(imgf);
        setInvisibleButton(jugar);
        img =  new ImageIcon("resources/fondoJuego.jpg");
        setContentPane(new JLabel(img));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(jugar, gbc);
        setVisible(true);
    }

    /**
     * Hqce invisibles los botones
     * @param button
     */
    private void setInvisibleButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }


    /**
     * prepara las acciones para salir, abrir, salga, cambiarColor
     */
    private void prepareAcciones() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                salga();
            }
        });
        addKeyListener(new EventoTeclado());
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                pressed.add(e.getKeyCode());
//                if (pressed.size()>1){
//                    for (Integer num: pressed){
//                        donkeyKongA.moverMario(num);
//
//                    }
//                } else{
//                    donkeyKongA.moverMario(e.getKeyCode());
//
//                }
//            }
//            @Override
//            public void keyReleased(KeyEvent e) {
//                pressed.remove(e.getKeyCode());
//            }
//
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//        });
    }

    /**
     * permite salir de el programa
     */
    private void salga(){
        int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == c) {
            System.exit(1);
        }
    }


    public class DonkeyKongGame extends JPanel {

        private Imagenes i = new Imagenes();
        private Objeto jugador;

        public DonkeyKongGame(aplicacion.DonkeyKong donkeyKongA) {
            setPreferredSize(new Dimension(587, 480));
        }


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//			Dibujar fondo de JPanel
            g.drawImage(i.getImagen("fondoJuego.jpg"), 0, 0, getWidth(), getHeight(), this);
            //Dibujar barriles iniciales
            g.drawImage(i.getImagen("barrilesIniciales.jpg"), 50, 89, 38, 60, this);
            drawVigas(g);
            drawDonkey(g);
            drawEscaleras(g);
            drawBarril(g);
            drawVidas(g);
            drawPrincesa(g);
            drawBarriles(g);
            drawSorpresas(g);
            jugador = new Jugador(donkeyKongA.getPosMarioX(), donkeyKongA.getPosMarioY(),donkeyKongA.getTurnoMario());
            jugador.draw(g, 0, 30, 35);
        }

        private void drawSorpresas(Graphics g) {
            for (SorpresaA s: donkeyKongA.getSorpresas()){
                Corazon corazon = new Corazon(s.getX(),s.getY());
                corazon.draw2(g,0,17,17);
            }
        }

        /**
         *
         * @param g
         */
        private void drawVidas(Graphics g){
            ArrayList<BufferedImage> frames2 = new ArrayList<>();
            if (donkeyKongA.getVidasMario()==5) {
                frames2.add(i.getImagen("vidasMario5.png"));
                g.drawImage(frames2.get(0), 60, 30, 40, 20, null);
            } else if (donkeyKongA.getVidasMario()==4){
                frames2.add(i.getImagen("vidasMario4.png"));
                g.drawImage(frames2.get(0), 60, 30, 36, 18, null);
            } else if (donkeyKongA.getVidasMario()==3){
                frames2.add(i.getImagen("vidasMario3.png"));
                g.drawImage(frames2.get(0), 60, 30, 30, 15, null);
            } else if (donkeyKongA.getVidasMario()==2){
                frames2.add(i.getImagen("vidasMario2.png"));
                g.drawImage(frames2.get(0), 60, 30, 26, 13, null);
            } else if (donkeyKongA.getVidasMario()==1){
                frames2.add(i.getImagen("vidasMario1.png"));
                g.drawImage(frames2.get(0), 60, 30, 17, 10, null);
            }
        }

        private void drawPrincesa(Graphics g){
            ArrayList<BufferedImage> frames2 = new ArrayList<>();
            if (donkeyKongA.getCambiarPrincesa()){
                frames2.add(i.getImagen("princesa1.png"));
                g.drawImage(frames2.get(0), 250, 35, 30, 50, null);
            } else{
                frames2.add(i.getImagen("princesa2.png"));
                g.drawImage(frames2.get(0),  250,  35, 30, 50, null);
            }
        }

        private void drawBarril(Graphics g){
            ArrayList<BufferedImage> frames2 = new ArrayList<>();
            if (donkeyKongA.getCambiarBarril()){
                frames2.add(i.getImagen("oil1.png"));
                g.drawImage(frames2.get(0), 60, 557, 30, 50, null);
            } else{
                frames2.add(i.getImagen("oil2.png"));
                g.drawImage(frames2.get(0),  60,  557, 30, 50, null);
            }
        }
        /**
         * Dibuja las vigas
         *
         * @param g
         */
        private void drawVigas(Graphics g) {
            for (VigaA v: donkeyKongA.getVigas()){
                Viga viga = new Viga(v.getX(),v.getY());
                viga.draw2(g,0,30,20);
            }
        }

        /**
         * @param g
         */
        private void drawEscaleras(Graphics g) {
            int conta=0;
            for (EscaleraA e: donkeyKongA.getEscaleras()){
                if (donkeyKongA.getPosiciones().indexOf(conta)==-1){
                    Escalera escalera = new Escalera(e);
                    escalera.draw2(g, 0, 20, 15);
                }
                conta++;
            }
        }

        private void drawDonkey(Graphics g) {
            Donkey donkey = new Donkey(donkeyKongA.getDonkey());
            donkey.draw2(g, 0, 70, 70);
        }

        private void drawBarriles(Graphics g) {
            for (int i = 0; i < donkeyKongA.getBarriles().size(); i++) {
                Barril barril=null;
                if (donkeyKongA.getPuntosBarril(donkeyKongA.getBarriles().get(i))==0){
                    barril = new BarrilVerde(donkeyKongA.getPosBarrilX(i), donkeyKongA.getPosBarrilY(i));
                } else if (donkeyKongA.getPuntosBarril(donkeyKongA.getBarriles().get(i))==10) {
                    barril = new BarrilAmarillo(donkeyKongA.getPosBarrilX(i), donkeyKongA.getPosBarrilY(i));
                } else if (donkeyKongA.getPuntosBarril(donkeyKongA.getBarriles().get(i))==20){
                    barril = new BarrilAzul(donkeyKongA.getPosBarrilX(i), donkeyKongA.getPosBarrilY(i));
                } else if (donkeyKongA.getPuntosBarril(donkeyKongA.getBarriles().get(i))==30){
                    barril = new BarrilRojo(donkeyKongA.getPosBarrilX(i), donkeyKongA.getPosBarrilY(i));
                }
                barril.draw2(g, 0, 20, 20);
            }
        }
    }




    private class MainLoop implements Runnable {
        private int dis = 5;

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            long frameRate = 100;
            while (running) {
                long startTime = System.currentTimeMillis();
                donkeyKongA.moverTodo();
                donkeyKongA.marioSaltar();
                repaint();
                    try {
                        Thread.sleep(35);
                    } catch (InterruptedException ex) {
                    }
            }

        }
    }
        /**
         * Inicio del juego y del thread
         */
        public void start() {
            if (running) {
                return;
            }
            running = true;

            Thread thread = new Thread(new MainLoop());
            thread.start();
        }



        /**
         * Fin del juego
         */
        public void end() {
            this.dispose();
        }


}


