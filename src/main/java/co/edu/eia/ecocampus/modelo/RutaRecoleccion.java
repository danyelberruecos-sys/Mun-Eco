package co.edu.eia.ecocampus.modelo;

import java.util.ArrayList;

public class RutaRecoleccion implements Identificable {
	
	private ArrayList <Parada> paradas = new ArrayList<>();
	private long id;
	private boolean activa;
	
	public RutaRecoleccion(long id, boolean activa) {
		this.id = id;
		this.activa = activa;
	}
	
	public void agregarParada(Parada parada) {
		paradas.add(parada);
	}
	
	public long getId() {return id;}
	
	public boolean getActiva() {return activa;}
	
	public ArrayList <Parada> getParadas(){
		return paradas;
	}
	
	public void cerrar(Notificador notificador) {
	    if (activa) {
	        activa = false;
	        notificador.notificar("Se cerró con éxito la ruta con el siguiente ID:\n" + id);
	    }
	}
	
	public String getEstadoTexto() {
	    return activa ? "Activa" : "Cerrada";
	}

	public int getCantidadParadas() {
	    return paradas.size();
	}

}
