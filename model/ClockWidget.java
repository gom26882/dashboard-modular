package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

public class ClockWidget extends Widget {

    private Timer reloj;

    public ClockWidget(int id, String nombre, double memoriaKB) {
        super(id, nombre, memoriaKB);

        reloj = new Timer(1000, e -> dibujar());
        reloj.start();
    }

    public String verConfig() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = LocalTime.now().format(formato);
        return super.verConfig() + "\nhora: " + hora;
    }
}