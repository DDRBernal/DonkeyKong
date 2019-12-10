package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.*;
public class DonkeyKong extends JDialog{

    private JPanel panel;
    private Dimension screenSize;
    private static DonkeyKong donkeyKongP;
    private DonkeyKongGUI donkeyKongGUI;
    private JButton play;
    private Imagenes i = new Imagenes();
    private boolean hacerVisible;

    public DonkeyKong(boolean hacerVisible){
        this.hacerVisible = hacerVisible;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Donkey Kong");
        prepareElementos();
        prepareAcciones();
    }

    public void prepareElementos(){
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel = new JPanel(){
            BufferedImage image = i.getImagen("donkeyFondo.jpg");
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, screenSize.width / 2, screenSize.height / 2, this);
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ImageIcon icon = new ImageIcon(i.getImagen("button1player.png"));
        play = new JButton("",icon);
        play.setBounds(0,0,229,70);
        play.setBorderPainted(false);
        play.setContentAreaFilled(false);
        play.setFocusPainted(false);
        play.setOpaque(false);
        gbc.weighty = 1;
        gbc.weightx = .5;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(play,gbc);
        setSize(screenSize.width / 2, screenSize.height / 2);
        this.setContentPane(panel);
        if (hacerVisible) this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        setLocationRelativeTo(null);
    }


    public void prepareAcciones(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                salga();
            }
        });
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(1);
            }
        });
    }

    /**
     * Inicializar juego
     */
    public void jugar(int numero) {
        donkeyKongGUI = new DonkeyKongGUI(this);
        if (hacerVisible){
            donkeyKongGUI.setVisible(true);
        }
        donkeyKongGUI.start();
        donkeyKongP.setVisible(false);
    }

    public void createDonkey(){
        donkeyKongP = new DonkeyKong(hacerVisible);
    }

    /**
     * Si se quiere salir de la ventana, solicitar confirmacion
     */
    public void salga() {
        int c = JOptionPane.showConfirmDialog(null, "Desea salir?", "EXIT", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == c) {
            System.exit(1);
        }
    }

    public void noHacerVisible(){
        hacerVisible=false;
    }

    public static void main(String[] args){
        donkeyKongP = new DonkeyKong(true);
        //donkeyKongP.setVisible(true);
    }

}