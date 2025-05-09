package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Utilizando parametros de la clase Config.java se establece una conexion con la base de datos.
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class Conector {

	protected Connection conexion;
	/**
	 * Se genera y se conecta con la base de datos mediante las especificaciones añadidas
	 */
	public Conector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD,
					Config.USERNAME, Config.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * recibe conexion
	 * 
	 * @return conexion Establece la conexion con la base de datos.
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * modifica conexion
	 * 
	 * @param conexion Establece la conexion con la base de datos.
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
