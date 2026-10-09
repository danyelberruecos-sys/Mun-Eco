package co.edu.eia.ecocampus.app.controlador;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;
import co.edu.eia.ecocampus.servicio.ServicioReporte;
import co.edu.eia.ecocampus.util.Alertas;
import co.edu.eia.ecocampus.util.Conversor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReportesController {


    @FXML private TextField campoIdReporte;
    @FXML private ComboBox<Persona> comboAutor;
    @FXML private ComboBox<PuntoEcologico> comboPuntoReporte;
    @FXML private DatePicker fechaReporte;
    @FXML private TextArea campoDescripcion;
    @FXML private ComboBox<String> comboTipoReporte;
    @FXML private ComboBox<String> comboPrioridad;


    @FXML private CheckBox checkSoloPendientes;
    @FXML private TableView<Reporte> tablaReportes;
    @FXML private TableColumn<Reporte, Long> colIdReporte;
    @FXML private TableColumn<Reporte, String> colFechaReporte;
    @FXML private TableColumn<Reporte, String> colTipoReporte;
    @FXML private TableColumn<Reporte, String> colPrioridadReporte;
    @FXML private TableColumn<Reporte, String> colEstadoReporte;
    @FXML private TableColumn<Reporte, String> colAutorReporte;
    @FXML private TableColumn<Reporte, String> colPuntoReporte;
    @FXML private TableColumn<Reporte, String> colAsignadoReporte;
    @FXML private ComboBox<Operador> comboOperador;
    @FXML private ComboBox<RutaRecoleccion> comboRuta;

    private ServicioReporte servicio;

    @FXML
    private void initialize() {
        comboTipoReporte.getItems().addAll("Desbordamiento", "Contaminacion",
                "Material especial", "Otro");
        comboPrioridad.getItems().addAll("Baja", "Media", "Alta");

        colIdReporte.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFechaReporte.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTipoReporte.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPrioridadReporte.setCellValueFactory(new PropertyValueFactory<>("prioridadTexto"));
        colEstadoReporte.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colAutorReporte.setCellValueFactory(new PropertyValueFactory<>("autorNombre"));
        colPuntoReporte.setCellValueFactory(new PropertyValueFactory<>("ubicacionPunto"));
        colAsignadoReporte.setCellValueFactory(new PropertyValueFactory<>("asignadoA"));

        tablaReportes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
    }

    public void setServicio(ServicioReporte servicio) {
        this.servicio = servicio;

        comboAutor.setItems(FXCollections.observableArrayList(servicio.listarPersonas()));
        comboPuntoReporte.setItems(
                FXCollections.observableArrayList(servicio.listarPuntosActivos()));
        comboOperador.setItems(FXCollections.observableArrayList(servicio.listarOperadores()));
        comboRuta.setItems(FXCollections.observableArrayList(servicio.listarRutas()));

        actualizarTabla();
    }

   
    @FXML
    private void registrarReporte() {
        try {
            long id = Conversor.aLong(campoIdReporte.getText(), "El ID");
            String fecha = Conversor.fechaATexto(fechaReporte.getValue());

            servicio.registrar(id, comboAutor.getValue(), comboPuntoReporte.getValue(),
                    fecha, campoDescripcion.getText(), comboTipoReporte.getValue(),
                    comboPrioridad.getValue());

            Alertas.informar("Reporte registrado correctamente.");
            limpiarFormulario();
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

 
    @FXML
    private void asignarAOperador() {
        Reporte seleccionado = tablaReportes.getSelectionModel().getSelectedItem();

        try {
            servicio.asignarAOperador(seleccionado, comboOperador.getValue());

            Alertas.informar("Reporte asignado al operador correctamente.");
            comboOperador.setValue(null);
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void asignarARuta() {
        Reporte seleccionado = tablaReportes.getSelectionModel().getSelectedItem();

        try {
            servicio.asignarARuta(seleccionado, comboRuta.getValue());

            Alertas.informar("Reporte asignado a la ruta correctamente.");
            comboRuta.setValue(null);
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }


    @FXML
    private void actualizarTabla() {
        tablaReportes.setItems(FXCollections.observableArrayList(
                servicio.listar(checkSoloPendientes.isSelected())));
    }

    private void limpiarFormulario() {
        campoIdReporte.clear();
        comboAutor.setValue(null);
        comboPuntoReporte.setValue(null);
        fechaReporte.setValue(null);
        campoDescripcion.clear();
        comboTipoReporte.setValue(null);
        comboPrioridad.setValue(null);
    }
}