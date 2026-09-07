package co.eia;

public class Movimiento {
	
	private String concepto;
	private String fecha;
	private int cantidad;
	
	public Movimiento(String concepto, String fecha, int cantidad) {
		this.concepto = concepto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("Concepto: " + concepto);
		System.out.println("Fecha: " + fecha);
		System.out.println("Cantidad: " + cantidad + " eco-puntos");
		System.out.println("=======================================");
	}
	
	public int getCantidad() {return cantidad;}
	
	
	
	

}
