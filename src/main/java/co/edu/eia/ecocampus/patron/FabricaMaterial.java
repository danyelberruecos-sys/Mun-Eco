package co.edu.eia.ecocampus.patron;

import co.edu.eia.ecocampus.excepcion.DatoInvalidoException;
import co.edu.eia.ecocampus.modelo.Material;
import co.edu.eia.ecocampus.modelo.MaterialEspecial;
import co.edu.eia.ecocampus.modelo.MaterialOrganico;
import co.edu.eia.ecocampus.modelo.MaterialReciclable;

public class FabricaMaterial {

    public static  String RECICLABLE = "Reciclable";
    public static  String ORGANICO = "Orgánico";
    public static  String ESPECIAL = "Especial";

    public static Material crear(String tipo) throws DatoInvalidoException {
        if (RECICLABLE.equals(tipo)) {
            return crearReciclable();
        }
        if (ORGANICO.equals(tipo)) {
            return crearOrganico();
        }
        if (ESPECIAL.equals(tipo)) {
            return crearEspecial();
        }
        throw new DatoInvalidoException("Material no reconocido: " + tipo);
    }

    public static Material crearReciclable() {
        return configurar(new MaterialReciclable("Reciclable", 0));
    }

    public static Material crearOrganico() {
        return configurar(new MaterialOrganico("Organico", 0));
    }

    public static Material crearEspecial() {
        return configurar(new MaterialEspecial("Especial", 0));
    }

    private static Material configurar(Material material) {
        material.setEstrategia(new PuntosPorPeso(material.calcularValorPuntos()));
        return material;
    }
}