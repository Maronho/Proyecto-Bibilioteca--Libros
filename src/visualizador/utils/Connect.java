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
}
	/*public String[] AprobadosSuspensos (String CodAsig) throws SQLException{
		String []Salida = {"",""};
		
		PreparedStatement getAprobados = con.prepareStatement("Select COUNT(codAlumno) from notas where nota > 4 AND codAsignatura LIKE ?");
		getAprobados.setString(1, CodAsig);
		
		PreparedStatement getSuspensos = con.prepareStatement("Select COUNT(codAlumno) from notas where nota < 5 AND codAsignatura LIKE ?");
		getSuspensos.setString(1, CodAsig);
		
		ResultSet res  = getAprobados.executeQuery();
		ResultSet resS = getSuspensos.executeQuery();
		while (res.next()){
			Salida[0]=res.getString(1);
		}
		while (resS.next()){
			Salida[1]= resS.getString(1);
		}
				
		return Salida;*/
	

