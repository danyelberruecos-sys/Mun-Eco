package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.modelo.Actividad;
import co.edu.eia.ecocampus.modelo.Campania;
import co.edu.eia.ecocampus.modelo.Indicador;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.modelo.Responsable;
import co.edu.eia.ecocampus.modelo.ResumenMateriales;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;
import co.edu.eia.ecocampus.modelo.Usuario;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioIndicadores {

    private RepositorioMemoria<Persona> personas;
    private RepositorioMemoria<PuntoEcologico> puntos;
    private RepositorioMemoria<RutaRecoleccion> rutas;
    private RepositorioMemoria<Reporte> reportes;
    private RepositorioMemoria<Recoleccion> recolecciones;
    private RepositorioMemoria<Campania> campanias;
    private RepositorioMemoria<Actividad> actividades;
    private ServicioEcoPuntos servicioEcoPuntos;

    public ServicioIndicadores(RepositorioMemoria<Persona> personas,
                               RepositorioMemoria<PuntoEcologico> puntos,
                               RepositorioMemoria<RutaRecoleccion> rutas,
                               RepositorioMemoria<Reporte> reportes,
                               RepositorioMemoria<Recoleccion> recolecciones,
                               RepositorioMemoria<Campania> campanias,
                               RepositorioMemoria<Actividad> actividades,
                               ServicioEcoPuntos servicioEcoPuntos) {
        this.personas = personas;
        this.puntos = puntos;
        this.rutas = rutas;
        this.reportes = reportes;
        this.recolecciones = recolecciones;
        this.campanias = campanias;
        this.actividades = actividades;
        this.servicioEcoPuntos = servicioEcoPuntos;
    }


    public ArrayList<Indicador> indicadoresPersonas() {
        ArrayList<Persona> todas = personas.listar();
        int usuarios = 0;
        int operadores = 0;
        int responsables = 0;
        int disponibles = 0;

        for (int i = 0; i < todas.size(); i++) {
            Persona p = todas.get(i);

            if (p instanceof Usuario) {
                usuarios++;
            } else if (p instanceof Operador) {
                operadores++;
                if (((Operador) p).getDisponible()) {
                    disponibles++;
                }
            } else if (p instanceof Responsable) {
                responsables++;
            }
        }

        ArrayList<Indicador> lista = new ArrayList<>();
        agregar(lista, "Total de personas", String.valueOf(todas.size()));
        agregar(lista, "Usuarios", String.valueOf(usuarios));
        agregar(lista, "Operadores", String.valueOf(operadores));
        agregar(lista, "Responsables", String.valueOf(responsables));
        agregar(lista, "Operadores disponibles", disponibles + " de " + operadores);
        return lista;
    }

  
    public ArrayList<Indicador> indicadoresPuntos() {
        ArrayList<PuntoEcologico> todos = puntos.listar();
        int activos = 0;

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getActivo()) {
                activos++;
            }
        }

        ArrayList<Indicador> lista = new ArrayList<>();
        agregar(lista, "Total de puntos", String.valueOf(todos.size()));
        agregar(lista, "Activos", String.valueOf(activos));
        agregar(lista, "Inactivos", String.valueOf(todos.size() - activos));
        return lista;
    }


    public ArrayList<Indicador> indicadoresReportes() {
        ArrayList<Reporte> todos = reportes.listar();
        int registrados = 0;
        int asignados = 0;
        int cerrados = 0;
        int alta = 0;
        int media = 0;
        int baja = 0;

        for (int i = 0; i < todos.size(); i++) {
            Reporte r = todos.get(i);
            String estado = r.getEstado();

            if (estado.equals("REGISTRADO")) {
                registrados++;
            } else if (estado.equals("ASIGNADO")) {
                asignados++;
            } else if (estado.equals("CERRADO")) {
                cerrados++;
            }

            if (r.getPrioridadTexto().equals("Alta")) {
                alta++;
            } else if (r.getPrioridadTexto().equals("Media")) {
                media++;
            } else if (r.getPrioridadTexto().equals("Baja")) {
                baja++;
            }
        }

        ArrayList<Indicador> lista = new ArrayList<>();
        agregar(lista, "Total de reportes", String.valueOf(todos.size()));
        agregar(lista, "Registrados", String.valueOf(registrados));
        agregar(lista, "Asignados", String.valueOf(asignados));
        agregar(lista, "Cerrados", String.valueOf(cerrados));
        agregar(lista, "Prioridad alta", String.valueOf(alta));
        agregar(lista, "Prioridad media", String.valueOf(media));
        agregar(lista, "Prioridad baja", String.valueOf(baja));
        return lista;
    }


    public ArrayList<Indicador> indicadoresRutas() {
        ArrayList<RutaRecoleccion> todasRutas = rutas.listar();
        int activas = 0;
        int totalParadas = 0;

        for (int i = 0; i < todasRutas.size(); i++) {
            if (todasRutas.get(i).getActiva()) {
                activas++;
            }
            totalParadas = totalParadas + todasRutas.get(i).getParadas().size();
        }

        ArrayList<Recoleccion> todasRec = recolecciones.listar();
        double pesoTotal = 0;
        for (int i = 0; i < todasRec.size(); i++) {
            pesoTotal = pesoTotal + todasRec.get(i).getPesoTotal();
        }

        ResumenMateriales resumen = servicioEcoPuntos.resumenMateriales();

        ArrayList<Indicador> lista = new ArrayList<>();
        agregar(lista, "Total de rutas", String.valueOf(todasRutas.size()));
        agregar(lista, "Rutas activas", String.valueOf(activas));
        agregar(lista, "Rutas cerradas", String.valueOf(todasRutas.size() - activas));
        agregar(lista, "Paradas registradas", String.valueOf(totalParadas));
        agregar(lista, "Recolecciones", String.valueOf(todasRec.size()));
        agregar(lista, "Peso recolectado", kilos(pesoTotal));
        agregar(lista, "Reciclable", kilos(resumen.getReciclable()));
        agregar(lista, "Orgánico", kilos(resumen.getOrganico()));
        agregar(lista, "Especial", kilos(resumen.getEspecial()));
        return lista;
    }


    public ArrayList<Indicador> indicadoresCampanias() {
        ArrayList<Campania> todas = campanias.listar();
        int activas = 0;
        int inscripciones = 0;
        int cupoTotal = 0;

        for (int i = 0; i < todas.size(); i++) {
            Campania c = todas.get(i);

            if (c.getEstado().equals("ACTIVA")) {
                activas++;
            }
            inscripciones = inscripciones + c.getParticipaciones().size();
            cupoTotal = cupoTotal + c.getCupo();
        }

        ArrayList<Indicador> lista = new ArrayList<>();
        agregar(lista, "Total de campañas", String.valueOf(todas.size()));
        agregar(lista, "Activas", String.valueOf(activas));
        agregar(lista, "Cerradas", String.valueOf(todas.size() - activas));
        agregar(lista, "Actividades", String.valueOf(actividades.listar().size()));
        agregar(lista, "Inscripciones", String.valueOf(inscripciones));
        agregar(lista, "Cupo total ofrecido", String.valueOf(cupoTotal));
        return lista;
    }


    
    public ArrayList<Indicador> indicadoresEcoPuntos() {
        ArrayList<Persona> todas = personas.listar();
        int total = 0;
        Persona lider = null;

        for (int i = 0; i < todas.size(); i++) {
            int puntosPersona = todas.get(i).getEcopuntos();
            total = total + puntosPersona;

            if (lider == null || puntosPersona > lider.getEcopuntos()) {
                lider = todas.get(i);
            }
        }

        String textoLider = "Nadie aún";
        if (lider != null && lider.getEcopuntos() > 0) {
            textoLider = lider.getNombre() + " (" + lider.getEcopuntos() + " pts)";
        }

        double promedio = 0;
        if (todas.size() > 0) {
            promedio = (double) total / todas.size();
        }

        ArrayList<Indicador> lista = new ArrayList<>();
        agregar(lista, "Eco-puntos otorgados", String.valueOf(total));
        agregar(lista, "Persona con más eco-puntos", textoLider);
        agregar(lista, "Promedio por persona", String.format("%.2f", promedio));
        return lista;
    }

    private void agregar(ArrayList<Indicador> lista, String titulo, String valor) {
        lista.add(new Indicador(titulo, valor));
    }

    private String kilos(double valor) {
        return String.format("%.1f kg", valor);
    }
}