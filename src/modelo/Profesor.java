package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionOracle;

public class Profesor {
	
	private String createStmt = "CREATE TABLE Profesor\n" + 
								"(\n" + 
								"    cedula VARCHAR(10),\n" + 
								"    nombre VARCHAR(20) NOT NULL,\n" + 
								"    departamento NUMBER(2) NOT NULL,\n" + 
								"    PRIMARY KEY (cedula)\n" + 
								")";
	private String dropStmt = "DROP TABLE Profesor";
	
	public boolean createTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(createStmt);
			System.out.println("Se creó la tabla Profesor.");
		} catch (SQLException e) {
			System.out.println("No se pudo crear la tabla Profesor." + e.getMessage());
		}
		
		return ex;
	}
	
	public boolean dropTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(dropStmt);
			System.out.println("Se eliminó la tabla Profesor.");
		} catch (SQLException e) {
			System.out.println("No se pudo eliminar la tabla Profesor.\n" + e.getMessage());
		}
		return ex;
	}
	
	public void insertar(ConexionOracle conn, String cedula, String nombre, int departamento) {
		String pStmtStr = "INSERT INTO Profesor (cedula, nombre, departamento) VALUES (?, ?, ?)";
		PreparedStatement pStmt;
		try {
			pStmt = conn.getConnection().prepareStatement(pStmtStr);
			pStmt.setString(1, cedula);
			pStmt.setString(2, nombre);
			pStmt.setInt(3, departamento);
			pStmt.executeUpdate();
			System.out.println("Se registró el profesor " + nombre + " con cédula " + cedula + ".");
		} catch (SQLException e) {			
			System.out.println("No se pudo registrar el profesor con cédula " + cedula + ". " + e.getMessage());
		}
	}

}
