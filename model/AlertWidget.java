package model;

import java.awt.BorderLayout;
import javax.swing.JButton;

import interfaces.Interactivo;

public class AlertWidget extends Widget implements Interactivo {

    private String mensaje;
    private String prioridad;
    private boolean leida;

    public AlertWidget(int id, String nombre, double memoriaKB, String mensaje, 
        String prioridad) {
        super(id, nombre, memoriaKB);

        this.mensaje = mensaje;
        this.prioridad = prioridad;
        leida = false;

        JButton boton = new JButton("Marcar leido");
        boton.addActionListener(e -> interactuar());
        panel.add(boton, BorderLayout.SOUTH);
    }

    public void interactuar() {
        leida = true;
        dibujar();
    }

    public String verConfig() {
        String estado = "no leido";

        if (leida) {
            estado = "leido";
        }

        return super.verConfig()
                + "\nMensaje: " + mensaje
                + "\nPrioridad: " + prioridad
                + "\nEstado: " + estado;
    }
}