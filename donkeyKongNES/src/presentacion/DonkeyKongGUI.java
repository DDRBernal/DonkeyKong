package presentacion;
import aplicacion.*;

import javax.swing.border.EmptyBorder;

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

    private JPanel fondo;
    private Image background;
    private JButton jugar;
    private ImageIcon img;

    public DonkeyKongGUI(){
        super("DonkeyKong");
        prepareElementos();
        prepareAcciones();
    }

    /**
     * define el tamaño de el jFrame
     */
    private void prepareElementos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(597,480);
        setLocationRelativeTo(null);
        preparePantallaPrincipal();
    }

    /**
     * realizar la pantalla principal
     */
    public void preparePantallaPrincipal() {
        jugar = new JButton();
        ImageIcon imgf = new ImageIcon("resources/button1player.jpg");
        jugar.setIcon(imgf);
        setInvisibleButton(jugar);
        img =  new ImageIcon("resources/donkeyFondo.jpg");
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
        jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(jugar);
                prepareElementosInicial();
            }
        });
    }

    private void prepareElementosInicial(){
        setPreferredSize(new Dimension(933, 544));
        pack();
        setLocationRelativeTo(null);
        prepareTablero();
    }

    private void prepareTablero(){
        img =  new ImageIcon("resources/fondoJuego.jpg");
        setContentPane(new JLabel(img));
        setVisible(true);
    }

    /**
     * genera el background o fondo de el juego
     * @param imagePath
     */
    public void setBackground(String imagePath) {
        fondo.setOpaque(false);
        this.background = new ImageIcon("resources/donkeyFondo.png").getImage();
        fondo.repaint();
    }

    /**
     * punta los componentes
     * @param g
     */
    public void paintComponent(Graphics g) {
        int width = this.getSize().width;
        int height = this.getSize().height;
        if (this.background != null) {
            g.drawImage(this.background, 0, 0, width, height, null);
        }
        paintComponent(g);
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


    public static void main(String[] args) {
        DonkeyKongGUI donkeyKongGUI= new DonkeyKongGUI();
        donkeyKongGUI.setVisible(true);
    }
}
