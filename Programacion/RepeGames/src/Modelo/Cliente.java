package Modelo;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String direccion;
	private int telefono;
	private String nickname;
	private String contrasenya;

	public Cliente(int idCliente, String nombre, String direccion, int telefono, String nickname, String contrasenya) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
	}

	public Cliente() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
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

	@Override
	public String toString() {
		return "Cliente:\nidCliente: " + idCliente + "\nnombre: " + nombre + "\ndireccion: " + direccion
				+ "\ntelefono: " + telefono + "\nnickname: " + nickname + "\ncontraseña: " + contrasenya;
	}

}
