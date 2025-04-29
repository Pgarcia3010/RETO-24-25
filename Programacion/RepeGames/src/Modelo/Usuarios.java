package Modelo;

public class Usuarios {
	
	private String nickname;
	private String contrasenya;
	private int id_cliente;
	private int id_empleado;
	
	public Usuarios(String nickname, String contrasenya, int id_cliente, int id_empleado) {
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.id_cliente = id_cliente;
		this.id_empleado = id_empleado;
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

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	@Override
	public String toString() {
		return "Usuarios [nickname=" + nickname + ", contrasenya=" + contrasenya + ", id_cliente=" + id_cliente
				+ ", id_empleado=" + id_empleado + "]";
	}
	
	

}
