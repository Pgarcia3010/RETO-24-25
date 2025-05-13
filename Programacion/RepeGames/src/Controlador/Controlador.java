package Controlador;

import java.util.ArrayList;

import Modelo.Cliente;
import Modelo.Empleados;
import Modelo.Modelo;
import Modelo.Usuarios;
import Vista.MenuEmpleados;
import Vista.TablaPedidos;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class Controlador {

	private Modelo modelo;
	private VentanaRegistrar Registrar;
	private VentanaLogin Login;
	private MenuEmpleados menuEmp;
	private TablaPedidos menuCli;

	public void recibirClientes() {
		ArrayList<Cliente> clientes = this.modelo.recibirClientes();
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).toString());
		}
	}

	public void recibirEmpleados() {
		ArrayList<Empleados> empleados = this.modelo.recibirEmpleados();
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println(empleados.get(i).toString());
		}
	}

	public void comprobarLogin(String usuario, String contra) {
		ArrayList<Cliente> clienteList = this.modelo.recibirClientes();
		boolean existe =false;
//		ArrayList<Empleados> empleList = this.modelo.recibirEmpleados();
		for (int i = 0; i < clienteList.size(); i++) {
			if (clienteList.get(i).equals(usuario) && clienteList.get(i).equals(contra)) {
				existe=true;
				System.out.println("Usuario existe");
				System.out.println("Usuario es Cliente");
				menuCli.mostrarVentana();
			} else {
				existe=true;
				System.out.println("Usuario existe");
				System.out.println("Usuario es empleado");
				menuEmp.mostrarVentana();
			}
		}
		
		if(!false) {
			System.out.println("Usuario no existe");
		}

	}

	public VentanaLogin getLogin() {
		return Login;
	}

	public void setLogin(VentanaLogin login) {
		Login = login;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public VentanaRegistrar getRegistrar() {
		return Registrar;
	}

	public void setRegistrar(VentanaRegistrar registrar) {
		Registrar = registrar;
	}

}
