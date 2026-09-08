package co.eia;   //Falta inscribir participante

import java.util.ArrayList;

public class Campania implements Verificable {
	
	private long id;
	private String fecha;
	private int cupo;
	private String estado;
	private ArrayList <Actividad> actividades;
	private ArrayList <Participacion> participaciones;
	
	public Campania(long id, String fecha, int cupo) {
		this.id = id;
		this.fecha = fecha;
		this.cupo = cupo;
		this.estado = "ACTIVA";
	}
	
	public void agregarActividad(Actividad actividad) {
		actividades.add(actividad);
	}
	
	public void incribirParticipante() {
		
	}
	
	public void cerrar(Notificador notificador) {
		this.estado = "CERRADO";
		notificador.notificar("La acitividad con el ID " + id + 
							"\nfue cerrada correctamente");
	}
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("ID: " + id);
		System.out.println("Estado: " + estado);
		System.out.println("Fecha: " + fecha);
		System.out.println("Cupo: " + cupo);
		System.out.println("Actividades: ");
		if (actividades.size() == 0) {
			System.out.println("No hay actividades registradas");
		}else {
			for (int i = 0; i < actividades.size(); i++) {
				System.out.println("- " + actividades.get(i).getNombre());
			}
		}
		System.out.println("Participantes: ");
		if (participaciones.size() == 0) {
			System.out.println("No hay participantes incritos");
		}else {
			for (int i = 0; i < participaciones.size(); i++) {
				System.out.println("- " + participaciones.get(i).getUsuario().getNombre());
			}
		}
		System.out.println("=======================================");
	}
	
	
	public long getId() {return id;}
	
	public String getEstado() {return estado;}
	
	public int getCupo() {return cupo;}
	
	public ArrayList<Participacion> getParticipaciones() {return participaciones;}
		

}
