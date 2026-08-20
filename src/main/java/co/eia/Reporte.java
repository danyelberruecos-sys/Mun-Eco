package co.eia;

import java.util.ArrayList;
import java.util.Scanner;

public class Reporte {
	private String autor;
	private  int codigo;
	private String fecha;
	private int prioridad;
	private String descripcion;
	private String estado;
	private PuntoEcologico punto;

	
	Scanner scanner = new Scanner(System.in);
	
	public int getCodigo() {
		return codigo;
	}
	
	public Reporte(int codigo, String fecha, int prioridad, String estado) {
	this.codigo = codigo;
	this.fecha = fecha;
	this.prioridad = prioridad;
	this.estado = estado;
	}
	
	public void registrar(ArrayList <Reporte> reportes) {

		autenticarCodigo(reportes);
		System.out.println("Ingrese nombre del autor: ");
		autor = scanner.nextLine();
		System.out.println("Ingrese una breve descripcion: ");
		descripcion = scanner.nextLine();
		System.out.println("Ingrese la fecha: ");
		fecha = scanner.nextLine();
		verificarPrioridad();
		System.out.println("Ingrese el estado del reporte: ");
		estado = scanner.nextLine();
		
	}
	
	public void setPunto(ArrayList <PuntoEcologico> puntos) {
		boolean asignado = false;
		do {
			System.out.println("Relacionar punto ecologico a este reporte");
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
					System.out.println("Ingrese el codigo del punto ecologico: ");
				int codigo = scanner.nextInt();;
				scanner.nextLine();
				for (int i = 0; i < puntos.size(); i++) {
					if (codigo == puntos.get(i).getCodigo()) {
						punto = puntos.get(i);
						encontrado = true;
					}
				}
				if(!encontrado) {
					System.out.println("No se encontro el punto ecologico, vuelva a intentarlo...");
				}else {
					System.out.println("Se registro el reporte exitosamente...");
				}
				}while(!encontrado);
				asignado = true;
				break;
				
			}
		}while(!asignado);
	
		
	}
	
	public void autenticarCodigo(ArrayList<Reporte> reportes) {
		boolean unico = true;
		
		do {
		System.out.println("Ingrese el codigo unico para este reporte: ");
		codigo = scanner.nextInt(); 
		scanner.nextLine();
		for (int i = 0; i < reportes.size(); i++) {
			unico = verificar(reportes.get(i), i);
			if(!unico) {
				System.out.println("Error, el codigo del reporte ya esta en uso...'\n");
				break;
			}
		}
		}while(!unico);
	}
	
	
	public boolean verificar(Reporte evaluado, int i) {
		if(evaluado.getCodigo() == getCodigo()) {
			return false;
		}else {return true;}
	}
	
	public Reporte() {
	}
	
	public void verificarPrioridad() {
		boolean correcto = true;
		do {
			System.out.println("Ingrese el nivel prioridad en escala del uno al cinco: ");
			prioridad = scanner.nextInt();
			scanner.nextLine();
			if(prioridad < 1 || prioridad > 5) {
				System.out.println("Valor incorrecto, intente de nuevo...");
				correcto = false;
			}else {
				correcto = true;
			}
		}while(!correcto);
		
	}
	
	public void mostrar() {
		System.out.println("------------------------------");
		System.out.println("Codigo: " + codigo);
		System.out.println("Fecha: " + fecha);
		System.out.println("Prioridad de nivel: " + prioridad);
		System.out.println("Estado: " + estado);
		System.out.println("Codigo punto ecologico: "  +  punto.getCodigo());
		System.out.println("------------------------------");
	}

}
