package co.eia;

public abstract class Persona {
	protected int id;
	protected String correo;
	protected String nombre;
	protected int ecoPuntos;
	
	public Persona(int id, String correo, String nombre) {
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
	}
	
	public int getId() {return id;}
	
	public void setId(int id) {this.id = id;}
	
	public String getCorreo() {return correo;}
	
	public void setCorreo(String correo) {this.correo = correo;}
	
	public String getNombre() {return nombre;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public void setEcopuntos(int ecoPuntos) {this.ecoPuntos= ecoPuntos;}
	
	public int getEcopuntos() {return ecoPuntos;}
	
	public abstract void mostrar();
	
}
