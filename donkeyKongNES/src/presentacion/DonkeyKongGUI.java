package presentacion;
import aplicacion.*;

import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


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
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressed.add(e.getKeyCode());
                if (pressed.size()>1){
                    for (Integer num: pressed){
                        donkeyKongA.moverMario(num);

                    }
                } else{
                    donkeyKongA.moverMario(e.getKeyCode());

                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                pressed.remove(e.getKeyCode());
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
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
            long startFrameTime = (long) (999999999 * Math.random());
            int Mx = (int) ((startFrameTime + System.nanoTime()) * Math.abs(-5) * 0.000000001) % 2;
            drawBarriles(g);
            drawVigas(g);
            drawDonkey(g);
            drawEscaleras(g);
            jugador = new Jugador(donkeyKongA.getPosMarioX(), donkeyKongA.getPosMarioY(),donkeyKongA.getTurnoMario());
            jugador.draw(g, 0, 30, 35);
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
            for (EscaleraA e: donkeyKongA.getEscaleras()){
                Escalera escalera = new Escalera(e.getX(),e.getY());
                escalera.draw2(g,0,20,15);
            }
        }

        private void drawDonkey(Graphics g) {
            Donkey donkey = new Donkey(donkeyKongA.getPosDonkeyX(), donkeyKongA.getPosDonkeyY(),donkeyKongA.getTurnoDonkey());
            donkey.draw2(g, 0, 70, 70);
        }

        private void drawBarriles(Graphics g) {
            for (int i = 0; i < 1; i++) {
                Barril barril = new Barril(donkeyKongA.getPosBarrilX(), donkeyKongA.getPosBarrilY());
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


