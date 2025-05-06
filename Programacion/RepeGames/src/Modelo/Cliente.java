package Modelo;

/**
 * 
 * @author Paul Garcia
 * @version 1.0
 */

public class Cliente {

	private int idCliente;
	private String nombre;
	private String direccion;
	private int telefono;
	private String nickname;
	private String contrasenya;

	/**
	 * 
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * Cliente.
	 * 
	 * @param idCliente
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param nickname
	 * @param contrasenya
	 */
	public Cliente(int idCliente, String nombre, String direccion, int telefono, String nickname, String contrasenya) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
	}

	/**
	 * Este constructor esta vacio
	 */
	public Cliente() {
	}

	/**
	 * recibe el idCliente
	 * 
	 * @return idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * modifica el idCliente
	 * 
	 * @param idCliente
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * recibe el nombre del cliente
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * modifica el nombre del cliente
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * recibe la direccion del cliente
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * modifica la direccion del cliente
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * recibe el telefono del cliente
	 * 
	 * @return telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * modifica el telefono del cliente
	 * 
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * recibe el nombre de usuario del cliente
	 * 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * modifica el nombre de usuario del cliente
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * recibe la contraseña del cliente
	 * 
	 * @return contrasenya
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * modifica la contraseña del cliente
	 * 
	 * @param contrasenya
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         hecha a mano
	 */
	public String toString() {
		return "Cliente:\nidCliente: " + idCliente + "\nnombre: " + nombre + "\ndireccion: " + direccion
				+ "\ntelefono: " + telefono + "\nnickname: " + nickname + "\ncontraseña: " + contrasenya;
	}

}
