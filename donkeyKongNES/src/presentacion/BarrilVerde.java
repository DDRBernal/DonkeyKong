package presentacion;

import aplicacion.BarrilVerdeA;

public class BarrilVerde extends Barril {

    public BarrilVerde(double x, double y){
        super(x,y);
    }

    public void carga(){
        if (BarrilVerdeA.getTurno()==0) {
            frames2.add(i.getImagen("barrilVMove1.png"));
        } else if (BarrilVerdeA.getTurno()==1){
            frames2.add(i.getImagen("barrilVMove2.png"));
        } else if (BarrilVerdeA.getTurno()==2){
            frames2.add(i.getImagen("barrilVMove3.png"));
        } else if (BarrilVerdeA.getTurno()==3){
            frames2.add(i.getImagen("barrilVMove4.png"));
        } else if (BarrilVerdeA.getTurno()==4){
            frames2.add(i.getImagen("barrilVMove3.png"));
        }
    }
}
