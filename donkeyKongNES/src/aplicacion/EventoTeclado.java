package aplicacion;

import java.awt.event.*;

public class EventoTeclado extends KeyAdapter{
    static boolean right,left,up,a,d,space;

    public static boolean getSpace() {
        return space;
    }

    /**
     * Se invoca cuando presionamos una tecla
     * @param e=tecla
     */
    public void keyPressed(KeyEvent e){
        int id = e.getKeyCode();
        if (id == KeyEvent.VK_UP){
            up=true;
        }
        if (id == KeyEvent.VK_SPACE){
            space=true;
        }
        if (id == KeyEvent.VK_LEFT){
            left=true;
        }
        if (id == KeyEvent.VK_RIGHT){
            right=true;
        }
        if (id == KeyEvent.VK_A) {
            a=true;
        }
        if (id == KeyEvent.VK_D) {
            d=true;
        }
    }

    /**
     * Se invoca cuando Soltamos una tecla
     */
    public void keyReleased(KeyEvent e){
        int id = e.getKeyCode();
        if (id == KeyEvent.VK_UP){
            up=false;
        }
        if (id == KeyEvent.VK_LEFT){
            left=false;
        }
        if (id == KeyEvent.VK_RIGHT){
            right=false;
        }
        if (id == KeyEvent.VK_A) {
            a=false;
        }
        if (id == KeyEvent.VK_D) {
            d=false;
        }
    }


    public static boolean isRight(){
        return right;
    }

    public static boolean isLeft(){
        return left;
    }

    public static boolean isUp(){
        return up;
    }
}
