package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Material;
import co.edu.eia.ecocampus.modelo.MaterialEspecial;
import co.edu.eia.ecocampus.modelo.MaterialOrganico;
import co.edu.eia.ecocampus.modelo.MaterialReciclable;
import co.edu.eia.ecocampus.modelo.Movimiento;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.PosicionRanking;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.ResumenMateriales;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioEcoPuntos {

    private RepositorioMemoria<Persona> personas;
    private RepositorioMemoria<Recoleccion> recolecciones;
    private Verificador verificador;

    public ServicioEcoPuntos(RepositorioMemoria<Persona> personas,
                             RepositorioMemoria<Recoleccion> recolecciones,
                             Verificador verificador) {
        this.personas = personas;
        this.recolecciones = recolecciones;
        this.verificador = verificador;
    }

    public ArrayList<Persona> listarPersonas() {
        return personas.listar();
    }

    
    public ArrayList<Movimiento> historial(Persona persona) {
        return persona.getHistorial().getMovimientos();
    }

    public ArrayList<PosicionRanking> ranking() {
        ArrayList<Persona> orden = new ArrayList<>(personas.listar());

       
        for (int i = 0; i < orden.size() - 1; i++) {
            for (int j = 0; j < orden.size() - 1 - i; j++) {
                if (orden.get(j).getEcopuntos() < orden.get(j + 1).getEcopuntos()) {
                    Persona temp = orden.get(j);
                    orden.set(j, orden.get(j + 1));
                    orden.set(j + 1, temp);
                }
            }
        }

        ArrayList<PosicionRanking> ranking = new ArrayList<>();
        for (int i = 0; i < orden.size(); i++) {
            ranking.add(new PosicionRanking(i + 1, orden.get(i)));
        }
        return ranking;
    }


    public ResumenMateriales resumenMateriales() {
        double reciclable = 0;
        double organico = 0;
        double especial = 0;

        ArrayList<Recoleccion> todas = recolecciones.listar();
        for (int i = 0; i < todas.size(); i++) {
            ArrayList<Material> materiales = todas.get(i).getMateriales();
            ArrayList<Double> pesos = todas.get(i).getPesos();

            for (int j = 0; j < materiales.size(); j++) {
                Material m = materiales.get(j);
                double peso = pesos.get(j);

                if (m instanceof MaterialReciclable) {
                    reciclable = reciclable + peso;
                } else if (m instanceof MaterialOrganico) {
                    organico = organico + peso;
                } else if (m instanceof MaterialEspecial) {
                    especial = especial + peso;
                }
            }
        }

        return new ResumenMateriales(reciclable, organico, especial);
    }


    public void registrarMovimiento(Persona persona, int puntos, String concepto, String fecha)
            throws EcoCampusException {

        verificador.verificarSeleccionado(persona, "una persona");
        verificador.verificarPositivo(puntos, "La cantidad de eco-puntos");
        verificador.verificarTextoObligatorio(concepto, "El concepto");
        verificador.verificarTextoObligatorio(fecha, "La fecha");

        persona.sumarEcoPuntos(puntos, concepto, fecha);
    }
}