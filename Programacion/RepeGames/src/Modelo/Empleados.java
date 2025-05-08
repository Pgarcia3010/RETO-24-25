package Modelo;

public class Empleados extends Usuarios{

	public Empleados() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleados(String nickname, String contrasenya, String id) {
		super(nickname, contrasenya, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Empleados [getNickname()=" + getNickname() + ", getContrasenya()=" + getContrasenya() + ", getId()="
				+ getId() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	

}
