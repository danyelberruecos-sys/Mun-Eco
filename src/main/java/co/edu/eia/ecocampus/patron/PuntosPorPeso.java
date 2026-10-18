package co.edu.eia.ecocampus.patron;

import co.edu.eia.ecocampus.modelo.EstrategiaPuntos;

public class PuntosPorPeso implements EstrategiaPuntos {

    private int factor;

    public PuntosPorPeso(int factor) {
        this.factor = factor;
    }

    @Override
    public int calcular(double peso) {
        return (int) Math.round(peso * factor);
    }
}