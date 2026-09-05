package co.eia;

public class Parada {

	private PuntoEcologico puntoEcologico;
	private String accionEsperada;
	private int orden;
	
	public Parada(int orden, String accionEsperada) {
		this.orden = orden;
		this.accionEsperada = accionEsperada;
	}
	
	public void setPuntoEcologico(PuntoEcologico puntoEcologico) {
		this.puntoEcologico = puntoEcologico;
	}
	
	public String mostrar() {
		String mostrar = "Parada #" + orden + " , Accion a realizar: " + accionEsperada + " ,Punto ecologico: " + puntoEcologico.getId();
		return mostrar;
	}
	
	public int getOrden() {return orden;}
	
}
