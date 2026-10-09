package co.edu.eia.ecocampus.servicio;

import co.edu.eia.ecocampus.excepcion.OperacionNoPermitidaException;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;

public class VerificadorReporte {

    public void verificarPuntoActivo(PuntoEcologico punto) throws OperacionNoPermitidaException {
        if (!punto.getActivo()) {
            throw new OperacionNoPermitidaException(
                    "No se puede registrar un reporte sobre un punto inactivo.");
        }
    }

    public void verificarOperadorDisponible(Operador operador) throws OperacionNoPermitidaException {
        if (!operador.getDisponible()) {
            throw new OperacionNoPermitidaException(
                    "El operador seleccionado no está disponible.");
        }
    }

    public void verificarOperadorHabilitadoParaEspecial(Operador operador, String tipoReporte) throws OperacionNoPermitidaException {
        if (!tipoReporte.equalsIgnoreCase("MaterialEspecial")) {
            return;
        }
        if (!operador.getAccionesPermitidas().toLowerCase().contains("especial")) {
            throw new OperacionNoPermitidaException(
                    "El operador no está habilitado para material especial.");
        }
    }

    public void verificarPuedeAsignar(Reporte reporte) throws OperacionNoPermitidaException {
        String estado = reporte.getEstado();
        if (!estado.equals("REGISTRADO")) {
            throw new OperacionNoPermitidaException(
                    "El reporte no se puede asignar desde su estado actual (" + estado + ").");
        }
    }

    public void verificarRutaActivaParaAsignar(RutaRecoleccion ruta) throws OperacionNoPermitidaException {
        if (!ruta.getActiva()) {
            throw new OperacionNoPermitidaException(
                    "No se puede asignar el reporte a una ruta cerrada.");
        }
    }

    public void verificarPuedeCerrar(Reporte reporte, boolean tieneRecoleccionAsociada,double pesoTotal) throws OperacionNoPermitidaException {
        if (!reporte.getEstado().equals("ASIGNADO")) {
            throw new OperacionNoPermitidaException(
                    "Solo se puede cerrar un reporte que esté asignado.");
        }
        if (!tieneRecoleccionAsociada) {throw new OperacionNoPermitidaException(
                    "El reporte no tiene una recolección asociada.");
        }
        if (pesoTotal <= 0) {throw new OperacionNoPermitidaException(
                    "El peso total debe ser mayor a cero.");
        }
    }
}
