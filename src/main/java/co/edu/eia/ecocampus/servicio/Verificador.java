package co.edu.eia.ecocampus.servicio;

import co.edu.eia.ecocampus.excepcion.*;
import co.edu.eia.ecocampus.repositorio.*;


public class Verificador {
	
	public void verificarId(long id) throws DatoInvalidoException, DuplicadoException {
		if (id <= 0) {
			throw new DatoInvalidoException("El ID debe ser mayor a cero");
		}
		if(RepositorioMemoria.idExistenteEnTodos(id)) {
			throw new DuplicadoException("El ID ya esta en uso, intente con uno distinto");
		}
	}
	

	public void verificarTextoObligatorio(String texto, String campo) throws DatoInvalidoException {
		if (texto == null || texto.trim().isEmpty()) {
			throw new DatoInvalidoException (campo + "es obligatorio. ");
		}
	}

}
