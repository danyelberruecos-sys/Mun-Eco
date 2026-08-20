package co.eia;

import java.util.ArrayList;
import java.util.Scanner;

public class Operador extends Persona {
	private boolean disponible;
	private String accionesPermitidas;
	
	Scanner scanner = new Scanner(System.in);
	
	public void setDisponible() {
		System.out.println("Disponibilidad Si o No: ");
		String n = scanner.nextLine();
		if(n.equalsIgnoreCase("si")) {
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
	
	public boolean getDisponible() {
		return disponible;
	}
	
	public void mostrar() {
		System.out.println("-----------------------");
		System.out.println("Nombre: " + getNombre());
		System.out.println("id: " + getId());
		System.out.println("Correo: " + getCorreo());
		if (disponible) {
			System.out.println("Disponibilidad: disponible");
		}else{System.out.println("Disponibilidad: Ocupado");}
		System.out.println("Acciones: " + accionesPermitidas);
	}
	
	
	public void registrar(ArrayList<Operador> operadores) {
		System.out.println("------REGISTRO------");
		System.out.println("Ingrese el nombre: ");
		setNombre(scanner.nextLine());
		autenticarCodigo(operadores);
		scanner.nextLine();
		System.out.println("Igrese correo: ");
		setCorreo(scanner.nextLine());
	}


	public void autenticarCodigo(ArrayList<Operador> operadores) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese ID unico del operador: ");
		setId(scanner.nextInt()); 
		for (int i = 0; i < operadores.size(); i++) {
			unico = verificar(operadores.get(i), i);
			if(!unico) {
				System.out.println("Error, el ID del Operador ya esta en uso...\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(Operador evaluado, int i) {
		if(evaluado.getId() == getId()) {
			return false;
		}else {return true;}
	}
}

