package co.eia;

public class VerificadorReporte {

	
    public boolean verificarPuntoActivo(PuntoEcologico punto) {
        if (punto.getActivo()) {
            return true;
        } else {
            System.out.println("Error, no se puede registrar un reporte sobre un punto inactivo...");
            return false;
        }
    }
    
    
    public boolean verificarOperadorDisponible(Operador operador) {
        if (operador.getDisponible()) {
            return true;
        } else {
            System.out.println("Error, el operador seleccionado no esta disponible...");
            return false;
        }
    }
    
    
    public boolean verificarOperadorHabilitadoParaEspecial(Operador operador, String tipoReporte) {
        if (!tipoReporte.equalsIgnoreCase("MaterialEspecial")) {
            return true;
        }
        if (operador.getAccionesPermitidas().toLowerCase().contains("especial")) {
            return true;
        } else {
            System.out.println("Error, el operador no esta habilitado para material especial...");
            return false;
        }
    }
    
    
    public boolean verificarPuedeAsignar(Reporte reporte) {
        String estado = reporte.getEstado();
        if (estado.equals("REGISTRADO")) {
            return true;
        } else {
            System.out.println("Error, el reporte no se puede asignar desde su estado actual (" + estado + ")...");
            return false;
        }
    }
    
    
    public boolean verificarRutaActivaParaAsignar(RutaRecoleccion ruta) {
        if (ruta.getActiva()) {
            return true;
        } else {
            System.out.println("Error, no se puede asignar el reporte a una ruta cerrada...");
            return false;
        }
    }
    
    
    public boolean verificarPuedeCerrar(Reporte reporte, boolean tieneRecoleccionAsociada, double pesoTotal) {
        if (!reporte.getEstado().equals("ASIGNADO")) {
            System.out.println("Error, solo se puede cerrar un reporte que este asignado...");
            return false;
        }
        if (!tieneRecoleccionAsociada) {
            System.out.println("Error, el reporte no tiene una recoleccion asociada...");
            return false;
        }
        if (pesoTotal <= 0) {
            System.out.println("Error, el peso total debe ser mayor a cero...");
            return false;
        }
        return true;
    }
    
    
}
