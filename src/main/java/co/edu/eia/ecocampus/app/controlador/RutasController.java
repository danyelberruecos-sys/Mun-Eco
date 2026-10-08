package co.edu.eia.ecocampus.app.controlador;

import java.util.ArrayList;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Parada;
import co.edu.eia.ecocampus.modelo.PuntoEcologico;
import co.edu.eia.ecocampus.modelo.RutaRecoleccion;
import co.edu.eia.ecocampus.servicio.ServicioRuta;
import co.edu.eia.ecocampus.util.Alertas;
import co.edu.eia.ecocampus.util.Conversor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RutasController {


    @FXML private TextField campoIdRuta;
    @FXML private CheckBox checkRutaActiva;
    @FXML private TextField campoOrden;
    @FXML private TextField campoAccion;
    @FXML private ComboBox<PuntoEcologico> comboPunto;

    @FXML private TableView<Parada> tablaParadasNuevas;
    @FXML private TableColumn<Parada, Integer> colOrdenNueva;
    @FXML private TableColumn<Parada, String> colAccionNueva;
    @FXML private TableColumn<Parada, String> colPuntoNueva;

 
    @FXML private TableView<RutaRecoleccion> tablaRutas;
    @FXML private TableColumn<RutaRecoleccion, Long> colIdRuta;
    @FXML private TableColumn<RutaRecoleccion, String> colEstadoRuta;
    @FXML private TableColumn<RutaRecoleccion, Integer> colCantParadas;

    @FXML private TableView<Parada> tablaParadasRuta;
    @FXML private TableColumn<Parada, Integer> colOrdenParada;
    @FXML private TableColumn<Parada, String> colAccionParada;
    @FXML private TableColumn<Parada, String> colPuntoParada;

    private ServicioRuta servicio;


    private ArrayList<Parada> paradasNuevas = new ArrayList<>();

    @FXML
    private void initialize() {
        checkRutaActiva.setSelected(true);
        campoOrden.setText("1");

        colOrdenNueva.setCellValueFactory(new PropertyValueFactory<>("orden"));
        colAccionNueva.setCellValueFactory(new PropertyValueFactory<>("accionEsperada"));
        colPuntoNueva.setCellValueFactory(new PropertyValueFactory<>("ubicacionPunto"));

        colIdRuta.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEstadoRuta.setCellValueFactory(new PropertyValueFactory<>("estadoTexto"));
        colCantParadas.setCellValueFactory(new PropertyValueFactory<>("cantidadParadas"));

        colOrdenParada.setCellValueFactory(new PropertyValueFactory<>("orden"));
        colAccionParada.setCellValueFactory(new PropertyValueFactory<>("accionEsperada"));
        colPuntoParada.setCellValueFactory(new PropertyValueFactory<>("ubicacionPunto"));
    }

    public void setServicio(ServicioRuta servicio) {
        this.servicio = servicio;
        comboPunto.setItems(FXCollections.observableArrayList(servicio.listarPuntosActivos()));
        actualizarTabla();
    }

    @FXML
    private void agregarParada() {
        try {
            int orden = Conversor.aInt(campoOrden.getText(), "El orden");

            Parada parada = servicio.crearParada(orden, campoAccion.getText(),
                    comboPunto.getValue(), paradasNuevas);

            paradasNuevas.add(parada);
            refrescarParadasNuevas();

            campoOrden.setText(String.valueOf(paradasNuevas.size() + 1));
            campoAccion.clear();
            comboPunto.setValue(null);

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void quitarParada() {
        Parada seleccionada = tablaParadasNuevas.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            Alertas.error("Seleccione una parada de la tabla.");
            return;
        }

        paradasNuevas.remove(seleccionada);
        refrescarParadasNuevas();
    }

    @FXML
    private void registrarRuta() {
        try {
            long id = Conversor.aLong(campoIdRuta.getText(), "El ID");

            servicio.registrar(id, checkRutaActiva.isSelected(), paradasNuevas);

            Alertas.informar("Ruta registrada correctamente.");
            limpiarFormulario();
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }


    @FXML
    private void mostrarParadas() {
        RutaRecoleccion seleccionada = tablaRutas.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            tablaParadasRuta.getItems().clear();
        } else {
            tablaParadasRuta.setItems(
                    FXCollections.observableArrayList(seleccionada.getParadas()));
        }
    }

    @FXML
    private void cerrarRuta() {
        RutaRecoleccion seleccionada = tablaRutas.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            Alertas.error("Seleccione una ruta de la tabla.");
            return;
        }

        if (!Alertas.confirmar("¿Desea cerrar la ruta " + seleccionada.getId() + "?")) {
            return;
        }

        try {
            servicio.cerrar(seleccionada);
            Alertas.informar("Ruta cerrada correctamente.");
            actualizarTabla();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    // ================= AUXILIARES =================
    @FXML
    private void actualizarTabla() {
        tablaRutas.setItems(FXCollections.observableArrayList(servicio.listar()));
        tablaParadasRuta.getItems().clear();
    }

    private void refrescarParadasNuevas() {
        tablaParadasNuevas.setItems(FXCollections.observableArrayList(paradasNuevas));
    }

    private void limpiarFormulario() {
        campoIdRuta.clear();
        checkRutaActiva.setSelected(true);
        campoAccion.clear();
        comboPunto.setValue(null);
        paradasNuevas.clear();
        refrescarParadasNuevas();
        campoOrden.setText("1");
    }
}