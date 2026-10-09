package co.edu.eia.ecocampus.modelo;

public class Participacion {

	private String fechaInscripcion;
	private Usuario usuario;
	private Campania campania;
	
	public Participacion(String fechaInscripcion, Usuario usuario, Campania campania) {
		this.fechaInscripcion = fechaInscripcion;
		this.usuario = usuario;
		this.campania = campania;
	}
	

	public Usuario getUsuario() {return usuario;}
}
