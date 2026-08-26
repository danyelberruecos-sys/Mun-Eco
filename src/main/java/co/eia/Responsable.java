package co.eia;

import java.util.ArrayList;
import java.util.Scanner;

public class Responsable extends Persona{
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
	
	@Override
	public void mostrar() {
		super.mostrar();
		if (disponible) {
			System.out.println("Disponibilidad: disponible");
		}else{System.out.println("Disponibilidad: Ocupado");}
		System.out.println("Acciones: " + accionesPermitidas);
		System.out.println("-----------------------");
	}
	
	
	
	
	public void registrar(ArrayList<Responsable> responsables) {
		System.out.println("------REGISTRO------");
		System.out.println("Ingrese el nombre: ");
		setNombre(scanner.nextLine());
		autenticarCodigo(responsables);
		scanner.nextLine();
		System.out.println("Igrese correo: ");
		setCorreo(scanner.nextLine());
	}


	public void autenticarCodigo(ArrayList<Responsable> responsables) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese ID unico del responable: ");
		setId(scanner.nextInt()); 
		for (int i = 0; i < responsables.size(); i++) {
			unico = verificar(responsables.get(i), i);
			if(!unico) {
				System.out.println("Error, el ID del responsable ya esta en uso...\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(Responsable evaluado, int i) {
		if(evaluado.getId() == getId()) {
			return false;
		}else {return true;}
	}
	
	
	
}
