package co.edu.eia.ecocampus.app.controlador;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.servicio.ServicioPuntoEcologico;
import co.edu.eia.ecocampus.util.Alertas;
import co.edu.eia.ecocampus.util.Conversor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PuntosEcologicosController {


    @FXML private TextField campoIdPunto;
    @FXML private TextField campoUbicacion;
    @FXML private TextField campoCapacidad;
    @FXML private CheckBox checkLleno;
    @FXML private CheckBox checkActivo;
    @FXML private CheckBox checkReciclable;
    @FXML private CheckBox checkOrganico;
    @FXML private CheckBox checkEspecial;

 
    @FXML private TableView<PuntoEcologico> tablaPuntos;
    @FXML private TableColumn<PuntoEcologico, Long> colIdPunto;
    @FXML private TableColumn<PuntoEcologico, String> colUbicacion;
    @FXML private TableColumn<PuntoEcologico, Integer> colCapacidad;
    @FXML private TableColumn<PuntoEcologico, String> colLleno;
    @FXML private TableColumn<PuntoEcologico, String> colEstado;
    @FXML private TableColumn<PuntoEcologico, String> colMateriales;

    private ServicioPuntoEcologico servicio;

    @FXML
    private void initialize() {
        checkActivo.setSelected(true);

        colIdPunto.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        colCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
        colLleno.setCellValueFactory(new PropertyValueFactory<>("llenoTexto"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoTexto"));
        colMateriales.setCellValueFactory(new PropertyValueFactory<>("materialesTexto"));
    }

    public void setServicio(ServicioPuntoEcologico servicio) {
        this.servicio = servicio;
        actualizarTabla();
    }


    @FXML
    private void registrarPunto() {
        try {
            long id = Conversor.aLong(campoIdPunto.getText(), "El ID");
            int capacidad = Conversor.aInt(campoCapacidad.getText(), "La capacidad");

            servicio.registrar(id, campoUbicacion.getText(), capacidad,
                    checkLleno.isSelected(), checkActivo.isSelected(),
                    checkReciclable.isSelected(), checkOrganico.isSelected(),
                    checkEspecial.isSelected());

            Alertas.informar("Punto ecológico registrado correctamente.");
            limpiarFormulario();
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }


    @FXML
    private void inactivarPunto() {
        PuntoEcologico seleccionado = tablaPuntos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            Alertas.error("Seleccione un punto ecológico de la tabla.");
            return;
        }

        if (!Alertas.confirmar("¿Desea inactivar el punto ubicado en "
                + seleccionado.getUbicacion() + "?")) {
            return;
        }

        try {
            servicio.inactivar(seleccionado);
            Alertas.informar("Punto inactivado correctamente.");
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }


    @FXML
    private void actualizarTabla() {
        tablaPuntos.setItems(FXCollections.observableArrayList(servicio.listar()));
    }

    private void limpiarFormulario() {
        campoIdPunto.clear();
        campoUbicacion.clear();
        campoCapacidad.clear();
        checkLleno.setSelected(false);
        checkActivo.setSelected(true);
        checkReciclable.setSelected(false);
        checkOrganico.setSelected(false);
        checkEspecial.setSelected(false);
    }
}