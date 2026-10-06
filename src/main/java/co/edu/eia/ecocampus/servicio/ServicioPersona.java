package co.edu.eia.ecocampus.servicio;

import java.util.List;
import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.Responsable;
import co.edu.eia.ecocampus.modelo.Usuario;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioPersona {

	private RepositorioMemoria<Persona> personas;
    private Verificador verificador;
	
    
    public ServicioPersona(RepositorioMemoria<Persona> personas, Verificador verificador) {
        this.personas = personas;
        this.verificador = verificador;
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
        return usuario;
    }

    public Operador registrarOperador(long id, String correo, String nombre,
            boolean disponible, String acciones) throws EcoCampusException {
        validarDatosBasicos(id, correo, nombre);
        verificador.verificarTextoObligatorio(acciones, "Las acciones permitidas");

        Operador operador = new Operador(id, correo, nombre, disponible, acciones);
        personas.guardar(operador);
        return operador;
    }

    public Responsable registrarResponsable(long id, String correo, String nombre,
            boolean disponible, String acciones, String area) throws EcoCampusException {
        validarDatosBasicos(id, correo, nombre);
        verificador.verificarTextoObligatorio(acciones, "Las acciones permitidas");
        verificador.verificarTextoObligatorio(area, "El área de responsabilidad");

        Responsable responsable = new Responsable(id, correo, nombre, disponible, acciones, area);
        personas.guardar(responsable);
        return responsable;
    }


    public List<Persona> listar() {
    
        return personas.listar(); 
    }
}
