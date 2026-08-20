package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

public class PuntoEcologico {
	private int codigo;
	private String ubicacion;
	private int capacidad;
	private boolean lleno;
	private ArrayList <String> categoriasMateriales = new ArrayList();

	Scanner scanner = new Scanner(System.in);
	
	public PuntoEcologico(int codigo, String ubicacion, int capacidad, boolean lleno) {
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
	
	public void registrar(ArrayList<PuntoEcologico> puntos) {
		System.out.println("------REGISTRO------");
		autenticarCodigo(puntos);
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
	
	
	public void autenticarCodigo(ArrayList<PuntoEcologico> puntos) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese el codigo unico del punto ecologico: ");
		codigo = scanner.nextInt(); 
		for (int i = 0; i < puntos.size(); i++) {
			unico = verificar(puntos.get(i), i);
			if(!unico) {
				System.out.println("Error, el codigo del punto ecologico ya esta en uso...'\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(PuntoEcologico evaluado, int i) {
		if(evaluado.codigo == codigo) {
			return false;
		}else {return true;}
	}
	
	
	
	
	public void mostrar() {
		System.out.println("------------------------");
		System.out.println("Codigo: " + codigo);
		System.out.println("Ubicacion: " + ubicacion);
		System.out.println("Capacidad: " + capacidad);
		if(lleno) {
			System.out.println("Esta lleno");
		}else {System.out.println("Tiene espacio disponible");}
		System.out.println("Materiales:");
		for (int i = 0; i < categoriasMateriales.size();i++) {
			System.out.println(categoriasMateriales.get(i));
		}
		System.out.println("------------------------");
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setMateriales() {
		String material;
		System.out.println("¿Cuanto tipos de materiales recolecta este punto ecologico?");
		int cantidad = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0;  i < cantidad; i++) {
			System.out.println("Ingrese el tipo de matrial No. " + (i+1));
			material = scanner.nextLine();
			categoriasMateriales.add(material);
		}
	}

}
