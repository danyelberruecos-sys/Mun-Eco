package co.eia;

public abstract class Persona implements Verificable {
	protected long id;
	protected String correo;
	protected String nombre;
	protected Historial historial;

	public Persona(long id, String correo, String nombre) {
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.historial = new Historial(this);
	}
	
	public void sumarEcoPuntos(int puntos, String concepto, String fecha) {
	    if (puntos > 0) {
	        Movimiento movimiento = new Movimiento(concepto, fecha, puntos);
	        historial.agregarMovimiento(movimiento);
	    }
	}
	
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public String getCorreo() {return correo;}
	public void setCorreo(String correo) {this.correo = correo;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public int getEcopuntos() {return historial.getEcopuntosTotales();}
	public Historial getHistorial() {return historial;}
	
	public abstract void mostrar();
}