package co.eia;

public class MaterialEspecial extends Material{
	
	public MaterialEspecial(String nombre, int cantidad) {
		super(nombre, cantidad);
	}
	
	public int calcularValorPuntos() {return 5;}

}
