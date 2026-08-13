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
	
	public void agragarParada(ArrayList <Parada> listaParadas) {
		for(int i = 0; i < listaParadas.size();i++) {
			System.out.println("1.");
		}
	}

}
