package co.edu.eia.ecocampus.modelo;

public class Responsable extends PersonalOperativo {
	private String areaReponsabilidad;
	
	public Responsable(long id, String correo,String nombre, boolean disponible, String accionesPermitidas, String areaResponsable) {
		super(id, correo, nombre, disponible, accionesPermitidas);
		this.areaReponsabilidad = areaResponsable;
	}
	
	@Override
	public String getRol() {
	    return "Responsable";
	}
}
