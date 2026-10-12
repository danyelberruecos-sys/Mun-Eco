package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.DatoInvalidoException;
import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Notificador;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioReporte {

    private RepositorioMemoria<Reporte> reportes;
    private RepositorioMemoria<Persona> personas;
    private RepositorioMemoria<PuntoEcologico> puntos;
    private RepositorioMemoria<RutaRecoleccion> rutas;
    private RepositorioMemoria<Recoleccion> recolecciones;
    private Verificador verificador;
    private VerificadorReporte verificadorReporte;
    private Notificador notificador;

    public ServicioReporte(RepositorioMemoria<Reporte> reportes,
                           RepositorioMemoria<Persona> personas,
                           RepositorioMemoria<PuntoEcologico> puntos,
                           RepositorioMemoria<RutaRecoleccion> rutas,
                           RepositorioMemoria <Recoleccion> recolecciones,
                           Verificador verificador,
                           VerificadorReporte verificadorReporte,
                           Notificador notificador) {
        this.reportes = reportes;
        this.personas = personas;
        this.puntos = puntos;
        this.rutas = rutas;
        this.recolecciones = recolecciones;
        this.verificador = verificador;
        this.verificadorReporte = verificadorReporte;
        this.notificador = notificador;
    }


    public Reporte registrar(long id, Persona autor, PuntoEcologico punto, String fecha,
            String descripcion, String tipo, String prioridad) throws EcoCampusException {

        verificador.verificarId(id);
        verificador.verificarSeleccionado(autor, "el autor del reporte");
        verificador.verificarSeleccionado(punto, "el punto ecológico");
        verificadorReporte.verificarPuntoActivo(punto);
        verificador.verificarTextoObligatorio(fecha, "La fecha");
        verificador.verificarTextoObligatorio(descripcion, "La descripción");
        verificador.verificarSeleccionado(tipo, "el tipo de reporte");
        int nivel = prioridadANumero(prioridad);

        Reporte reporte = new Reporte(id, autor, punto, fecha, descripcion,
                tipoAValor(tipo), nivel);
        reportes.guardar(reporte);
        return reporte;
    }


    public void asignarAOperador(Reporte reporte, Operador operador) throws EcoCampusException {
        verificador.verificarSeleccionado(reporte, "un reporte de la tabla");
        verificador.verificarSeleccionado(operador, "un operador");
        verificadorReporte.verificarPuedeAsignar(reporte);
        verificadorReporte.verificarOperadorDisponible(operador);
        verificadorReporte.verificarOperadorHabilitadoParaEspecial(operador, reporte.getTipo());

        reporte.asignarOperador(operador, notificador);
    }

    public void asignarARuta(Reporte reporte, RutaRecoleccion ruta) throws EcoCampusException {
        verificador.verificarSeleccionado(reporte, "un reporte de la tabla");
        verificador.verificarSeleccionado(ruta, "una ruta");
        verificadorReporte.verificarPuedeAsignar(reporte);
        verificadorReporte.verificarRutaActivaParaAsignar(ruta);

        reporte.asignarRuta(ruta, notificador);
    }

    // ================= CONSULTAS =================
    public ArrayList<Reporte> listar(boolean soloPendientes) {
        ArrayList<Reporte> todos = reportes.listar();
        if (!soloPendientes) {
            return todos;
        }

        ArrayList<Reporte> pendientes = new ArrayList<>();
        for (int i = 0; i < todos.size(); i++) {
            String estado = todos.get(i).getEstado();
            if (estado.equals("REGISTRADO") || estado.equals("ASIGNADO")) {
                pendientes.add(todos.get(i));
            }
        }
        return pendientes;
    }

    public ArrayList<Persona> listarPersonas() {
        return personas.listar();
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

    public ArrayList<Operador> listarOperadores() {
        ArrayList<Operador> operadores = new ArrayList<>();
        ArrayList<Persona> todas = personas.listar();
        for (int i = 0; i < todas.size(); i++) {
            if (todas.get(i) instanceof Operador) {
                operadores.add((Operador) todas.get(i));
            }
        }
        return operadores;
    }

    public ArrayList<RutaRecoleccion> listarRutas() {
        return rutas.listar();
    }

   
    private int prioridadANumero(String texto) throws DatoInvalidoException {
        if ("Baja".equals(texto)) {
            return 1;
        }
        if ("Media".equals(texto)) {
            return 2;
        }
        if ("Alta".equals(texto)) {
            return 3;
        }
        throw new DatoInvalidoException("Seleccione la prioridad.");
    }


    private String tipoAValor(String tipo) {
        if (tipo.equals("Material especial")) {
            return "MaterialEspecial";
        }
        return tipo;
    }
    

	 public int cerrar(Reporte reporte) throws EcoCampusException {
	     verificador.verificarSeleccionado(reporte, "un reporte de la tabla");
	
	     Recoleccion recoleccion = buscarRecoleccion(reporte);
	     boolean tieneRecoleccion = recoleccion != null;
	     double pesoTotal = tieneRecoleccion ? recoleccion.getPesoTotal() : 0;
	
	     verificadorReporte.verificarPuedeCerrar(reporte, tieneRecoleccion, pesoTotal);
	
	     reporte.cerrar(notificador);
	
	     int puntosGanados = recoleccion.calcularEcoPuntos();
	     String concepto = "Recoleccion de material - Reporte #" + reporte.getId();
	     reporte.getAutor().sumarEcoPuntos(puntosGanados, concepto, reporte.getFecha());
	     notificador.notificar(reporte.getAutor().getNombre() + " ganó " + puntosGanados
	             + " eco-puntos.");
	
	     return puntosGanados;
	 }
	
	 private Recoleccion buscarRecoleccion(Reporte reporte) {
	     ArrayList<Recoleccion> todas = recolecciones.listar();
	     for (int i = 0; i < todas.size(); i++) {
	         if (todas.get(i).getReporteAsociado().getId() == reporte.getId()) {
	             return todas.get(i);
	         }
	     }
	     return null;
	 }
    
    
}
