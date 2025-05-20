package Modelo;

/**
 * Se crean objetos Empleado.
 */
public class Empleados extends Usuarios {

	// mete sueldo
	/**
	 * el constructor esta vacio
	 */
	public Empleados() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * El constructor registra los parametros de los objetos empleado.
	 * 
	 * 
	 * @param nickname    El nickname es un String que indica el nickname del
	 *                    cliente.
	 * @param contrasenya La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 * @param id          La id es un String que indica la id del cliente.
	 */
	public Empleados(String nickname, String contrasenya, String id) {
		super(nickname, contrasenya, id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * El toString genera el contenido del objeto en una linea de texto creada a
	 * mano
	 */
	public String toString() {
		return "Empleados:\nnickname: " + getNickname() + "\ncontraseña: " + getContrasenya() + "\nid: " + getId() +"\n";
	}

}
