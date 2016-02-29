package visualizador.utils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

public class Connect {

	Connection con;

	public Connect() {
		// TODO Auto-generated constructor stub
	}

	public void Conecta(String DB, String dbName, String Username) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println(DB + " " + dbName + " " + Username + " ");
			con = DriverManager.getConnection("jdbc:mysql://" + DB + "/" + dbName, Username, "");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el acceso");
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("Error cargando el driver");
			e.printStackTrace();
		}		
	}
	
	public String[][] getLibros() throws SQLException{		
		String[][]rows;
		String ISBN,Titulo,Autor,editorial,rawRow;
		
		PreparedStatement getNumFilas = con.prepareStatement("select count(cod_libro) from autor_libro");
		ResultSet numfilasAux = getNumFilas.executeQuery();
		numfilasAux.next();
		
		int numFilas = Integer.valueOf(numfilasAux.getString(1));
		rows = new String[numFilas][4];
		
		
		PreparedStatement getLibrosSQL = con.prepareStatement(
				"select cod_libro, autor.nombre, libro.Titulo, editorial.nombre "
				+ "from autor_libro "
				+ "inner join autor "
					+ "on autor_libro.cod_autor = autor.cod_autor "
				+ "inner join libro "
					+ "on autor_libro.cod_libro = libro.ISBN "
				+ "inner join editorial "
					+ "on libro.Cod_editorial = editorial.Cod_editorial");
		
		ResultSet salidaLibros = getLibrosSQL.executeQuery();
		
		int i=0;		
		while (salidaLibros.next()){
			
			ISBN = salidaLibros.getString(1);
			Autor = salidaLibros.getString(2);
			Titulo = salidaLibros.getString(3);
			editorial = salidaLibros.getString(4);
			
			rows[i][0]=ISBN;
			rows[i][1]=Autor;
			rows[i][2]=Titulo;
			rows[i][3]=editorial;
			i++;
		}
		return rows;
	}
	
	public String[][] getAutores() throws SQLException{
		String[][] arrayAutores;
		int nAutores;
		ResultSet res ;
		
		try {
			PreparedStatement getNautores = con.prepareStatement("Select count(cod_autor) from autor");
			res = getNautores.executeQuery();
			
			res.next();
			nAutores = Integer.valueOf(res.getString(1));
			
			PreparedStatement getTablaAutores = con.prepareStatement("SELECT cod_autor, nombre FROM autor");
			
			res= getTablaAutores.executeQuery();
			
			arrayAutores= new String[nAutores][2];
			
			System.out.println(arrayAutores.length+ "-"+arrayAutores[0].length);
			
			res.next();
			for (int i = 0; i < nAutores; i++) {
				arrayAutores[i][0]=res.getString(1);
				arrayAutores[i][1]=res.getString(2);
				res.next();
			}
			return arrayAutores;
			
		} catch (SQLException e) {
			System.out.println("Error recuperando autores");
			return null;
		}
		
			
		
		
	}
	
	public String[][] getEditoriales() throws SQLException{
		String [][] arrayEditoriales;
		int nEditoriales;
		ResultSet res;
		PreparedStatement pres;
		
		pres = con.prepareStatement("select count(Nombre) from editorial");
		res = pres.executeQuery();
		res.next();
		nEditoriales = Integer.valueOf(res.getString(1));
		
		pres = con.prepareStatement("Select * from editorial ");
		res = pres.executeQuery();
		
		arrayEditoriales= new String[nEditoriales][2];
		
		res.next();
		for (int i = 0; i < nEditoriales; i++) {
			arrayEditoriales[i][0]=res.getString(1);
			arrayEditoriales[i][1]=res.getString(2);
		}
		
		return arrayEditoriales;
	}
}


