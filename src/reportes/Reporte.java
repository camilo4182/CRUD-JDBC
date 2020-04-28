package reportes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionOracle;

public class Reporte {

	public void queryCursosDeCadaEstudiante(ConexionOracle con) {
		String query = "SELECT e.codigo, e.nombre, c.nombre, c.horario, c.salon, p.nombre\n" +
						"FROM ((Matricula m  INNER JOIN Estudiante e ON m.estudiante = e.codigo) " +
						"INNER JOIN Curso c ON m.curso = c.nombre) INNER JOIN Profesor p ON c.profesor = p.cedula " + 
						"ORDER BY e.nombre ASC";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("********** INICIO REPORTE DE CURSOS POR ESTUDIANTE **********");
			System.out.printf("CODIGO_EST | NOMBRE_EST | NOMBRE_CURSO | HORARIO | SALON | NOMBRE_PROF\n");
			while(rs.next()) {
				String codigo = rs.getString(1);
				String nombre_est = rs.getString(2);
				String nombre_curso = rs.getString(3);
				String horario = rs.getString(4);
				String salon = rs.getString(5);
				String nombre_pro = rs.getString(6);
				System.out.println(codigo + " | " + nombre_est + " | " + nombre_curso + " | " + horario + " | " + salon + " | " + nombre_pro);
			}
			System.out.println("********************* FIN REPORTE **************************");
		} catch (SQLException e) {
			System.out.println("Ocurrió un error al hacer la consulta. " + e.getMessage());
		}
	}
	
}
