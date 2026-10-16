package co.edu.eia.ecocampus.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notificacion {

    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private String mensaje;
    private String fechaHora;

    public Notificacion(String mensaje) {
        
    	this.mensaje = mensaje.replaceAll("\\s+", " ").trim();
    	this.fechaHora = LocalDateTime.now().format(FORMATO);
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFechaHora() {
        return fechaHora;
    }
}