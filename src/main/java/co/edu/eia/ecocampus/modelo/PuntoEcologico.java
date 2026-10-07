package co.edu.eia.ecocampus.modelo;

import java.util.ArrayList;

public class PuntoEcologico implements Identificable {
	
	private long id;
	private String ubicacion;
	private int capacidad;
	private boolean lleno;
	private boolean activo; 
	private ArrayList <Material> materialesAdmitidos = new ArrayList<>();
	
	public PuntoEcologico(long id, String ubicacion, int capacidad, boolean lleno, boolean activo) {
		this.id = id;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.lleno = lleno;
		this.activo = activo;
	}
	
	public void agregarMaterial(Material material) {
		materialesAdmitidos.add(material);
	}
	
	public long getId() {return id;}
	

	
	public void inactivar(Notificador notificador) {
		this.activo = false;
		notificador.notificar("El punto ecologico de ID " + id + " \nse cerro correctamente");
	}
	
	public int getCapacidad() {return capacidad;}
	
	public String getUbicacion() {return ubicacion;}
	
	public boolean getActivo() {return activo;}
	
	public String getEstadoTexto() {
	    return activo ? "Activo" : "Inactivo";
	}

	public String getLlenoTexto() {
	    return lleno ? "Sí" : "No";
	}

	public String getMaterialesTexto() {
	    String texto = "";
	    for (int i = 0; i < materialesAdmitidos.size(); i++) {
	        if (i > 0) {
	            texto = texto + ", ";
	        }
	        texto = texto + materialesAdmitidos.get(i).getNombre();
	    }
	    return texto;
	}

}
