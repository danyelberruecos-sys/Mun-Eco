package co.edu.eia.ecocampus.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import co.edu.eia.ecocampus.modelo.Identificable;

public class RepositorioMemoria<T extends Identificable> implements Repositorio<T> {

    private HashMap<Long, T> datos = new HashMap<>();

    private static ArrayList<RepositorioMemoria<?>> todasLasInstancias = new ArrayList<>();

    public RepositorioMemoria() {
        todasLasInstancias.add(this);
    }

    @Override
    public void guardar(T elemento) {
        datos.put(elemento.getId(), elemento);
    }

    @Override
    public T buscarPorId(long id) {
        return datos.get(id);
    }

    @Override
    public ArrayList<T> listar() {
        return new ArrayList<>(datos.values());
    }

    @Override
    public boolean existe(long id) {
        return datos.containsKey(id);
    }

    public static boolean idExistenteEnTodos(long id) {
        for (RepositorioMemoria<?> repo : todasLasInstancias) {
            if (repo.datos.containsKey(id)) {
                return true;
            }
        }
        return false;
    }
}