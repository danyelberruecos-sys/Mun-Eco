package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Verificador verificador = new Verificador();
		
		ArrayList <Usuario> usuarios = new ArrayList();
		ArrayList <Operador> operadores = new ArrayList();
		ArrayList <Responsable> responsables = new ArrayList();
		
		
		
		System.out.println("=======================================");
		System.out.println("||              MUNECO               ||");
		System.out.println("=======================================");
		
		boolean salir = false;
		int  accion = 0;
		
		do{
			System.out.println("=======================================");
			System.out.println("||           MENÚ PRINCIPAL          ||");
			System.out.println("=======================================");
			System.out.println("||1. Gestion personas                ||");
			System.out.println("||2. Puntos ecologicos               ||");
			System.out.println("||3. Reportes                        ||");
			System.out.println("||4. Rutas y recoleccion             ||");
			System.out.println("||5. Campañas ambientales            ||");
			System.out.println("||6. Eco Puntos y consultas          ||");
			System.out.println("||7. Indicadores generales           ||");
			System.out.println("||8. Salir                           ||");
			System.out.println("=======================================");
			
			do {
			System.out.println("Ingrese el número de la accion que desee realizar: ");
			try {
				accion = sc.nextInt();
				sc.nextLine();
				break;
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error, valor invalido");
			}
			}while(true);
			
			
			switch(accion) {
			
			
			
			case 1: //Gestion personas
				
				System.out.println("=======================================");
				System.out.println("||          GESTION PERSONAS         ||");
				System.out.println("=======================================");
				System.out.println("||1. Registrar  Usuario              ||");
				System.out.println("||2. Registrar Operador              ||");
				System.out.println("||3. Registrar Responsable           ||");
				System.out.println("||4. Ver lista de personas           ||");
				System.out.println("=======================================");
				
				int gestionPersonas = 0;
				
				do {
					System.out.println("Ingrese el número de la accion que desee realizar: ");
					try {
						gestionPersonas = sc.nextInt();
						sc.nextLine();
						break;
					}catch(Exception e) {
						sc.nextLine();
						System.out.println("Error, valor invalido");
					}
					}while(true);
					
				switch (gestionPersonas) {
				
				case 1: //Registrar usuario
						long id ;
						boolean verificado = false;
						
					do {	do {
						System.out.println("Ingrese ID: ");
						try {
							id = sc.nextLong();
							sc.nextLine();
							break;
						}catch(Exception e) {
							sc.nextLine();
							System.out.println("Error, valor invalido");
					
						}
						}while(true);
					
					if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, usuarios)) {
						verificado= true;
					}
						
					}while(!verificado);
					
					String correo;
					System.out.println("Ingrese el correo: ");
					correo = sc.nextLine();
					
					String nombre;
					System.out.println("Ingrese el nombre: ");
					nombre = sc.nextLine();
					
					String tipo;
					System.out.println("Ingrese el tipo: ");
					tipo = sc.nextLine();
					
					Usuario newUsusario = new Usuario(id, correo, nombre, tipo);
					usuarios.add(newUsusario);
					break;
					
					
					
				case 2: //Registrar Operdor
					id = 0 ;
					verificado = false;
					
				do {	do {
					System.out.println("Ingrese ID: ");
					try {
						id = sc.nextLong();
						sc.nextLine();
						break;
					}catch(Exception e) {
						sc.nextLine();
						System.out.println("Error, valor invalido");
					}
					}while(true);
				
				if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, operadores)) {
					verificado= true;
				}
					
				}while(!verificado);
				
				System.out.println("Ingrese el correo: ");
				correo = sc.nextLine();
				
				System.out.println("Ingrese el nombre: ");
				nombre = sc.nextLine();
				
				boolean disponible = false;;
				boolean correcto = false;
				String n;
				do {
					System.out.println("Ingrese disponibilidad (si/no):");
					n = sc.nextLine().toLowerCase();
					if(n.equals("si")) {
						disponible = true;
						correcto = true;
					}else if(n.equals("no")){
						disponible = false;
						correcto = true;
					}else {System.out.println("Error, valor invalido");}
				}while(!correcto);
				
				System.out.println("Ingrese la acciones permitidas: ");
				String accionesPermitidas = sc.nextLine();
				
				Operador newOperador = new Operador(id,correo,nombre,disponible,accionesPermitidas);
				operadores.add(newOperador);
					break;
					
				
				case 3:// Registrar responsable
					id = 0 ;
					verificado = false;
					
				do {	do {
					System.out.println("Ingrese ID: ");
					try {
						id = sc.nextLong();
						sc.nextLine();
						break;
					}catch(Exception e) {
						sc.nextLine();
						System.out.println("Error, valor invalido");
					}
					}while(true);
				
				if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, responsables)) {
					verificado= true;
				}
					
				}while(!verificado);
				
				System.out.println("Ingrese el correo: ");
				correo = sc.nextLine();
				
				System.out.println("Ingrese el nombre: ");
				nombre = sc.nextLine();
				
				disponible = false;;
				correcto = false;
				n = null;
				do {
					System.out.println("Ingrese disponibilidad (si/no):");
					n = sc.nextLine().toLowerCase();
					if(n.equals("si")) {
						disponible = true;
						correcto = true;
					}else if(n.equals("no")){
						disponible = false;
						correcto = true;
					}else {System.out.println("Error, valor invalido...");}
				}while(!correcto);
				
				System.out.println("Ingrese la acciones permitidas: ");
				accionesPermitidas = sc.nextLine();
				
				System.out.println("Ingrese su area de responsabilidad: ");
				String areaResponsabilidad = sc.nextLine();
				
				Responsable newResponsable = new Responsable(id,correo,nombre,disponible,accionesPermitidas, areaResponsabilidad);
				responsables.add(newResponsable);
					break;
			
					
					
				case 4:
					if(usuarios.size() == 0 && operadores.size() == 0 && responsables.size() == 0) {System.out.println("No hay personas registradas");}
					else {
					System.out.println("=======================================");
					System.out.println("||            VER PERSONAS           ||");
					System.out.println("=======================================");
					if (usuarios.size() != 0) {
						System.out.println("=======================================");
						System.out.println("||              USUARIOS             ||");
						System.out.println("=======================================");
						for(int i = 0; i < usuarios.size(); i++) {
							usuarios.get(i).mostrar();
							}
						}
					if (operadores.size() != 0) {
						System.out.println("=======================================");
						System.out.println("||              OPERADORES           ||");
						System.out.println("=======================================");
						for(int i = 0; i < operadores.size(); i++) {
							operadores.get(i).mostrar();
							}
					}
					if (responsables.size() != 0) {
						System.out.println("=======================================");
						System.out.println("||            RESPONSABLES           ||");
						System.out.println("=======================================");
						for(int i = 0; i < responsables.size(); i++) {
							responsables.get(i).mostrar();
							}
						}
					}
					break;
					
					default:
						System.out.println("Error, numero invalido, debe estar entre 1 y 4");
						break;
				}

				
				
				break;
				
				
				
			case 2: 
				break;
			
				
				
			case 3: 
				break;
				
				
				
			case 4: 
				break;
				
				
				
			case 5: 
				break;
				
				
				
			case 6: 
				break;
				
				
				
			case 7: 
				break;
				
				
				
			case 8: 
				System.out.println("Saliendo...");
				salir = true;
				break;
				
				
				
			default:
				System.out.println("Error, numero invalido, debe estar entre el 1 y el 8");
				break;
			
			
			}
			
		}while(!salir);
	}
	

}
