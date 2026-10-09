package co.edu.eia.ecocampus.modelo;

public class Actividad implements Identificable{
	private long id;
	private String nombre;
	private String tipo;
	private String fecha;
	
	public Actividad(long id, String nombre, String tipo,  String fecha) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
	}
	
	public long getId() {return id;}
	
	public String getNombre() {return nombre;}
	

}
