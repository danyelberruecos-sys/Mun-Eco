package co.eia;

import java.util.ArrayList;
import java.util.Scanner;

public class Reporte {
	private  int codigo;
	private String fecha;
	private int prioridad;
	private String estado;
	private Operador operador = null;
	private RutaRecoleccion ruta = null;
	
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
	
	public void registrar(ArrayList <Reporte> reportes, ArrayList <Operador> operadores, ArrayList <RutaRecoleccion> rutas) {
		String asignacion;
		boolean correcto = true;
		autenticarCodigo(reportes);
		System.out.println("Ingrese la fecha: ");
		fecha = scanner.nextLine();
		verificarPrioridad();
		System.out.println("Ingrese el estado del reporte: ");
		estado = scanner.nextLine();
		System.out.println("Desea asignarle un operador o una ruta:");
		asignacion = scanner.nextLine();
		asignacion = asignacion.toLowerCase();
		do {
			switch(asignacion) {
			default: 
				System.out.println("Error, asignacion incorrecta, intente de nuevo... ");
				correcto = false;
				break;
				
			case "operador":

				
				int idOperador;
				boolean ingreso = true;
				boolean ocupado = true;
				
				do {
					System.out.println("Desea:");
					System.out.println("-Ver operadores");
					System.out.println("-Ingresar ID");
					
					String opcion = scanner.nextLine();
					opcion = opcion.toLowerCase();
					
					switch(opcion) {
					default: 
						System.out.println("Error, intente de nuevo...");
						ingreso = false;
						break;
						
					case "ver operadores":
						System.out.println("----LISTA DE OPERADORES----");
						for (int i = 0; i < operadores.size(); i++) {
							operadores.get(i).mostrar();
						}
						System.out.println("----------------------------\n");
						ingreso = false;
						break;
						
					case "ingresar id":
						boolean encontrado =  false;
						System.out.println("Ingrese el ID del operador: ");
						idOperador = scanner.nextInt();
						scanner.nextLine();
						for(int i = 0; i < operadores.size(); i++) {
							if (idOperador == operadores.get(i).getId()) {
								if(operadores.get(i).getDisponible()) {
								operador = operadores.get(i);
								encontrado = true;
								}else {
									System.out.println("El operador se encuentra ocupado...");
									ocupado = true;
								}
							}
							if (encontrado) {
								System.out.println("Se registro el reporte con exito...");
								ingreso = true;
							}else if(!encontrado && ocupado){
								ingreso = false;
							}else {
								System.out.println("No se encontro el operador, intente de nuevo...");
								ingreso = false;
							}
						}
						
					}
					
				}while(!ingreso);
				correcto = true;
				break;
				
			case "ruta":

				
				int idRuta;
				ingreso = true;
				
				
				do {
					System.out.println("Desea:");
					System.out.println("-Ver rutas");
					System.out.println("-Ingresar ID");
					
					String opcion = scanner.nextLine();
					opcion = opcion.toLowerCase();
					
					switch(opcion) {
					default: 
						System.out.println("Error, intente de nuevo...");
						ingreso = false;
						break;
						
					case "ver rutas":
						System.out.println("----LISTA DE RUTAS----");
						for (int i = 0; i < rutas.size(); i++) {
							rutas.get(i).mostrar();
						}
						System.out.println("----------------------------\n");
						ingreso = false;
						break;
						
					case "ingresar id":
						boolean encontrado =  false;
						ocupado = false;
						System.out.println("Ingrese el ID de la ruta: ");
						idRuta = scanner.nextInt();
						scanner.nextLine();
						for(int i = 0; i < rutas.size(); i++) {
							if (idRuta == rutas.get(i).getId()) {
								if(rutas.get(i).getEstado()) {
								ruta = rutas.get(i);
								encontrado = true;
								}else {
									System.out.println("La ruta se encuentra ocupada...");
									ocupado = true;
								}
							}
							if (encontrado) {
								System.out.println("Se registro el reporte con exito...");
								ingreso = true;
							}else if(!encontrado && ocupado) {
								ingreso = false;
							}
							
							else {
								System.out.println("No se encontro la ruta, intente de nuevo...");
								ingreso = false;
							}
						}
						
					}
					
				}while(!ingreso);
				correcto = true;
				break;
			}
		}while(!correcto);
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
		if (operador != null) {
			System.out.println("Operador: " + operador.getNombre() + ", " + operador.getId());
		}
		if (ruta != null) {
			System.out.println("Ruta " + ruta.getId());
		}
		System.out.println("------------------------------");
	}

}
