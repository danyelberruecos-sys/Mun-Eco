package co.eia;

import java.util.ArrayList;

public class Historial {

	private Persona persona;
 	private ArrayList <Movimiento> movimientos = new ArrayList();
 	
 	public Historial (Persona persona) {
 		this.persona = persona;
 	}
 	
 	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("HISTRIAL DE " + persona.getNombre().toUpperCase());
		for (int i = 0 ; i < movimientos.size(); i++) {
			movimientos.get(i).mostrar();
		}
 	}
 	
 	public void agregarMovimiento(Movimiento movimiento) {
 		movimientos.add(movimiento);
 	}
 	
 	public int getEcopuntosTotales() {
 		int total = 0;
 		for (int i = 0; i < movimientos.size(); i++) {
 			total += movimientos.get(i).getCantidad();
 		}
 		return total;
 	}
}
