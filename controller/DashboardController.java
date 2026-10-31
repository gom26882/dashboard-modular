package controller;

import interfaces.Renderizable;
import model.Dashboard;
import view.DashboardView;

public class DashboardController {

    private Dashboard modelo;
    private DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.alBuscar(e -> buscar());
        vista.alListar(e -> vista.mostrarMensaje(modelo.widgetList()));
        vista.alOrdenar(e -> {modelo.ordenarPorMemoria();
            vista.mostrarWidgets(modelo.getWidgets());
        });

        vista.alInteractuar(e -> interactuar());
    }

    public void iniciar() {
        vista.mostrarWidgets(modelo.getWidgets());
        vista.setVisible(true);
    }

    private void buscar() {
        String entrada = vista.getEntrada();

        Renderizable widget = modelo.findByName(entrada);

        if (widget == null) {
            try {
                int id = Integer.parseInt(entrada);
                widget = modelo.findById(id);
            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Nombre o id invalido");
                return;
            }
        }

        if (widget == null) {
            vista.mostrarMensaje("Widget no encontrado");
        } else {
            vista.mostrarMensaje(widget.verConfig());
        }
    }

    private void interactuar() {
        try {
            int id = Integer.parseInt(vista.getEntrada());
            vista.mostrarMensaje(modelo.interactuarWid(id));
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Id debe ser numerico");
        }
    }
}