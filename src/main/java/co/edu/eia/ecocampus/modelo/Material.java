package co.edu.eia.ecocampus.modelo;

public abstract class Material {

	private String nombre;
	private int cantidad;
	private EstrategiaPuntos estrategia;

	
	public Material(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public void setEstrategia(EstrategiaPuntos estrategia) {
	    this.estrategia = estrategia;
	}
	
	public int calcularPuntos(double peso) {
	    return estrategia.calcular(peso);
	}
	
	public String getNombre() {return nombre;}
	
	public int getCantidad() {return cantidad;}
	
	public abstract int calcularValorPuntos();

}
