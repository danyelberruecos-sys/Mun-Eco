package co.edu.eia.ecocampus.app.controlador;

import java.util.ArrayList;

import co.edu.eia.ecocampus.modelo.Notificacion;
import co.edu.eia.ecocampus.patron.HistorialNotificaciones;
import co.edu.eia.ecocampus.util.Alertas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class NotificacionesController {

    @FXML private TableView<Notificacion> tablaNotificaciones;
    @FXML private TableColumn<Notificacion, String> colFechaNotif;
    @FXML private TableColumn<Notificacion, String> colMensajeNotif;

    private HistorialNotificaciones historial;

    @FXML
    private void initialize() {
        colFechaNotif.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
        colMensajeNotif.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tablaNotificaciones.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        tablaNotificaciones.setPlaceholder(new Label("Aún no hay notificaciones."));
    }

    public void setHistorial(HistorialNotificaciones historial) {
        this.historial = historial;
        actualizarTabla();
    }

    @FXML
    private void actualizarTabla() {
        ArrayList<Notificacion> todas = historial.getNotificaciones();        
        ArrayList<Notificacion> recientesPrimero = new ArrayList<>();
        for (int i = todas.size() - 1; i >= 0; i--) {
            recientesPrimero.add(todas.get(i));
        }

        tablaNotificaciones.setItems(FXCollections.observableArrayList(recientesPrimero));
    }

    @FXML
    private void limpiarHistorial() {
        if (!Alertas.confirmar("¿Desea borrar todo el historial de notificaciones?")) {
            return;
        }

        historial.limpiar();
        actualizarTabla();
    }
}