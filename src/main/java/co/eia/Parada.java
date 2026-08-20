package co.eia;

import java.util.ArrayList;
import java.util.Scanner;

public class Parada {
	private int numero;
	private String accionEsperada;
	private PuntoEcologico puntoRelacionado;

	Scanner scanner = new Scanner(System.in);
	
	public Parada (int numero, String accionEsperada) {
		this.numero = numero;
		this.accionEsperada = accionEsperada;
	}
	
	public Parada() {
		
	}

	public void mostrar() {
		System.out.println("----------------------------");
		System.out.println("Numero: " + numero);
		System.out.println("Ubicacion: " + puntoRelacionado.getUbicacion());
		System.out.println("Accion a realizar: " + accionEsperada);
		System.out.println("----------------------------");
	}
	
	//getter numero
	public int getnumero() {
		return numero;
	}
	
	public void registrar(ArrayList <Parada> paradas) {
		autenticarCodigo(paradas);
		System.out.println("Ingrese la accion que se debera realizar en esta parada: ");
		accionEsperada = scanner.nextLine();
	}
	
	public void setPunto(ArrayList <PuntoEcologico> puntos) {
		boolean asignado = false;
		do {
			System.out.println("Relacionar punto ecologico a esta parada");
			System.out.println("-Ver puntos ecologicos");
			System.out.println("-Ingresar codigo\n");
			System.out.println("Ingrese la accion que desea realizar: ");
			String accion = scanner.nextLine();
			accion = accion.toLowerCase();
			
			switch(accion) {
			default: 
				System.out.println("Error, accion invalida, intente de nuevo...");
				break;
				
			case "ver puntos ecologicos": 
				for(int i = 0 ; i < puntos.size(); i++ ) {
					puntos.get(i).mostrar();
				}
				break;
				
			case "ingresar codigo":
				boolean encontrado = false;
				do {
					System.out.println("Ingrese el codigo del punto ecologico:");
				int codigo = scanner.nextInt();;
				scanner.nextLine();
				for (int i = 0; i < puntos.size(); i++) {
					if (codigo == puntos.get(i).getCodigo()) {
						puntoRelacionado = puntos.get(i);
						encontrado = true;
					}
				}
				if(!encontrado) {
					System.out.println("No se encontro el punto ecologico, vuelva a intentarlo...");
				}else {
					System.out.println("Se registro exitosamente...");
				}
				}while(!encontrado);
				asignado = true;
				break;
				
			}
		}while(!asignado);
	
		
	}
	
	public void autenticarCodigo(ArrayList<Parada> paradas) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese el numero unico de la parada: ");
		numero = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < paradas.size(); i++) {
			unico = verificar(paradas.get(i), i);
			if(!unico) {
				System.out.println("Error, el numero de la parada ya esta en uso...\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(Parada evaluado, int i) {
		if(evaluado.numero == numero) {
			return false;
		}else {return true;}
	}
	
}
