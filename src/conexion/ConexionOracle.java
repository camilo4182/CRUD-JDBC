package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {
	
	private Connection conn;
	private String usuario = "P09551_1_10";
	private String contrasenia = "cortes8921";
	private String url = "jdbc:oracle:thin:@200.3.193.24:1522:ESTUD";
	
	public void setConnection() {
		try {
			conn = DriverManager.getConnection(url, usuario, contrasenia);
			System.out.println("¡Conexión establecida!");
		} catch (SQLException e) {
			System.out.println("No se pudo establecer la conexión con la base de datos.\n" + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void desconectar() {
		try {
			conn.close();
			System.out.println("Se ha desconectado de la base de datos.");
		} catch (Exception e) {
			System.out.println("Error al desconectar:" + e.getMessage());
		}
	}

}
