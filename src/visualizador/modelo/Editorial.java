package visualizador.modelo;

public class Editorial {
	String cod, nom;
	
	Editorial(String cd, String nm){
		cod = cd;
		nom = nm;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
