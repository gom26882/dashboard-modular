package model;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;

import interfaces.Interactivo;

public class TaskWidget extends Widget implements Interactivo {

    private ArrayList<String> tareas;
    private ArrayList<Boolean> completo;

    public TaskWidget(int id, String nombre, double memoriaKB) {
        super(id, nombre, memoriaKB);

        tareas = new ArrayList<>();
        completo = new ArrayList<>();

        JButton boton = new JButton("Marcar como completada");
        boton.addActionListener(e -> interactuar());

        panel.add(boton, BorderLayout.SOUTH);
    }

    public void addTarea(String tarea) {
        tareas.add(tarea);
        completo.add(false);
        dibujar();
    }

    public void interactuar() {
        for (int i = 0; i < tareas.size(); i++) {
            if (!completo.get(i)) {
                completo.set(i, true);
                dibujar();
                return;
            }
        }
    }

    public String verConfig() {
        String informacion = super.verConfig();

        for (int i = 0; i < tareas.size(); i++) {
            if (completo.get(i)) {
                informacion += "\n[*] " + tareas.get(i);
            } else {
                informacion += "\n[ ] " + tareas.get(i);
            }
        }

        return informacion;
    }
}