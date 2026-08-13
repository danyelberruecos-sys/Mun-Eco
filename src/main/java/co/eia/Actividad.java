package co.eia;

public class Actividad {
	private int codigo;
	private String nombre;
	private String tipo;
	private String fecha;
	
	
	// constructor
	public Actividad(String tipo, String fecha) {
		this.tipo = tipo;
		this.fecha = fecha;
	}
	
	// getter de codigo
	public int getCodigo() {
		return codigo;
	}
	
	
	//Mostrar información básica
	public void mostrar() {
		System.out.println("----------------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Código: " + codigo);
		System.out.println("Fecha: " + fecha);
		System.out.println("----------------------------");
	}
	
}
