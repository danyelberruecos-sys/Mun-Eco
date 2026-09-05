package co.eia;

public class VerificadorParada {
	public boolean verificarPuntoActivo(PuntoEcologico puntoEcologico) {
		return puntoEcologico.getActivo();
	}
	
	   public boolean verificarOrdenUnico(int orden, RutaRecoleccion rutaRecoleccion) {
	        for (int i = 0; i < rutaRecoleccion.getParadas().size(); i++) {
	            if (rutaRecoleccion.getParadas().get(i).getOrden() == orden) {
	                return false;
	            }
	        }
	        return true;
	    }
}
