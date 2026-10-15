package co.edu.eia.ecocampus.modelo;

public class ResumenMateriales {

    private double reciclable;
    private double organico;
    private double especial;

    public ResumenMateriales(double reciclable, double organico, double especial) {
        this.reciclable = reciclable;
        this.organico = organico;
        this.especial = especial;
    }

    public double getReciclable() {
        return reciclable;
    }

    public double getOrganico() {
        return organico;
    }

    public double getEspecial() {
        return especial;
    }

    public double getTotal() {
        return reciclable + organico + especial;
    }
}