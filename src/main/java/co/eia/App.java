package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Notificador notificador = new Notificador();
		Verificador verificador = new Verificador();
		VerificadorParada verificadorParada = new VerificadorParada();
		VerificadorReporte verificadorReporte = new VerificadorReporte();
		VerificadorRecoleccion verificadorRecoleccion = new VerificadorRecoleccion();
		VerificadorPunto verificadorPunto = new VerificadorPunto();
		
		ArrayList <Usuario> usuarios = new ArrayList();
		ArrayList <Operador> operadores = new ArrayList();
		ArrayList <Responsable> responsables = new ArrayList();
		ArrayList <PuntoEcologico> puntosEcologicos = new ArrayList();
		ArrayList <RutaRecoleccion> rutasRecoleccion = new ArrayList();
		ArrayList <Reporte> reportes =new ArrayList();
		ArrayList <Persona> todasPersonas = new ArrayList();
		ArrayList <Recoleccion> recolecciones = new ArrayList();
		
		
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
					
					if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, todasPersonas)) {
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
					todasPersonas.add(newUsusario);
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
				
				if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, todasPersonas)) {
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
				todasPersonas.add(newOperador);
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
				
				if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, todasPersonas)) {
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
				todasPersonas.add(newResponsable);
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
			
				case 3: // Inactivar puntos 
				    
				    PuntoEcologico puntoParaInactivar = null;
				    boolean encontradoPuntoInactivar = false;
				    
				    do {
				        System.out.println("Ingrese el ID del punto ecologico a inactivar:");
				        try {
				            long idPunto = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < puntosEcologicos.size(); i++) {
				                if (puntosEcologicos.get(i).getId() == idPunto) {
				                    puntoParaInactivar = puntosEcologicos.get(i);
				                    encontradoPuntoInactivar = true;
				                    break;
				                }
				            }
				            
				            if (!encontradoPuntoInactivar) {
				                System.out.println("Error, no se encontro un punto con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontradoPuntoInactivar);
				    
				    if (!puntoParaInactivar.getActivo()) {
				        System.out.println("Error, el punto ya esta inactivo...");
				    } else if (verificadorPunto.verificarSinReportesAbiertos(puntoParaInactivar, reportes)) {
				        puntoParaInactivar.inactivar(notificador);
				        System.out.println("Punto inactivado correctamente.");
				    }
				    
				    break;
				
					
					default:
						System.out.println("Numero invalido, debe estar entre el 1 y el 3...");
				
				}
				
				break;// Aca acaba ecopuntos
			
				
				
			case 3: //Reportes
				
				System.out.println("=======================================");
				System.out.println("||             REPORTES              ||");
				System.out.println("=======================================");
				System.out.println("||1.Registrar reporte                ||");
				System.out.println("||2.Asignar reporte a operador o ruta||");
				System.out.println("||3.Cambiar Estado                   ||");
				System.out.println("||4.Consultar pendientes             ||");
				System.out.println("=======================================");
				
				int accionReporte = 0;
				
				do {
					System.out.println("Ingrese el número de la accion que desee realizar: ");
					try {
						accionReporte = sc.nextInt();
						sc.nextLine();
						break;
					}catch(Exception e) {
						sc.nextLine();
						System.out.println("Error, valor invalido...");
					}
					}while(true);
				
				switch (accionReporte) {
				
				default: 
					System.out.println("Numero invalido, debe estar entre el 1 y el 4: ");
					break;
					
				case 1: //Registrar
				    
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
				    
				    if(verificador.verificarLongitud(id) && verificador.verificarUnico(id, reportes)) {
				        verificado= true;
				    }
				    }while(!verificado);
				    
				    Persona autorEncontrado = null;
				    boolean encontrado = false;
				    
				    do {
				        System.out.println("Ingrese el ID de la persona que registra el reporte:");
				        try {
				            long idAutor = sc.nextLong();
				            sc.nextLine();

				            for (int i = 0; i < todasPersonas.size(); i++) {
				                if (todasPersonas.get(i).getId() == idAutor) {
				                    autorEncontrado = todasPersonas.get(i);
				                    encontrado = true;
				                    break;
				                }
				            }

				            if (!encontrado) {
				                System.out.println("Error, no se encontro una persona con ese ID...");
				            }

				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontrado);
				    
				    PuntoEcologico puntoEncontrado = null;
				    encontrado = false;
				    
				    do {
				        System.out.println("Ingrese el ID del punto ecologico donde ocurrio el reporte:");
				        try {
				            long idPunto = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < puntosEcologicos.size(); i++) {
				                if (puntosEcologicos.get(i).getId() == idPunto
				                        && verificadorReporte.verificarPuntoActivo(puntosEcologicos.get(i))) {
				                    puntoEncontrado = puntosEcologicos.get(i);
				                    encontrado = true;
				                    break;
				                }
				            }
				            
				            if (!encontrado) {
				                System.out.println("Error, no se encontro un punto activo con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontrado);
				    
				    System.out.println("Ingrese la fecha del reporte (dd/mm/aaaa):");
				    String fecha = sc.nextLine();
				    
				    System.out.println("Ingrese la descripcion del reporte:");
				    String descripcion = sc.nextLine();
				    
				    int opcionTipo = 0;
				    String tipo = null;
				    boolean tipoValido = false;
				    
				    do {
				        System.out.println("Seleccione el tipo de reporte:");
				        System.out.println("1. Desbordamiento");
				        System.out.println("2. Contaminacion");
				        System.out.println("3. Material especial");
				        System.out.println("4. Otro");
				        try {
				            opcionTipo = sc.nextInt();
				            sc.nextLine();
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				            continue;
				        }
				        
				        switch(opcionTipo) {
				        case 1: tipo = "Desbordamiento"; tipoValido = true; break;
				        case 2: tipo = "Contaminacion"; tipoValido = true; break;
				        case 3: tipo = "MaterialEspecial"; tipoValido = true; break;
				        case 4: tipo = "Otro"; tipoValido = true; break;
				        default: System.out.println("Error, opcion invalida..."); break;
				        }
				    }while(!tipoValido);
				    
				    int prioridad = 0;
				    boolean prioridadValida = false;
				    
				    do {
				        System.out.println("Ingrese la prioridad (1 = Baja, 2 = Media, 3 = Alta):");
				        try {
				            prioridad = sc.nextInt();
				            sc.nextLine();
				            if (prioridad >= 1 && prioridad <= 3) {
				                prioridadValida = true;
				            }else {
				                System.out.println("Error, la prioridad debe ser 1, 2 o 3...");
				            }
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!prioridadValida);
				    
				    Reporte newReporte = new Reporte(id, autorEncontrado, puntoEncontrado, fecha, descripcion, tipo, prioridad);
				    reportes.add(newReporte);
				    
				    System.out.println("Reporte registrado correctamente.");
				    
				 
					break;
					
					
				case 2: //Asignar 
				    
				    Reporte reporteSeleccionado = null;
				    boolean encontradoReporte = false;
				    
				    do {
				        System.out.println("Ingrese el ID del reporte a asignar:");
				        try {
				            long idReporte = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < reportes.size(); i++) {
				                if (reportes.get(i).getId() == idReporte) {
				                    reporteSeleccionado = reportes.get(i);
				                    encontradoReporte = true;
				                    break;
				                }
				            }
				            
				            if (!encontradoReporte) {
				                System.out.println("Error, no se encontro un reporte con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontradoReporte);
				    
				    if (!verificadorReporte.verificarPuedeAsignar(reporteSeleccionado)) {
				        break; 
				    }
				    
				    int tipoAsignacion = 0;
				    boolean opcionValida = false;
				    
				    do {
				        System.out.println("Asignar a: 1) Operador   2) Ruta");
				        try {
				            tipoAsignacion = sc.nextInt();
				            sc.nextLine();
				            if (tipoAsignacion == 1 || tipoAsignacion == 2) {
				                opcionValida = true;
				            }else {
				                System.out.println("Error, la opcion debe ser 1 o 2...");
				            }
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!opcionValida);
				    
				    if (tipoAsignacion == 1) { 
				      
				        Operador operadorSeleccionado = null;
				        boolean encontradoOperador = false;
				        
				        do {
				            System.out.println("Ingrese el ID del operador:");
				            try {
				                long idOperador = sc.nextLong();
				                sc.nextLine();
				                
				                for (int i = 0; i < operadores.size(); i++) {
				                    if (operadores.get(i).getId() == idOperador) {
				                        operadorSeleccionado = operadores.get(i);
				                        encontradoOperador = true;
				                        break;
				                    }
				                }
				                
				                if (!encontradoOperador) {
				                    System.out.println("Error, no se encontro un operador con ese ID...");
				                }
				                
				            }catch(Exception e) {
				                sc.nextLine();
				                System.out.println("Error, valor invalido...");
				            }
				        }while(!encontradoOperador);
				        
				        if (verificadorReporte.verificarOperadorDisponible(operadorSeleccionado)
				                && verificadorReporte.verificarOperadorHabilitadoParaEspecial(operadorSeleccionado, reporteSeleccionado.getTipo())) {
				            
				            reporteSeleccionado.asignarOperador(operadorSeleccionado, notificador);
				            System.out.println("Reporte asignado al operador correctamente.");
				        }
				        
				    } else { 
				        
				        RutaRecoleccion rutaSeleccionada = null;
				        boolean encontradaRuta = false;
				        
				        do {
				            System.out.println("Ingrese el ID de la ruta:");
				            try {
				                long idRuta = sc.nextLong();
				                sc.nextLine();
				                
				                for (int i = 0; i < rutasRecoleccion.size(); i++) {
				                    if (rutasRecoleccion.get(i).getId() == idRuta) {
				                        rutaSeleccionada = rutasRecoleccion.get(i);
				                        encontradaRuta = true;
				                        break;
				                    }
				                }
				                
				                if (!encontradaRuta) {
				                    System.out.println("Error, no se encontro una ruta con ese ID...");
				                }
				                
				            }catch(Exception e) {
				                sc.nextLine();
				                System.out.println("Error, valor invalido...");
				            }
				        }while(!encontradaRuta);
				        
				        if (verificadorReporte.verificarRutaActivaParaAsignar(rutaSeleccionada)) {
				            reporteSeleccionado.asignarRuta(rutaSeleccionada, notificador);
				            System.out.println("Reporte asignado a la ruta correctamente.");
				        }
				    }
				    
					break;
					
					
				case 3: // Cambiar estado
				    
				    Reporte reporteParaCerrar = null;
				    boolean encontradoReporteCerrar = false;
				    
				    do {
				        System.out.println("Ingrese el ID del reporte a cerrar:");
				        try {
				            long idReporte = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < reportes.size(); i++) {
				                if (reportes.get(i).getId() == idReporte) {
				                    reporteParaCerrar = reportes.get(i);
				                    encontradoReporteCerrar = true;
				                    break;
				                }
				            }
				            
				            if (!encontradoReporteCerrar) {
				                System.out.println("Error, no se encontro un reporte con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontradoReporteCerrar);
				    
				    Recoleccion recoleccionDelReporte = null;
				    
				    for (int i = 0; i < recolecciones.size(); i++) {
				        if (recolecciones.get(i).getReporteAsociado().getId() == reporteParaCerrar.getId()) {
				            recoleccionDelReporte = recolecciones.get(i);
				            break;
				        }
				    }
				    
				    boolean tieneRecoleccion = recoleccionDelReporte != null;
				    double pesoTotal = tieneRecoleccion ? recoleccionDelReporte.getPesoTotal() : 0;
				    
				    if (verificadorReporte.verificarPuedeCerrar(reporteParaCerrar, tieneRecoleccion, pesoTotal)) {
				        reporteParaCerrar.cerrar(notificador);
				        
				        if (tieneRecoleccion) {
				            int puntosGanados = recoleccionDelReporte.calcularEcoPuntos();
				            reporteParaCerrar.getAutor().sumarEcopuntos(puntosGanados);
				            System.out.println(reporteParaCerrar.getAutor().getNombre() + " gano " + puntosGanados + " eco-puntos.");
				        }
				    }
				    
					break;
					
					
				case 4: //Pendientes
				    
				    System.out.println("=======================================");
				    System.out.println("||        REPORTES PENDIENTES        ||");
				    System.out.println("=======================================");
				    
				    boolean hayResultados = false;
				    
				    for (int i = 0; i < reportes.size(); i++) {
				        Reporte r = reportes.get(i);
				        boolean esPendiente = r.getEstado().equals("REGISTRADO") || r.getEstado().equals("ASIGNADO");
				        
				        if (esPendiente) {
				            r.mostrar();
				            hayResultados = true;
				        }
				    }
				    
				    if (!hayResultados) {
				        System.out.println("No hay reportes pendientes...");
				    }
				    
				    break;
				
				}
				
				
				break;//Hasta aca va reportes
				
				
				
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
							System.out.println("Ingrese el numero de orden de la parada:");
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
						
						System.out.println("Ingrese la accion que se espera realizar en esta parada:");
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
					
					
				case 3: //Registrar recoleccion
				    
				    Reporte reporteParaRecoleccion = null;
				    boolean encontradoReporteRec = false;
				    
				    do {
				        System.out.println("Ingrese el ID del reporte asociado a esta recoleccion:");
				        try {
				            long idReporte = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < reportes.size(); i++) {
				                if (reportes.get(i).getId() == idReporte) {
				                    reporteParaRecoleccion = reportes.get(i);
				                    encontradoReporteRec = true;
				                    break;
				                }
				            }
				            
				            if (!encontradoReporteRec) {
				                System.out.println("Error, no se encontro un reporte con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontradoReporteRec);
				    
				    if (!verificadorRecoleccion.verificarReporteAsignado(reporteParaRecoleccion)) {
				        break;
				    }
				    
				    Operador operadorResponsable = null;
				    boolean encontradoOperadorRec = false;
				    
				    do {
				        System.out.println("Ingrese el ID del operador responsable de la recoleccion:");
				        try {
				            long idOperador = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < operadores.size(); i++) {
				                if (operadores.get(i).getId() == idOperador) {
				                    operadorResponsable = operadores.get(i);
				                    encontradoOperadorRec = true;
				                    break;
				                }
				            }
				            
				            if (!encontradoOperadorRec) {
				                System.out.println("Error, no se encontro un operador con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontradoOperadorRec);
				    
				    long idRecoleccion = 0;
				    boolean verificadoRec = false;
				    
				    do {	do {
				        System.out.println("Ingrese ID de la recoleccion: ");
				        try {
				            idRecoleccion = sc.nextLong();
				            sc.nextLine();
				            break;
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				        }while(true);
				    
				    if(verificador.verificarLongitud(idRecoleccion) && verificador.verificarUnico(idRecoleccion, recolecciones)) {
				        verificadoRec = true;
				    }
				    }while(!verificadoRec);
				    
				    System.out.println("Ingrese observaciones de la recoleccion:");
				    String observaciones = sc.nextLine();
				    
				    Recoleccion newRecoleccion = new Recoleccion(idRecoleccion, observaciones, operadorResponsable, reporteParaRecoleccion);
				    
				    boolean agregarMasMateriales = true;
				    
				    do {
				        int opcionMaterial = 0;
				        boolean opcionMaterialValida = false;
				        
				        do {
				            System.out.println("Seleccione el material recolectado:");
				            System.out.println("1. Reciclable");
				            System.out.println("2. Organico");
				            System.out.println("3. Especial");
				            try {
				                opcionMaterial = sc.nextInt();
				                sc.nextLine();
				                if (opcionMaterial >= 1 && opcionMaterial <= 3) {
				                    opcionMaterialValida = true;
				                }else {
				                    System.out.println("Error, la opcion debe ser 1, 2 o 3...");
				                }
				            }catch(Exception e) {
				                sc.nextLine();
				                System.out.println("Error, valor invalido...");
				            }
				        }while(!opcionMaterialValida);
				        
				        Material materialSeleccionado = null;
				        if (opcionMaterial == 1) { materialSeleccionado = new MaterialReciclable("Reciclable", 0); }
				        else if (opcionMaterial == 2) { materialSeleccionado = new MaterialOrganico("Organico", 0); }
				        else { materialSeleccionado = new MaterialEspecial("Especial", 0); }
				        
				        if (!verificadorRecoleccion.verificarOperadorHabilitado(operadorResponsable, materialSeleccionado)) {
				            System.out.println("No se agrego este material a la recoleccion.");
				        }else {
				            double pesoMaterial = 0;
				            boolean pesoValido = false;
				            
				            do {
				                System.out.println("Ingrese el peso recolectado (kg):");
				                try {
				                    pesoMaterial = sc.nextDouble();
				                    sc.nextLine();
				                    if (pesoMaterial > 0) {
				                        pesoValido = true;
				                    }else {
				                        System.out.println("Error, el peso debe ser mayor a cero...");
				                    }
				                }catch(Exception e) {
				                    sc.nextLine();
				                    System.out.println("Error, valor invalido...");
				                }
				            }while(!pesoValido);
				            
				            newRecoleccion.agregarMaterial(materialSeleccionado, pesoMaterial);
				        }
				        
				        String respuesta;
				        boolean respuestaValida = false;
				        do {
				            System.out.println("¿Desea agregar otro material? (si/no):");
				            respuesta = sc.nextLine().toLowerCase();
				            if (respuesta.equals("si")) {
				                agregarMasMateriales = true;
				                respuestaValida = true;
				            }else if (respuesta.equals("no")) {
				                agregarMasMateriales = false;
				                respuestaValida = true;
				            }else {
				                System.out.println("Error, valor invalido...");
				            }
				        }while(!respuestaValida);
				        
				    }while(agregarMasMateriales);
				    
				    recolecciones.add(newRecoleccion);
				    System.out.println("Recoleccion registrada correctamente.");
				    
				    break;
		
					
					
				case 4: // Cerrar ruta 
				    
				    RutaRecoleccion rutaParaCerrar = null;
				    boolean encontradaRutaCerrar = false;
				    
				    do {
				        System.out.println("Ingrese el ID de la ruta a cerrar:");
				        try {
				            long idRuta = sc.nextLong();
				            sc.nextLine();
				            
				            for (int i = 0; i < rutasRecoleccion.size(); i++) {
				                if (rutasRecoleccion.get(i).getId() == idRuta) {
				                    rutaParaCerrar = rutasRecoleccion.get(i);
				                    encontradaRutaCerrar = true;
				                    break;
				                }
				            }
				            
				            if (!encontradaRutaCerrar) {
				                System.out.println("Error, no se encontro una ruta con ese ID...");
				            }
				            
				        }catch(Exception e) {
				            sc.nextLine();
				            System.out.println("Error, valor invalido...");
				        }
				    }while(!encontradaRutaCerrar);
				    
				    rutaParaCerrar.cerrar(notificador);
				    
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
				
				//Responsables
				System.out.println("Cargando Responsables...");
				Responsable responsable1 = new Responsable(1234567801L,"laura.gomez@eia.edu.co","Laura Gómez",true,"Inspeccion, Cierre de rutas","Gestión de residuos sólidos");
				responsables.add(responsable1);
				Responsable responsable2 = new Responsable(2345678912L,"andres.paez@eia.edu.co","Andrés Páez",true,"Recoleccion general, Recoleccion de material especial","Manejo de residuos especiales");
				responsables.add(responsable2);
				Responsable responsable3 = new Responsable(3456789023L,"camila.rios@eia.edu.co","Camila Ríos", false,"Inspeccion","Sostenibilidad y campañas ambientales");
				responsables.add(responsable3);
				
				//Puntos ecologicos
				System.out.println("Cargando Puntos Ecologicos...");
				PuntoEcologico punto1 = new PuntoEcologico(1122334455L, "Bloque 5 - Cafeteria", 100, false, true);
				punto1.agregarMaterial(new MaterialReciclable("Reciclable", 0));
				punto1.agregarMaterial(new MaterialOrganico("Organico", 0));
				puntosEcologicos.add(punto1);

				PuntoEcologico punto2 = new PuntoEcologico(2233445566L, "Zona deportiva", 150, false, true);
				punto2.agregarMaterial(new MaterialReciclable("Reciclable", 0));
				punto2.agregarMaterial(new MaterialEspecial("Especial", 0));
				puntosEcologicos.add(punto2);

				PuntoEcologico punto3 = new PuntoEcologico(3344556677L, "Parqueadero Norte", 80, true, false);
				punto3.agregarMaterial(new MaterialOrganico("Organico", 0));
				puntosEcologicos.add(punto3);

				//Paradas
				System.out.println("Cargando Paradas...");
				Parada parada1 = new Parada(1, "Recoger material reciclable");
				parada1.setPuntoEcologico(punto1);

				Parada parada2 = new Parada(2, "Inspeccionar caneca");
				parada2.setPuntoEcologico(punto2);

				Parada parada3 = new Parada(1, "Recoger material especial");
				parada3.setPuntoEcologico(punto2);

				Parada parada4 = new Parada(2, "Vaciar caneca");
				parada4.setPuntoEcologico(punto1);

				Parada parada5 = new Parada(1, "Inspeccionar punto");
				parada5.setPuntoEcologico(punto2);

				//Rutas de recoleccion
				System.out.println("Cargando Rutas de Recoleccion...");
				RutaRecoleccion ruta1 = new RutaRecoleccion(4455667788L, true);
				ruta1.agregarParada(parada1);
				ruta1.agregarParada(parada2);
				rutasRecoleccion.add(ruta1);

				RutaRecoleccion ruta2 = new RutaRecoleccion(5566778899L, true);
				ruta2.agregarParada(parada3);
				ruta2.agregarParada(parada4);
				rutasRecoleccion.add(ruta2);

				RutaRecoleccion ruta3 = new RutaRecoleccion(6677889900L, false);
				ruta3.agregarParada(parada5);
				rutasRecoleccion.add(ruta3);

				//Reportes
				System.out.println("Cargando Reportes...");
				Reporte reporte1 = new Reporte(7788990011L, esteban, punto1, "01/09/2026", "Caneca desbordada", "Desbordamiento", 3);
				reporte1.asignarOperador(juan, notificador);
				reportes.add(reporte1);

				Reporte reporte2 = new Reporte(8899001122L, mariana, punto2, "02/09/2026", "Material especial depositado sin autorizacion", "MaterialEspecial", 3);
				reporte2.asignarRuta(ruta1, notificador);
				reportes.add(reporte2);

				Reporte reporte3 = new Reporte(9900112233L, santiago, punto1, "03/09/2026", "Contaminacion por residuos organicos", "Contaminacion", 2);
				reporte3.asignarOperador(daniel, notificador);
				reportes.add(reporte3);

				//Recolecciones
				System.out.println("Cargando Recolecciones...");
				Recoleccion recoleccion1 = new Recoleccion(1112223334L, "Recoleccion sin novedades", juan, reporte1);
				recoleccion1.agregarMaterial(new MaterialReciclable("Reciclable", 0), 12.5);
				recoleccion1.agregarMaterial(new MaterialOrganico("Organico", 0), 5.0);
				recolecciones.add(recoleccion1);

				Recoleccion recoleccion2 = new Recoleccion(2223334445L, "Se encontro material adicional", daniel, reporte3);
				recoleccion2.agregarMaterial(new MaterialOrganico("Organico", 0), 3.2);
				recolecciones.add(recoleccion2);

				Recoleccion recoleccion3 = new Recoleccion(3334445556L, "Recoleccion rutinaria de la ruta", estephanie, reporte2);
				recoleccion3.agregarMaterial(new MaterialEspecial("Especial", 0), 8.0);
				recolecciones.add(recoleccion3);

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
