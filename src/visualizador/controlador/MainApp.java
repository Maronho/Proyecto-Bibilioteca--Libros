package visualizador.controlador;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Lista de Libros");
		initRootLayout();
	}

	private void initRootLayout() {
		// TODO Auto-generated method stub
		try {
			
			FXMLLoader loader = new FXMLLoader(
								getClass().getResource(
														"/visualizador/vista/Interfaz.fxml"
													   ));
			rootLayout = (BorderPane)loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			System.out.println("Problema Cargando");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
