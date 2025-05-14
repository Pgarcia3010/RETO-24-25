
import java.sql.SQLException;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.MenuEmpleados;
import Vista.TablaPedidos;
import Vista.VentanaLogin;

public class appPrincipal {

	public static void main(String[] args) {
		//de aqui a la ventana y de alli al controlador
	MenuEmpleados menuEmp = new MenuEmpleados();
	TablaPedidos menuCli = new TablaPedidos();
	VentanaLogin login = new VentanaLogin();
	Modelo modelo = new Modelo();
	Controlador controlador = new Controlador(modelo, null, login, menuEmp, menuCli);
	
	
	VentanaLogin ventanaLogin = new VentanaLogin();
	ventanaLogin.setControlador(controlador);
	
	
	controlador.setModelo(modelo);
	controlador.setLogin(ventanaLogin);
	controlador.recibirClientes();
	controlador.recibirEmpleados();
	try {
		controlador.llenarTablaproductos();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
//	ventanaLogin.setVisible(true);
	
	ventanaLogin.mostrarVentana();
	
	
	}

}
