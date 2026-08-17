package co.eia;

public class Parada {
	private int numero;
	private String accionEsperada;
	private PuntoEcologico puntoRelacionado;
	
	public Parada (int numero, String accionEsperada) {
		this.numero = numero;
		this.accionEsperada = accionEsperada;
	}

	public void mostrar() {
		System.out.println("----------------------------");
		System.out.println("Numero: " + numero);
		System.out.println("Ubicación" + puntoRelacionado.getUbicacion());
		System.out.println("----------------------------");
	}
	
	//getter numero
	public int getnumero() {
		return numero;
	}
	//Falta hacer el setter para elegir el punto ecologico relacionado
	
}
