package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Logs.Loggers;
import Modelo.Cliente;
import Modelo.Copia;
import Modelo.Empleados;
import Modelo.Modelo;
import Modelo.Producto;
import Modelo.cabeceraPedido;
import Modelo.lineaPedido;
import Vista.AdministrarPedidos;
import Vista.AdministrarProductos;
import Vista.Confirmacion;
import Vista.CopiasSeguridad;
import Vista.MenuEmpleados;
import Vista.PedidosEmleados;
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
	private PedidosEmleados pedidosempleados;
	private Confirmacion confirmar;
	private AdministrarProductos administrarProductos;
	private Producto produelegido;

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

		try (Loggers logger = new Loggers()) {
			// Buscar en clientes
			for (Cliente cliente : clienteList) {
				if (cliente.getNickname().equals(usuario) && cliente.getContrasenya().equals(contraseina)) {
					existe = true;
					System.out.println("Usuario existe");
					System.out.println("Usuario es Cliente");
					logger.logSesion("Inicio de sesión exitoso - Cliente: " + usuario);
					if (menuCli != null) {
						menuCli.mostrarVentana();
					} else {
						System.out.println("menuCliente no inicializado");
					}
					return; // salir al encontrar
				}
			}

			// Buscar en empleados
			for (Empleados empleado : empleList) {
				if (empleado.getNickname().equals(usuario) && empleado.getContrasenya().equals(contraseina)) {
					existe = true;
					System.out.println("Usuario existe");
					System.out.println("Usuario es Empleado");
					logger.logSesion("Inicio de sesión exitoso - Empleado: " + usuario);
					if (menuEmp != null) {
						menuEmp.mostrarVentana();
					} else {
						System.out.println("menuEmpleado no inicializado");
					}
					return; // salir al encontrar
				}
			}

			// Si no se encontró el usuario
			if (!existe) {
				System.out.println("Usuario no existe");
				String mensajeError = "Intento de inicio de sesión fallido - Usuario: " + usuario;
				Loggers.logError(mensajeError, new Exception("Usuario o contraseña incorrectos"));
			}

		} catch (Exception e) {
			System.err.println("Error al inicializar el logger: " + e.getMessage());
		}
	}

	public void llenarCabecera() throws SQLException {

		ArrayList<cabeceraPedido> cabeList = modelo.recibirCabeceras();
		pedidosAdmin.SetTablaE1(cabeList);

	}

	public void llenarTablaproductos() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		menuCli.setLlenartabla(produList);

	}

	public void tablaEmpleadoproduc() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		tablaProdu.setTabla(produList);

	}

//	public void tablapediAdmin() throws SQLException {
//
//		ArrayList<Producto> produList = modelo.recibirProducto();
//		pedidosAdmin.SetTablaE1(produList);
//
//	}

	public void usuariosCopiasTabla() throws SQLException {

		ArrayList<Copia> usuarioList = modelo.recibirCopia();
		copiasdeseguri.tablaCS(usuarioList);

	}

	public void pedidosCargar() throws SQLException {

		ArrayList<lineaPedido> linealist = modelo.recibirLinea();
		pedidosempleados.tablaPedidos(linealist);

	}

	public void eliminarLineaPedido(lineaPedido linea) throws SQLException {

		ArrayList<lineaPedido> lineaList = modelo.recibirLinea();
		boolean existe = false;

		for (int i = 0; i < lineaList.size(); i++) {
			if (lineaList.get(i).getNumLinea() == linea.getNumLinea()) {
				existe = true;
				modelo.eliminarLinea(linea);

			}

		}
		if (!existe) {
			System.out.println("Linea de pedido no encontrada");
			return;
		}

		ArrayList<lineaPedido> listaActualizada = modelo.recibirLinea();
		pedidosempleados.tablaPedidos(listaActualizada);

	}

	public void eliminarCabecera(cabeceraPedido cabe) throws SQLException {

		ArrayList<cabeceraPedido> produList = modelo.recibirCabeceras();
		boolean existe = false;

		for (int i = 0; i < produList.size(); i++) {
			if (produList.get(i).getId().equalsIgnoreCase(cabe.getId())) {
				existe = true;
				modelo.eliminarCabecera(cabe);

			}

		}

		if (!existe) {
			System.out.println("Id no encontrado");
		}

		ArrayList<cabeceraPedido> cabeActu = modelo.recibirCabeceras();
		pedidosAdmin.SetTablaE1(cabeActu);

	}

	public void llenarLineaPedido() throws SQLException {

		ArrayList<lineaPedido> lineaList = modelo.recibirLinea();
		pedidosempleados.tablaPedidos(lineaList);

	}

	@SuppressWarnings("unused")
	public void eliminarProdu(Producto produ) throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();

		boolean existe = false;

		for (int i = 0; i < produList.size(); i++) {
			if (produList.get(i).getIdProducto().equalsIgnoreCase(produ.getIdProducto())) {
				existe = true;
				modelo.eliminarProducto(produ);

			}

		}

		ArrayList<Producto> produActu = modelo.recibirProducto();
		tablaProdu.setTabla(produActu);

	}

	public void nuevoCliente(String nombre, String telefono, String direccion, String usuario, String contrasenia) {

		Cliente clienteNuevo = new Cliente();

		int randomNum = (int) (Math.random() * 101);

		String id = String.valueOf(randomNum);

		clienteNuevo.setId(id);

		clienteNuevo.setNombre(nombre);

		clienteNuevo.setTelefono(telefono);

		clienteNuevo.setDireccion(direccion);

		clienteNuevo.setNickname(usuario);

		clienteNuevo.setContrasenya(contrasenia);

		System.out.println(clienteNuevo.toString());

		modelo.insertCliente(clienteNuevo);

	}

	public void comprobarModificacion(Producto produNuevo, Producto produViejo) throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();

		boolean existe = false;

		for (int i = 0; i < produList.size(); i++) {

			if (produList.get(i).getIdProducto().equalsIgnoreCase(produViejo.getIdProducto())) {
				existe = true;

				modelo.updateProductos(produNuevo, produViejo);

			}

		}
		
		ArrayList<Producto>produActual = modelo.recibirProducto();
		tablaProdu.setTabla(produActual);

		if (existe==false) {
			System.out.println("Producto no encontrado");
		}

	}

	public Controlador(Modelo modelo, VentanaRegistrar registrar, VentanaLogin login, MenuEmpleados menuEmp,
			TablaPedidos menuCli, TablaAdministrarProductos tablaProdu, AdministrarPedidos pedidosAdmin,
			CopiasSeguridad copiasdeseguri, PedidosEmleados pedidosempleados, Confirmacion confirmar,
			AdministrarProductos administrarProductos) {

		this.modelo = modelo;
		Registrar = registrar;
		Login = login;
		this.menuEmp = menuEmp;
		this.menuCli = menuCli;
		this.tablaProdu = tablaProdu;
		this.pedidosAdmin = pedidosAdmin;
		this.copiasdeseguri = copiasdeseguri;
		this.pedidosempleados = pedidosempleados;
		this.confirmar = confirmar;
		this.administrarProductos = administrarProductos;

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

	public PedidosEmleados getPedidosempleados() {
		return pedidosempleados;
	}

	public void setPedidosempleados(PedidosEmleados pedidosempleados) {
		this.pedidosempleados = pedidosempleados;
	}

	public Confirmacion getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(Confirmacion confirmar) {
		this.confirmar = confirmar;
	}

	public AdministrarProductos getAdministrarProductos() {
		return administrarProductos;
	}

	public void setAdministrarProductos(AdministrarProductos administrarProductos) {
		this.administrarProductos = administrarProductos;
	}

	public Controlador(Producto produelegido) {

	}

	public Producto getProduelegido() {
		return produelegido;
	}

	public void setProduelegido(Producto produelegido) {
		this.produelegido = produelegido;
	}

}
