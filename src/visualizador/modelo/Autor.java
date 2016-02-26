package visualizador.modelo;

public class Autor {
	
	String autor, cod;
	
	Autor(String aut, String cd){
		autor = aut;
		cod = cd;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}
	
}
