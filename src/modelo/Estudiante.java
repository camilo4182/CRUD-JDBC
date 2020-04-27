package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionOracle;

public class Estudiante {
	
	private String createStmt = "CREATE TABLE Estudiante\n" + 
								"(\n" + 
								"    codigo VARCHAR(10),\n" + 
								"    nombre VARCHAR(20) NOT NULL,\n" + 
								"    nombre_programa VARCHAR(26) NOT NULL,\n" + 
								"    promedio_acumulado NUMBER(2,1) NOT NULL,\n" + 
								"    edad NUMBER(2) NOT NULL,\n" + 
								"    PRIMARY KEY (codigo)\n" + 
								")";
	
	private String dropStmt = "DROP TABLE Estudiante";
	
	public boolean createTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(createStmt);
			System.out.println("Se creó la tabla Estudiante.");
		} catch (SQLException e) {
			System.out.println("No se pudo crear la tabla Estudiante." + e.getMessage());
		}
		
		return ex;
	}
	
	public boolean dropTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(dropStmt);
			System.out.println("Se eliminó la tabla Estudiante.");
		} catch (SQLException e) {
			System.out.println("No se pudo eliminar la tabla Estudiante.\n" + e.getMessage());
		}
		return ex;
	}
	
	public void insertar(ConexionOracle conn, String codigo, String nombre, String nombre_programa, double promedio_acumulado, int edad) {
		String pStmtStr = "INSERT INTO Estudiante (codigo, nombre, nombre_programa, promedio_acumulado, edad) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.getConnection().prepareStatement(pStmtStr);
			pstmt.setString(1, codigo);
			pstmt.setString(2, nombre);
			pstmt.setString(3, nombre_programa);
			pstmt.setDouble(4, promedio_acumulado);
			pstmt.setInt(5, edad);
			pstmt.executeUpdate();
			System.out.println("Se registró el estudiante " + nombre + " con código " + codigo + ".");
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el estudiante con código " + codigo + ". " + e.getMessage());
		}
	}

}
