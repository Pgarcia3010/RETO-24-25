package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

import Modelo.Cliente;
import Modelo.Copia;
import Modelo.Empleados;
import Modelo.Modelo;
import Modelo.Producto;
import Modelo.Usuarios;
import Vista.AdministrarPedidos;
import Vista.CopiasSeguridad;
import Vista.MenuEmpleados;
import Vista.TablaAdministrarProductos;
import Vista.TablaPedidos;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class Controlador {

	private Modelo modelo;
	private VentanaRegistrar Registrar;
	private VentanaLogin Login;
	private MenuEmpleados menuEmp;
	private TablaPedidos menuCli;
	private TablaAdministrarProductos tablaProdu;
	private AdministrarPedidos pedidosAdmin;
	private CopiasSeguridad copiasdeseguri;

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

	public void comprobarLogin(String usuario, String contraseina) {
		ArrayList<Cliente> clienteList = this.modelo.recibirClientes();
		ArrayList<Empleados> empleList = this.modelo.recibirEmpleados();
		boolean existe = false;

		// Buscar en clientes
		for (int i = 0; i < clienteList.size(); i++) {
			if (clienteList.get(i).getNickname().equals(usuario)
					&& clienteList.get(i).getContrasenya().equals(contraseina)) {

				existe = true;
				System.out.println("Usuario existe");
				System.out.println("Usuario es Cliente");

				if (menuCli != null) {
					menuCli.mostrarVentana();
				} else {
					System.out.println("menuCliente no inicializado");
				}
				return; // salir al encontrar
			}
		}

		// Buscar en empleados
		for (int i = 0; i < empleList.size(); i++) {
			if (empleList.get(i).getNickname().equals(usuario)
					&& empleList.get(i).getContrasenya().equals(contraseina)) {
				existe = true;
				System.out.println("Usuario existe");
				System.out.println("Usuario es Empleado");

				if (menuEmp != null) {
					menuEmp.mostrarVentana();
				} else {
					System.out.println("menuEmpleado no inicializado");
				}
				return;
			}
		}

		// Si no se encontro ni un usuario
		if (!existe) {
			System.out.println("Usuario no existe");
		}
	}

	public void llenarTablaproductos() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		menuCli.setLlenartabla(produList);

	}

	public void tablaEmpleadoproduc() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		tablaProdu.setTabla(produList);

	}

	public void tablapediAdmin() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		pedidosAdmin.SetTablaE1(produList);

	}

	public void usuariosCopiasTabla() throws SQLException {

		ArrayList<Copia> usuarioList = modelo.recibirCopia();
		copiasdeseguri.tablaCS(usuarioList);

	}

	public Controlador(Modelo modelo, VentanaRegistrar registrar, VentanaLogin login, MenuEmpleados menuEmp,
			TablaPedidos menuCli, TablaAdministrarProductos tablaProdu, AdministrarPedidos pedidosAdmin,
			CopiasSeguridad copiasdeseguri) {

		this.modelo = modelo;
		Registrar = registrar;
		Login = login;
		this.menuEmp = menuEmp;
		this.menuCli = menuCli;
		this.tablaProdu = tablaProdu;
		this.pedidosAdmin = pedidosAdmin;
		this.copiasdeseguri = copiasdeseguri;
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

	public VentanaLogin getLogin() {
		return Login;
	}

	public void setLogin(VentanaLogin login) {
		Login = login;
	}

	public MenuEmpleados getMenuEmp() {
		return menuEmp;
	}

	public void setMenuEmp(MenuEmpleados menuEmp) {
		this.menuEmp = menuEmp;
	}

	public TablaPedidos getMenuCli() {
		return menuCli;
	}

	public void setMenuCli(TablaPedidos menuCli) {
		this.menuCli = menuCli;
	}

	public TablaAdministrarProductos getTablaProdu() {
		return tablaProdu;
	}

	public void setTablaProdu(TablaAdministrarProductos tablaProdu) {
		this.tablaProdu = tablaProdu;
	}

	public AdministrarPedidos getPedidosAdmin() {
		return pedidosAdmin;
	}

	public void setPedidosAdmin(AdministrarPedidos pedidosAdmin) {
		this.pedidosAdmin = pedidosAdmin;
	}

	public CopiasSeguridad getCopiasdeseguri() {
		return copiasdeseguri;
	}

	public void setCopiasdeseguri(CopiasSeguridad copiasdeseguri) {
		this.copiasdeseguri = copiasdeseguri;
	}

}
