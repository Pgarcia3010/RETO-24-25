package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Paul Garcia
 * @version 1.4
 */
public class Modelo extends Conector {
	
	public ArrayList<Empleados> recibirEmpleados(){
		ArrayList<Empleados> empleados = new ArrayList<Empleados>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE id LIKE 'E%';");
			while(rs.next()) {
				Empleados empleado = new Empleados();
				empleado.setId(rs.getString("id"));
				empleado.setNickname(rs.getString("nickname"));
				empleado.setContrasenya(rs.getString("contrasenya"));
				empleados.add(empleado);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en selec empleados");
		}
		return empleados;
	}

	public ArrayList<Cliente> recibirClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cliente;");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getString("idCliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setTelefono(rs.getInt("telefono"));
				cliente.setNickname(rs.getString("nickname"));
				cliente.setContrasenya(rs.getString("contrasenya"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en select clientes");
		}

		return clientes;
	}

	public ArrayList<Producto> recibirProducto() {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM producto;");
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getString("idProducto"));
				producto.setNombreProducto(rs.getString("nombreProducto"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en select productos");
		}

		return productos;
	}

	public ArrayList<cabeceraPedido> recibirCabeceras() {
		ArrayList<cabeceraPedido> cabeceras = new ArrayList<cabeceraPedido>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cabeceraPedido;");
			while (rs.next()) {
				cabeceraPedido cabecera = new cabeceraPedido();
				cabecera.setNumPedido(rs.getInt("numPedido"));
				cabecera.setIdCliente(rs.getInt("idCliente"));
				cabecera.setPrecioTotal(rs.getDouble("precioTotal"));
				cabecera.setFechaPedido(rs.getDate("fechaPedido"));
				cabeceras.add(cabecera);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en select Cabeceras");
		}

		return cabeceras;
	}

	public ArrayList<lineaPedido> recibirLinea() {
		ArrayList<lineaPedido> lineas = new ArrayList<lineaPedido>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM lineaPedido;");
			while (rs.next()) {
				lineaPedido linea = new lineaPedido();
				linea.setNumPedido(rs.getInt("numPedido"));
				linea.setNumLinea(rs.getInt("numLinea"));
				linea.setIdProducto(rs.getString("idProducto"));
				linea.setCantidadProducto(rs.getInt("cantidadProducto"));
				lineas.add(linea);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en select lineas");
		}

		return lineas;
	}

	public ArrayList<Avisos> recibirAvisos() {
		ArrayList<Avisos> avisos = new ArrayList<Avisos>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM avisos;");
			while (rs.next()) {
				Avisos aviso = new Avisos();
				aviso.setIdProducto(rs.getString("idProducto"));
				aviso.setNombreProducto(rs.getString("nombreProducto"));
				aviso.setStock(rs.getInt("stock"));
				avisos.add(aviso);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Error en select avisos");
		}

		return avisos;
	}

	public ArrayList<Copia> recibirCopia() {
		ArrayList<Copia> copias = new ArrayList<Copia>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM copia;");
			while (rs.next()) {
				Copia copia = new Copia();
				copia.setIdCopia(rs.getInt("idCopia"));
				copia.setNombre(rs.getString("nombre"));
				copia.setFecha(rs.getDate("fecha"));
				copia.setUbicacion(rs.getString("ubicacion"));
				copias.add(copia);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return copias;
	}

//------------------------------------------------------------------------------------------------------

	public void insertCliente(Cliente clienteNuevo) {
		try {
			/**
			 * clienteNuevo se crea en el controlador, como un metodo, lo hare a
			 * continuacion
			 */
			PreparedStatement ps = this.conexion.prepareStatement(
					"INSERT INTO cliente (id,nombre,direccion,telefono,nickname,contrasenya) VALUES (?,?,?,?,?,?);");
			ps.setString(1, clienteNuevo.getId());
			ps.setString(2, clienteNuevo.getNombre());
			ps.setString(3, clienteNuevo.getDireccion());
			ps.setInt(4, clienteNuevo.getTelefono());
			ps.setString(5, clienteNuevo.getNickname());
			ps.setString(6, clienteNuevo.getContrasenya());

			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en insertCliente");
		}
	}

	public void insertProducto(Producto productoNuevo) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement(
					"INSERT INTO producto (idProducto,nombreProducto,precio,stock) VALUES (?,?,?,?);");
			ps.setString(1, productoNuevo.getIdProducto());
			ps.setString(2, productoNuevo.getNombreProducto());
			ps.setDouble(3, productoNuevo.getPrecio());
			ps.setInt(4, productoNuevo.getStock());

			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertProducto");
		}
	}

	public void insertAviso(Avisos avisoNuevo) {
		try {
			PreparedStatement ps = this.conexion
					.prepareStatement("INSERT INTO avisos (idProducto,nombreProducto,stock) VALUES (?,?,?);");
			ps.setString(1, avisoNuevo.getIdProducto());
			ps.setString(2, avisoNuevo.getNombreProducto());
			ps.setInt(3, avisoNuevo.getStock());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertAviso");
		}
	}
	
	

}
