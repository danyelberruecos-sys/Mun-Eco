package co.edu.eia.ecocampus.modelo;

public class Indicador {

    private String titulo;
    private String valor;

    public Indicador(String titulo, String valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getValor() {
        return valor;
    }
}