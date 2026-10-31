package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import interfaces.Renderizable;

public class DashboardView extends JFrame {

    private JPanel contenedor;
    private JTextField entrada;
    private JButton buscar;
    private JButton listar;
    private JButton ordenar;
    private JButton interactuar;

    public DashboardView() {
        setTitle("Dashboard");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel barra = new JPanel();

        entrada = new JTextField(12);
        buscar = new JButton("Buscar");
        listar = new JButton("Listar");
        ordenar = new JButton("Ordenar por memoria");
        interactuar = new JButton("Interactuar por ID");

        barra.add(new JLabel("Mi Dashboard | ID o nombre:"));
        barra.add(entrada);
        barra.add(buscar);
        barra.add(listar);
        barra.add(ordenar);
        barra.add(interactuar);

        contenedor = new JPanel(new GridLayout(0, 2, 10, 10));

        add(barra, BorderLayout.NORTH);
        add(new JScrollPane(contenedor), BorderLayout.CENTER);
    }

    public void mostrarWidgets(List<Renderizable> widgets) {
        contenedor.removeAll();

        for (Renderizable widget : widgets) {
            JComponent panel = widget.obtenerVista();
            panel.setPreferredSize(new Dimension(400, 180));
            contenedor.add(panel);
        }

        contenedor.revalidate();
        contenedor.repaint();
    }

    public String getEntrada() {
        return entrada.getText().trim();
    }

    public void mostrarMensaje(String mensaje) {
        JTextArea texto = new JTextArea(mensaje, 15, 35);
        texto.setEditable(false);

        JOptionPane.showMessageDialog(
                this, new JScrollPane(texto));
    }

    public void alBuscar(ActionListener accion) {
        buscar.addActionListener(accion);
    }

    public void alListar(ActionListener accion) {
        listar.addActionListener(accion);
    }

    public void alOrdenar(ActionListener accion) {
        ordenar.addActionListener(accion);
    }

    public void alInteractuar(ActionListener accion) {
        interactuar.addActionListener(accion);
    }
}