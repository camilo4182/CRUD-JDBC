package interfaz;

import conexion.ConexionOracle;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Matricula;
import modelo.Profesor;
import reportes.Reporte;

public class InterfazPrincipal {
	
	private static ConexionOracle con = new ConexionOracle();
	private static Estudiante est = new Estudiante();
	private static Profesor pro = new Profesor();
	private static Curso cu = new Curso();
	private static Matricula mat = new Matricula();
	private static Reporte report = new Reporte();

	public static void main(String[] args) {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("¡Oracle JDBC Driver no encontrado!");
		}		
		con.setConnection();
		borrarTablas();
		crearTablas();
		insertarEstudiantes();
		insertarProfesores();
		insertarCursos();
		insertarMatriculas();
		report.queryCursosDeCadaEstudiante(con);
		con.desconectar();
	}
	
	public static void crearTablas() {
		est.createTable(con);
		pro.createTable(con);
		cu.createTable(con);
		mat.createTable(con);
	}
	
	public static void borrarTablas() {
		mat.dropTable(con);
		cu.dropTable(con);
		est.dropTable(con);
		pro.dropTable(con);		
	}
	
	public static void insertarEstudiantes() {
		est.insertar(con, "051135593", "Sofia Loren", "Ciencia Politica", 4.2, 22);
		est.insertar(con, "060839453", "Julio Iglesias", "Diseno Industrial", 4.2, 23);
		est.insertar(con, "099354543", "Andres Cepeda", "Derecho", 3.7, 21);
		est.insertar(con, "112348546", "Julio Sabala", "Ingenieria de Sistemas", 4.0, 20);
		est.insertar(con, "115987938", "Fernando Alonso", "Ingenieria de Sistemas", 3.7, 21);
		est.insertar(con, "132977562", "Celia Cruz", "Antropologia", 4.2, 21);
		est.insertar(con, "269734834", "Placido Domingo", "Psicologia", 4.0, 19);
		est.insertar(con, "280158572", "Angela Carrasco", "Medicina", 3.5, 19);
		est.insertar(con, "301221823", "Richard Marx", "Psicologia", 3.7, 20);
		est.insertar(con, "318548912", "Luis Angel", "Economia", 3.5, 19);
	}
	
	public static void insertarProfesores() {
		pro.insertar(con, "142519864", "Camilo Valderrama", 20);
		pro.insertar(con, "242518965", "Luis Felipe Cardona", 68);
		pro.insertar(con, "141582651", "Hugo Arboleda", 20);
		pro.insertar(con, "011564812", "Gonzalo Llano", 68);
		pro.insertar(con, "254099823", "Angela Villota", 68);
		pro.insertar(con, "356187925", "Gabriel Tamura", 12);
		pro.insertar(con, "489456522", "Sandra Cespedes", 20);
		pro.insertar(con, "287321212", "Norha Villegas", 12);
		pro.insertar(con, "248965255", "Alvaro Pachon", 12);
	}
	
	public static void insertarCursos() {
		cu.insertar(con, "Algoritmos y Estructuras de Datos", "LMiV 10:00-12:00", "108D", "489456522");
		cu.insertar(con, "Sistemas Operativos", "MaJ 11:00-13:00", "203C", "489456522");
		cu.insertar(con, "Contabilidad y Costos", "MaJ 14:00-16:00", "101A", "011564812");
		cu.insertar(con, "Ingles I", "LMiV 14:00-17:00", "204C", "248965255");
		cu.insertar(con, "Ingenieria de Procesos", "LMiV 9:00-11:00", "304C", "011564812");
		cu.insertar(con, "Redes de Comunicaciones", "LMi 9:00-11:00", "203C", "141582651");
	}
	
	public static void insertarMatriculas() {
		mat.insertar(con, "112348546", "Algoritmos y Estructuras de Datos");
		mat.insertar(con, "115987938", "Algoritmos y Estructuras de Datos");
		mat.insertar(con, "112348546", "Sistemas Operativos");
		mat.insertar(con, "115987938", "Sistemas Operativos");
		mat.insertar(con, "301221823", "Ingles I");
	}

}
