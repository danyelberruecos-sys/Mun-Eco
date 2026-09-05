package co.eia;

import java.util.ArrayList;

public class PuntoEcologico implements Verificable {
	
	private long id;
	private String ubicacion;
	private int capacidad;
	private boolean lleno;
	private boolean activo; 
	private ArrayList <Material> materialesAdmitidos = new ArrayList();
	
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
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("ID: " + id);
		System.out.println("Ubicacion: " + ubicacion );
		System.out.println("Capacidad: " + capacidad);
		if (lleno) {
			System.out.println("El punto ecologico esta lleno");
		}else {System.out.println("El punto ecologico aun tinene capacidad");}
		if (activo) {
			System.out.println("El punto ecologico esta activo");
		}else {System.out.println("El punto ecologico esta inactivo");}
		System.out.println("Materiales: ");
		for (int i = 0; i < materialesAdmitidos.size();i++) {
			System.out.println("-"+ materialesAdmitidos.get(i).getNombre());
		}
		System.out.println("=======================================");
	}
	
	public String getUbicacion() {return ubicacion;}
	
	public boolean getActivo() {return activo;}
	
	public void setActivo(boolean activo) {this.activo = activo;}

}
