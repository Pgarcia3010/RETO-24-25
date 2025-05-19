import java.sql.SQLException;

import Controlador.Controlador;
import Logs.CustomLogger;
import Modelo.Modelo;
import Vista.AdministrarPedidos;
import Vista.Confirmacion;
import Vista.CopiasSeguridad;
import Vista.MenuEmpleados;
import Vista.PedidosEmleados;
import Vista.TablaAdministrarProductos;
import Vista.TablaPedidos;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class appPrincipal {
	public static void main(String[] args) {
		
		//LOGS
		
		 try (CustomLogger logger = new CustomLogger()) {
	            logger.logSession("Aplicación iniciada");

	            // Ejemplo de operación
	            System.out.println("Realizando una operación...");
	            logger.logSession("Operación realizada con éxito");

	            // Ejemplo de captura de excepción
	            try {
	                int resultado = 10 / 0;
	            } catch (ArithmeticException e) {
	                CustomLogger.logError("Error de división por cero", e);
	            }

	            logger.logSession("Aplicación finalizada");
	        }
		
		
		
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
		Confirmacion confirmacion = new Confirmacion();
		CustomLogger CustomLogger = new CustomLogger();

		Controlador controlador = new Controlador(modelo, registrar, login, menuEmp, menuCli, tablaadministrarproductos,
				pedidosAdmin, copiasdeseguri, pedidosempleados, confirmacion);

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
		confirmacion.setControlador(controlador);

		try {
			controlador.llenarTablaproductos();

		} catch (SQLException e) {
			System.err.println("ERROR");
		}

//	ventanaLogin.setVisible(true);

		ventanaLogin.mostrarVentana();
		
		
		
		
		  


	}
}