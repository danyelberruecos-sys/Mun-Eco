package co.edu.eia.ecocampus.servicio;

import co.edu.eia.ecocampus.modelo.Material;
import co.edu.eia.ecocampus.modelo.MaterialEspecial;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Reporte;

public class VerificadorRecoleccion {
	
	 public boolean verificarOperadorHabilitado(Operador operador, Material material) {
	    if (material instanceof MaterialEspecial) {
	    	if (operador.getAccionesPermitidas().toLowerCase().contains("especial")) {
	    		return true;
	        } else {
	            System.out.println("Error, el operador no esta habilitado para manejar material especial...");
	            return false;
	            }
	        }
	        return true;
	 }

	    
	 public boolean verificarReporteAsignado(Reporte reporte) {
		 if (reporte.getEstado().equals("ASIGNADO")) {
			 return true;
	     } else {
	        System.out.println("Error, el reporte debe estar asignado antes de registrar una recoleccion...");
	        return false;
	        }
	 }
	
}
