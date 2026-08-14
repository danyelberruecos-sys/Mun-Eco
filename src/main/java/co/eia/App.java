package co.eia;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean salida = false;
		String accion = null;
		
		
		do {
			
			System.out.println("-------MENU PRINCIPAL-------");
			System.out.println("-Salir");
			
			try {
				System.out.println("Ingrese el nombre de la accion a realizar: ");
				accion = scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Error, valor ingresado invalido, debe ser un numero entero.");
			}
			accion.toLowerCase();
			
			switch(accion) {
			
			case "salir": 
				System.out.println("Saliendo...");
				salida = true;
			}
			
			
			
		}while(!salida);
		
		scanner.close();
	}
}
