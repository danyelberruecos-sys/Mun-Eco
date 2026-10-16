package co.edu.eia.ecocampus.app.controlador;

import java.util.ArrayList;

import co.edu.eia.ecocampus.modelo.Indicador;
import co.edu.eia.ecocampus.servicio.ServicioIndicadores;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class IndicadoresController {

    @FXML private FlowPane panelPersonas;
    @FXML private FlowPane panelPuntos;
    @FXML private FlowPane panelReportes;
    @FXML private FlowPane panelRutas;
    @FXML private FlowPane panelCampanias;
    @FXML private FlowPane panelEcoPuntos;

    private ServicioIndicadores servicio;

    public void setServicio(ServicioIndicadores servicio) {
        this.servicio = servicio;
        actualizar();
    }

    @FXML
    private void actualizar() {
        llenarPanel(panelPersonas, servicio.indicadoresPersonas());
        llenarPanel(panelPuntos, servicio.indicadoresPuntos());
        llenarPanel(panelReportes, servicio.indicadoresReportes());
        llenarPanel(panelRutas, servicio.indicadoresRutas());
        llenarPanel(panelCampanias, servicio.indicadoresCampanias());
        llenarPanel(panelEcoPuntos, servicio.indicadoresEcoPuntos());
    }

    private void llenarPanel(FlowPane panel, ArrayList<Indicador> indicadores) {
        panel.getChildren().clear();

        for (int i = 0; i < indicadores.size(); i++) {
            panel.getChildren().add(crearTarjeta(indicadores.get(i)));
        }
    }

    private VBox crearTarjeta(Indicador indicador) {
        Label titulo = new Label(indicador.getTitulo().toUpperCase());
        titulo.getStyleClass().add("etiqueta-campo");

        Label valor = new Label(indicador.getValor());
        valor.getStyleClass().add("cifra");
        if (indicador.getValor().length() > 10) {
            valor.getStyleClass().add("cifra-pequena");
        }

        VBox tarjeta = new VBox(titulo, valor);
        tarjeta.getStyleClass().add("tarjeta");
        tarjeta.setPrefWidth(210);
        tarjeta.setMinWidth(210);
        return tarjeta;
    }
}