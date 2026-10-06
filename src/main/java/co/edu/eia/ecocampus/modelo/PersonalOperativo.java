package co.edu.eia.ecocampus.modelo;

public abstract class PersonalOperativo extends Persona {
	
	private boolean disponible;
	private String accionesPermitidas;
	
	public PersonalOperativo(long id, String correo,String nombre, boolean disponible, String accionesPermitidas) {
		super(id, correo, nombre);
		this.disponible = disponible;
		this.accionesPermitidas = accionesPermitidas;
	}

	
	
	public void setDisponibilidad(boolean disponible) {
		this.disponible = disponible;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
	
	public String getAccionesPermitidas() {return accionesPermitidas;}
}
