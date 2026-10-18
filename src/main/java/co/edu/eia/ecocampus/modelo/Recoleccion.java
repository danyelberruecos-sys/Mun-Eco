package co.edu.eia.ecocampus.modelo;

import java.util.ArrayList;

public class Recoleccion implements Identificable{
	
    private long id;
    private ArrayList <Material> materiales = new ArrayList<>();
    private ArrayList <Double> pesos = new ArrayList<>();
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
    
    public String getObservaciones() {
        return observaciones;
    }
    

    
 
    public int calcularEcoPuntos() {
        int puntos = 0;
        for (int i = 0; i < materiales.size(); i++) {
            puntos += materiales.get(i).calcularPuntos(pesos.get(i));
        }
        return puntos;
    }
    
    public long getId() {return id;}
    
    public Reporte getReporteAsociado() {return reporteAsociado;}
    
    public ArrayList<Material> getMateriales() { return materiales; }
    
    public ArrayList<Double> getPesos() { return pesos; }
    
    public long getReporteId() {
        return getReporteAsociado().getId();
    }

    public String getOperadorNombre() {
        return operadorResponsable.getNombre();
    }

    public String getMaterialesTexto() {
        String texto = "";
        ArrayList<Material> materiales = getMateriales();
        ArrayList<Double> pesos = getPesos();

        for (int i = 0; i < materiales.size(); i++) {
            if (i > 0) {
                texto = texto + ", ";
            }
            texto = texto + materiales.get(i).getNombre() + " (" + pesos.get(i) + " kg)";
        }
        return texto;
    }

    public int getEcoPuntosCalculados() {
        return calcularEcoPuntos();
    }
}
