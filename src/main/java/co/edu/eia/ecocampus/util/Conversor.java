package co.edu.eia.ecocampus.util;

import co.edu.eia.ecocampus.excepcion.DatoInvalidoException;

public class Conversor {

    public static long aLong(String texto, String campo) throws DatoInvalidoException {
        try {
            return Long.parseLong(texto.trim());
        } catch (NumberFormatException e) {
            throw new DatoInvalidoException(campo + " debe ser un número entero.");
        }
    }

    public static int aInt(String texto, String campo) throws DatoInvalidoException {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new DatoInvalidoException(campo + " debe ser un número entero.");
        }
    }

    public static double aDouble(String texto, String campo) throws DatoInvalidoException {
        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            throw new DatoInvalidoException(campo + " debe ser un número.");
        }
    }
}