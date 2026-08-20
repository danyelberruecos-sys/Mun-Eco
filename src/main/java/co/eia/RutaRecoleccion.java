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
				break;
			}
		}
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void mostrar() {
		System.out.println("------------------------------");
		System.out.println("ID: " + id);
		System.out.println("Estado: " + estado);
		System.out.println("Paradas: ");
		for (int i = 0; i < paradas.size(); i++) {
			System.out.println(paradas.get(i).getnumero());
		}
		System.out.println("------------------------------");
	}

}
