package visualizador.modelo;

import java.awt.dnd.Autoscroll;
import java.sql.SQLException;
import java.util.ArrayList;

import visualizador.utils.Connect;

public class Inventario {
	
	Connect con;
	
	Autor[] autores;
	Editorial[] editoriales;
	Libro [] libros;
	
	public Inventario() {
		
		con = new Connect();
		try {
			con.Conecta("localhost", "biblioteca_bd", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actualizaLibros();
		actualizaAutores();
		actualizaEditoriales();
		
		imprimirLibros();
		
		
	}


	private void actualizaEditoriales() {
		try {
			String[][] editorialesRecogidas = con.getEditoriales();
			editoriales= new Editorial[editorialesRecogidas.length];
			
			for (int i = 0; i < editorialesRecogidas.length; i++){				
				editoriales[i]= new Editorial(editorialesRecogidas[i][0], editorialesRecogidas[i][1]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void actualizaAutores() {
		try{
			String[][] tablaAutores = con.getAutores();
			for (int i = 0; i < tablaAutores.length; i++) {
				for (int j = 0; j < tablaAutores[0].length; j++) {
				}

			}
		}
		catch(SQLException e){
			
		}
	}

	public void actualizaLibros(){
		try {
			ArrayList<Libro> librosArrayList = new ArrayList<Libro>();
			ArrayList<String> autoresLibroActual = new ArrayList<String>();
			String isbnActual,tituloActual,editorialActual;
			
			
			String[][]listaLibros =con.getLibros();
			
			isbnActual=listaLibros[0][0];
			tituloActual=listaLibros[0][2];
			editorialActual=listaLibros[0][3];
			
			for (int i = 0; i < listaLibros.length; i++) {				
				if (isbnActual.equals(listaLibros[i][0])){
					autoresLibroActual.add(listaLibros[i][1]);
	
				}
				
				else if (isbnActual!=listaLibros[i][0]){
					
					String[] autores = new String[autoresLibroActual.size()];
					for (int j = 0; j < autores.length; j++) {
						autores[j]=autoresLibroActual.get(j);
					}
							
					librosArrayList.add(new Libro(autores, editorialActual, isbnActual, tituloActual));
					autoresLibroActual = new ArrayList<String>();
					autoresLibroActual.add(listaLibros[i][1]);
					isbnActual=listaLibros[i][0];
					tituloActual=listaLibros[i][2];
					editorialActual=listaLibros[i][3];
				}
				
			}
			String[] autores = new String[autoresLibroActual.size()];
			for (int j = 0; j < autores.length; j++) {
				autores[j]=autoresLibroActual.get(j);
			}
			librosArrayList.add(new Libro(autores, editorialActual, isbnActual, tituloActual));
			System.out.println(librosArrayList.size());
			
			libros= new Libro[librosArrayList.size()];
			
			for (int i = 0; i < librosArrayList.size(); i++) {
				System.out.println(librosArrayList.get(i).getNombre());
				libros[i]=librosArrayList.get(i);
			}
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error conectando a BD");
		}
		
		
	}
	
	public Autor[] getAutores() {
		return autores;
	}

	public void setAutores(Autor[] autores) {
		this.autores = autores;
	}

	public Editorial[] getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(Editorial[] editoriales) {
		this.editoriales = editoriales;
	}

	public Libro[] getLibros() {
		return libros;
	}

	public void setLibros(Libro[] libros) {
		this.libros = libros;
	}
	
	public void imprimirLibros(){
		System.out.println(libros.length+" libros");
		for (int i = 0; i < libros.length; i++) {
			System.out.println(libros[i].toString());
		}
	}
}
