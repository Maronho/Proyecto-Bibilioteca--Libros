package visualizador.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

//import javax.swing.text.html.AccessibleHTML.TableElementInfo.TableAccessibleContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import visualizador.modelo.Inventario;
import visualizador.modelo.Libro;
import visualizador.utils.Connect;

public class VisualizadorFXMLController  implements Initializable{
	
	public Inventario inventario;
	public Connect con;
	public ObservableList<Libro> librosInventario;
	/*
	@FXML
	private Button botonAnhadirAutor, botonModificarAutor, botonEliminarAutor,
				   botonAnhadirEditorial, botonModificarEditorial, botonEliminarEditorial,
				   botonAnhadirLibro, botonModificarLibro, botonEliminarLibro;
	*/
	@FXML
	private ComboBox<String>opcBusquedaLibroCombo, opcBusquedaAutorCombo, opcBusquedaEditorialCombo;

	@FXML
	private TableView<Libro> tablaLibros;

	@FXML
	private TableColumn<Libro, String> colCodLibro;
	@FXML
	private TableColumn<Libro, String> colListaAutores;
	@FXML
	private TableColumn<Libro, String> colTituloLibro;
	@FXML
	private TableColumn<Libro, String> colEditorialLibro;
	
	@FXML
    private void newLibro() {
	    System.out.println("FIRE!");
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		librosInventario = FXCollections.observableArrayList();
		
		inventario = new Inventario();
		
		inicializarCombos();
		
		rellenarTablaLibros();
		
		
	}


	private void rellenarTablaLibros() {
		Libro [] LibrosActuales = inventario.getLibros();
		
		tablaLibros = new TableView<>();
		
		colCodLibro=new TableColumn<>("Nombre");
		colCodLibro.setCellValueFactory(
				new PropertyValueFactory<Libro,String>("Codigo"));
			
		colListaAutores = new TableColumn<>("Autor");
		colListaAutores.setCellValueFactory(
				new PropertyValueFactory<Libro,String>("Autores"));
		
		colTituloLibro = new TableColumn<>("Titulo");
		colTituloLibro.setCellValueFactory(
				new PropertyValueFactory<Libro,String>("Nombre"));
		
		colEditorialLibro = new TableColumn<>("Editorial");
		colEditorialLibro.setCellValueFactory(
				new PropertyValueFactory<Libro,String>("Editorial"));
		
		for (int i = 0; i < LibrosActuales.length; i++) {
			librosInventario.add(LibrosActuales[i]);
		}

		if (tablaLibros.getColumns().addAll(colCodLibro,colListaAutores,colTituloLibro,colEditorialLibro)){
			tablaLibros.setItems(librosInventario);
			System.out.println("AÑADIDOS");
		}
		
		
		
	}


	private void inicializarCombos() {
		opcBusquedaLibroCombo.getItems().addAll("Titulo","Autores","Editorial","ISBN");
		opcBusquedaAutorCombo.getItems().addAll("Nombre","Codigo");
		opcBusquedaEditorialCombo.getItems().addAll("Nombre","Codigo");
		opcBusquedaLibroCombo.getSelectionModel().select(0);
		opcBusquedaAutorCombo.getSelectionModel().select(0);
		opcBusquedaEditorialCombo.getSelectionModel().select(0);
	}

}
