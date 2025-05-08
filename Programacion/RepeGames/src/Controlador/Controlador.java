package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modelo.Modelo;
import Modelo.Usuarios;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class Controlador implements ActionListener {

	private VentanaLogin Login;
	private Modelo modelo;
	private VentanaRegistrar Registrar;

	public Controlador(VentanaLogin login, VentanaRegistrar registrar) {

		this.Login = login;
		this.Registrar = registrar;

		this.Login.btnIniciar.addActionListener(this);

	}
//
//	LOGIN CUALQUIER DUDA PREGUNTAR A ISMA 
//	public void loginEmpleados() {
//
//		ArrayList<Usuarios> empleadosList = (ArrayList<Usuarios>) this.modelo.getConexion();
//
//		for (int i = 0; i < empleadosList.size(); i++) {
//			if (empleadosList.get(i).getIdCliente() == Integer.parseInt(null)) {
//				
//			} else {
//				
//			}
//		}
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public VentanaLogin getLogin() {
		return Login;
	}

	public void setLogin(VentanaLogin login) {
		Login = login;
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

}
