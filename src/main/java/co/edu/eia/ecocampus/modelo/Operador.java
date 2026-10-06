package co.edu.eia.ecocampus.modelo;

public class Operador extends PersonalOperativo {
	
	
	public Operador(long id, String correo,String nombre, boolean disponible, String accionesPermitidas) {
		super(id, correo, nombre, disponible, accionesPermitidas);
	}
	
	@Override
	public String getRol() {
	    return "Operador";
	}

}
