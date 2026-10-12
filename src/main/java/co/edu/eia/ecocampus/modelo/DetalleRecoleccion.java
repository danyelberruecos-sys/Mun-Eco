package co.edu.eia.ecocampus.modelo;

public class DetalleRecoleccion {

    private Material material;
    private double peso;

    public DetalleRecoleccion(Material material, double peso) {
        this.material = material;
        this.peso = peso;
    }

    public Material getMaterial() {
        return material;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return material.getNombre();
    }
}