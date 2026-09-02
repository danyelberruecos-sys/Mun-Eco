package co.eia;

import java.util.Scanner;

public class Usuario extends Persona {
	
	private String tipo;
	
	public Usuario(int id, String correo, String nombre, String tipo) {
		super(id,correo,nombre);
		this.tipo = tipo;
	}
	
	public void mostrar() {
		System.out.println("===================================");
		System.out.println("Nombre: " + nombre);
		System.out.println("ID: " + id);
		System.out.println("Correo: " + correo);
		System.out.println("EcoPuntos: " + ecoPuntos);
		System.out.println("Tipo: " + tipo);
		System.out.println("===================================");
	}
	
	public void setTipo(String tipo) {this.tipo = tipo;}
	
	public void setTipo() {
		Scanner scanner = new Scanner(System.in);
		tipo = scanner.nextLine();
	}
	
	public String getTipo() {return tipo;}
	
	public void registrar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese nombre: ");
		nombre = scanner.nextLine();
		System.out.println("Ingrese el ID:");
	}
}
