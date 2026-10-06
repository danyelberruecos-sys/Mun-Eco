package co.edu.eia.ecocampus.servicio;

import co.edu.eia.ecocampus.modelo.*;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class CargadorDatos {

    private final RepositorioMemoria<Persona> personas;
    private final RepositorioMemoria<PuntoEcologico> puntos;
    private final RepositorioMemoria<RutaRecoleccion> rutas;
    private final RepositorioMemoria<Reporte> reportes;
    private final RepositorioMemoria<Recoleccion> recolecciones;
    private final RepositorioMemoria<Campania> campanias;
    private final RepositorioMemoria<Actividad> actividades;
    private final Notificador notificador;

    private boolean cargado = false;

    public CargadorDatos(RepositorioMemoria<Persona> personas,
                         RepositorioMemoria<PuntoEcologico> puntos,
                         RepositorioMemoria<RutaRecoleccion> rutas,
                         RepositorioMemoria<Reporte> reportes,
                         RepositorioMemoria<Recoleccion> recolecciones,
                         RepositorioMemoria<Campania> campanias,
                         RepositorioMemoria<Actividad> actividades,
                         Notificador notificador) {
        this.personas = personas;
        this.puntos = puntos;
        this.rutas = rutas;
        this.reportes = reportes;
        this.recolecciones = recolecciones;
        this.campanias = campanias;
        this.actividades = actividades;
        this.notificador = notificador;
    }

    /** Carga los datos una sola vez. Devuelve false si ya estaban cargados. */
    public boolean cargar() {
        if (cargado) {
            return false;
        }

        // ---- Usuarios ----
        Usuario esteban = new Usuario(1029387354L, "estebanano@gmail.com", "Esteban Trujillo", "Estudiante");
        Usuario mariana = new Usuario(2345432389L, "marryana@gmail.com", "Mariana Giraldo", "Estudiante");
        Usuario santiago = new Usuario(5834549087L, "zantir4m1@gmail.com", "Santiago Ramirez", "Profesor");
        personas.guardar(esteban);
        personas.guardar(mariana);
        personas.guardar(santiago);

        // ---- Operadores ----
        Operador juan = new Operador(3382934784L, "juancho@gmail.com", "Juan Pablo Castaño", true,
                "Recolectar material especial, Inspeccion de puntos");
        Operador estephanie = new Operador(5467389230L, "estephalaenana@gmail.com", "Estephanie Taborda", false,
                "Recoleccion general, Cierre de rutas");
        Operador daniel = new Operador(1020116808L, "danyflow@gmail.com", "Daniel Gutierrez", true,
                "Recolectar material especial, Recoleccion material especial");
        personas.guardar(juan);
        personas.guardar(estephanie);
        personas.guardar(daniel);

        // ---- Responsables ----
        personas.guardar(new Responsable(1234567801L, "laura.gomez@eia.edu.co", "Laura Gómez", true,
                "Inspeccion, Cierre de rutas", "Gestión de residuos sólidos"));
        personas.guardar(new Responsable(2345678912L, "andres.paez@eia.edu.co", "Andrés Páez", true,
                "Recoleccion general, Recoleccion de material especial", "Manejo de residuos especiales"));
        personas.guardar(new Responsable(3456789023L, "camila.rios@eia.edu.co", "Camila Ríos", false,
                "Inspeccion", "Sostenibilidad y campañas ambientales"));

        // ---- Puntos ecologicos ----
        PuntoEcologico punto1 = new PuntoEcologico(1122334455L, "Bloque 5 - Cafeteria", 100, false, true);
        punto1.agregarMaterial(new MaterialReciclable("Reciclable", 0));
        punto1.agregarMaterial(new MaterialOrganico("Organico", 0));
        puntos.guardar(punto1);

        PuntoEcologico punto2 = new PuntoEcologico(2233445566L, "Zona deportiva", 150, false, true);
        punto2.agregarMaterial(new MaterialReciclable("Reciclable", 0));
        punto2.agregarMaterial(new MaterialEspecial("Especial", 0));
        puntos.guardar(punto2);

        PuntoEcologico punto3 = new PuntoEcologico(3344556677L, "Parqueadero Norte", 80, true, false);
        punto3.agregarMaterial(new MaterialOrganico("Organico", 0));
        puntos.guardar(punto3);

        // ---- Paradas y rutas ----
        Parada parada1 = new Parada(1, "Recoger material reciclable");
        parada1.setPuntoEcologico(punto1);
        Parada parada2 = new Parada(2, "Inspeccionar caneca");
        parada2.setPuntoEcologico(punto2);
        Parada parada3 = new Parada(1, "Recoger material especial");
        parada3.setPuntoEcologico(punto2);
        Parada parada4 = new Parada(2, "Vaciar caneca");
        parada4.setPuntoEcologico(punto1);
        Parada parada5 = new Parada(1, "Inspeccionar punto");
        parada5.setPuntoEcologico(punto2);

        RutaRecoleccion ruta1 = new RutaRecoleccion(4455667788L, true);
        ruta1.agregarParada(parada1);
        ruta1.agregarParada(parada2);
        rutas.guardar(ruta1);

        RutaRecoleccion ruta2 = new RutaRecoleccion(5566778899L, true);
        ruta2.agregarParada(parada3);
        ruta2.agregarParada(parada4);
        rutas.guardar(ruta2);

        RutaRecoleccion ruta3 = new RutaRecoleccion(6677889900L, false);
        ruta3.agregarParada(parada5);
        rutas.guardar(ruta3);

        // ---- Reportes ----
        Reporte reporte1 = new Reporte(7788990011L, esteban, punto1, "01/09/2026",
                "Caneca desbordada", "Desbordamiento", 3);
        reporte1.asignarOperador(juan, notificador);
        reportes.guardar(reporte1);

        Reporte reporte2 = new Reporte(8899001122L, mariana, punto2, "02/09/2026",
                "Material especial depositado sin autorizacion", "MaterialEspecial", 3);
        reporte2.asignarRuta(ruta1, notificador);
        reportes.guardar(reporte2);

        Reporte reporte3 = new Reporte(9900112233L, santiago, punto1, "03/09/2026",
                "Contaminacion por residuos organicos", "Contaminacion", 2);
        reporte3.asignarOperador(daniel, notificador);
        reportes.guardar(reporte3);

        // ---- Recolecciones ----
        Recoleccion recoleccion1 = new Recoleccion(1112223334L, "Recoleccion sin novedades", juan, reporte1);
        recoleccion1.agregarMaterial(new MaterialReciclable("Reciclable", 0), 12.5);
        recoleccion1.agregarMaterial(new MaterialOrganico("Organico", 0), 5.0);
        recolecciones.guardar(recoleccion1);

        Recoleccion recoleccion2 = new Recoleccion(2223334445L, "Se encontro material adicional", daniel, reporte3);
        recoleccion2.agregarMaterial(new MaterialOrganico("Organico", 0), 3.2);
        recolecciones.guardar(recoleccion2);

        Recoleccion recoleccion3 = new Recoleccion(3334445556L, "Recoleccion rutinaria de la ruta", estephanie, reporte2);
        recoleccion3.agregarMaterial(new MaterialEspecial("Especial", 0), 8.0);
        recolecciones.guardar(recoleccion3);

        // ---- Campañas ----
        Campania campania1 = new Campania(4445556667L, "15/09/2026", 3, 10);
        Campania campania2 = new Campania(5556667778L, "20/09/2026", 2, 15);
        Campania campania3 = new Campania(6667778889L, "10/08/2026", 5, 5);
        campania3.cerrar(notificador);
        campanias.guardar(campania1);
        campanias.guardar(campania2);
        campanias.guardar(campania3);

        // ---- Actividades ----
        Actividad actividad1 = new Actividad(7778889990L, "Jornada de reciclaje", "Recoleccion", "15/09/2026");
        Actividad actividad2 = new Actividad(8889990011L, "Charla de sensibilizacion ambiental", "Educativa", "16/09/2026");
        Actividad actividad3 = new Actividad(9990011122L, "Siembra de arboles", "Reforestacion", "20/09/2026");
        actividades.guardar(actividad1);
        actividades.guardar(actividad2);
        actividades.guardar(actividad3);
        campania1.agregarActividad(actividad1);
        campania1.agregarActividad(actividad2);
        campania2.agregarActividad(actividad3);

        // ---- Participaciones ----
        campania1.inscribirParticipante(esteban, "10/09/2026", notificador);
        campania1.inscribirParticipante(mariana, "11/09/2026", notificador);
        campania2.inscribirParticipante(santiago, "18/09/2026", notificador);

        cargado = true;
        return true;
    }
}