package model;

public class QuoteWidget extends Widget {

    private String frase;

    public QuoteWidget(int id, String nombre, double memoriaKB, String frase) {
        super(id, nombre, memoriaKB);
        this.frase = frase;
    }

    public String verConfig() {
        return super.verConfig() + "\nfrase: " + frase;
    }
}