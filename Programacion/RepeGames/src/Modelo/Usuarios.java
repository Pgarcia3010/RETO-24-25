package Modelo;
/**
 * 
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
 * 
 * @param nickname
 * @param contrasenya
 * @param idCliente
 * @param idEmpleado
 */
	public Usuarios(String nickname, String contrasenya, int idCliente, int idEmpleado) {
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
	}
/**
 * 
 */
	public Usuarios() {
	}
/**
 * 
 * @return
 */
	public String getNickname() {
		return nickname;
	}
/**
 * 
 * @param nickname
 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
/**
 * 
 * @return
 */
	public String getContrasenya() {
		return contrasenya;
	}
/**
 * 
 * @param contrasenya
 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
/**
 * 
 * @return
 */
	public int getIdCliente() {
		return idCliente;
	}
/**
 * 
 * @param idCliente
 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
/**
 * 
 * @return
 */
	public int getIdEmpleado() {
		return idEmpleado;
	}
/**
 * 
 * @param idEmpleado
 */
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	/**
	 * 
	 */
	public String toString() {
		return "Usuarios:\nnickname: " + nickname + "\ncontraseña: " + contrasenya + "\nidCliente: " + idCliente
				+ "\nidEmpleado: " + idEmpleado;
	}

}