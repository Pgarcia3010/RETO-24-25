import java.sql.SQLException;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.AdministrarPedidos;
import Vista.CopiasSeguridad;
import Vista.MenuEmpleados;
import Vista.PedidosEmleados;
import Vista.TablaAdministrarProductos;
import Vista.TablaPedidos;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class appPrincipal {
	public static void main(String[] args) {
		// de aqui a la ventana y de alli al controlador
		MenuEmpleados menuEmp = new MenuEmpleados();
		TablaPedidos menuCli = new TablaPedidos();
		VentanaLogin login = new VentanaLogin();
		Modelo modelo = new Modelo();
		TablaAdministrarProductos tablaadministrarproductos = new TablaAdministrarProductos();
		VentanaRegistrar registrar = new VentanaRegistrar();
		AdministrarPedidos pedidosAdmin = new AdministrarPedidos();
		CopiasSeguridad copiasdeseguri = new CopiasSeguridad();
		PedidosEmleados pedidosempleados = new PedidosEmleados();

		Controlador controlador = new Controlador(modelo, registrar, login, menuEmp, menuCli, tablaadministrarproductos,
				pedidosAdmin, copiasdeseguri, pedidosempleados);

		controlador.recibirClientes();
		controlador.recibirEmpleados();
		try {
			controlador.llenarTablaproductos();

		} catch (SQLException e) {
			System.err.println("ERROR");
		}
		login.mostrarVentana();

	}
}