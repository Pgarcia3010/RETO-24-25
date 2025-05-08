package Modelo;

public class Usuarios {

	private String nickname;
	private String contrasenya;
	private Integer idCliente;
	private int idEmpleado;

	public Usuarios(String nickname, String contrasenya, int idCliente, int idEmpleado) {
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
	}

	public Usuarios() {
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Usuarios:\nnickname: " + nickname + "\ncontraseña: " + contrasenya + "\nidCliente: " + idCliente
				+ "\nidEmpleado: " + idEmpleado;
	}

}