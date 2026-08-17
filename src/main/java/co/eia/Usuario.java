package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

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
	
	public void registrar(ArrayList<Usuario> usuarios) {
		System.out.println("------REGISTRO------");
		System.out.println("Ingrese el nombre: ");
		setNombre(scanner.nextLine());
		autenticarCodigo(usuarios);
		scanner.nextLine();
		System.out.println("Igrese correo: ");
		setCorreo(scanner.nextLine());
	}


	public void autenticarCodigo(ArrayList<Usuario> usuarios) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese ID unico de la persona: ");
		setId(scanner.nextInt()); 
		for (int i = 0; i < usuarios.size(); i++) {
			unico = verificar(usuarios.get(i), i);
			if(!unico) {
				System.out.println("Error, el ID del usuario ya esta en uso...'\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(Usuario evaluado, int i) {
		if(evaluado.getId() == getId()) {
			return false;
		}else {return true;}
	}
	
}
