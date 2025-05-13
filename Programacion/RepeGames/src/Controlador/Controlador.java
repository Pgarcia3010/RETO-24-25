package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Modelo.Modelo;
import Modelo.Producto;
import Vista.PedidosEmleados;
import Vista.TablaCliente;
import Vista.VentanaLogin;
import Vista.VentanaRegistrar;

public class Controlador {

	private VentanaLogin Login;
	private Modelo modelo;
	private VentanaRegistrar Registrar;
	private TablaCliente tablacliente;

//	public Controlador(VentanaLogin login, VentanaRegistrar registrar, TablaCliente tablacliente) {
//
//		this.Login = login;
//		this.Registrar = registrar;
//		this.tablacliente = tablacliente;
//
//	}

	public void cargarTablaProductos() {

		Modelo modelo = new Modelo();

		ArrayList<Producto> produList = modelo.recibirProducto();

		DefaultTableModel model = new DefaultTableModel(new String[] {

				"IdProducto", "NombreProducto", "Precio", "Stock"

		}, 0);

		for (int i = 0; i < produList.size(); i++) {

			Producto producto = produList.get(i);

			model.addRow(new Object[] {

					producto.getIdProducto(), producto.getNombreProducto(), producto.getPrecio(), producto.getStock()

			});

		}

		tablacliente.tablaClientes.setModel(model);

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

	public TablaCliente getTablacliente() {
		return tablacliente;
	}

	public void setTablacliente(TablaCliente tablacliente) {
		this.tablacliente = tablacliente;
	}

}
