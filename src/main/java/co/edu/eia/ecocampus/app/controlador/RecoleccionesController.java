package co.edu.eia.ecocampus.app.controlador;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.DetalleRecoleccion;
import co.edu.eia.ecocampus.modelo.Operador;
import co.edu.eia.ecocampus.modelo.Recoleccion;
import co.edu.eia.ecocampus.modelo.Reporte;
import co.edu.eia.ecocampus.patron.FabricaMaterial;
import co.edu.eia.ecocampus.servicio.ServicioRecoleccion;
import co.edu.eia.ecocampus.util.Alertas;
import co.edu.eia.ecocampus.util.Conversor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecoleccionesController {

    @FXML private TextField campoIdRecoleccion;
    @FXML private ComboBox<Reporte> comboReporteRec;
    @FXML private ComboBox<Operador> comboOperadorRec;
    @FXML private TextArea campoObservaciones;
    @FXML private ComboBox<String> comboMaterial;
    @FXML private TextField campoPeso;

    @FXML private TableView<DetalleRecoleccion> tablaMaterialesNuevos;
    @FXML private TableColumn<DetalleRecoleccion, String> colTipoNuevo;
    @FXML private TableColumn<DetalleRecoleccion, Double> colPesoNuevo;
    @FXML private Label etiquetaPesoTotal;

 
    @FXML private TableView<Recoleccion> tablaRecolecciones;
    @FXML private TableColumn<Recoleccion, Long> colIdRec;
    @FXML private TableColumn<Recoleccion, Long> colReporteRec;
    @FXML private TableColumn<Recoleccion, String> colOperadorRec;
    @FXML private TableColumn<Recoleccion, String> colMaterialesRec;
    @FXML private TableColumn<Recoleccion, Double> colPesoRec;
    @FXML private TableColumn<Recoleccion, Integer> colEcoPuntosRec;
    @FXML private TableColumn<Recoleccion, String> colObservacionesRec;

    private ServicioRecoleccion servicio;


    private ArrayList<DetalleRecoleccion> detallesNuevos = new ArrayList<>();

    @FXML
    private void initialize() {
    	comboMaterial.getItems().addAll(FabricaMaterial.RECICLABLE,FabricaMaterial.ORGANICO, FabricaMaterial.ESPECIAL);

        colTipoNuevo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colPesoNuevo.setCellValueFactory(new PropertyValueFactory<>("peso"));

        colIdRec.setCellValueFactory(new PropertyValueFactory<>("id"));
        colReporteRec.setCellValueFactory(new PropertyValueFactory<>("reporteId"));
        colOperadorRec.setCellValueFactory(new PropertyValueFactory<>("operadorNombre"));
        colMaterialesRec.setCellValueFactory(new PropertyValueFactory<>("materialesTexto"));
        colPesoRec.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
        colEcoPuntosRec.setCellValueFactory(new PropertyValueFactory<>("ecoPuntosCalculados"));
        colObservacionesRec.setCellValueFactory(new PropertyValueFactory<>("observaciones"));

        tablaMaterialesNuevos.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        tablaRecolecciones.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
    }

    public void setServicio(ServicioRecoleccion servicio) {
        this.servicio = servicio;
        cargarCombos();
        actualizarTabla();
    }


    @FXML
    private void agregarMaterial() {
        try {
            double peso = Conversor.aDouble(campoPeso.getText(), "El peso");

            DetalleRecoleccion detalle = servicio.crearDetalle(
                    comboOperadorRec.getValue(), comboMaterial.getValue(), peso);

            detallesNuevos.add(detalle);
            refrescarMaterialesNuevos();

            comboMaterial.setValue(null);
            campoPeso.clear();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void quitarMaterial() {
        DetalleRecoleccion seleccionado =
                tablaMaterialesNuevos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            Alertas.error("Seleccione un material de la tabla.");
            return;
        }

        detallesNuevos.remove(seleccionado);
        refrescarMaterialesNuevos();
    }

   
    @FXML
    private void registrarRecoleccion() {
        try {
            long id = Conversor.aLong(campoIdRecoleccion.getText(), "El ID");

            servicio.registrar(id, campoObservaciones.getText(), comboReporteRec.getValue(),
                    comboOperadorRec.getValue(), detallesNuevos);

            Alertas.informar("Recolección registrada correctamente.");
            limpiarFormulario();
            cargarCombos();
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

  
    @FXML
    private void actualizarTabla() {
        tablaRecolecciones.setItems(FXCollections.observableArrayList(servicio.listar()));
        tablaRecolecciones.refresh();
    }

    private void cargarCombos() {
        comboReporteRec.setItems(
                FXCollections.observableArrayList(servicio.listarReportesDisponibles()));
        comboOperadorRec.setItems(
                FXCollections.observableArrayList(servicio.listarOperadores()));
    }

    private void refrescarMaterialesNuevos() {
        tablaMaterialesNuevos.setItems(FXCollections.observableArrayList(detallesNuevos));

        double total = 0;
        for (int i = 0; i < detallesNuevos.size(); i++) {
            total = total + detallesNuevos.get(i).getPeso();
        }
        etiquetaPesoTotal.setText("Peso total: " + total + " kg");
    }

    private void limpiarFormulario() {
        campoIdRecoleccion.clear();
        comboReporteRec.setValue(null);
        comboOperadorRec.setValue(null);
        campoObservaciones.clear();
        comboMaterial.setValue(null);
        campoPeso.clear();
        detallesNuevos.clear();
        refrescarMaterialesNuevos();
    }
}