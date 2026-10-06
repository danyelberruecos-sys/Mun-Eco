package co.edu.eia.ecocampus.repositorio;

import java.util.Collection;
import co.edu.eia.ecocampus.modelo.*;

public interface Repositorio<T extends Identificable> {
    void guardar(T entidad);
    T buscarPorId(long id);
    Collection<T> listar();
    boolean existe(long id);
}