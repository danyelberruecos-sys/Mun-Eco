package co.eia;

import java.util.ArrayList;

public abstract class Persona implements Verificable {
	protected long id;
	protected String correo;
	protected String nombre;
	protected int ecoPuntos;
	
	

	public Persona(long id, String correo, String nombre) {
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
	}
	
	public long getId() {return id;}
	
	public void setId(long id) {this.id = id;}
	
	public String getCorreo() {return correo;}
	
	public void setCorreo(String correo) {this.correo = correo;}
	
	public String getNombre() {return nombre;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public void setEcopuntos(int ecoPuntos) {this.ecoPuntos= ecoPuntos;}
	
	public int getEcopuntos() {return ecoPuntos;}
	
	public abstract void mostrar();
	
	
}
