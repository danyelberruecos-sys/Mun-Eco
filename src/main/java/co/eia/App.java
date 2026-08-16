package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
	
	
		//ArrayLists donde se guardaran los objetos
		ArrayList <Usuario> usuarios = new ArrayList();
		ArrayList <Operador> operadores = new ArrayList();
		ArrayList <Responsable> responsables = new ArrayList();
		ArrayList <PuntoEcologico> puntosEcologicos = new ArrayList();
		
		Scanner scanner = new Scanner(System.in);
		
		boolean salida = false;
		String accion = null;
		
		
		do {
			
			boolean salir = false;
			
			System.out.println("-------MENU PRINCIPAL-------");
			System.out.println("-Cargar datos de prueba");
			System.out.println("-Registrar");
			System.out.println("-Mostar Informacion");
			System.out.println("-Salir");
			System.out.println("----------------------------");
			

			System.out.println("Ingrese el nombre de la accion a realizar: ");
			accion = scanner.nextLine();
			accion = accion.toLowerCase();
			
			
			switch(accion) {
			
			
			
			
			
			default: 
				System.out.println("Error, valor invalido");
				break;
				
				
				
				
				
			
			case "salir": 
				System.out.println("Saliendo...");
				salida = true;
				break;
				
				
				
				
				
			case "registrar":
				
				salir = false;
				String objetoRegistrar = null;
				
				do {
				
				System.out.println("------MENU REGISTRO------");
				System.out.println("-Usuario");
				System.out.println("-Operador");
				System.out.println("-Responsable");
				System.out.println("-Punto Ecologico");
				System.out.println("-Reporte");
				System.out.println("-Ruta de recoleccion");
				System.out.println("-Recoleccion");
				System.out.println("-Campaña ambiental");
				System.out.println("-Participacion");
				System.out.println("-Volver\n");
				System.out.println("-------------------------");
				System.out.println("Ingrese el la opcion de objeto que desea registrar");
				objetoRegistrar = scanner.nextLine();
				objetoRegistrar = objetoRegistrar.toLowerCase();
				
				switch(objetoRegistrar){
				default:
					System.out.println("Error, valor invalido");
					break;
					
				case "volver": 
					System.out.println("Volviendo a manu principal...\n");
					salir = true;
					break;
					
				case "usuario":
					Usuario newUsuario = new Usuario();
					newUsuario.registrar();
					newUsuario.setTipo();
					usuarios.add(newUsuario);
					System.out.println("Se registro el usuario exitosamente...\n");
					break;
					
				case "operador":
					Operador newOperador = new Operador();
					newOperador.registrar();
					newOperador.setAcciones();
					newOperador.setDisponible();
					operadores.add(newOperador);
					System.out.println("Se registro el operador exitosamente...\n");
					break;
				
				case "responsable": 
					Responsable newResponsable = new Responsable();
					newResponsable.registrar();
					newResponsable.setAcciones();
					newResponsable.setDisponible();
					responsables.add(newResponsable);
					System.out.println("Se registro el responsable correctamente...\n");
					break;
					
				case "punto ecologico":
					PuntoEcologico newPuntoEcologico = new PuntoEcologico();
					newPuntoEcologico.registrar();
					puntosEcologicos.add(newPuntoEcologico);
					break;	
				}
				
				}while(!salir);

				break;
			
			
				
				
				
			case "mostrar informacion":
			
				salir = false;
				String objetoMostrar;
				
				do {
					System.out.println("------MENU DE INFORMACION------");
					System.out.println("-Usuarios");
					System.out.println("-Operadores");
					System.out.println("-Responsables");
					System.out.println("-Puntos Ecologicos");
					System.out.println("-Reportes");
					System.out.println("-Rutas de recoleccion");
					System.out.println("-Recolecciones");
					System.out.println("-Campañas ambientales");
					System.out.println("-Participaciones");
					System.out.println("-Volver\n");
					System.out.println("-------------------------");
					System.out.println("Ingrese el la opcion de objeto que desea investigar");
					
					objetoMostrar = scanner.nextLine();
					objetoMostrar = objetoMostrar.toLowerCase();
					
					switch(objetoMostrar) {
					
					default: 
						System.out.println("Error, valor incorrecto");
						break;
						
						
					case "volver":
						System.out.println("Volviendo a menu principal");
						salir = true;
					
						
					case "usuarios":
						for (int i = 0; i < usuarios.size(); i++) {
							usuarios.get(i).mostrar();
						}
						break;
						
					case "operadores": 
						for(int i = 0; i < operadores.size(); i++) {
							operadores.get(i).mostrar();
						}
						break;
						
					case "responsables":
						for (int i = 0; i< responsables.size(); i++) {
							responsables.get(i).mostrar();
						}
						break;
						
					case "puntos ecologicos":
						for(int i = 0; i < puntosEcologicos.size(); i++) {
							puntosEcologicos.get(i).mostrar();
						}
						break;
				
					}
					
				}while(!salir);
			
			break;
			
			}
			
		
		}while(!salida);
		
		scanner.close();
	}
}
