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

/**
 * Es la clase que une el paquete Modelo y Vista
 * 
 * @author Paul e Ismael
 */
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

	/**
	 * permite recibir los clientes de la base de datos
	 */
	public void recibirClientes() {
		ArrayList<Cliente> clientes = this.modelo.recibirClientes();
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).toString());
		}
	}

	/**
	 * permite recibir los empleados de la base de datos
	 */
	public void recibirEmpleados() {
		ArrayList<Empleados> empleados = this.modelo.recibirEmpleados();
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println(empleados.get(i).toString());
		}
	}

	/**
	 * Se comprueba que el usuario introducido exista
	 * 
	 * @param usuario     El usuario es un String que indica el nickname del
	 *                    cliente.
	 * @param contraseina La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 */
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

	/**
	 * Se llena el contenido de la tabla Cabecera
	 * 
	 * @throws SQLException se usa SQL
	 */
	public void llenarCabecera() throws SQLException {

		ArrayList<cabeceraPedido> cabeList = modelo.recibirCabeceras();
		pedidosAdmin.SetTablaE1(cabeList);

	}

	/**
	 * se llena el contenido de la tabla Productos
	 * 
	 * @throws SQLException se usa SQL
	 */
	public void llenarTablaproductos() throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();
		menuCli.setLlenartabla(produList);

	}

	/**
	 * se llena la tabla de productos para empleados
	 * 
	 * @throws SQLException se usa SQL
	 */
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
	/**
	 * Se llena el contenido de la tabla de copias de seguridad
	 * 
	 * @throws SQLException se usa SQL
	 */
	public void usuariosCopiasTabla() throws SQLException {

		ArrayList<Copia> usuarioList = modelo.recibirCopia();
		copiasdeseguri.tablaCS(usuarioList);

	}

	/**
	 * Se llena el contenido de linea de pedido
	 * 
	 * @throws SQLException se usa SQL
	 */
	public void pedidosCargar() throws SQLException {

		ArrayList<lineaPedido> linealist = modelo.recibirLinea();
		pedidosempleados.tablaPedidos(linealist);

	}

	/**
	 * S
	 * 
	 * @param linea Objeto de tipo lineaPedido
	 * @throws SQLException se usa SQL
	 */
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

	/**
	 * Se elimina una cabecera de pedido
	 * 
	 * @param cabe Objeto de tipo cabeceraPedido
	 * @throws SQLException se usa SQL
	 */
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

	/**
	 * se llena el contenido de la tabla lineaPedido
	 * 
	 * @throws SQLException se usa SQL
	 */
	public void llenarLineaPedido() throws SQLException {

		ArrayList<lineaPedido> lineaList = modelo.recibirLinea();
		pedidosempleados.tablaPedidos(lineaList);

	}

	/**
	 * se elimina un producto
	 * 
	 * @param produ Objeto de tipo Producto
	 * @throws SQLException se usa SQL
	 */
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

	/**
	 * Se crea un nuevoClientes
	 * 
	 * @param nombre      El nombre es un String que indica el nombre del cliente.
	 * @param telefono    El telefono es un int que indica el telefono del cliente.
	 * @param direccion   La direccion es un String que indica la direccion del
	 *                    cliente.
	 * @param usuario     El nickname es un String que indica el nickname del
	 *                    cliente.
	 * @param contrasenia La contraseña es un String que indica la contraseña del
	 *                    cliente.
	 */
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

	/**
	 * Se comprueba que se pueda cambiar una modificacion
	 * 
	 * @param produNuevo Objeto de tipo producto que indica el nuevo producto
	 * @param produViejo Objeto de tipo producto que indica el producto antiguo
	 * @throws SQLException se usa SQL
	 */
	public void comprobarModificacion(Producto produNuevo, Producto produViejo) throws SQLException {

		ArrayList<Producto> produList = modelo.recibirProducto();

		boolean existe = false;

		for (int i = 0; i < produList.size(); i++) {

			if (produList.get(i).getIdProducto().equalsIgnoreCase(produViejo.getIdProducto())) {
				existe = true;

				modelo.updateProductos(produNuevo, produViejo);

			}

		}

		ArrayList<Producto> produActual = modelo.recibirProducto();
		tablaProdu.setTabla(produActual);

		if (existe == false) {
			System.out.println("Producto no encontrado");
		}

	}

	/**
	 * Constructor del Controlador donde se llama a todas las clases
	 * 
	 * @param modelo               Objeto de tipo modelo
	 * @param registrar            Objeto de tipo ventanaRegistrar
	 * @param login                Objeto de tipo ventanaLogin
	 * @param menuEmp              Objeto de tipo menuEmpleados
	 * @param menuCli              Objeto de tipo tablaPedidos
	 * @param tablaProdu           Objeto de tipo tablaAdministrarProductos
	 * @param pedidosAdmin         Objeto de tipo administrarPedidos
	 * @param copiasdeseguri       Objeto de tipo copiasSeguridad
	 * @param pedidosempleados     Objeto de tipo pedidosEmpleados
	 * @param confirmar            Objeto de tipo confirmacion
	 * @param administrarProductos Objeto de tipo administrarProductos
	 */
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

	/**
	 * recibe Modelo
	 * 
	 * @return modelo Clase que une las ventanas con el modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * modifia Modelo
	 * 
	 * @param modelo Clase que une las ventanas con el modelo
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * recibe ventanaRegistrar
	 * 
	 * @return registrar Objeto de tipo ventanaregistrar
	 */
	public VentanaRegistrar getRegistrar() {
		return Registrar;
	}

	/**
	 * modifica ventanaRegistrar
	 * 
	 * @param registrar Objeto de tipo ventanaregistrar
	 */
	public void setRegistrar(VentanaRegistrar registrar) {
		Registrar = registrar;
	}

	/**
	 * recibe ventanaLogin
	 * 
	 * @return login  Objeto de tipo ventanalogin
	 */
	public VentanaLogin getLogin() {
		return Login;
	}

	/**
	 * modifica ventanaLogin
	 * 
	 * @param login  Objeto de tipo ventanlogin
	 */
	public void setLogin(VentanaLogin login) {
		Login = login;
	}

	/**
	 * recibe menuEmpleados
	 * 
	 * @return menuEmp  Objeto de tipo menuEmpleados
	 */
	public MenuEmpleados getMenuEmp() {
		return menuEmp;
	}

	/**
	 * modifica menuEmpleados
	 * 
	 * @param menuEmp  Objeto de tipo menuEmpleados
	 */
	public void setMenuEmp(MenuEmpleados menuEmp) {
		this.menuEmp = menuEmp;
	}

	/**
	 * recibe menuCliente
	 * 
	 * @return menuCli  Objeto de tipo menuCliente
	 */
	public TablaPedidos getMenuCli() {
		return menuCli;
	}

	/**
	 * modifica menuCliente
	 * 
	 * @param menuCli  Objeto de tipo menuCliente
	 */
	public void setMenuCli(TablaPedidos menuCli) {
		this.menuCli = menuCli;
	}

	/**
	 * recibe tablaAdministrarProductos
	 * 
	 * @return tablaProdu  Objeto de tipo tablaadministrarProductos
	 */
	public TablaAdministrarProductos getTablaProdu() {
		return tablaProdu;
	}

	/**
	 * modifica tblaAdministrarProductos
	 * 
	 * @param tablaProdu  Objeto de tipo tablaadministrarProductos
	 */
	public void setTablaProdu(TablaAdministrarProductos tablaProdu) {
		this.tablaProdu = tablaProdu;
	}

	/**
	 * recibe AdministrarPedidos
	 * 
	 * @return pedidosAdmin  Objeto de tipo pedidosAdmin
	 */
	public AdministrarPedidos getPedidosAdmin() {
		return pedidosAdmin;
	}

	/**
	 * modifica administrarPedidos
	 * 
	 * @param pedidosAdmin  Objeto de tipo pedidosAdmin
	 */
	public void setPedidosAdmin(AdministrarPedidos pedidosAdmin) {
		this.pedidosAdmin = pedidosAdmin;
	}

	/**
	 * recibe CopiasSeguridad
	 * 
	 * @return copasdeseguri  Objeto de tipo CopiasSeguridad
	 */
	public CopiasSeguridad getCopiasdeseguri() {
		return copiasdeseguri;
	}

	/**
	 * modifica CopiassSeguridad
	 * 
	 * @param copiasdeseguri  Objeto de tipo CopiasSeguridad
	 */
	public void setCopiasdeseguri(CopiasSeguridad copiasdeseguri) {
		this.copiasdeseguri = copiasdeseguri;
	}

	/**
	 * recibe PedidosEmleados
	 * 
	 * @return pedidosempleados  Objeto de tipo pedidosEmleados
	 */
	public PedidosEmleados getPedidosempleados() {
		return pedidosempleados;
	}

	/**
	 * modifica pedidosEmleados
	 * 
	 * @param pedidosempleados  Objeto de tipo pedidosEmleados
	 */
	public void setPedidosempleados(PedidosEmleados pedidosempleados) {
		this.pedidosempleados = pedidosempleados;
	}

	/**
	 * recibe Confirmar
	 * 
	 * @return confirmar  Objeto de tipo Confirmar
	 */
	public Confirmacion getConfirmar() {
		return confirmar;
	}

	/**
	 * Modifica Confirmar
	 * 
	 * @param confirmar  Objeto de tipo Confirmar
	 */
	public void setConfirmar(Confirmacion confirmar) {
		this.confirmar = confirmar;
	}

	/**
	 * recibe AdministrarProductos
	 * 
	 * @return administrarProductos  Objeto de tipo administrarProductos
	 */
	public AdministrarProductos getAdministrarProductos() {
		return administrarProductos;
	}

	/**
	 * modifica AdministrarProductos
	 * 
	 * @param administrarProductos  Objeto de tipo administrarProductos
	 */
	public void setAdministrarProductos(AdministrarProductos administrarProductos) {
		this.administrarProductos = administrarProductos;
	}

	/**
	 * recibe controlador
	 * 
	 * @param produelegido  Objeto de tipo Producto
	 */
	public Controlador(Producto produelegido) {

	}

	/**
	 * modifica controlador
	 * 
	 * @return produelegido  Objeto de tipo Producto
	 */
	public Producto getProduelegido() {
		return produelegido;
	}

	/**
	 * modifica Produelegido
	 * 
	 * @param produelegido  Objeto de tipo Producto
	 */
	public void setProduelegido(Producto produelegido) {
		this.produelegido = produelegido;
	}

}
