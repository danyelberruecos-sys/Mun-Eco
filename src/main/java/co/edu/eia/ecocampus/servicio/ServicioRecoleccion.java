package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.DetalleRecoleccion;
import co.edu.eia.ecocampus.modelo.Material;
import co.edu.eia.ecocampus.modelo.Notificador;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.patron.FabricaMaterial;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioRecoleccion {

    private RepositorioMemoria<Recoleccion> recolecciones;
    private RepositorioMemoria<Reporte> reportes;
    private RepositorioMemoria<Persona> personas;
    private Verificador verificador;
    private VerificadorRecoleccion verificadorRecoleccion;
    private Notificador notificador;

    public ServicioRecoleccion(RepositorioMemoria<Recoleccion> recolecciones,
                               RepositorioMemoria<Reporte> reportes,
                               RepositorioMemoria<Persona> personas,
                               Verificador verificador,
                               VerificadorRecoleccion verificadorRecoleccion,
                               Notificador notificador) {
        this.recolecciones = recolecciones;
        this.reportes = reportes;
        this.personas = personas;
        this.verificador = verificador;
        this.verificadorRecoleccion = verificadorRecoleccion;
        this.notificador = notificador;
    }

 
    public DetalleRecoleccion crearDetalle(Operador operador, String tipoMaterial, double peso) throws EcoCampusException {

        verificador.verificarSeleccionado(operador, "el operador responsable");
        verificador.verificarSeleccionado(tipoMaterial, "el material");
        verificador.verificarPositivo(peso, "El peso");

        Material material = FabricaMaterial.crear(tipoMaterial);
        verificadorRecoleccion.verificarOperadorHabilitado(operador, material);

        return new DetalleRecoleccion(material, peso);
    }

    public Recoleccion registrar(long id, String observaciones, Reporte reporte,
            Operador operador, ArrayList<DetalleRecoleccion> detalles) throws EcoCampusException {

        verificador.verificarId(id);
        verificador.verificarSeleccionado(reporte, "el reporte asociado");
        verificador.verificarSeleccionado(operador, "el operador responsable");
        verificadorRecoleccion.verificarReporteAsignado(reporte);
        verificadorRecoleccion.verificarSinRecoleccionPrevia(reporte, recolecciones.listar());
        verificadorRecoleccion.verificarHayMateriales(detalles);

       
        for (int i = 0; i < detalles.size(); i++) {
            verificadorRecoleccion.verificarOperadorHabilitado(operador,
                    detalles.get(i).getMaterial());
        }

        Recoleccion recoleccion = new Recoleccion(id, observaciones, operador, reporte);
        for (int i = 0; i < detalles.size(); i++) {
            recoleccion.agregarMaterial(detalles.get(i).getMaterial(), detalles.get(i).getPeso());
        }

        recolecciones.guardar(recoleccion);
        notificador.notificar("Se registró la recolección " + id + " del reporte " + reporte.getId() + ".");
        return recoleccion;
    }


    public ArrayList<Reporte> listarReportesDisponibles() {
        ArrayList<Reporte> disponibles = new ArrayList<>();
        ArrayList<Reporte> todos = reportes.listar();

        for (int i = 0; i < todos.size(); i++) {
            Reporte r = todos.get(i);
            if (r.getEstado().equals("ASIGNADO") && !tieneRecoleccion(r)) {
                disponibles.add(r);
            }
        }
        return disponibles;
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

    public ArrayList<Recoleccion> listar() {
        return recolecciones.listar();
    }


    private boolean tieneRecoleccion(Reporte reporte) {
        ArrayList<Recoleccion> todas = recolecciones.listar();
        for (int i = 0; i < todas.size(); i++) {
            if (todas.get(i).getReporteAsociado().getId() == reporte.getId()) {
                return true;
            }
        }
        return false;
    }
}

   
