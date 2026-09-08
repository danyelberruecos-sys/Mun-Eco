package co.eia;

public class Actividad implements Verificable{
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
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("Nombre: " + nombre);
		System.out.println("ID: " + id);
		System.out.println("Tipo: " + tipo);
		System.out.println("Fecha: " + fecha);
		System.out.println("=======================================");
	}
}
