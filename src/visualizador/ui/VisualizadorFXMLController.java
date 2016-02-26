package visualizador.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import visualizador.modelo.Inventario;
import visualizador.utils.Connect;

public class VisualizadorFXMLController  implements Initializable{
	
	public Inventario inventario;
	public Connect con;
	/*
	@FXML
	private Button botonAnhadirAutor, botonModificarAutor, botonEliminarAutor,
				   botonAnhadirEditorial, botonModificarEditorial, botonEliminarEditorial,
				   botonAnhadirLibro, botonModificarLibro, botonEliminarLibro;
	*/
	@FXML
	private ComboBox<String>opcBusquedaLibroCombo, opcBusquedaAutorCombo, opcBusquedaEditorialCombo;

	
	
	@FXML
    private void newLibro() {
	    System.out.println("FIRE!");
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		inventario = new Inventario();
		
		opcBusquedaLibroCombo.getItems().addAll("Titulo","Autores","Editorial","ISBN");
		opcBusquedaAutorCombo.getItems().addAll("Nombre","Codigo");
		opcBusquedaEditorialCombo.getItems().addAll("Nombre","Codigo");
		opcBusquedaLibroCombo.getSelectionModel().select(0);
		opcBusquedaAutorCombo.getSelectionModel().select(0);
		opcBusquedaEditorialCombo.getSelectionModel().select(0);
		
	}

}
