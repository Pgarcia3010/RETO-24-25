import Controlador.Controlador;
import Modelo.Modelo;
import Vista.VentanaLogin;

public class appPrincipal {

	public static void main(String[] args) {
		//de aqui a la ventana y de alli al controlador
	Controlador controlador = new Controlador();
	
	Modelo modelo = new Modelo();
	VentanaLogin ventanaLogin = new VentanaLogin();
	ventanaLogin.setControlador(controlador);
	
	controlador.setModelo(modelo);
	controlador.setLogin(ventanaLogin);
	controlador.recibirClientes();
	controlador.recibirEmpleados();
	
//	ventanaLogin.setVisible(true);
	
	ventanaLogin.mostrarVentana();
	
	
	}

}
