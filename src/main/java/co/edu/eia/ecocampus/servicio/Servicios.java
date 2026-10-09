package co.edu.eia.ecocampus.servicio;

public class Servicios {

    private CargadorDatos cargador;
    private ServicioPersona personas;
    private ServicioPuntoEcologico puntos;
    private ServicioRuta rutas;
    private ServicioReporte reportes;

    public Servicios(CargadorDatos cargador,
                     ServicioPersona personas,
                     ServicioPuntoEcologico puntos,
                     ServicioRuta rutas,
                     ServicioReporte reportes) {
        this.cargador = cargador;
        this.personas = personas;
        this.puntos = puntos;
        this.rutas = rutas;
        this.reportes =reportes;
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
}