package presentacion;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;

/**
 * Clase que nos permite cargar imagenes al juego
 *
 * @author
 *
 */
public class Imagenes {
    private HashMap<String, BufferedImage> frames;

    /**
     * Constructor de la clase
     */
    public Imagenes() {
        frames = new HashMap<String, BufferedImage>();
    }

    /**
     * Metodo para buscar las imagenes en el sistema y retornarlas
     *
     * @param nombre
     * @return BufferedImage
     */
    private BufferedImage cargarImagenesH(String nombre) {
        try {
            return ImageIO.read(new File("src/resources/" + nombre));
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Retornar el BufferedImage de la imagen solicitada
     *
     * @param nombre nombre
     * @return BufferedImage imagen
     */
    public BufferedImage getImagen(String nombre) {
        BufferedImage item = (BufferedImage) frames.get(nombre);
        if (item == null)
            item = extracted(nombre);
        return item;
    }

    /**
     * Metodo para tener las imagenes en un ArrayList de manera que, no tenga que
     * cargarlas cada vez que las necesite
     *
     * @param nombre
     * @return BufferedImage
     */
    private BufferedImage extracted(String nombre) {
        BufferedImage item;
        {
            item = cargarImagenesH(nombre);
            frames.put(nombre, item);
        }
        return item;
    }

}