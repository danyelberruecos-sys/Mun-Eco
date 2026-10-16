package co.edu.eia.ecocampus.servicio;

import java.util.List;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Notificador;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.Responsable;
import co.edu.eia.ecocampus.modelo.Usuario;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioPersona {

	private RepositorioMemoria<Persona> personas;
    private Verificador verificador;
    private Notificador notificador;
	
    
    public ServicioPersona(RepositorioMemoria<Persona> personas, Verificador verificador, Notificador notificador) {
        this.personas = personas;
        this.verificador = verificador;
        this.notificador = notificador;
    }
    
    
    private void validarDatosBasicos(long id, String correo, String nombre)
            throws EcoCampusException {
        verificador.verificarId(id);
        verificador.verificarTextoObligatorio(correo, "El correo");
        verificador.verificarTextoObligatorio(nombre, "El nombre");
    }

    public Usuario registrarUsuario(long id, String correo, String nombre, String tipo)
            throws EcoCampusException {
        validarDatosBasicos(id, correo, nombre);
        verificador.verificarTextoObligatorio(tipo, "El tipo");

        Usuario usuario = new Usuario(id, correo, nombre, tipo);
        personas.guardar(usuario);
        notificador.notificar("Se registró el usuario " + nombre + ".");      

        return usuario;
    }

    public Operador registrarOperador(long id, String correo, String nombre,
            boolean disponible, String acciones) throws EcoCampusException {
        validarDatosBasicos(id, correo, nombre);
        verificador.verificarTextoObligatorio(acciones, "Las acciones permitidas");

        Operador operador = new Operador(id, correo, nombre, disponible, acciones);
        personas.guardar(operador);
        notificador.notificar("Se registró el operador " + nombre + ".");       

        return operador;
    }

    public Responsable registrarResponsable(long id, String correo, String nombre,
            boolean disponible, String acciones, String area) throws EcoCampusException {
        validarDatosBasicos(id, correo, nombre);
        verificador.verificarTextoObligatorio(acciones, "Las acciones permitidas");
        verificador.verificarTextoObligatorio(area, "El área de responsabilidad");

        Responsable responsable = new Responsable(id, correo, nombre, disponible, acciones, area);
        personas.guardar(responsable);
        notificador.notificar("Se registró el responsable " + nombre + ".");    
        return responsable;
    }


    public List<Persona> listar() {
    
        return personas.listar(); 
    }
}
