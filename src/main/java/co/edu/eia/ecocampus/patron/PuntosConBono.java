package co.edu.eia.ecocampus.patron;

import co.edu.eia.ecocampus.modelo.EstrategiaPuntos;

public class PuntosConBono implements EstrategiaPuntos {

    private int factor;
    private int multiplicador;

    public PuntosConBono(int factor, int multiplicador) {
        this.factor = factor;
        this.multiplicador = multiplicador;
    }

    @Override
    public int calcular(double peso) {
        return (int) Math.round(peso * factor * multiplicador);
    }
}