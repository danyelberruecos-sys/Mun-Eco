package co.eia;

import java.util.ArrayList;

public class RutaRecoleccion implements Verificable {
	
	private ArrayList <Parada> paradas = new ArrayList();
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
	
	public ArrayList <Parada> getParadas(){
		return paradas;
	}
	
	public void cerrar(Notificador notificador) {
		
		String mensaje = "Se cerro con exito a ruta con el siguiente ID:\n" + id;
		
		if (activa) {
			activa = false;
			notificador.notificar(mensaje);
		}else {
			System.out.println("Error, la ruta de recoleccino ya estaba cerrada...");
		}
	}
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("ID: " + id);
		if (activa) {
			System.out.println("La ruta de recoleccion esta activa");
		}else {
			System.out.println("La ruta de recoleccion esta cerrada");
		}
		System.out.println("Paradas:");
		for (int i = 0; i < paradas.size();i++) {
			System.out.println("-" + paradas.get(i).mostrar());
		}
		System.out.println("=======================================");

	}

}
