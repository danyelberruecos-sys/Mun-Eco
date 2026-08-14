package co.eia;

import java.util.Scanner;

import java.util.ArrayList;

public class PuntoEcologico {
	private int codigo;
	public String ubicacion;
	private int capacidad;
	private boolean lleno;
	private ArrayList <String> categoriasMateriales;

	Scanner scanner = new Scanner(System.in);
	
	public PuntoEcologico(int codigo, String ubicacion, int capacidd, boolean etado) {
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.lleno = lleno;
	}
	
	//Para crear un objeto vacio
	public PuntoEcologico() {
	}
	
	public void agregarMaterial(String material) {
		this.categoriasMateriales.add(material);
	}
	
	public void registrar() {
		System.out.println("------REGISTRO------");
		System.out.println("Ingrese codigo: ");
		codigo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese ubicación: ");
		ubicacion = scanner.nextLine();
		System.out.println("Ingrese capacidad en kg: ");
		capacidad = scanner.nextInt();
		scanner.nextLine();
		System.out.println("¿Está lleno? Ingrese Si o NO");
		String n = scanner.nextLine();
		if (n.equalsIgnoreCase("si")) {
			lleno = true;
		}else {lleno = false;}
	}
	

}
