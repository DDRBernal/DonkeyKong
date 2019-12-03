package presentacion;

import aplicacion.BarrilRojoA;

public class BarrilRojo extends Barril {

    public BarrilRojo(double x, double y){
        super(x,y);
    }

    public void carga(){
        if (BarrilRojoA.getTurno()==0) {
            frames2.add(i.getImagen("barrilRMove1.png"));
        } else if (BarrilRojoA.getTurno()==1){
            frames2.add(i.getImagen("barrilRMove2.png"));
        } else if (BarrilRojoA.getTurno()==2){
            frames2.add(i.getImagen("barrilRMove3.png"));
        } else if (BarrilRojoA.getTurno()==3){
            frames2.add(i.getImagen("barrilRMove4.png"));
        } else if (BarrilRojoA.getTurno()==4){
            frames2.add(i.getImagen("barrilRMove3.png"));
        }
    }
}
