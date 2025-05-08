package Modelo;

/**
 * Se crea un objeto Cliente.
 * 
 * @author Paul Garcia
 * @version 1.0
 */

public class Cliente extends Usuarios {

	private String nombre;
	private String direccion;
	private int telefono;

	public Cliente(String nickname, String contrasenya, String id, String nombre, String direccion, int telefono) {
		super(nickname, contrasenya, id);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Cliente() {
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

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", getNickname()="
				+ getNickname() + ", getContrasenya()=" + getContrasenya() + ", getId()=" + getId() + "]";
	}

}
