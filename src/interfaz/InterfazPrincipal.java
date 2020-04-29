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
		est.insertar(con, "051135593", "Sofia Loren", "Ciencia Politica", 4.2, 21);
		est.insertar(con, "060839453", "Julio Iglesias", "Diseno Industrial", 4.2, 22);
		est.insertar(con, "099354543", "Andres Cepeda", "Derecho", 3.7, 20);
		est.insertar(con, "112348546", "Julio Sabala", "Ingenieria de Sistemas", 4.0, 19);
		est.insertar(con, "115987938", "Fernando Alonso", "Ingenieria de Sistemas", 3.7, 20);
		est.insertar(con, "132977562", "Celia Cruz", "Antropologia", 4.2, 20);
		est.insertar(con, "269734834", "Placido Domingo", "Psicologia", 4.0, 18);
		est.insertar(con, "280158572", "Angela Carrasco", "Medicina", 3.5, 18);
		est.insertar(con, "301221823", "Richard Marx", "Psicologia", 3.7, 20);
		est.insertar(con, "318548912", "Luis Angel", "Economia", 3.5, 18);
		est.insertar(con, "320874981", "David Copperfield", "Ingenieria Telematica", 3.5, 17);
		est.insertar(con, "322654189", "Camilo Torres", "Ingenieria de Sistemas", 4.0, 17);
		est.insertar(con, "348121549", "Arcipreste de Hita", "Ingenieria de Sistemas", 3.7, 18);
		est.insertar(con, "351565322", "William Wallace", "Contaduria y Finanzas", 3.7, 19);
		est.insertar(con, "451519864", "Jaime Lannister", "Economia", 3.5, 18);
		est.insertar(con, "455798411", "Juan Sin Tierra", "Ingenieria Telematica", 3.5, 17);
		est.insertar(con, "462156489", "Alejandro Magno", "Ingenieria Industrial", 4.0, 19);
		est.insertar(con, "550156548", "Charles Darwin", "Administracion", 4.2, 21);
		est.insertar(con, "552455318", "Fabiana Cantilo", "Ingenieria de Sistemas", 4.2, 19);
		est.insertar(con, "556784565", "Andres Calamaro", "Ingenieria Industrial", 4.2, 21);
		est.insertar(con, "567354612", "Steven Tyler", "Ingenieria de Sistemas", 3.5, 18);
		est.insertar(con, "573284895", "Cristiano Ronaldo", "Medicina", 4.0, 19);
		est.insertar(con, "574489456", "Juan Pablo Montoya", "Economia", 3.7, 20);
		est.insertar(con, "578875478", "Antonio Ricaurte", "Medicina", 4.2, 21);
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
		pro.insertar(con, "159542516", "Luis Eduardo Munera", 33);
		pro.insertar(con, "090873519", "Carlos Arce", 11);
		pro.insertar(con, "486512566", "Juan Carlos Muñoz", 20);
		pro.insertar(con, "619023588", "Andres Navarro", 11);
		pro.insertar(con, "489221823", "Alfonso Bustamante", 33);
		pro.insertar(con, "548977562", "Gonzalo Ulloa", 20);
	}
	
	public static void insertarCursos() {
		cu.insertar(con, "Algoritmos y Estructuras de Datos", "LMiV 10:00-12:00", "108D", "489456522");
		cu.insertar(con, "Bases de Datos", "LMiV 18:00-20:00", "304C", "142519864");
		cu.insertar(con, "Sistemas Operativos", "MaJ 11:00-13:00", "203C", "489456522");
		cu.insertar(con, "Arte contemporaneo", "LMiV 14:00-17:00", "108D", "248965255");
		cu.insertar(con, "Contabilidad y Costos", "MaJ 14:00-16:00", "101A", "011564812");
		cu.insertar(con, "Introduccion a la Ingenieria y las TIC", "MaJ 11:30-13:00", "504L", "011564812");
		cu.insertar(con, "Ingles I", "LMiV 14:00-17:00", "204C", "248965255");
		cu.insertar(con, "Ingles II", "MaJ 14:00-17:00", "203C", "619023588");
		cu.insertar(con, "Literatura I", "Ma 18:00-21:00", "504L", "159542516");
		cu.insertar(con, "Sociedad del siglo XIX", "L 9:00-12:00", "101A", "489221823");
		cu.insertar(con, "Calculo varias variables", "MaJ 14:00-17:00", "504L", "090873519");
		cu.insertar(con, "Fundamentos de Derecho Constitucional", "V 7:00-9:00", "108D", "090873519");
		cu.insertar(con, "Principios de Economia", "LMiV 11:00-13:00", "203C", "489221823");
		cu.insertar(con, "Quimica Organica", "MaJ 14:00-16:00", "204C", "489221823");
		cu.insertar(con, "Fundamentos de Mercadeo", "LMi 7:00-9:00", "304C", "489221823");
		cu.insertar(con, "Probabilidad y Estadistica", "L 16:00-18:00", "504L", "489221823");
		cu.insertar(con, "Ingenieria de Procesos", "LMiV 9:00-11:00", "304C", "011564812");
		cu.insertar(con, "Organizaciones", "MaJ 14:00-16:00", "108D", "356187925");
		cu.insertar(con, "Redes de Comunicaciones", "LMi 9:00-11:00", "203C", "141582651");
		cu.insertar(con, "Logica Digital", "MaJ 14:00-16:00", "504L", "254099823");
		cu.insertar(con, "Algebra y Funciones", "MaJ 7:00-10:00", "108D", "489221823");
	}
	
	public static void insertarMatriculas() {
		mat.insertar(con, "112348546", "Algoritmos y Estructuras de Datos");
		mat.insertar(con, "115987938", "Algoritmos y Estructuras de Datos");
		mat.insertar(con, "348121549", "Bases de Datos");
		mat.insertar(con, "322654189", "Bases de Datos");
		mat.insertar(con, "552455318", "Bases de Datos");
		mat.insertar(con, "455798411", "Sistemas Operativos");
		mat.insertar(con, "552455318", "Sistemas Operativos");
		mat.insertar(con, "567354612", "Sistemas Operativos");
		mat.insertar(con, "112348546", "Sistemas Operativos");
		mat.insertar(con, "115987938", "Sistemas Operativos");
		mat.insertar(con, "322654189", "Sistemas Operativos");
		mat.insertar(con, "567354612", "Algoritmos y Estructuras de Datos");
		mat.insertar(con, "552455318", "Redes de Comunicaciones");
		mat.insertar(con, "455798411", "Logica Digital");
		mat.insertar(con, "301221823", "Sociedad del siglo XIX");
		mat.insertar(con, "301221823", "Literatura I");
		mat.insertar(con, "301221823", "Ingles I");
		mat.insertar(con, "556784565", "Introduccion a la Ingenieria y las TIC");
		mat.insertar(con, "099354543", "Fundamentos de Derecho Constitucional");
		mat.insertar(con, "574489456", "Principios de Economia");
	}

}
