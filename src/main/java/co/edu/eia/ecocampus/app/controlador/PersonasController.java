package co.edu.eia.ecocampus.app.controlador;

import co.edu.eia.ecocampus.excepcion.EcoCampusException;
import co.edu.eia.ecocampus.modelo.Persona;
import co.edu.eia.ecocampus.servicio.ServicioPersona;
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


public class PersonasController {

 
    @FXML private TextField campoId;
    @FXML private TextField campoCorreo;
    @FXML private TextField campoNombre;
    @FXML private ComboBox<String> comboTipo;


    @FXML private TextField campoIdOperador;
    @FXML private TextField campoCorreoOperador;
    @FXML private TextField campoNombreOperador;
    @FXML private CheckBox checkDisponibleOperador;
    @FXML private TextField campoAccionesOperador;


    @FXML private TextField campoIdResponsable;
    @FXML private TextField campoCorreoResponsable;
    @FXML private TextField campoNombreResponsable;
    @FXML private CheckBox checkDisponibleResponsable;
    @FXML private TextField campoAccionesResponsable;
    @FXML private TextField campoAreaResponsable;
    
    @FXML private TableView<Persona> tablaPersonas;
    @FXML private TableColumn<Persona, Long> colId;
    @FXML private TableColumn<Persona, String> colNombre;
    @FXML private TableColumn<Persona, String> colCorreo;
    @FXML private TableColumn<Persona, String> colRol;
    @FXML private TableColumn<Persona, Integer> colEcopuntos;

    private ServicioPersona servicio;

    @FXML
    private void initialize() {
        comboTipo.getItems().addAll("Estudiante", "Profesor", "Administrativo");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colEcopuntos.setCellValueFactory(new PropertyValueFactory<>("ecopuntos"));
    }

    public void setServicio(ServicioPersona servicio) {
        this.servicio = servicio;
        actualizarTabla();
    }
    
    private void actualizarTabla() {
    	
        tablaPersonas.setItems(FXCollections.observableArrayList(servicio.listar()));
    }


    @FXML
    private void registrarUsuario() {
        try {
            long id = Long.parseLong(campoId.getText().trim());
            servicio.registrarUsuario(id, campoCorreo.getText(),
                    campoNombre.getText(), comboTipo.getValue());

            Alertas.informar("Usuario registrado correctamente.");
            limpiarUsuario();
            
            actualizarTabla();

        } catch (NumberFormatException e) {
            Alertas.error("El ID debe ser un número entero.");
        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void registrarOperador() {
        try {
            long id = Long.parseLong(campoIdOperador.getText().trim());
            servicio.registrarOperador(id, campoCorreoOperador.getText(),
                    campoNombreOperador.getText(), checkDisponibleOperador.isSelected(),
                    campoAccionesOperador.getText());

            Alertas.informar("Operador registrado correctamente.");
            limpiarOperador();
            
            actualizarTabla();

        } catch (NumberFormatException e) {
            Alertas.error("El ID debe ser un número entero.");
        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

    @FXML
    private void registrarResponsable() {
        try {
            long id = Conversor.aLong(campoId.getText(), "El ID");
            servicio.registrarResponsable(id, campoCorreoResponsable.getText(),
                    campoNombreResponsable.getText(), checkDisponibleResponsable.isSelected(),
                    campoAccionesResponsable.getText(), campoAreaResponsable.getText());

            Alertas.informar("Responsable registrado correctamente.");
            limpiarResponsable();
            
            actualizarTabla();
            
        } catch (EcoCampusException e) {
            Alertas.error(e.getMessage());
        }
    }

 
    private void limpiarUsuario() {
        campoId.clear();
        campoCorreo.clear();
        campoNombre.clear();
        comboTipo.setValue(null);
    }

    private void limpiarOperador() {
        campoIdOperador.clear();
        campoCorreoOperador.clear();
        campoNombreOperador.clear();
        checkDisponibleOperador.setSelected(false);
        campoAccionesOperador.clear();
    }

    private void limpiarResponsable() {
        campoIdResponsable.clear();
        campoCorreoResponsable.clear();
        campoNombreResponsable.clear();
        checkDisponibleResponsable.setSelected(false);
        campoAccionesResponsable.clear();
        campoAreaResponsable.clear();
    }
}