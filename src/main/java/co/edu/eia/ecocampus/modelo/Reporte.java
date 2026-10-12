package co.edu.eia.ecocampus.modelo;


public class Reporte implements Identificable{

	private long id;
	private String fecha;
	private int prioridad;
	private String descripcion;
	private String estado;
	private Operador operadorAsignado = null;
	private RutaRecoleccion rutaAsignada = null;
	private Persona autor;
	private String tipo;
	private PuntoEcologico puntoEcologico;
	
	public Reporte(long id, Persona autor, PuntoEcologico punto, String fecha, 
			String descripcion,String tipo, int prioridad) {
		
		this.id = id;
		this.autor = autor;
		this.puntoEcologico = punto;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.prioridad = prioridad;
		this.estado = "REGISTRADO";
	}
	
	public void asignarOperador(Operador operador, Notificador notificador) {
	    if (rutaAsignada != null) {
	        notificador.notificar("Solo se puede tener un operador o una ruta asignada.\n"
	                            + "Por lo tanto la ruta previamente asignada fue removida\n"
	                            + "del reporte.");
	        rutaAsignada = null;
	    }
	    this.operadorAsignado = operador;
	    this.estado = "ASIGNADO";
	}
	
	public void asignarRuta(RutaRecoleccion ruta, Notificador notificador) {
	    if (operadorAsignado != null) {
	        notificador.notificar("Solo se puede tener un operador o una ruta asignada.\n"
	                            + "Por lo tanto el operador previamente asignado fue removido\n"
	                            + "del reporte.");
	        operadorAsignado = null;
	    }
	    this.rutaAsignada = ruta;
	    this.estado = "ASIGNADO";
	}
	
	
	public boolean tieneAsignacion() {
		return operadorAsignado != null || rutaAsignada != null;
	}
	
	public void cerrar(Notificador notificador) {
		this.estado = "CERRADO";
		notificador.notificar("El reporte con el id " + id + " fue cerrado");
	}
	

	
    public long getId() { return id; }
    
    public String getEstado() { return estado; }
    
    public String getTipo() { return tipo; }
    
    public PuntoEcologico getPunto() { return puntoEcologico; }
    
    public Persona getAutor() { return autor; }
    
    public String getPrioridadTexto() {
        if (prioridad == 1) {
            return "Baja";
        }
        if (prioridad == 2) {
            return "Media";
        }
        return "Alta";
    }
    
    public Operador getOperadorAsignado() { return operadorAsignado; }
    
    public String getFecha() {return fecha;}
    
    public String getAutorNombre() {
        return autor.getNombre();
    }
    
    public String getUbicacionPunto() {
        return puntoEcologico.getUbicacion();
    }
    
    public String getAsignadoA() {
        if (operadorAsignado != null) {
            return "Operador: " + operadorAsignado.getNombre();
        }
        if (rutaAsignada != null) {
            return "Ruta: " + rutaAsignada.getId();
        }
        return "Sin asignar";
    }
    
    @Override
    public String toString() {
        return "Reporte " + id + " - " + tipo + " (" + puntoEcologico.getUbicacion() + ")";
    }
		
}
