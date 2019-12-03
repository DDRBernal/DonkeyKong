package presentacion;

import aplicacion.BarrilA;

public class BarrilAmarillo extends Barril {

    public BarrilAmarillo(double x, double y){
        super(x,y);
    }

    public void carga(){
        if (BarrilA.getTurno()==0) {
            frames2.add(i.getImagen("barrilMove1.png"));
        } else if (BarrilA.getTurno()==1){
            frames2.add(i.getImagen("barrilMove2.png"));
        } else if (BarrilA.getTurno()==2){
            frames2.add(i.getImagen("barrilMove3.png"));
        } else if (BarrilA.getTurno()==3){
            frames2.add(i.getImagen("barrilMove4.png"));
        } else if (BarrilA.getTurno()==4){
            frames2.add(i.getImagen("barrilMove3.png"));
        }
    }


}
