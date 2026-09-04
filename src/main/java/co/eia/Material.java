package co.eia;

public abstract class Material {

	private String nombre;
	private int cantidad;
	
	public Material(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public abstract int calcularValorPuntos();
	
	public String getNombre() {return nombre;}
	
	public int getCantidad() {return cantidad;}
	

}
