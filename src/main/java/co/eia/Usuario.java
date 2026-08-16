package co.eia;

import java.util.Scanner;

public class Usuario extends Persona{
	private String tipo;
	
	Scanner scanner = new Scanner(System.in);
	
	//Setter con scanner
	public void setTipo() {
		System.out.println("Ingrese el tipo: ");
		tipo = scanner.nextLine();
		
	}
	
	//Setter normal
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void mostrar() {
		System.out.println("----------------------------");
		System.out.println("Nombre: " + getNombre());
		System.out.println("id: " + getId());
		System.out.println("Correo: " + getCorreo());
		System.out.println("Tipo: " + tipo);
		System.out.println("----------------------------");
	}
}
