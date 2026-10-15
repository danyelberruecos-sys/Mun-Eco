package co.edu.eia.ecocampus.app.controlador;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Movimiento;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.modelo.PosicionRanking;
import co.edu.eia.ecocampus.modelo.ResumenMateriales;
import co.edu.eia.ecocampus.servicio.ServicioEcoPuntos;
import co.edu.eia.ecocampus.util.Alertas;
import co.edu.eia.ecocampus.util.Conversor;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EcoPuntosController {


    @FXML private ComboBox<Persona> comboPersonaHistorial;
    @FXML private Label etiquetaTotalPuntos;
    @FXML private TableView<Movimiento> tablaMovimientos;
    @FXML private TableColumn<Movimiento, String> colFechaMov;
    @FXML private TableColumn<Movimiento, String> colConceptoMov;
    @FXML private TableColumn<Movimiento, Integer> colPuntosMov;


    @FXML private TableView<PosicionRanking> tablaRanking;
    @FXML private TableColumn<PosicionRanking, Integer> colPuesto;
    @FXML private TableColumn<PosicionRanking, String> colNombreRank;
    @FXML private TableColumn<PosicionRanking, String> colRolRank;
    @FXML private TableColumn<PosicionRanking, Integer> colPuntosRank;
    @FXML private TableColumn<PosicionRanking, String> colCategoriaRank;


    @FXML private Label etiquetaReciclable;
    @FXML private Label etiquetaOrganico;
    @FXML private Label etiquetaEspecial;
    @FXML private Label etiquetaTotal;


    @FXML private ComboBox<Persona> comboPersonaMov;
    @FXML private TextField campoPuntosMov;
    @FXML private TextField campoConceptoMov;
    @FXML private DatePicker fechaMov;

    private ServicioEcoPuntos servicio;

    @FXML
    private void initialize() {
        colFechaMov.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colConceptoMov.setCellValueFactory(new PropertyValueFactory<>("concepto"));
        colPuntosMov.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        colPuesto.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        colNombreRank.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRolRank.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colPuntosRank.setCellValueFactory(new PropertyValueFactory<>("ecoPuntos"));
        colCategoriaRank.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        tablaMovimientos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        tablaRanking.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        tablaMovimientos.setPlaceholder(new Label("Esta persona aún no tiene movimientos."));
    }

    public void setServicio(ServicioEcoPuntos servicio) {
        this.servicio = servicio;

        comboPersonaHistorial.setItems(
                FXCollections.observableArrayList(servicio.listarPersonas()));
        comboPersonaMov.setItems(
                FXCollections.observableArrayList(servicio.listarPersonas()));

        actualizarRanking();
        actualizarMateriales();
    }


    @FXML
    private void mostrarHistorial() {
        Persona persona = comboPersonaHistorial.getValue();

        if (persona == null) {
            tablaMovimientos.getItems().clear();
            etiquetaTotalPuntos.setText("Eco-puntos acumulados: 0");
            return;
        }

        tablaMovimientos.setItems(
                FXCollections.observableArrayList(servicio.historial(persona)));
        etiquetaTotalPuntos.setText("Eco-puntos acumulados: " + persona.getEcopuntos());
    }

   
    @FXML
    private void actualizarRanking() {
        tablaRanking.setItems(FXCollections.observableArrayList(servicio.ranking()));
        tablaRanking.refresh();
    }


    @FXML
    private void actualizarMateriales() {
        ResumenMateriales resumen = servicio.resumenMateriales();

        etiquetaReciclable.setText(String.format("%.1f kg", resumen.getReciclable()));
        etiquetaOrganico.setText(String.format("%.1f kg", resumen.getOrganico()));
        etiquetaEspecial.setText(String.format("%.1f kg", resumen.getEspecial()));
        etiquetaTotal.setText(String.format("%.1f kg", resumen.getTotal()));
    }


    @FXML
    private void registrarMovimiento() {
        try {
            int puntos = Conversor.aInt(campoPuntosMov.getText(), "La cantidad de eco-puntos");
            String fecha = Conversor.fechaATexto(fechaMov.getValue());

            servicio.registrarMovimiento(comboPersonaMov.getValue(), puntos,
                    campoConceptoMov.getText(), fecha);

            Alertas.informar("Movimiento registrado correctamente.");

            comboPersonaMov.setValue(null);
            campoPuntosMov.clear();
            campoConceptoMov.clear();
            fechaMov.setValue(null);

            mostrarHistorial();
            actualizarRanking();

        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }
}