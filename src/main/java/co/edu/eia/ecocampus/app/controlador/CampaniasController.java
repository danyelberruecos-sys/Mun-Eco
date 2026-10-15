package co.edu.eia.ecocampus.app.controlador;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Actividad;
import co.edu.eia.ecocampus.modelo.Campania;
import co.edu.eia.ecocampus.modelo.Participacion;
import co.edu.eia.ecocampus.modelo.Usuario;
import co.edu.eia.ecocampus.servicio.ServicioCampania;
import co.edu.eia.ecocampus.util.Alertas;
import co.edu.eia.ecocampus.util.Conversor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CampaniasController {

    @FXML private TextField campoIdCampania;
    @FXML private DatePicker fechaCampania;
    @FXML private TextField campoCupo;
    @FXML private TextField campoPuntosCampania;

    @FXML private ComboBox<Campania> comboCampaniaActividad;
    @FXML private TextField campoIdActividad;
    @FXML private TextField campoNombreActividad;
    @FXML private TextField campoTipoActividad;
    @FXML private DatePicker fechaActividad;

    @FXML private ComboBox<Campania> comboCampaniaInscripcion;
    @FXML private ComboBox<Usuario> comboUsuario;
    @FXML private DatePicker fechaInscripcion;

    @FXML private TableView<Campania> tablaCampanias;
    @FXML private TableColumn<Campania, Long> colIdCampania;
    @FXML private TableColumn<Campania, String> colFechaCampania;
    @FXML private TableColumn<Campania, String> colEstadoCampania;
    @FXML private TableColumn<Campania, Integer> colCupoCampania;
    @FXML private TableColumn<Campania, Integer> colInscritos;
    @FXML private TableColumn<Campania, Integer> colPuntosCampania;
    @FXML private TableColumn<Campania, Integer> colCantActividades;

    @FXML private TableView<Actividad> tablaActividades;
    @FXML private TableColumn<Actividad, String> colNombreAct;
    @FXML private TableColumn<Actividad, String> colTipoAct;
    @FXML private TableColumn<Actividad, String> colFechaAct;

    @FXML private TableView<Participacion> tablaParticipantes;
    @FXML private TableColumn<Participacion, String> colNombrePart;
    @FXML private TableColumn<Participacion, String> colFechaPart;

    private ServicioCampania servicio;

    @FXML
    private void initialize() {
        colIdCampania.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFechaCampania.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colEstadoCampania.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colCupoCampania.setCellValueFactory(new PropertyValueFactory<>("cupo"));
        colInscritos.setCellValueFactory(new PropertyValueFactory<>("inscritos"));
        colPuntosCampania.setCellValueFactory(new PropertyValueFactory<>("ecoPuntos"));
        colCantActividades.setCellValueFactory(new PropertyValueFactory<>("cantidadActividades"));

        colNombreAct.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTipoAct.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colFechaAct.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        colNombrePart.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colFechaPart.setCellValueFactory(new PropertyValueFactory<>("fechaInscripcion"));

        tablaCampanias.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        tablaActividades.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        tablaParticipantes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
    }

    public void setServicio(ServicioCampania servicio) {
        this.servicio = servicio;
        cargarCombos();
        actualizarTabla();
    }

    @FXML
    private void registrarCampania() {
        try {
            long id = Conversor.aLong(campoIdCampania.getText(), "El ID");
            String fecha = Conversor.fechaATexto(fechaCampania.getValue());
            int cupo = Conversor.aInt(campoCupo.getText(), "El cupo");
            int puntos = Conversor.aInt(campoPuntosCampania.getText(), "Los eco-puntos");

            servicio.registrar(id, fecha, cupo, puntos);

            Alertas.informar("Campaña registrada correctamente.");
            campoIdCampania.clear();
            fechaCampania.setValue(null);
            campoCupo.clear();
            campoPuntosCampania.clear();

            cargarCombos();
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void agregarActividad() {
        try {
            long id = Conversor.aLong(campoIdActividad.getText(), "El ID de la actividad");
            String fecha = Conversor.fechaATexto(fechaActividad.getValue());

            servicio.agregarActividad(comboCampaniaActividad.getValue(), id,
                    campoNombreActividad.getText(), campoTipoActividad.getText(), fecha);

            Alertas.informar("Actividad agregada correctamente.");
            campoIdActividad.clear();
            campoNombreActividad.clear();
            campoTipoActividad.clear();
            fechaActividad.setValue(null);

            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void inscribirParticipante() {
        try {
            String fecha = Conversor.fechaATexto(fechaInscripcion.getValue());

            servicio.inscribir(comboCampaniaInscripcion.getValue(),
                    comboUsuario.getValue(), fecha);

            Alertas.informar("Participante inscrito correctamente.");
            comboUsuario.setValue(null);
            fechaInscripcion.setValue(null);

            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void mostrarDetalle() {
        Campania seleccionada = tablaCampanias.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            tablaActividades.getItems().clear();
            tablaParticipantes.getItems().clear();
        } else {
            tablaActividades.setItems(
                    FXCollections.observableArrayList(seleccionada.getActividades()));
            tablaParticipantes.setItems(
                    FXCollections.observableArrayList(seleccionada.getParticipaciones()));
        }
    }

    @FXML
    private void cerrarCampania() {
        Campania seleccionada = tablaCampanias.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            Alertas.error("Seleccione una campaña de la tabla.");
            return;
        }

        if (!Alertas.confirmar("¿Desea cerrar la campaña " + seleccionada.getId() + "?")) {
            return;
        }

        try {
            int participantes = servicio.cerrar(seleccionada);

            Alertas.informar("Campaña cerrada correctamente.\nParticipantes: " + participantes);
            cargarCombos();
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void actualizarTabla() {
        tablaCampanias.setItems(FXCollections.observableArrayList(servicio.listar()));
        tablaCampanias.refresh();
        tablaActividades.getItems().clear();
        tablaParticipantes.getItems().clear();
    }

    private void cargarCombos() {
        comboCampaniaActividad.setItems(
                FXCollections.observableArrayList(servicio.listarActivas()));
        comboCampaniaInscripcion.setItems(
                FXCollections.observableArrayList(servicio.listarActivas()));
        comboUsuario.setItems(
                FXCollections.observableArrayList(servicio.listarUsuarios()));
    }
}