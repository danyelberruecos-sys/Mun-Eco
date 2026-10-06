package co.edu.eia.ecocampus.modelo;

import java.util.ArrayList;

import java.util.Scanner;

public class Usuario extends Persona {
	
	private String tipo;
	
	public Usuario(long id, String correo, String nombre, String tipo) {
		super(id,correo,nombre);
		this.tipo = tipo;
	}
	
	
	public void setTipo(String tipo) {this.tipo = tipo;}
	
	
	public String getTipo() {return tipo;}
	
	@Override
	public String getRol() {
	    return "Usuario";
	}
	
}
