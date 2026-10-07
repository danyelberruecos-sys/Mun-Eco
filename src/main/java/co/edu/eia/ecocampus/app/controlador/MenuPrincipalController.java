package co.edu.eia.ecocampus.app.controlador;

import java.io.IOException;
import java.util.Optional;

import co.edu.eia.ecocampus.servicio.CargadorDatos;
import co.edu.eia.ecocampus.servicio.ServicioPersona;
import co.edu.eia.ecocampus.servicio.ServicioPuntoEcologico;
import co.edu.eia.ecocampus.util.Alertas;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuPrincipalController {

   
    @FXML private Label tituloSeccion;
    @FXML private Label estadoDatos;
    @FXML private StackPane contenido;
    @FXML private VBox pantallaInicio;
    @FXML private Button botonInicio;
    @FXML private Button botonCargarDatos;
    @FXML private Button botonPersonas;

    private CargadorDatos cargador;
    private Button botonActivo;
    private ServicioPersona servicioPersona;
    private ServicioPuntoEcologico servicioPunto;

    
    @FXML
    private void initialize() {
        botonActivo = botonInicio;
        
        if (botonPersonas != null) {
            botonPersonas.setOnAction(this::abrirPersonas);
        }
    }


    public void setCargador(CargadorDatos cargador) {
        this.cargador = cargador;
    }
    
    public void setServicioPersona(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }
    
    public void setServicioPunto(ServicioPuntoEcologico servicioPunto) {
        this.servicioPunto = servicioPunto;
    }

   
    @FXML
    private void abrirInicio(ActionEvent evento) {
        activar(evento);
        tituloSeccion.setText("Inicio");
        contenido.getChildren().setAll(pantallaInicio);
    }

    @FXML
    private void abrirPersonas(ActionEvent evento) {
        activar(evento);
        tituloSeccion.setText("Gestión de personas");

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/eia/ecocampus/app/vista/personas.fxml"));
            Parent pantalla = loader.load();

            PersonasController controlador = loader.getController();
            if (controlador != null && servicioPersona != null) {
                controlador.setServicio(servicioPersona);
            }

            contenido.getChildren().setAll(pantalla);
        } catch (Exception e) { // Cambiado de IOException a Exception para ver todo
            e.printStackTrace();
            Alertas.error("Error al abrir personas: " + e.getMessage());
        }
    }

    @FXML
    private void abrirPuntos(ActionEvent evento) {
        activar(evento);
        tituloSeccion.setText("Puntos ecológicos");

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/eia/ecocampus/app/vista/puntos-ecologicos.fxml"));
            Parent pantalla = loader.load();

            PuntosEcologicosController controlador = loader.getController();
            controlador.setServicio(servicioPunto);

            contenido.getChildren().setAll(pantalla);
        } catch (IOException e) {
            Alertas.error("No se pudo abrir la pantalla de puntos ecológicos.");
        }
    }

    @FXML
    private void abrirReportes(ActionEvent evento) {
        activar(evento);
        mostrarEnConstruccion("Reportes");
    }

    @FXML
    private void abrirRutas(ActionEvent evento) {
        activar(evento);
        mostrarEnConstruccion("Rutas y recolección");
    }

    @FXML
    private void abrirCampanias(ActionEvent evento) {
        activar(evento);
        mostrarEnConstruccion("Campañas ambientales");
    }

    @FXML
    private void abrirConsultas(ActionEvent evento) {
        activar(evento);
        mostrarEnConstruccion("Eco-puntos y consultas");
    }

    @FXML
    private void abrirIndicadores(ActionEvent evento) {
        activar(evento);
        mostrarEnConstruccion("Indicadores generales");
    }

  
    @FXML
    private void cargarDatosPrueba() {
        boolean acepto = confirmar("Cargar datos de prueba",
                "Se cargarán personas, puntos ecológicos, rutas, reportes, "
                + "recolecciones y campañas de ejemplo. ¿Desea continuar?");
        if (!acepto) {
            return;
        }

        if (cargador.cargar()) {
            estadoDatos.setText("Datos de prueba: cargados");
            estadoDatos.getStyleClass().remove("estado-pendiente");
            estadoDatos.getStyleClass().add("estado-ok");

            botonCargarDatos.setText("Datos de prueba cargados");
            botonCargarDatos.setDisable(true);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Datos cargados",
                    "Los datos de prueba se cargaron correctamente.");
        } else {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Datos ya cargados",
                    "Los datos de prueba ya habían sido cargados.");
        }
    }

    @FXML
    private void salir() {
        if (confirmar("Salir", "¿Desea cerrar la aplicación?")) {
            Platform.exit();
        }
    }


    private void activar(ActionEvent evento) {
        if (botonActivo != null) {
            botonActivo.getStyleClass().remove("activo");
        }
        botonActivo = (Button) evento.getSource();
        botonActivo.getStyleClass().add("activo");
    }


    private void mostrarEnConstruccion(String titulo) {
        tituloSeccion.setText(titulo);
        Label aviso = new Label("Esta pantalla se está construyendo...");
        aviso.getStyleClass().add("texto-secundario");
        contenido.getChildren().setAll(aviso);
    }

    private boolean confirmar(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, mensaje,
                ButtonType.OK, ButtonType.CANCEL);
        alerta.setTitle("MunEco");
        alerta.setHeaderText(titulo);
        Optional<ButtonType> respuesta = alerta.showAndWait();
        return respuesta.isPresent() && respuesta.get() == ButtonType.OK;
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje);
        alerta.setTitle("MunEco");
        alerta.setHeaderText(titulo);
        alerta.showAndWait();
    }
}