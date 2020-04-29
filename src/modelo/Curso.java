package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionOracle;

public class Curso {
	
	private String createStmt = "CREATE TABLE Curso\n" + 
								"(\n" + 
								"    nombre VARCHAR(40) NOT NULL,\n" + 
								"    horario VARCHAR(20) NOT NULL,\n" + 
								"    salon VARCHAR(4) NOT NULL,\n" + 
								"    profesor VARCHAR(10) NOT NULL,\n" + 
								"    PRIMARY KEY (nombre),\n" + 
								"    FOREIGN KEY (profesor) REFERENCES Profesor\n" + 
								")";
	private String dropStmt = "DROP TABLE Curso";
	
	public boolean createTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(createStmt);
			System.out.println("Se creó la tabla Curso.");
		} catch (SQLException e) {
			System.out.println("No se pudo crear la tabla Curso." + e.getMessage());
		}
		
		return ex;
	}
	
	public boolean dropTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(dropStmt);
			System.out.println("Se eliminó la tabla Curso.");
		} catch (SQLException e) {
			System.out.println("No se pudo eliminar la tabla Curso.\n" + e.getMessage());
		}
		return ex;
	}
	
	public void insertar(ConexionOracle conn, String nombre, String horario, String salon, String profesor) {
		String pStmtStr = "INSERT INTO Curso (nombre, horario, salon, profesor) VALUES (?, ?, ?, ?)";
		PreparedStatement pStmt;
		try {
			pStmt = conn.getConnection().prepareStatement(pStmtStr);
			pStmt.setString(1, nombre);
			pStmt.setString(2, horario);
			pStmt.setString(3, salon);
			pStmt.setString(4, profesor);
			pStmt.executeUpdate();
			System.out.println("Se registró el curso " + nombre + ".");
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el curso " + nombre + ". " + e.getMessage() + ".");
		}
	}

}
