package Modelo;

/**
 * Se crea un objeto Cliente.
 * 
 * @author Paul Garcia
 * @version 1.0
 */

/**
 * Se crea un objeto cliente.
 * 
 */
public class Cliente extends Usuarios {

	private String nombre;
	private String direccion;
	private int telefono;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * Clientes.
	 * 
	 * @param nickname    El nickname es un String que indica el nickname del
	 *                    cliente.
	 * @param contrasenya La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 * @param id          La id es un String que indica la id del cliente.
	 * @param nombre      El nombre es un String que indica el nombre del cliente.
	 * @param direccion   La direccion es un String que indica la direccion del
	 *                    cliente.
	 * @param telefono    El telefono es un int que indica el telefono del cliente.
	 */
	public Cliente(String nickname, String contrasenya, String id, String nombre, String direccion, int telefono) {
		super(nickname, contrasenya, id);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	/**
	 * Este constructor esta vacio
	 */
	public Cliente() {
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
	 * @return direccion La direccion es un String que indica la direccion del
	 *         cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * modifica la direccion del cliente
	 * 
	 * @param direccion La direccion es un String que indica la direccion del
	 *                  cliente.
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
	 * El toString genera el contenido del objeto en una linea de texto creada a
	 * mano
	 */
	public String toString() {
		return "Cliente \nid: " + getId() + "\nnombre: " + nombre + "\ndireccion: " + direccion + "\ntelefono: "
				+ telefono + "\nnickname" + getNickname() + "\ncontraseña: " + getContrasenya();
	}
}
