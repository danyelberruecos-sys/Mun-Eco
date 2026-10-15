package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.OperacionNoPermitidaException;
import co.edu.eia.ecocampus.modelo.Campania;
import co.edu.eia.ecocampus.modelo.Participacion;
import co.edu.eia.ecocampus.modelo.Usuario;

public class VerificadorCampania {

    public void verificarCampaniaActiva(Campania campania) throws OperacionNoPermitidaException {
        if (!campania.getEstado().equals("ACTIVA")) {
            throw new OperacionNoPermitidaException("La campaña está cerrada.");
        }
    }

    public void verificarNoInscritoPreviamente(Usuario usuario, Campania campania)
            throws OperacionNoPermitidaException {
        ArrayList<Participacion> participaciones = campania.getParticipaciones();

        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i).getUsuario().getId() == usuario.getId()) {
                throw new OperacionNoPermitidaException(
                        "El usuario ya está inscrito en esta campaña.");
            }
        }
    }

    public void verificarCupoDisponible(Campania campania) throws OperacionNoPermitidaException {
        if (campania.getParticipaciones().size() >= campania.getCupo()) {
            throw new OperacionNoPermitidaException("La campaña no tiene cupo disponible.");
        }
    }
}