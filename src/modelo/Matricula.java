package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionOracle;

public class Matricula {
	
	private String createStmt = "CREATE TABLE Matricula\n" + 
								"(\n" + 
								"    estudiante VARCHAR(10) NOT NULL,\n" + 
								"    curso VARCHAR(36) NOT NULL,\n" + 
								"    PRIMARY KEY (estudiante, curso),\n" + 
								"    FOREIGN KEY (estudiante) REFERENCES Estudiante,\n" + 
								"    FOREIGN KEY (curso) REFERENCES Curso\n" + 
								")";
	private String dropStmt = "DROP TABLE Matricula";
	
	public boolean createTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(createStmt);
			System.out.println("Se creó la tabla Matricula.");
		} catch (SQLException e) {
			System.out.println("No se pudo crear la tabla Matricula." + e.getMessage());
		}
		
		return ex;
	}
	
	public boolean dropTable(ConexionOracle conn) {
		boolean ex = false;
		try {
			Statement stmt = conn.getConnection().createStatement();
			ex = stmt.execute(dropStmt);
			System.out.println("Se eliminó la tabla Matricula.");
		} catch (SQLException e) {
			System.out.println("No se pudo eliminar la tabla Matricula.\n" + e.getMessage());
		}
		return ex;
	}
	
	public void insertar(ConexionOracle conn, String estudiante, String curso) {
		String pStmtStr = "INSERT INTO Matricula (estudiante, curso) VALUES (?, ?)";
		PreparedStatement pStmt;
		try {
			pStmt = conn.getConnection().prepareStatement(pStmtStr);
			pStmt.setString(1, estudiante);
			pStmt.setString(2, curso);
			pStmt.executeUpdate();
			System.out.println("Se insertó la fila (" + estudiante + ", " + curso + ").");
		} catch (SQLException e) {
			System.out.println("No se pudo insertar la fila (" + estudiante + ", " + curso + ") en la tabla Matricula.");
		}
	}
	
}
