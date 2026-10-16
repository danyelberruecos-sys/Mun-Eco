package co.edu.eia.ecocampus.patron;

import java.util.ArrayList;

import co.edu.eia.ecocampus.modelo.Notificacion;

public class HistorialNotificaciones implements ObservadorNotificacion {

    private ArrayList<Notificacion> notificaciones = new ArrayList<>();

    @Override
    public void recibir(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return new ArrayList<>(notificaciones);
    }

    public void limpiar() {
        notificaciones.clear();
    }
}