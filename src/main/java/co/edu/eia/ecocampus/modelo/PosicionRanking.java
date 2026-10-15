package co.edu.eia.ecocampus.modelo;

public class PosicionRanking {

    private static final int TAMANIO_TOP = 5;

    private int puesto;
    private Persona persona;

    public PosicionRanking(int puesto, Persona persona) {
        this.puesto = puesto;
        this.persona = persona;
    }

    public int getPuesto() {
        return puesto;
    }

    public String getNombre() {
        return persona.getNombre();
    }

    public String getRol() {
        return persona.getRol();
    }

    public int getEcoPuntos() {
        return persona.getEcopuntos();
    }

    public String getCategoria() {
        if (puesto <= TAMANIO_TOP) {
            return "Top " + TAMANIO_TOP;
        }
        return "Resto";
    }
}