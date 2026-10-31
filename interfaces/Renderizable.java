package interfaces;
import javax.swing.JComponent;

public interface Renderizable extends Comparable<Renderizable> {

    void dibujar();
    int getId();
    String getNombre();
    double getMemoriaKB();
    String verConfig();
    JComponent obtenerVista();
}