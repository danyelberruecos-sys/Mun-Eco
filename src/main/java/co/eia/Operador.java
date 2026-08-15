package co.eia;

import java.util.Scanner;

public class Operador extends Persona {
	private boolean disponible;
	private String accionesPermitidas;
	
	Scanner scanner = new Scanner(System.in);
	
	public void setDisponible() {
		System.out.println("Disponibilidad Si o No: ");
		String n = scanner.nextLine();
		n.toLowerCase();
		if(n == "si") {
			disponible = true;
		}else {disponible = false;}
		
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public void setAcciones() {
		System.out.println("Ingrese las acciones permitidas separadas por comas: ");
		accionesPermitidas = scanner.nextLine();
	}
	
	public void setAcciones(String accionesPermitidas) {
		this.accionesPermitidas = accionesPermitidas;
	}
}

