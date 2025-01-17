package Contenedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ConectorBd {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/sakila";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";
	
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	
	public Connection conectar() {
		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			stm = cn.createStatement();
			System.out.println("Conexion realizada correctamente");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return cn;
	}

	public ArrayList buscarActor(String nombreActor) {
		
		ArrayList arrayActores = new ArrayList();
		
		try {
			resultado = stm.executeQuery("select * from actor where first_name = '"+nombreActor+"'");
			
			while(resultado.next()) {
				String nombreEncontrado = resultado.getString("first_name");
				String apellidoEncontrado = resultado.getString("last_name");
				arrayActores.add(nombreEncontrado + ", " + apellidoEncontrado); 
				System.out.println(nombreEncontrado + ", " + apellidoEncontrado);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return arrayActores;
	}

	public DefaultTableModel cargarTabla(String nombreActor) {
		String [] titulos = {"Nombre","Apellido"};
		String [] registros = new String [2];

		DefaultTableModel modelo = new DefaultTableModel(null,titulos);
		conectar();
		
		try {
			resultado = stm.executeQuery("select * from actor where first_name = '"+nombreActor+"'");
			while(resultado.next()) {
				registros[0] = resultado.getString("first_name");
				registros[1] = resultado.getString("last_name");
				modelo.addRow(registros);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelo;
	}

	public void insertarNuevo(JTextField txtNuevoNombre, JTextField txtNuevoApellido) {
		conectar();
		String nuevoNombre = txtNuevoNombre.getText();
		String nuevoApellido = txtNuevoApellido.getText();
		
		if(!nuevoNombre.isEmpty() && !nuevoApellido.isEmpty()) {
			try {
				stm.executeUpdate("insert into actor (first_name, last_name) values ('"+nuevoNombre+"','"+nuevoApellido+"')");
				stm.close();
				cn.close();
				JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Introduce al menos una letra");
		}
		
	}
	
	
	
}
