package co.eia;

import java.util.ArrayList;

public class VerificadorPunto {

    public boolean verificarSinReportesAbiertos(PuntoEcologico punto, ArrayList<Reporte> reportes) {
        for (int i = 0; i < reportes.size(); i++) {
            Reporte r = reportes.get(i);
            if (r.getPunto().getId() == punto.getId() && !r.getEstado().equals("CERRADO")) {
                System.out.println("Error, el punto tiene reportes abiertos, no se puede inactivar...");
                return false;
            }
        }
        return true;
    }
}