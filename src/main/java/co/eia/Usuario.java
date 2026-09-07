package co.eia;

import java.util.ArrayList;

import java.util.Scanner;

public class Usuario extends Persona {
	
	private String tipo;
	
	public Usuario(long id, String correo, String nombre, String tipo) {
		super(id,correo,nombre);
		this.tipo = tipo;
	}
	
	public void mostrar() {
		System.out.println("=======================================");
		System.out.println("Nombre: " + nombre);
		System.out.println("ID: " + id);
		System.out.println("Correo: " + correo);
		System.out.println("EcoPuntos: " + getEcopuntos());
		System.out.println("Tipo: " + tipo);
		System.out.println("=======================================");
	}
	
	public void setTipo(String tipo) {this.tipo = tipo;}
	
	
	public String getTipo() {return tipo;}
	
	
	
}
