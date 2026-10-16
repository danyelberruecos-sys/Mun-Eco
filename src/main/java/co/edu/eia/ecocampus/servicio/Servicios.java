package co.edu.eia.ecocampus.servicio;

import co.edu.eia.ecocampus.patron.HistorialNotificaciones;

public class Servicios {

    private CargadorDatos cargador;
    private ServicioPersona personas;
    private ServicioPuntoEcologico puntos;
    private ServicioRuta rutas;
    private ServicioReporte reportes;
    private ServicioRecoleccion recolecciones;
    private ServicioCampania campanias;
    private ServicioEcoPuntos ecoPuntos;
    private ServicioIndicadores indicadores;
    private HistorialNotificaciones historial;

    

    public Servicios(CargadorDatos cargador,
                     ServicioPersona personas,
                     ServicioPuntoEcologico puntos,
                     ServicioRuta rutas,
                     ServicioReporte reportes,
                     ServicioRecoleccion recolecciones,
                     ServicioCampania campanias,
                     ServicioEcoPuntos ecoPuntos,
                     ServicioIndicadores indicadores,
                     HistorialNotificaciones historial) {
        this.cargador = cargador;
        this.personas = personas;
        this.puntos = puntos;
        this.rutas = rutas;
        this.reportes =reportes;
        this.recolecciones = recolecciones;
        this.campanias = campanias;
        this.ecoPuntos = ecoPuntos;
        this.indicadores = indicadores;
        this.historial = historial;
    }

    public CargadorDatos getCargador() {
        return cargador;
    }

    public ServicioPersona getPersonas() {
        return personas;
    }

    public ServicioPuntoEcologico getPuntos() {
        return puntos;
    }

    public ServicioRuta getRutas() {
        return rutas;
    }
    
    public ServicioReporte getReportes() { return reportes; }
    
    public ServicioRecoleccion getRecolecciones() {return recolecciones;}
    
    public ServicioCampania getCampanias() {return campanias;}
    
    public ServicioEcoPuntos getEcoPuntos() {return ecoPuntos;}
    
    public ServicioIndicadores getIndicadores() {return indicadores;}
    
    public HistorialNotificaciones getHistorial() { return historial; }
}