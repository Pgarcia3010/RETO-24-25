import java.sql.SQLException;

import Controlador.Controlador;
import Logs.Loggers;
import Modelo.Modelo;
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
 * Inicio de la aplicacion donde se ejecuta todo
 * 
 * @author Paul y Ismael
 */
public class appPrincipal {
//	@SuppressWarnings({ "unused", "resource"})
	/**
	 * Inicio de la aplicacion
	 * 
	 * @param args args del programa
	 */
	public static void main(String[] args) {

		// LOGS

		try (Loggers logger = new Loggers()) {
			logger.logSesion("Aplicación iniciada");

            // Ejemplo de operación
            System.out.println("Realizando una ejecucion...");
            logger.logSesion("Ejecucion realizada con éxito");

            // Ejemplo de captura de excepción
            try {
                int resultado = 10 / 0;
            } catch (ArithmeticException e) {
                Loggers.logError("Error en log", e);
            }

			// Ejemplo de operación
			System.out.println("Realizando una operación...");
			logger.logSesion("Operación realizada con éxito");

			// Ejemplo de captura de excepción

			logger.logSesion("Aplicación finalizada");
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
		Loggers CustomLogger = new Loggers();
		AdministrarProductos administrarProductos = new AdministrarProductos();
		

		Controlador controlador = new Controlador(modelo, registrar, login, menuEmp, menuCli, tablaadministrarproductos,
				pedidosAdmin, copiasdeseguri, pedidosempleados, confirmacion,administrarProductos);

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
		registrar.setControlador(controlador);
		tablaadministrarproductos.setControlador(controlador);
		administrarProductos.setControlador(controlador);
		

		try {
			controlador.llenarTablaproductos();

		} catch (SQLException e) {
			System.err.println("ERROR");
		}
		
		ventanaLogin.mostrarVentana();

	}
}