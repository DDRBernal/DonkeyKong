package presentacion;

import aplicacion.BarrilAzulA;

public class BarrilAzul extends Barril {

    public BarrilAzul(double x, double y){
        super(x,y);
    }

    public void carga(){
        if (BarrilAzulA.getTurno()==0) {
            frames2.add(i.getImagen("barrilAMove1.png"));
        } else if (BarrilAzulA.getTurno()==1){
            frames2.add(i.getImagen("barrilAMove2.png"));
        } else if (BarrilAzulA.getTurno()==2){
            frames2.add(i.getImagen("barrilAMove3.png"));
        } else if (BarrilAzulA.getTurno()==3){
            frames2.add(i.getImagen("barrilAMove4.png"));
        } else if (BarrilAzulA.getTurno()==4){
            frames2.add(i.getImagen("barrilAMove3.png"));
        }
    }
}
