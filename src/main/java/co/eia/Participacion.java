package co.eia;

public class Participacion {

	private String fechaInscripcion;
	private Usuario usuario;
	private Campania campania;
	
	public Participacion(String fechaInscripcion, Usuario usuario, Campania campania) {
		this.fechaInscripcion = fechaInscripcion;
		this.usuario = usuario;
		this.campania = campania;
	}
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("Participante: " + usuario.getNombre());
		System.out.println("Fecha de inscripcion: " + fechaInscripcion);
		System.out.println("Campania: " + campania.getId());
		System.out.println("=======================================");
	}
	
	public Usuario getUsuario() {return usuario;}
}
