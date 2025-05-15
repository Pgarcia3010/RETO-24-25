import java.sql.SQLException;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.MenuEmpleados;
import Vista.TablaPedidos;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class appPrincipal {
	public static void main(String[] args) {
		// de aqui a la ventana y de alli al controlador
		MenuEmpleados menuEmp = new MenuEmpleados();
		TablaPedidos menuCli = new TablaPedidos();
		Modelo modelo = new Modelo();
		VentanaRegistrar registrar = new VentanaRegistrar();
		VentanaLogin ventanaLogin = new VentanaLogin();

		Controlador controlador = new Controlador(modelo, registrar, ventanaLogin, menuEmp, menuCli);

		/*ventanaLogin.setControlador(controlador);
		registrar.setControlador(controlador);
		
		controlador.setLogin(ventanaLogin);j
		controlador.setRegistrar(registrar);*/
		controlador.recibirClientes();
		controlador.recibirEmpleados();
		try {
			controlador.llenarTablaproductos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventanaLogin.mostrarVentana();

	}
}