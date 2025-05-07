package Modelo;

/**
 * Se crea un objeto Cliente.
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
	 * @param idCliente   La idCliente es un int que indica la id del cliente.
	 * @param nombre      El nombre es un String que indica el nombre del cliente.
	 * @param direccion   La direccion es un String que indica la direccion del
	 *                    cliente.
	 * @param telefono    El telefono es un int que indica el telefono del cliente.
	 * @param nickname    El nickname es un String que indica el nickname del
	 *                    cliente.
	 * @param contrasenya La contraseña es un String que indica la contraseña del
	 *                    cliente.
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
	 * @return idCliente La idCliente es un int que indica la id del cliente.
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * modifica el idCliente
	 * 
	 * @param idCliente La idCliente es un int que indica la id del cliente.
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * recibe el nombre del cliente
	 * 
	 * @return nombre El nombre es un String que indica el nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * modifica el nombre del cliente
	 * 
	 * @param nombre El nombre es un String que indica el nombre del cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * recibe la direccion del cliente
	 * 
	 * @return direccion La direccion es un String que indica la direccion del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * modifica la direccion del cliente
	 * 
	 * @param direccion La direccion es un String que indica la direccion del cliente.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * recibe el telefono del cliente
	 * 
	 * @return telefono El telefono es un int que indica el telefono del cliente.
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * modifica el telefono del cliente
	 * 
	 * @param telefono El telefono es un int que indica el telefono del cliente.
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * recibe el nombre de usuario del cliente
	 * 
	 * @return nickname El nickname es un String que indica el nickname del cliente.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * modifica el nombre de usuario del cliente
	 * 
	 * @param nickname El nickname es un String que indica el nickname del cliente.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * recibe la contraseña del cliente
	 * 
	 * @return contrasenya La contraseña es un String que indica la contraseña del cliente.
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * modifica la contraseña del cliente
	 * 
	 * @param contrasenya La contraseña es un String que indica la contraseña del cliente.
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano
	 */
	public String toString() {
		return "Cliente:\nidCliente: " + idCliente + "\nnombre: " + nombre + "\ndireccion: " + direccion
				+ "\ntelefono: " + telefono + "\nnickname: " + nickname + "\ncontraseña: " + contrasenya;
	}

}
