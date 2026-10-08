package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.DatoInvalidoException;
import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.excepcion.OperacionNoPermitidaException;
import co.edu.eia.ecocampus.modelo.Parada;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;

public class VerificadorParada {
	
	public void verificarOrdenUnico(int orden, ArrayList<Parada> paradas)
	        throws DatoInvalidoException {
	    for (int i = 0; i < paradas.size(); i++) {
	        if (paradas.get(i).getOrden() == orden) {
	            throw new DatoInvalidoException(
	                    "Ya existe una parada con el orden " + orden + " en esta ruta.");
	        }
	    }
	}

	public void verificarPuntoActivo(PuntoEcologico punto) throws EcoCampusException {
	    if (punto == null) {
	        throw new DatoInvalidoException("Seleccione un punto ecológico.");
	    }
	    if (!punto.getActivo()) {
	        throw new OperacionNoPermitidaException("El punto ecológico seleccionado está inactivo.");
	    }
	}

	public void verificarHayParadas(ArrayList<Parada> paradas) throws DatoInvalidoException {
	    if (paradas.isEmpty()) {
	        throw new DatoInvalidoException("La ruta debe tener al menos una parada.");
	    }
	}
}
