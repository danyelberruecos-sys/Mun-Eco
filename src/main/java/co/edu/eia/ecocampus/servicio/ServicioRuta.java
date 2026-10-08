package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.excepcion.OperacionNoPermitidaException;
import co.edu.eia.ecocampus.modelo.Notificador;
import co.edu.eia.ecocampus.modelo.Parada;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioRuta {

    private RepositorioMemoria<RutaRecoleccion> rutas;
    private RepositorioMemoria<PuntoEcologico> puntos;
    private Verificador verificador;
    private VerificadorParada verificadorParada;
    private Notificador notificador;

    public ServicioRuta(RepositorioMemoria<RutaRecoleccion> rutas,
                        RepositorioMemoria<PuntoEcologico> puntos,
                        Verificador verificador,
                        VerificadorParada verificadorParada,
                        Notificador notificador) {
        this.rutas = rutas;
        this.puntos = puntos;
        this.verificador = verificador;
        this.verificadorParada = verificadorParada;
        this.notificador = notificador;
    }

   
    public Parada crearParada(int orden, String accion, PuntoEcologico punto,
            ArrayList<Parada> paradasActuales) throws EcoCampusException {

        verificador.verificarPositivo(orden, "El orden");
        verificadorParada.verificarOrdenUnico(orden, paradasActuales);
        verificador.verificarTextoObligatorio(accion, "La acción esperada");
        verificadorParada.verificarPuntoActivo(punto);

        Parada parada = new Parada(orden, accion);
        parada.setPuntoEcologico(punto);
        return parada;
    }

    public RutaRecoleccion registrar(long id, boolean activa, ArrayList<Parada> paradas)
            throws EcoCampusException {

        verificador.verificarId(id);
        verificadorParada.verificarHayParadas(paradas);

        RutaRecoleccion ruta = new RutaRecoleccion(id, activa);
        for (int i = 0; i < paradas.size(); i++) {
            ruta.agregarParada(paradas.get(i));
        }

        rutas.guardar(ruta);
        return ruta;
    }

    public void cerrar(RutaRecoleccion ruta) throws EcoCampusException {
        if (!ruta.getActiva()) {
            throw new OperacionNoPermitidaException("La ruta ya está cerrada.");
        }
        ruta.cerrar(notificador);
    }

  
    public ArrayList<PuntoEcologico> listarPuntosActivos() {
        ArrayList<PuntoEcologico> activos = new ArrayList<>();
        ArrayList<PuntoEcologico> todos = puntos.listar();
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getActivo()) {
                activos.add(todos.get(i));
            }
        }
        return activos;
    }

    public ArrayList<RutaRecoleccion> listar() {
        return rutas.listar();
    }
}