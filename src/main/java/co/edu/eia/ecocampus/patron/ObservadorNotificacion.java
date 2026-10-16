package co.edu.eia.ecocampus.patron;

import co.edu.eia.ecocampus.modelo.Notificacion;

public interface ObservadorNotificacion {

    void recibir(Notificacion notificacion);
}