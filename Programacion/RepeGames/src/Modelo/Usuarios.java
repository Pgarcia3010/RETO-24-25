package Modelo;

/**
 * Sea crea un objeto Usuario.
 * 
 * @author Paul Garcia
 * @version 1.2
 */
public abstract class Usuarios {

	private String nickname;
	private String contrasenya;
	private String id;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * Usuarios.
	 * 
	 * @param nickname    El nickname es un String que indica el nickname del
	 *                    cliente.
	 * @param contrasenya La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 * @param id          La id es un String que indica la id del usuario.
	 */
	public Usuarios(String nickname, String contrasenya, String id) {
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.id = id;
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
	 * recibe id
	 * 
	 * @return id La id es un String que indica la id del usuario.
	 */
	public String getId() {
		return id;
	}

	/**
	 * modifica id
	 * 
	 * @param id La id es un String que indica la id del usuario.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano.
	 * 
	 */
	public String toString() {
		return "Usuarios:\nnickname: " + nickname + "\ncontraseña: " + contrasenya + "\nid: " + id;
	}

}