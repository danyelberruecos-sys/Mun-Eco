package co.eia;

import java.util.Scanner;

public class Persona {
	private int id;
	private String nombre;
	private String correo;
	
	Scanner scanner = new Scanner(System.in);
	
	public Persona(int id, String nombre, String correo) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
	}
	
	// Constructor vacío para que las herencias no pongan problema
	public Persona() {
	}
	
	public void registrar() {
		System.out.println("------REGISTRO------");
		System.out.println("Ingrese el nombre: ");
		nombre = scanner.nextLine();
		System.out.println("Ingrese id: ");
		id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Igrese correo: ");
		correo = scanner.nextLine();
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}

}
