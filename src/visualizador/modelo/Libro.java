package visualizador.modelo;

import javax.swing.plaf.BorderUIResource.TitledBorderUIResource;

public class Libro {
	
	String[] autores;
	String editorial;
	
	String codigo, nombre;
	
	public Libro(String []escritores, String editorialActual, String cod, String nom) {
		
		this.autores=escritores;
		this.editorial = editorialActual;
		this.codigo = cod;
		this.nombre = nom;
		
	}

	public String getAutores() {
		StringBuffer salida = new StringBuffer("");
		
		for (int i = 0; i < autores.length; i++) {
			salida.append(autores[i]);
		}
		
		return salida.toString();
	}

	public void setAutores(String[] autores) {
		this.autores = autores;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String autoresToString(){
		StringBuffer salida = new StringBuffer("");
		for (int i = 0; i < autores.length; i++) {
			salida.append(autores[i]+",");
		}
		return salida.toString();
	}
	
	public String toString(){
		return new String(getCodigo()+", ["+autoresToString()+"], "+getNombre()+", "+getEditorial());
	}
	
}
