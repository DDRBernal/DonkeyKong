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
    private DonkeyKong donkeyKongA;
    private DonkeyKongGame game;
    private JButton jugar;
    private ImageIcon img;
    private final Set<Integer> pressed = new HashSet<Integer>();
    private DonkeyKong dk;

    public DonkeyKongGUI(DonkeyKong dk){
        super("DonkeyKong");
        this.dk=dk;
        donkeyKongA=new DonkeyKong();
        game=new DonkeyKongGame(donkeyKongA);
        prepareElementos();
        prepareAcciones();
    }

    /**
     * define el tamaño de el jFrame
     */
    private void prepareElementos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(933,544);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(game,BorderLayout.CENTER);
        setBounds(0,0,933,544);
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
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressed.add(e.getKeyCode());
                if (pressed.size()>1){
                    for (Integer num: pressed){
                        //donkeyKongA.moverMario(num);
                    }
                } else{
                    Integer num = e.getKeyCode();
                    //donkeyKongA.moverMario(num);

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

    private void prepareTablero(){
        img =  new ImageIcon("resources/fondoJuego.jpg");
        setContentPane(new JLabel(img));
        setVisible(true);
    }

//    /**
//     * genera el background o fondo de el juego
//     * @param imagePath
//     */
//    public void setBackground(String imagePath) {
//        fondo.setOpaque(false);
//        this.background = new ImageIcon("resources/donkeyFondo.png").getImage();
//        fondo.repaint();
//    }


    /**
     * permite salir de el programa
     */
    private void salga(){
        int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == c) {
            System.exit(1);
        }
    }

    public void start() {
    }


    public class DonkeyKongGame extends JPanel {


        private Imagenes i = new Imagenes();
        private Objeto jugador;

        public DonkeyKongGame(DonkeyKong donkeyKongA) {
            setPreferredSize(new Dimension(587, 480));
        }

        /**
         * Esta metodo pertenece a la clase JPanel, nos permite dibujar
         *
         * @param g
         */
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(i.getImagen("fondoJuego.jpg"),0,0,getWidth(),getHeight(),this);}
//            long startFrameTime = (long) (999999999 * Math.random());
//            int Mx = (int) ((startFrameTime + System.nanoTime()) * Math.abs(-5) * 0.000000001) % 2;
//            jugador = new Jugador(sp.getPosNaveX(r), sp.getPosNaveY(r), r);
//            //jugador = new Jugador(0,0);
//            //drawBarriles();
//        }
//
//        private void drawBarriles(){
//
//        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
//			Dibujar fondo de JPanel
            g.drawImage(i.getImagen("fondoJuego.jpg"), 0, 0, getWidth(), getHeight(), this);
            long startFrameTime = (long) (999999999 * Math.random());
            int Mx = (int) ((startFrameTime + System.nanoTime()) * Math.abs(-5) * 0.000000001) % 2;
//			Agrego un nuevo jugador grafico

//			Dibujo a este jugador

            jugador = new Jugador(0,0);
            jugador.draw(g,0,60,60);
            drawBarriles(g);
        }



    private void drawBarriles(Graphics g){
        for (int i=0; i< 1; i++){
            Barril barril = new Barril(10,10);
            barril.draw2(g,0,20,20);
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

//                    long startTime = System.currentTimeMillis();
//                    // update();
//                    sp.moverTodo();
//                    sp.revisarTodo();
//                    sp.ataqueAlien();
//                    if (modo == "m") {
//                        sp.moverNave(1);
//                        if (dispara()) {
//                            if (sp.initDisparo(1) == false) {
//                                sinBalas();
//                            }
//                        }
//                    }
//                    repaint();
//                    while (System.currentTimeMillis() - startTime < frameRate) {
//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException ex) {
//                        }
//                    }
//                }
//                if (!sp.jugadoresVivos()) {
//                    end = true;
//                    SpaceInvaders ii = new SpaceInvaders();
//                    ii.end();
//                    end();
//                }
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

//        /**
//         * Fin del juego
//         */
//        public void end() {
//            this.dispose();
//        }

}}}


