package pruebaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConectorBd {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://bw2uvyre8khrg7weegni-mysql.services.clever-cloud.com/bw2uvyre8khrg7weegni";
	private static final String USUARIO = "unr7dqmb7zjdfiuu";
	private static final String CLAVE = "1pzoM4jrh1rg44lxZX4q";
	
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	
	public Connection conexion_correcta() {
		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexion realizada correctamente");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return cn;
	}
	
	
	
}
