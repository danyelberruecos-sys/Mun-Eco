package co.eia;

import java.util.ArrayList;

public class Campania {
	private int id;
	private String fecha;
	private int cupo;
	private String estado;
	private ArrayList <Actividad> actividades;
	
	
	public Campania(int id, String fecha, int cupo, String estado) {
		this.id = id;
		this.fecha = fecha;
		this.cupo = cupo;
		this.estado = estado;
	}
	
	
	//Antes hacer un for que muestre la lista de actividades
	public void agrgarActividad(ArrayList <Actividad> listaActividades, int busqueda) {
		for(int i = 0; i <listaActividades.size(); i++) {
			if (busqueda == listaActividades.get(i).getCodigo()) {
				actividades.add(listaActividades.get(i));
				break;
			}
		}
	}
	
	
}
