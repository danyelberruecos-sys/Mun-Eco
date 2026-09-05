package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Verificador verificador = new Verificador();
		VerificadorParada verificadorParada = new VerificadorParada();
		
		ArrayList <Usuario> usuarios = new ArrayList();
		ArrayList <Operador> operadores = new ArrayList();
		ArrayList <Responsable> responsables = new ArrayList();
		ArrayList <PuntoEcologico> puntosEcologicos = new ArrayList();
		ArrayList <RutaRecoleccion> rutasRecoleccion = new ArrayList();
		
		
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
			System.out.println("||8. Cargar objetos de prueba        ||");
			System.out.println("||9. Salir                           ||");
			System.out.println("=======================================");
			
			do {
			System.out.println("Ingrese el número de la accion que desee realizar: ");
			try {
				accion = sc.nextInt();
				sc.nextLine();
				break;
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("Error, valor invalido...");
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
						System.out.println("Error, valor invalido...");
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
							System.out.println("Error, valor invalido...");
					
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
						System.out.println("Error, valor invalido...");
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
					}else {System.out.println("Error, valor invalido...");}
				}while(!correcto);
				
				System.out.println("Ingrese la acciones permitidas (Separads por comas): ");
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
						System.out.println("Error, valor invalido...");
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
						System.out.println("Error, numero invalido, debe estar entre 1 y 4...");
						break;
				}

				
				
				break;
				
				
				
			case 2: 
				
				System.out.println("=======================================");
				System.out.println("||          PUNTOS ECOLOGICOS        ||");
				System.out.println("=======================================");
				System.out.println("||1. Registrar  punto ecologico      ||");
				System.out.println("||2. Ver puntos ecologicos           ||");
				System.out.println("||3. Inactivar puntos segun reportes ||");
				System.out.println("=======================================");
				
				int accionPuntosEcologicos = 0;
				
				do {
					System.out.println("Ingrese el número de la accion que desee realizar: ");
					try {
						accionPuntosEcologicos = sc.nextInt();
						sc.nextLine();
						break;
					}catch(Exception e) {
						sc.nextLine();
						System.out.println("Error, valor invalido...");
					}
					}while(true);
				
				switch (accionPuntosEcologicos) {
				
				case 1: // REgistrar puntos ecologicos
					long id = 0;
					boolean verificado = false;
					
					do {	do {
						System.out.println("Ingrese ID: ");
						try {
							id = sc.nextLong();
							sc.nextLine();
							break;
						}catch(Exception e) {
							sc.nextLine();
							System.out.println("Error, valor invalido...");
					
						}
						}while(true);
					
					if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, puntosEcologicos)) {
						verificado= true;
					}
						
					}while(!verificado);
					
					System.out.println("Ingrese ubicacion:");
					String ubicacion = sc.nextLine();
					

					verificado = false;
					int capacidad = 0;
					
					do {
						System.out.println("Ingrese capacidad en kilos: ");
						try {
							capacidad = sc.nextInt();
							sc.nextLine();
						}catch(Exception e) {
							sc.nextLine();
							System.out.println("Valor invalido...");
						}
						if (capacidad > 0) {
							verificado = true;
						}else {
							System.out.println("La capacidad debe ser mayor a 0...");
						}
					}while(!verificado);
					
					boolean lleno = false;;
					boolean correcto = false;
					String n = null;
					do {
						System.out.println("¿El punto ecologico esta lleno? (si/no):");
						n = sc.nextLine().toLowerCase();
						if(n.equals("si")) {
							lleno = true;
							correcto = true;
						}else if(n.equals("no")){
							lleno = false;
							correcto = true;
						}else {System.out.println("Error, valor invalido...");}
					}while(!correcto);
					
					 boolean activo = false;
					correcto = false;
					n = null;
					do {
						System.out.println("¿El punto ecologico esta activo? (si/no):");
						n = sc.nextLine().toLowerCase();
						if(n.equals("si")) {
							activo = true;
							correcto = true;
						}else if(n.equals("no")){
							activo = false;
							correcto = true;
						}else {System.out.println("Error, valor invalido...");}
					}while(!correcto);
					
					PuntoEcologico newPuntoEcologico = new PuntoEcologico(id, ubicacion, capacidad, lleno, activo);
					
					//Reciclaje
					boolean admitido = false;
					correcto = false;
					n = null;
					do {
						System.out.println("¿El punto ecologico admite material reciclable? (si/no):");
						n = sc.nextLine().toLowerCase();
						if(n.equals("si")) {
							admitido = true;
							correcto = true;
						}else if(n.equals("no")){
							admitido = false;
							correcto = true;
						}else {System.out.println("Error, valor invalido...");}
					}while(!correcto);
					
					if (admitido) {
						Material reciclaje = new MaterialReciclable("Reciclable", 0);
						newPuntoEcologico.agregarMaterial(reciclaje);
					}
					
					//Organico
					admitido = false;
					correcto = false;
					n = null;
					do {
						System.out.println("¿El punto ecologico admite material organico? (si/no):");
						n = sc.nextLine().toLowerCase();
						if(n.equals("si")) {
							admitido = true;
							correcto = true;
						}else if(n.equals("no")){
							admitido = false;
							correcto = true;
						}else {System.out.println("Error, valor invalido...");}
					}while(!correcto);
					
					if (admitido) {
						Material organico = new MaterialOrganico("Organico", 0);
						newPuntoEcologico.agregarMaterial(organico);
					}
					
					//Especial
					admitido = false;
					correcto = false;
					n = null;
					do {
						System.out.println("¿El punto ecologico admite material especial? (si/no):");
						n = sc.nextLine().toLowerCase();
						if(n.equals("si")) {
							admitido = true;
							correcto = true;
						}else if(n.equals("no")){
							admitido = false;
							correcto = true;
						}else {System.out.println("Error, valor invalido...");}
					}while(!correcto);
					
					if (admitido) {
						Material especial = new MaterialEspecial("Especial", 0);
						newPuntoEcologico.agregarMaterial(especial);
					}
					
					puntosEcologicos.add(newPuntoEcologico);
					
					break;
					
					
				case 2: //Ver puntos ecologicos
					if (puntosEcologicos.size() == 0) {
						System.out.println("No hay puntos ecologicos registrados...");
					}else {
						System.out.println("=======================================");
						System.out.println("||       VER PUNTOS ECOLOGICOS       ||");
						System.out.println("=======================================");
						for (int i = 0; i < puntosEcologicos.size(); i++) {
							puntosEcologicos.get(i).mostrar();
						}
					}
					break;
					
				case 3: 
					break;
					
					default:
						System.out.println("Numero invalido, debe estar entre el 1 y el 3...");
				
				}
				
				break;// Aca acaba ecopuntos
			
				
				
			case 3: 
				break;
				
				
				
			case 4: //Rutas y recoleccion
				
				
				System.out.println("=======================================");
				System.out.println("||         RUTAS Y RECOLECCION       ||");
				System.out.println("=======================================");
				System.out.println("||1. Registrar ruta                  ||");
				System.out.println("||2. Mostrar Rutas                   ||");
				System.out.println("||3. Registrar recoleccion           ||");
				System.out.println("||4. Cerrar ruta                     ||");
				System.out.println("=======================================");
				
				int accionRutas = 0;
				
				do {
					System.out.println("Ingrese el número de la accion que desee realizar: ");
					try {
						accionRutas = sc.nextInt();
						sc.nextLine();
						break;
					}catch(Exception e) {
						sc.nextLine();
						System.out.println("Error, valor invalido...");
					}
					}while(true);
				
				switch(accionRutas) {
				
				default: 
					System.out.println("Numero invalido, el numero debe estar entre el 1 y el 4...");
					break;
					
					
					
				case 1: //Registrar ruta
					
					long id = 0;
					boolean verificado = false;
					
					do {	do {
						System.out.println("Ingrese ID: ");
						try {
							id = sc.nextLong();
							sc.nextLine();
							break;
						}catch(Exception e) {
							sc.nextLine();
							System.out.println("Error, valor invalido...");
					
						}
						}while(true);
					
					if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, rutasRecoleccion)) {
						verificado= true;
					}
					}while(!verificado);
					
					boolean activa = false;
					boolean correcto = false;
					String n = null;
					do {
						System.out.println("¿La ruta se registro como activa? (si/no):");
						n = sc.nextLine().toLowerCase();
						if(n.equals("si")) {
							activa = true;
							correcto = true;
						}else if(n.equals("no")){
							activa = false;
							correcto = true;
						}else {System.out.println("Error, valor invalido...");}
					}while(!correcto);
					
					RutaRecoleccion newRuta = new RutaRecoleccion(id,activa);
					int cantParadas = 1;
					
					System.out.println("¿Cuantas paradas tendra la ruta?");
					do {
						System.out.println("¿Cuantas paradas tendra la ruta?");
						try {
							cantParadas = sc.nextInt();
							sc.nextLine();
							if(cantParadas > 0) {
							break;
							}else {
								System.out.println("Error, la cantidad de paradas debe ser mayor a cero...");
							}
						}catch(Exception e) {
							sc.nextLine();
							System.out.println("Error, valor invalido...");
						}
						}while(true);
					
					for (int i = 0; i < cantParadas; i++ ) {
						
						int orden = 0;
						
						do {
							System.out.println("Ingrese el numero de oren de la parada:");
							try {
								orden = sc.nextInt();
								sc.nextLine();
							}catch (Exception e){ 
								sc.nextLine();
								System.out.println("Error, valor invalido...");
								continue;
							}
							if(verificadorParada.verificarOrdenUnico(orden, newRuta)) {
								break;
							}
						}while(true);
						
						System.out.println("Ingrese la accion que se esper realizar en esta parada:");
						String accionEsperada = sc.nextLine();
						
						Parada newParada = new Parada(orden, accionEsperada);
						long idPuntoEcologico = 0;
						boolean encontrado = false;
						
							do {
							System.out.println("Ingrese el ID del punto ecologico que corresponde a la parada:");
							
								try {
									idPuntoEcologico = sc.nextLong();
									sc.nextLine();
							        for (int j = 0; j < puntosEcologicos.size(); j++) {
							            if (idPuntoEcologico == puntosEcologicos.get(j).getId()
							                    && verificadorParada.verificarPuntoActivo(puntosEcologicos.get(j))) {
							                newParada.setPuntoEcologico(puntosEcologicos.get(j));
							                encontrado = true;
							                break;
							            }
							        }

							        if (!encontrado) {
							            System.out.println("Error, no se encontro un punto activo con ese ID...");
							        }
									
								}catch(Exception e) {
									sc.nextLine();
									System.out.println("Error, valor invalido");
								}
								}while(!encontrado);
						newRuta.agregarParada(newParada);
					}
					rutasRecoleccion.add(newRuta);
					
					break;
					
					
				case 2: //Mostrar Rutas 
					if (rutasRecoleccion.size() == 0) {
						System.out.println("No hay rutas de recoleccion registradas...");
					}else {
						System.out.println("=======================================");
						System.out.println("||      VER RUTAS DE RECOLECCION     ||");
						System.out.println("=======================================");
						for (int i = 0; i < rutasRecoleccion.size(); i++) {
							rutasRecoleccion.get(i).mostrar();
						}
					}
					break;
					
					
				case 3:
					break;
					
					
				case 4:
					break;
				
				}
				break;// Hasta aca llegan rutas
				
				
				
			case 5: 
				break;
				
				
				
			case 6: 
				break;
				
				
				
			case 7: 
				break;
				
				
				
				
			case 8: // Cargar objetos de prueba
				//Usuarios
				System.out.println("Cargando Usuarios...");
				Usuario esteban = new Usuario(1029387354L, "estebanano@gmail.com", "Esteban Trujillo", "Estudiante");
				usuarios.add(esteban);
				Usuario mariana = new Usuario(2345432389L, "marryana@gmail.com", "Mariana Giraldo", "Estudiante");
				usuarios.add(mariana);
				Usuario santiago = new Usuario(5834549087L, "zantir4m1@gmail.com", "Santigo Ramirez", "Profesor");
				usuarios.add(santiago);
				
				//Operadores
				System.out.println("Cargando Operadores...");
				Operador juan = new Operador(3382934784L,"juancho@gmial.com", "Juan Pablo Castaño", true, "Recolectar material especial, Inspeccion de puntos");
				operadores.add(juan);
				Operador estephanie = new Operador(5467389230L,"estephalaenana@gmial.com", "Estephanie Taborda", false, "Recolecccion general, Cierre de rutas");
				operadores.add(estephanie);
				Operador daniel = new Operador(1020116808L,"danyflow@gmial.com", "Daniel Gutierrez", true, "Recolectar material especial, Recoleccion material especial");
				operadores.add(daniel);
				break;
				
				
				
			case 9: 
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
