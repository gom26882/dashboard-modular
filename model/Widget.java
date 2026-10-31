package model;

import java.awt.BorderLayout;
import javax.swing.*;

import interfaces.Renderizable;

public abstract class Widget implements Renderizable {

    private int id;
    private String nombre;
    private double memoriaKB;
    protected JPanel panel;
    protected JLabel texto;

    public Widget(int id, String nombre, double memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;

        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(nombre));

        texto = new JLabel();
        panel.add(texto, BorderLayout.CENTER);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMemoriaKB() {
        return memoriaKB;
    }

    public String verConfig() {
        return "ID: " + id
            + "\nNombre: " + nombre
            + "\nMemoria: " + memoriaKB + " KB";
    }

    public void dibujar() {
        texto.setText("<html>"
                + verConfig().replace("\n", "<br>")
                + "</html>");
    }

    public JComponent obtenerVista() {
        dibujar();
        return panel;
    }

    public int compareTo(Renderizable otro) {
        return Double.compare(memoriaKB, otro.getMemoriaKB());
    }
}