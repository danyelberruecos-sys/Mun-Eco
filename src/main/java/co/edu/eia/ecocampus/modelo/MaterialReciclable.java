package co.edu.eia.ecocampus.modelo;

public class MaterialReciclable extends Material {
	
	public MaterialReciclable(String nombre, int cantidad) {
		super(nombre, cantidad);
	}
	
	public int calcularValorPuntos() {return 2;}
}
