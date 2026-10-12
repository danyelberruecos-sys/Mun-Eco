package co.edu.eia.ecocampus.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertas {

    public static void informar(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, mensaje);
        alerta.setTitle("MunEco");
        alerta.setHeaderText(null);
        aplicarEstilo(alerta);
        alerta.showAndWait();
    }

    public static void error(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR, mensaje);
        alerta.setTitle("MunEco");
        alerta.setHeaderText("No se pudo completar la operación");
        aplicarEstilo(alerta);
        alerta.showAndWait();
    }

    public static boolean confirmar(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, mensaje,
                ButtonType.OK, ButtonType.CANCEL);
        alerta.setTitle("MunEco");
        alerta.setHeaderText(null);
       aplicarEstilo(alerta);
        Optional<ButtonType> respuesta = alerta.showAndWait();
        return respuesta.isPresent() && respuesta.get() == ButtonType.OK;
    }
    
    private static void aplicarEstilo(Alert alerta) {
        alerta.getDialogPane().getStylesheets().add(
                Alertas.class.getResource("/co/edu/eia/ecocampus/app/estilos/estilos.css")
                        .toExternalForm());
    }
}
