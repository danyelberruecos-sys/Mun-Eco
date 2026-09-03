package co.eia;

import java.util.ArrayList;

public class Verificador {
	
	public boolean verificarUnico(int id,  ArrayList<? extends Verificable> lista) {
		boolean unico = true;
		for (int i = 0; i < lista.size();i++) {
			if (id == lista.get(i).getId()) {
				unico = false;
			}
		}
		if (unico) {return true;}
		else {return false;}
	}
	
	public boolean verificarLongitud(int id) {
		int cantidadDigitos = String.valueOf(id).length();
		if(cantidadDigitos == 10) {
			return true;
		}else {return false;}
	}

}
