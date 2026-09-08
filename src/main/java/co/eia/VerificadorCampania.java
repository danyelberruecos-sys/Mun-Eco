package co.eia;

import java.util.ArrayList;

public class VerificadorCampania {

    public boolean verificarCampaniaActiva(Campania campania) {
        if (campania.getEstado().equals("ACTIVA")) {
            return true;
        } else {
            System.out.println("Error, la campania esta cerrada, no admite nuevas inscripciones ni actividades...");
            return false;
        }
    }

    public boolean verificarNoInscritoPreviamente(Usuario usuario, Campania campania) {
        ArrayList<Participacion> participaciones = campania.getParticipaciones();

        for (int i = 0; i < participaciones.size(); i++) {
            if (participaciones.get(i).getUsuario().getId() == usuario.getId()) {
                System.out.println("Error, esta persona ya esta inscrita en esta campania...");
                return false;
            }
        }
        return true;
    }

    public boolean verificarCupoDisponible(Campania campania) {
        if (campania.getParticipaciones().size() < campania.getCupo()) {
            return true;
        } else {
            System.out.println("Error, la campania ya alcanzo su cupo maximo...");
            return false;
        }
    }
}