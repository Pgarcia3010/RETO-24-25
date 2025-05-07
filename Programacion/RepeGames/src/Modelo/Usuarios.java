package Modelo;

/**
 * Sea crea un objeto Usuario.
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class Usuarios {

	private String nickname;
	private String contrasenya;
	private int idCliente;
	private int idEmpleado;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * Usuarios.
	 * 
	 * @param nickname    El nickname es un String que indica el nickname del
	 *                    cliente.
	 * @param contrasenya La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 * @param idCliente   La idCliente es un int que indica la id del cliente.
	 * @param idEmpleado  La idEmpleado es un int que indica la id del empleado.
	 */
	public Usuarios(String nickname, String contrasenya, int idCliente, int idEmpleado) {
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
	}

	/**
	 * El constructor esta vacio
	 */
	public Usuarios() {
	}

	/**
	 * recibe nickname
	 * 
	 * @return nickname El nickname es un String que indica el nickname del cliente.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * modifica nickname
	 * 
	 * @param nickname El nickname es un String que indica el nickname del cliente.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * recibe contrasenya
	 * 
	 * @return contrasenya La contraseña es un String que indica la contraseña del
	 *         cliente.
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * modifica contrasenya
	 * 
	 * @param contrasenya La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * recibe idCliente
	 * 
	 * @return idCliente La idCliente es un int que indica la id del cliente.
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * modifica idCliente
	 * 
	 * @param idCliente La idCliente es un int que indica la id del cliente.
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * recibe idEmpleado
	 * 
	 * @return idEmpleado La idEmpleado es un int que indica la id del empleado.
	 */
	public int getIdEmpleado() {
		return idEmpleado;
	}

	/**
	 * modifica idEmpleado
	 * 
	 * @param idEmpleado La idEmpleado es un int que indica la id del empleado.
	 */
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano.
	 * 
	 */
	public String toString() {
		return "Usuarios:\nnickname: " + nickname + "\ncontraseña: " + contrasenya + "\nidCliente: " + idCliente
				+ "\nidEmpleado: " + idEmpleado;
	}

}