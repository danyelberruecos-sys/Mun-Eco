package co.edu.eia.ecocampus.app;

import co.edu.eia.ecocampus.app.controlador.MenuPrincipalController;
import co.edu.eia.ecocampus.modelo.Actividad;
import co.edu.eia.ecocampus.modelo.Campania;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;
import co.edu.eia.ecocampus.patron.NotificadorProvisional;
import co.edu.eia.ecocampus.repositorio.Repositorio;
import co.edu.eia.ecocampus.repositorio.RepositorioMemoria;
import co.edu.eia.ecocampus.servicio.CargadorDatos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppFx extends Application {

    @Override
    public void start(Stage ventana) throws Exception {

        // 1. Repositorios: se crean UNA sola vez y se comparten con todo el programa
    	RepositorioMemoria<Persona> personas = new RepositorioMemoria<>();
    	RepositorioMemoria<PuntoEcologico> puntos = new RepositorioMemoria<>();
    	RepositorioMemoria<RutaRecoleccion> rutas = new RepositorioMemoria<>();
    	RepositorioMemoria<Reporte> reportes = new RepositorioMemoria<>();
    	RepositorioMemoria<Recoleccion> recolecciones = new RepositorioMemoria<>();
    	RepositorioMemoria<Campania> campanias = new RepositorioMemoria<>();
    	RepositorioMemoria<Actividad> actividades = new RepositorioMemoria<>();

        // 2. Cargador de datos de prueba
        CargadorDatos cargador = new CargadorDatos(personas, puntos, rutas, reportes,recolecciones, campanias, actividades, new NotificadorProvisional());

        // 3. Cargar la pantalla del menu principal
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/eia/ecocampus/app/vista/menu-principal.fxml"));
        Parent raiz = loader.load();

        // 4. Entregarle al controlador lo que necesita
        MenuPrincipalController controlador = loader.getController();
        controlador.setCargador(cargador);

        // 5. Mostrar la ventana
        ventana.setTitle("MunEco");
        ventana.setScene(new Scene(raiz, 1100, 700));
        ventana.setMinWidth(900);
        ventana.setMinHeight(600);
        ventana.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}