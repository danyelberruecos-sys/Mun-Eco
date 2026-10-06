package co.edu.eia.ecocampus.modelo;

public class MaterialOrganico extends Material {

	public MaterialOrganico(String nombre, int cantidad) {
		super(nombre, cantidad);
	}
	
	public int calcularValorPuntos() {return 1;}
	
 
}
