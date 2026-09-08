package co.eia;

import java.util.ArrayList;

public class Recoleccion implements Verificable{
	
    private long id;
    private ArrayList <Material> materiales = new ArrayList();
    private ArrayList <Double> pesos = new ArrayList();
    private String observaciones;
    private Operador operadorResponsable;
    private Reporte reporteAsociado;

    
    public Recoleccion(long id, String observaciones, Operador operadorResponsable, Reporte reporteAsociado) {
        this.id = id;
        this.observaciones = observaciones;
        this.operadorResponsable = operadorResponsable;
        this.reporteAsociado = reporteAsociado;
    }
    
    public void agregarMaterial(Material material, double peso) {
        materiales.add(material);
        pesos.add(peso);
    }
    
    public double getPesoTotal() {
        double total = 0;
        for (int i = 0; i < pesos.size(); i++) {
            total += pesos.get(i);
        }
        return total;
    }
    
    public void mostrar() {
        System.out.println("=======================================");
        System.out.println("ID: " + id);
        System.out.println("Operador responsable: " + operadorResponsable.getNombre());
        System.out.println("Reporte asociado: " + reporteAsociado.getId());
        System.out.println("Observaciones: " + observaciones);
        System.out.println("Materiales recolectados:");
        for (int i = 0; i < materiales.size(); i++) {
            System.out.println("-" + materiales.get(i).getNombre() + ": " + pesos.get(i) + " kg");
        }
        System.out.println("Peso total: " + getPesoTotal() + " kg");
        System.out.println("=======================================");
    }
    
 
    public int calcularEcoPuntos() {
        int puntos = 0;
        for (int i = 0; i < materiales.size(); i++) {
            puntos += (int) Math.round(pesos.get(i) * materiales.get(i).calcularValorPuntos());
        }
        return puntos;
    }
    
    public long getId() {return id;}
    
    public Reporte getReporteAsociado() {return reporteAsociado;}
    
    public ArrayList<Material> getMateriales() { return materiales; }
    
    public ArrayList<Double> getPesos() { return pesos; }
}
