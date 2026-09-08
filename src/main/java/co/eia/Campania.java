package co.eia;  

import java.util.ArrayList;

public class Campania implements Verificable {
	
	private long id;
	private String fecha;
	private int cupo;
	private String estado;
	private ArrayList <Actividad> actividades = new ArrayList();
	private ArrayList <Participacion> participaciones = new ArrayList();
	private int puntosPorParticipacion;
	
	public Campania(long id, String fecha, int cupo, int puntosPorParticipacion) {
		this.id = id;
		this.fecha = fecha;
		this.cupo = cupo;
		this.estado = "ACTIVA";
		this.puntosPorParticipacion = puntosPorParticipacion;
	}
	
	public void agregarActividad(Actividad actividad) {
		actividades.add(actividad);
	}
	
	public void inscribirParticipante(Usuario usuario, String fechaInscripcion, Notificador notificador) {
	    Participacion nuevaParticipacion = new Participacion(fechaInscripcion, usuario, this);
	    participaciones.add(nuevaParticipacion);
	    
	    if (participaciones.size() == cupo) {
	        notificador.notificar("La campania con ID " + id + " alcanzo su cupo maximo de " + cupo + " participantes.");
	    }
	}
	
	public void cerrar(Notificador notificador) {
	    this.estado = "CERRADA";
	    
	    for (int i = 0; i < participaciones.size(); i++) {
	        Usuario participante = participaciones.get(i).getUsuario();
	        String concepto = "Participacion en campania #" + id;
	        participante.sumarEcoPuntos(puntosPorParticipacion, concepto, fecha);
	    }
	    
	    notificador.notificar("La campania con ID " + id + " \n"
	    					+ "ha sido cerrada. \n"
	    					+ "Se otorgaron eco-puntos a\n"
	    					+ " " + participaciones.size() + " participantes.");
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
