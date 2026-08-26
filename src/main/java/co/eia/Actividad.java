package co.eia;

import java.util.ArrayList;
import java.util.Scanner;

public class Actividad {
	private int codigo;
	private String nombre;
	private String tipo;
	private String fecha;
	
	Scanner scanner = new Scanner(System.in);
	
	// constructor
	public Actividad(String tipo, String fecha,String nombre, int codigo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.codigo = codigo;
	}
	
	// getter de codigo
	public int getCodigo() {
		return codigo;
	}
	
	
	//Mostrar información básica
	public void mostrar() {
		System.out.println("----------------------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Código: " + codigo);
		System.out.println("Fecha: " + fecha);
		System.out.println("----------------------------");
	}
	
	public void registrar(ArrayList<Actividad> actividades) {
		autenticarCodigo(actividades);
		System.out.println("Ingrese el nombre de la actividad: ");
		nombre = scanner.nextLine();
		System.out.println("Ingrese el tipo de actividad: ");
		
	}
	
	
	public void autenticarCodigo(ArrayList<Actividad> actividades) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese el codigo unico: ");
		codigo = scanner.nextInt(); 
		for (int i = 0; i < actividades.size(); i++) {
			unico = verificar(actividades.get(i), i);
			if(!unico) {
				System.out.println("Error, el codigo de la actividad ya esta en uso...\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(Actividad evaluado, int i) {
		if(evaluado.codigo == codigo) {
			return false;
		}else {return true;}
	}
	
}
