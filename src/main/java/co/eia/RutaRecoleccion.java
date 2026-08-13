package co.eia;

import java.util.ArrayList;

public class RutaRecoleccion {
	private int id;
	private boolean estado;
	private ArrayList <Parada> paradas;
	
	
	public RutaRecoleccion(int id, boolean estado) {
		this.id = id;
		this.estado = estado;
	}
	
	
	// antes de usar este metodo se debe hacer un bucle for donde se muestre la opciones de paradas 
	//y se seleccione el buscador para este metodo
	public void agragarParada(ArrayList <Parada> listaParadas, int buscador) {
		for(int i = 0; i < listaParadas.size();i++) {
			if(listaParadas.get(i).getnumero() == buscador) {
				paradas.add(listaParadas.get(i));
			}
		}
	}

}
