package co.edu.eia.ecocampus.servicio;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.MaterialEspecial;
import co.edu.eia.ecocampus.modelo.MaterialOrganico;
import co.edu.eia.ecocampus.modelo.MaterialReciclable;
import co.edu.eia.ecocampus.modelo.Notificador;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;

public class ServicioPuntoEcologico {

    private RepositorioMemoria<PuntoEcologico> puntos;
    private RepositorioMemoria<Reporte> reportes;
    private Verificador verificador;
    private VerificadorPunto verificadorPunto;
    private Notificador notificador;

    public ServicioPuntoEcologico(RepositorioMemoria<PuntoEcologico> puntos,
                                  RepositorioMemoria<Reporte> reportes,
                                  Verificador verificador,
                                  VerificadorPunto verificadorPunto,
                                  Notificador notificador) {
        this.puntos = puntos;
        this.reportes = reportes;
        this.verificador = verificador;
        this.verificadorPunto = verificadorPunto;
        this.notificador = notificador;
    }

    public PuntoEcologico registrar(long id, String ubicacion, int capacidad,
            boolean lleno, boolean activo, boolean admiteReciclable,
            boolean admiteOrganico, boolean admiteEspecial) throws EcoCampusException {

        verificador.verificarId(id);
        verificador.verificarTextoObligatorio(ubicacion, "La ubicación");
        verificador.verificarPositivo(capacidad, "La capacidad");

        PuntoEcologico punto = new PuntoEcologico(id, ubicacion, capacidad, lleno, activo);

        if (admiteReciclable) {
            punto.agregarMaterial(new MaterialReciclable("Reciclable", 0));
        }
        if (admiteOrganico) {
            punto.agregarMaterial(new MaterialOrganico("Organico", 0));
        }
        if (admiteEspecial) {
            punto.agregarMaterial(new MaterialEspecial("Especial", 0));
        }

        puntos.guardar(punto);
        return punto;
    }

    public void inactivar(PuntoEcologico punto) throws EcoCampusException {
        verificadorPunto.verificarPuedeInactivar(punto, reportes.listar());
        punto.inactivar(notificador);
    }

    public ArrayList<PuntoEcologico> listar() {
        return puntos.listar();
    }
}