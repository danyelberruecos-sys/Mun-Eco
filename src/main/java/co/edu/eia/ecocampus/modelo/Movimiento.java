package co.edu.eia.ecocampus.modelo;

public class Movimiento {
	
	private String concepto;
	private String fecha;
	private int puntos;
	
	public Movimiento(String concepto, String fecha, int puntos) {
		this.concepto = concepto;
		this.fecha = fecha;
		this.puntos = puntos;
	}
	

	
	public int getPuntos() {return puntos;}
	
	public String getFecha() {return fecha;}
	
	public String getConcepto() {return concepto;}
	
	
	
	

}
