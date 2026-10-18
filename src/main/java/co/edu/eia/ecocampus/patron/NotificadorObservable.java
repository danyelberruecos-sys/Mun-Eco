package co.edu.eia.ecocampus.patron;

import java.util.ArrayList;

import co.edu.eia.ecocampus.modelo.Notificacion;
import co.edu.eia.ecocampus.modelo.Notificador;

public class NotificadorObservable implements Notificador {
	
	   private static NotificadorObservable instancia;

    private ArrayList<ObservadorNotificacion> observadores = new ArrayList<>();
    
    private NotificadorObservable() {
    }

    public static NotificadorObservable getInstancia() {
        if (instancia == null) {
            instancia = new NotificadorObservable();
        }
        return instancia;
    }
    
    

    public void agregarObservador(ObservadorNotificacion observador) {
        observadores.add(observador);
    }

    public void quitarObservador(ObservadorNotificacion observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar(String mensaje) {
        Notificacion notificacion = new Notificacion(mensaje);

        for (int i = 0; i < observadores.size(); i++) {
            observadores.get(i).recibir(notificacion);
        }
    }
}