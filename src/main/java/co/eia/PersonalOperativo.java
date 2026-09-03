package co.eia;

public class PersonalOperativo extends Persona {
	
	private boolean disponible;
	private String accionesPermitidas;
	
	public PersonalOperativo(int id, String correo,String nombre, boolean disponible, String accionesPermitidas) {
		super(id, correo, nombre);
		this.disponible = disponible;
		this.accionesPermitidas = accionesPermitidas;
	}

	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("Nombre: " + nombre);
		System.out.println("ID: " + id);
		System.out.println("Correo: " + correo);
		System.out.println("EcoPuntos: " + ecoPuntos);
		if(disponible) {
			System.out.println("Disponibilidad: Disponible");
		}else {System.out.println("Disponibilidad: Ocupado");}
		System.out.println("Acciones: " + accionesPermitidas);
		System.out.println("=======================================");
	}
	
	public void setDisponibilidad(boolean disponible) {
		this.disponible = disponible;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
}
