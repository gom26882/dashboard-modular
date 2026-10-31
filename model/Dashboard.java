package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import interfaces.Interactivo;
import interfaces.Renderizable;

public class Dashboard {

    private ArrayList<Renderizable> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
        init();
    }

    public void init() {
        if (!widgets.isEmpty()) {
            return;
        }

        addWidget(new WeatherWidget(
                1, "Clima Guatemala", 100, "Guatemala", 25));

        addWidget(new WeatherWidget(
                2, "Clima Antigua", 90, "Antigua", 22));

        TaskWidget personales =
                new TaskWidget(3, "Tareas personales", 70);

        personales.addTarea("Estudiar");
        personales.addTarea("Hacer ejercicio");
        addWidget(personales);

        TaskWidget proyecto =
                new TaskWidget(4, "Tareas del proyecto", 80);

        proyecto.addTarea("Terminar UML");
        proyecto.addTarea("Revisar código");
        addWidget(proyecto);

        addWidget(new AlertWidget(
                5, "Alerta del sistema", 60,
                "Memoria elevada", "Alta"));

        addWidget(new AlertWidget(
                6, "Recordatorio", 50,
                "Entregar tarea", "Media"));

        addWidget(new ClockWidget(
                7, "Reloj principal", 30));

        addWidget(new ClockWidget(
                8, "Reloj secundario", 35));

        addWidget(new QuoteWidget(
                9, "Frase del día", 20,
                "Cada paso cuenta."));

        addWidget(new QuoteWidget(
                10, "Motivación", 25,
                "Aprender requiere práctica."));
    }

    public void addWidget(Renderizable widget) {
        widgets.add(widget);
    }

    public List<Renderizable> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }

    public String widgetList() {
        String informacion = "";

        for (Renderizable widget : widgets) {
            informacion += widget.verConfig()
                    + "\n--------------------\n";
        }

        return informacion;
    }

    public Renderizable findById(int id) {
        for (Renderizable widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }

        return null;
    }

    public Renderizable findByName(String nombre) {
        for (Renderizable widget : widgets) {
            if (widget.getNombre().equalsIgnoreCase(nombre)) {
                return widget;
            }
        }

        return null;
    }

    public String interactuarWid(int id) {
        Renderizable widget = findById(id);

        if (widget == null) {
            return "Widget no encontrado.";
        }

        if (widget instanceof Interactivo) {
            Interactivo interactivo = (Interactivo) widget;
            interactivo.interactuar();
            return "Interacción realizada.";
        }

        return "Este widget no permite interacción.";
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }
}