package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.DatoInvalidoException;
import co.edu.eia.ecocampus.excepcion.OperacionNoPermitidaException;
import co.edu.eia.ecocampus.modelo.DetalleRecoleccion;
import co.edu.eia.ecocampus.modelo.Material;
import co.edu.eia.ecocampus.modelo.MaterialEspecial;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.Reporte;

public class VerificadorRecoleccion {
	
	 public void verificarOperadorHabilitado(Operador operador, Material material)  throws OperacionNoPermitidaException{
	    if (material instanceof MaterialEspecial) {
	    	if (!operador.getAccionesPermitidas().toLowerCase().contains(material.getNombre().toLowerCase())) {
	    		throw new OperacionNoPermitidaException("El operador no puede recoger material " + material.getNombre() + ".");
	        	} 
	        }	        
	 }

	    
	  public void verificarReporteAsignado(Reporte reporte) throws OperacionNoPermitidaException {
	        if (!reporte.getEstado().equals("ASIGNADO")) {
	            throw new OperacionNoPermitidaException( "Solo se puede registrar una recolección sobre un reporte asignado.");
	        }
	    }
	  
	    public void verificarSinRecoleccionPrevia(Reporte reporte, ArrayList<Recoleccion> recolecciones)
	            throws OperacionNoPermitidaException {
	        for (int i = 0; i < recolecciones.size(); i++) {
	            if (recolecciones.get(i).getReporteAsociado().getId() == reporte.getId()) {
	                throw new OperacionNoPermitidaException("El reporte ya tiene una recolección registrada.");
	            }
	        }
	    }
	
	    public void verificarHayMateriales(ArrayList<DetalleRecoleccion> detalles) throws DatoInvalidoException {
	        if (detalles.isEmpty()) {
	            throw new DatoInvalidoException("Agregue al menos un material a la recolección.");
	        }
	    }
	}

