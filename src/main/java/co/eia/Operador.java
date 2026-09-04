package co.eia;

public class Operador extends PersonalOperativo {
	
	
	public Operador(long id, String correo,String nombre, boolean disponible, String accionesPermitidas) {
		super(id, correo, nombre, disponible, accionesPermitidas);
	}
	
	@Override
	public void mostrar() {
		super.mostrar();
		System.out.println("=======================================");
	}

}
