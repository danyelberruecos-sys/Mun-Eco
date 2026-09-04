package co.eia;

import java.util.ArrayList;

public class Verificador {
	
	public boolean verificarUnico(long id,  ArrayList<? extends Verificable> lista) {
		boolean unico = true;
		for (int i = 0; i < lista.size();i++) {
			if (id == lista.get(i).getId()) {
				unico = false;
			}
		}
		if (unico) {return true;}
		else {
			System.out.println("Error, el ID ya esta e uso");
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
