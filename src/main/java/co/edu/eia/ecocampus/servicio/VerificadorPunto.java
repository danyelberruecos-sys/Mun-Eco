package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.OperacionNoPermitidaException;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Reporte;

public class VerificadorPunto {

	public void verificarPuedeInactivar(PuntoEcologico punto, ArrayList<Reporte> reportes)
	        throws OperacionNoPermitidaException {

	    if (!punto.getActivo()) {
	        throw new OperacionNoPermitidaException("El punto ecológico ya está inactivo.");
	    }

	    for (int i = 0; i < reportes.size(); i++) {
	        Reporte r = reportes.get(i);
	        boolean abierto = r.getEstado().equals("REGISTRADO") || r.getEstado().equals("ASIGNADO");

	        if (abierto && r.getPunto().getId() == punto.getId()) {
	            throw new OperacionNoPermitidaException(
	                    "El punto tiene reportes abiertos y no puede inactivarse.");
	        }
	    }
	}
}