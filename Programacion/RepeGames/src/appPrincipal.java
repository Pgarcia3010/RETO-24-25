import java.sql.SQLException;

import Controlador.Controlador;
import Logs.CustomLogger;
import Modelo.Modelo;
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

public class appPrincipal {
	public static void main(String[] args) {
		
		try (CustomLogger logger = new CustomLogger()) {
            logger.logSession("Aplicación iniciada");

            // Ejemplo de operación
            System.out.println("Realizando una ejecucion...");
            logger.logSession("Ejecucion realizada con éxito");

            // Ejemplo de captura de excepción
            try {
                int resultado = 10 / 0;
            } catch (ArithmeticException e) {
                CustomLogger.logError("Error en log", e);
            }

            logger.logSession("Aplicación finalizada");
        }
		
		// de aqui a la ventana y de alli al controlador
		Modelo modelo = new Modelo();
		AdministrarPedidos pedidosAdmin = new AdministrarPedidos();
		AdministrarProductos productosAdmin = new AdministrarProductos();
		Confirmacion confirmacion = new Confirmacion();
		CopiasSeguridad copiasdeseguri = new CopiasSeguridad();
		ErrorBBDD error = new ErrorBBDD();
		MenuEmpleados menuEmp = new MenuEmpleados();
		PedidosEmleados pedidosempleados = new PedidosEmleados();
		TablaAdministrarProductos tablaadministrarproductos = new TablaAdministrarProductos();
		TablaPedidos menuCli = new TablaPedidos();
		VentanaLogin login = new VentanaLogin();
		VentanaRegistrar registrar = new VentanaRegistrar();

		Controlador controlador = new Controlador(modelo, pedidosAdmin, productosAdmin, confirmacion, copiasdeseguri,
				error, menuEmp, pedidosempleados, tablaadministrarproductos,menuCli, login, registrar);

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