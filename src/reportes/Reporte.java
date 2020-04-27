package reportes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionOracle;

public class Reporte {

	public void queryCursosDeCadaEstudiante(ConexionOracle con) {
		String query = "SELECT e.codigo, e.nombre, c.nombre, c.horario, c.salon, p.nombre\n" +
						"FROM";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("\nCursos por estudiante:");
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
