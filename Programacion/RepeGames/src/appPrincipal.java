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

import java.sql.SQLException;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.MenuEmpleados;
import Vista.TablaPedidos;
import Vista.VentanaLogin;

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
				pedidosAdmin, copiasdeseguri,pedidosempleados);

		VentanaLogin ventanaLogin = new VentanaLogin();
		ventanaLogin.setControlador(controlador);

		controlador.setModelo(modelo);
		controlador.setLogin(ventanaLogin);
		controlador.recibirClientes();
		controlador.recibirEmpleados();
		menuEmp.setControlador(controlador);
		pedidosAdmin.setControlador(controlador);
		copiasdeseguri.setControlador(controlador);
		pedidosempleados.setControlador(controlador);
		try {
			controlador.llenarTablaproductos();

		} catch (SQLException e) {
			System.err.println("ERROR");
		}

//	ventanaLogin.setVisible(true);

		ventanaLogin.mostrarVentana();

	}
}