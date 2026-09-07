package co.eia;

public class Reporte implements Verificable{

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
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("ID: " + id);
		System.out.println("Tipo: " + tipo);
		System.out.println("Autor: " + autor.getNombre());
		System.out.println("PuntoEcologico: " + puntoEcologico.getUbicacion());
		System.out.println("Fecha: " + fecha);
		System.out.println("Estado: " + estado);
		System.out.println("Nivel de prioridad: Nivel " + prioridad);
		System.out.println("Descripcion: " + descripcion);
		if(rutaAsignada != null) {
			System.out.println("Ruta asignada: " + rutaAsignada.getId());
		}
		if(operadorAsignado != null) {
			System.out.println("Operador asignado " + operadorAsignado.getId());
		}
		System.out.println("=======================================");

	}
	
    public long getId() { return id; }
    
    public String getEstado() { return estado; }
    
    public String getTipo() { return tipo; }
    
    public PuntoEcologico getPunto() { return puntoEcologico; }
    
    public Persona getAutor() { return autor; }
    
    public int getPrioridad() { return prioridad; }
    
    public Operador getOperadorAsignado() { return operadorAsignado; }
    
    public String getFecha() {return fecha;}
		
}
