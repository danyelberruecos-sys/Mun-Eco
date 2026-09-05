package co.eia;

public class VerificadorParada {
	public boolean verificarPuntoActivo(PuntoEcologico puntoEcologico) {
		if( puntoEcologico.getActivo()) {
			return true;
		}else {
			System.out.println("Error, el punot ecologico seleccionado esta inactivo...");
			return false;
		}
	}
	
	   public boolean verificarOrdenUnico(int orden, RutaRecoleccion rutaRecoleccion) {
	        for (int i = 0; i < rutaRecoleccion.getParadas().size(); i++) {
	            if (rutaRecoleccion.getParadas().get(i).getOrden() == orden) {
	            	System.out.println("Error, el valor de orden ya esta ocupado por otra parada...");
	                return false;
	            }
	        }
	        return true;
	    }
}
