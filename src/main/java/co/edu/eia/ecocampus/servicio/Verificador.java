package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.modelo.Identificable;

public class Verificador {
	
	public boolean verificarUnico(long id,  ArrayList<? extends Identificable> lista) {
		boolean unico = true;
		for (int i = 0; i < lista.size();i++) {
			if (id == lista.get(i).getId()) {
				unico = false;
			}
		}
		if (unico) {return true;}
		else {
			System.out.println("Error, el ID ya esta en uso");
			return false;}
	}
	
	public boolean verificarLongitud(long id) {
		int cantidadDigitos = String.valueOf(id).length();
		if(cantidadDigitos == 10) {
			return true;
		}else {
			System.out.println("Error, la longitud del ID debe ser de 10 digitos...");
			return false;}
	}

}
