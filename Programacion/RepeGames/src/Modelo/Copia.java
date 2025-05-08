package Modelo;

import java.sql.Date;

/**
 * Se crea un objeto copia, la cual solo guarda usuarios.
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class Copia {
	private int idCopia;
	private String nombre;
	private Date fecha;
	private String ubicacion;

	/**
	 *  El constructor registra los parametros de la base de datos en la tabla de
	 * Copia.
	 * 
	 * @param idCopia La idCopia es un int que indica la id de la copia de seguridad.
	 * @param nombre El nombre es un String que indica el nombre de la copia de seguridad.
	 * @param fecha La fecha es un date que indica la fecha de creacion de la copia de seguridad.
	 * @param ubicacion La ubicacion es un String que indica la ubicacion del fichero de la copia de seguridad.
	 */
	public Copia(int idCopia, String nombre, Date fecha, String ubicacion) {
		this.idCopia = idCopia;
		this.nombre = nombre;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
	}

	/**
	 * El constructor esta vacio
	 */
	public Copia() {
	}

	/**
	 * recibe idCopia
	 * 
	 * @return idCopia La idCopia es un int que indica la id de la copia de seguridad.
	 */
	public int getIdCopia() {
		return idCopia;
	}

	/**
	 * modifica idCopia
	 * 
	 * @param idCopia La idCopia es un int que indica la id de la copia de seguridad.
	 */
	public void setIdCopia(int idCopia) {
		this.idCopia = idCopia;
	}

	/**
	 * recibe nombre
	 * 
	 * @return nombre El nombre es un String que indica el nombre de la copia de seguridad.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * modifica nombre
	 * 
	 * @param nombre El nombre es un String que indica el nombre de la copia de seguridad.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * recibe fecha
	 * 
	 * @return fecha La fecha es un date que indica la fecha de creacion de la copia de seguridad.
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * modifica fecha
	 * 
	 * @param fecha La fecha es un date que indica la fecha de creacion de la copia de seguridad.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * recibe ubicacion
	 * 
	 * @return ubicacion La ubicacion es un String que indica la ubicacion del fichero de la copia de seguridad.
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * modifica ubicacion
	 * 
	 * @param ubicacion La ubicacion es un String que indica la ubicacion del fichero de la copia de seguridad.
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano
	 */
	public String toString() {
		return "Copia: \nidCopia: " + idCopia + "\nnombre: " + nombre + "\nfecha: " + fecha + "\nubicacion: "
				+ ubicacion;
	}

}
