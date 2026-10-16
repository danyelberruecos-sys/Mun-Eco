package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Actividad;
import co.edu.eia.ecocampus.modelo.Campania;
import co.edu.eia.ecocampus.modelo.Notificador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.Usuario;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioCampania {

    private RepositorioMemoria<Campania> campanias;
    private RepositorioMemoria<Actividad> actividades;
    private RepositorioMemoria<Persona> personas;
    private Verificador verificador;
    private VerificadorCampania verificadorCampania;
    private Notificador notificador;

    public ServicioCampania(RepositorioMemoria<Campania> campanias,
                            RepositorioMemoria<Actividad> actividades,
                            RepositorioMemoria<Persona> personas,
                            Verificador verificador,
                            VerificadorCampania verificadorCampania,
                            Notificador notificador) {
        this.campanias = campanias;
        this.actividades = actividades;
        this.personas = personas;
        this.verificador = verificador;
        this.verificadorCampania = verificadorCampania;
        this.notificador = notificador;
    }

    
    public Campania registrar(long id, String fecha, int cupo, int ecoPuntos)
            throws EcoCampusException {

        verificador.verificarId(id);
        verificador.verificarTextoObligatorio(fecha, "La fecha");
        verificador.verificarPositivo(cupo, "El cupo");
        verificador.verificarPositivo(ecoPuntos, "Los eco-puntos");

        Campania campania = new Campania(id, fecha, cupo, ecoPuntos);
        campanias.guardar(campania);
        notificador.notificar("Se registró la campaña " + id + ".");
        return campania;
    }

    
    public Actividad agregarActividad(Campania campania, long id, String nombre,
            String tipo, String fecha) throws EcoCampusException {

        verificador.verificarSeleccionado(campania, "una campaña");
        verificadorCampania.verificarCampaniaActiva(campania);
        verificador.verificarId(id);
        verificador.verificarTextoObligatorio(nombre, "El nombre de la actividad");
        verificador.verificarTextoObligatorio(tipo, "El tipo de actividad");
        verificador.verificarTextoObligatorio(fecha, "La fecha de la actividad");

        Actividad actividad = new Actividad(id, nombre, tipo, fecha);
        actividades.guardar(actividad);
        campania.agregarActividad(actividad);
        notificador.notificar("Se agregó la actividad " + nombre + " a la campaña " + campania.getId() + ".");

        return actividad;
    }


    public void inscribir(Campania campania, Usuario usuario, String fecha)
            throws EcoCampusException {

        verificador.verificarSeleccionado(campania, "una campaña");
        verificador.verificarSeleccionado(usuario, "un usuario");
        verificadorCampania.verificarCampaniaActiva(campania);
        verificadorCampania.verificarNoInscritoPreviamente(usuario, campania);
        verificadorCampania.verificarCupoDisponible(campania);
        verificador.verificarTextoObligatorio(fecha, "La fecha de inscripción");

        campania.inscribirParticipante(usuario, fecha, notificador);
        notificador.notificar(usuario.getNombre() + " se inscribió en la campaña " + campania.getId() + ".");
    }


    public int cerrar(Campania campania) throws EcoCampusException {
        verificador.verificarSeleccionado(campania, "una campaña de la tabla");
        verificadorCampania.verificarCampaniaActiva(campania);

        campania.cerrar(notificador);
        return campania.getParticipaciones().size();
    }

  
    public ArrayList<Campania> listar() {
        return campanias.listar();
    }

    public ArrayList<Campania> listarActivas() {
        ArrayList<Campania> activas = new ArrayList<>();
        ArrayList<Campania> todas = campanias.listar();

        for (int i = 0; i < todas.size(); i++) {
            if (todas.get(i).getEstado().equals("ACTIVA")) {
                activas.add(todas.get(i));
            }
        }
        return activas;
    }

   
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Persona> todas = personas.listar();

        for (int i = 0; i < todas.size(); i++) {
            if (todas.get(i) instanceof Usuario) {
                usuarios.add((Usuario) todas.get(i));
            }
        }
        return usuarios;
    }
}