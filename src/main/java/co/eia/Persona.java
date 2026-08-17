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

	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
