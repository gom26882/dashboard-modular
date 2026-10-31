package model;

import java.awt.BorderLayout;
import javax.swing.JButton;

import interfaces.Interactivo;

public class WeatherWidget extends Widget implements Interactivo {

    private String ciudad;
    private double temperaturaC;
    private boolean mostrarF;

    public WeatherWidget(int id, String nombre, double memoriaKB, String ciudad, 
        double temperaturaC) {
        super(id, nombre, memoriaKB);

        this.ciudad = ciudad;
        this.temperaturaC = temperaturaC;
        mostrarF = false;

        JButton boton = new JButton("Cambiar C / F");
        boton.addActionListener(e -> interactuar());
        panel.add(boton, BorderLayout.SOUTH);
    }

    public double cambioT() {
        if (mostrarF) {
            return temperaturaC * 9.0 / 5 + 32;
        }
        return temperaturaC;
    }

    public void interactuar() {
        mostrarF = !mostrarF;
        dibujar();
    }

    public String verConfig() {
        String unidad = "C";

        if (mostrarF) {
            unidad = "F";
        }

        return super.verConfig()
                + "\nCiudad: " + ciudad
                + "\nTemperatura: " + cambioT() + unidad;
    }
}