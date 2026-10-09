package co.edu.eia.ecocampus.modelo;

public class Movimiento {
	
	private String concepto;
	private String fecha;
	private int cantidad;
	
	public Movimiento(String concepto, String fecha, int cantidad) {
		this.concepto = concepto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}
	

	
	public int getCantidad() {return cantidad;}
	
	
	
	

}
