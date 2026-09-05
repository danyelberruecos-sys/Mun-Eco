package co.eia;

import java.util.ArrayList;

public class RutaRecoleccion implements Verificable {
	
	private ArrayList <Parada> paradas = new ArrayList();
	private long id;
	
	public long getId() {return id;}
	
	public ArrayList <Parada> getParadas(){
		return paradas;
	}

}
