package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Logs.CustomLogger;
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
import Vista.ErrorBBDD;
import Vista.MenuEmpleados;
import Vista.PedidosEmleados;
import Vista.TablaAdministrarProductos;
import Vista.TablaPedidos;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class Controlador implements ActionListener {

	private Modelo modelo;
	private VentanaRegistrar Registrar;
	private VentanaLogin Login;
	private MenuEmpleados menuEmp;
	private TablaPedidos menuCli;
	private TablaAdministrarProductos tablaProdu;
	private AdministrarPedidos pedidosAdmin;
	private AdministrarProductos productosAdmin;
	private CopiasSeguridad copiasdeseguri;
	private PedidosEmleados pedidosempleados;
	private Confirmacion confirmacion;
	private ErrorBBDD error;

	public Controlador() {

	}

	public Controlador(Modelo modelo, AdministrarPedidos pedidosAdmin, AdministrarProductos productosAdmin,
			Confirmacion confirmacion, CopiasSeguridad copiasdeseguri, ErrorBBDD error, MenuEmpleados menuEmp,
			PedidosEmleados pedidosempleados, TablaAdministrarProductos tablaProdu, TablaPedidos menuCli,
			VentanaLogin login, VentanaRegistrar registrar) {

		this.modelo = modelo;
		Registrar = registrar;
		Login = login;
		this.menuEmp = menuEmp;
		this.menuCli = menuCli;
		this.tablaProdu = tablaProdu;
		this.pedidosAdmin = pedidosAdmin;
		this.copiasdeseguri = copiasdeseguri;
		this.pedidosempleados = pedidosempleados;
		this.Registrar.btnCrear2.addActionListener(this);
		this.Login.btnIniciar.addActionListener(this);
		this.Login.btnCrear.addActionListener(this);
		this.menuEmp.Btnproductos.addActionListener(this);
		this.menuEmp.Btnpedidos.addActionListener(this);
		this.menuEmp.BtncopiasSegu.addActionListener(this);
		this.menuCli.comboNombre.addActionListener(this);
		this.tablaProdu.filtroId.addActionListener(this);
	}

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

		try (CustomLogger logger = new CustomLogger()) {
			// Buscar en clientes
			for (Cliente cliente : clienteList) {
				if (cliente.getNickname().equals(usuario) && cliente.getContrasenya().equals(contraseina)) {
					existe = true;
					System.out.println("Usuario existe");
					System.out.println("Usuario es Cliente");
					logger.logSession("Inicio de sesión exitoso - Cliente: " + usuario);
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
					logger.logSession("Inicio de sesión exitoso - Empleado: " + usuario);
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
				CustomLogger.logError(mensajeError, new Exception("Usuario o contraseña incorrectos"));
			}

		} catch (Exception e) {
			System.err.println("Error al inicializar el logger: " + e.getMessage());
		}
	}

	public void eliminarPedido(cabeceraPedido cab) throws SQLException {

		ArrayList<cabeceraPedido> cablis = modelo.recibirCabeceras();
		boolean existe = false;

		for (int i = 0; i < cablis.size(); i++) {
			if (cablis.get(i).getId().equalsIgnoreCase(cab.getId())) {
				existe = true;
				modelo.eliminarCabecera(cab);

			}

		}

		if (!existe) {
			System.out.println("Id no encontrado");
		}

		ArrayList<cabeceraPedido> actualiProduc = modelo.recibirCabeceras();
		pedidosAdmin.SetTablaE1(actualiProduc);

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

	public void llenarTablaproductos() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		menuCli.setLlenartabla(produList);

	}

	public void tablaEmpleadoproduc() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		tablaProdu.setTabla(produList);
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
		this.modelo.insertCliente(clienteNuevo);
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {

		ArrayList<Producto> produlist = modelo.recibirProducto();

		if (e.getSource().equals(Login.btnIniciar)) {
			System.out.println("paso boton iniciar");
			comprobarLogin(Login.usuario.getText(), Login.contraseina.getText());
		}
		if (e.getSource().equals(Registrar.btnCrear2)) {
			System.out.println("paso boton crear");
			nuevoCliente(Registrar.Rnombre.getText(), Registrar.Rtelefono.getText(), Registrar.Rdireccion.getText(),
					Registrar.Rusuario.getText(), Registrar.Rcontraseina.getText());
			// COntrolador y static al otro lado
		}
		if (e.getSource().equals(Login.btnCrear)) {
//				ver.MostrarVentana();
			Registrar.MostrarVentana();
		}
		if (e.getSource().equals(menuEmp.Btnproductos)) {
			try {
				tablaEmpleadoproduc();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tablaProdu.MostrarVentana();
		}
		if (e.getSource().equals(menuEmp.Btnpedidos)) {
			try {
				tablapediAdmin();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pedidosAdmin.MostrarVentana();

		}
		if (e.getSource().equals(menuEmp.BtncopiasSegu)) {
			try {
				usuariosCopiasTabla();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			copiasdeseguri.MostrarVentana();

		}

		else if (e.getSource().equals(menuCli.comboNombre)) {
//			 menuCli.comboNombre.removeAllItems();
			for (Producto p : modelo.recibirProducto()) {
				tablaProdu.filtroId.addItem(p.getNombreProducto());
			}
		} else if (e.getSource().equals(tablaProdu.filtroId)) {
//			 tablaProdu.filtroId.removeAllItems();
			for (Producto p : modelo.recibirProducto()) {
				tablaProdu.filtroId.addItem(p.getNombreProducto());
			}
		}
	}

	public void tablapediAdmin() throws SQLException {

		ArrayList<cabeceraPedido> cabec = modelo.recibirCabeceras();
		pedidosAdmin.SetTablaE1(cabec);

	}

	public void usuariosCopiasTabla() throws SQLException {

		ArrayList<Copia> usuarioList = modelo.recibirCopia();
		copiasdeseguri.tablaCS(usuarioList);

	}

	public void pedidosCargar() throws SQLException {

		ArrayList<lineaPedido> linealist = modelo.recibirLinea();
		pedidosempleados.tablaPedidos(linealist);

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

	public AdministrarProductos getProductosAdmin() {
		return productosAdmin;
	}

	public void setProductosAdmin(AdministrarProductos productosAdmin) {
		this.productosAdmin = productosAdmin;
	}

	public Confirmacion getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}

	public ErrorBBDD getError() {
		return error;
	}

	public void setError(ErrorBBDD error) {
		this.error = error;
	}

}
