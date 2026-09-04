package co.eia;

public class Responsable extends PersonalOperativo {
	private String areaReponsabilidad;
	
	public Responsable(long id, String correo,String nombre, boolean disponible, String accionesPermitidas, String areaResponsable) {
		super(id, correo, nombre, disponible, accionesPermitidas);
		this.areaReponsabilidad = areaResponsable;
	}
	
	@Override
	public void mostrar() {
		super.mostrar();
		System.out.println("Area responsabilidad: " + areaReponsabilidad);
		System.out.println("=======================================");
	}
}
