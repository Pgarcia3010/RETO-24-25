package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo extends Conector {

	/**
	 * aqui va toda la parafernalia de los ejercicios SQL, como el SELECT
	 */

	public ArrayList<Usuarios> recibirUsuarios() {
		ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();

		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
			while (rs.next()) {
				Usuarios usuario = new Usuarios();
				usuario.setNickname(rs.getString("nickname"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setIdCliente(rs.getInt("idCliente"));
				usuario.setIdEmpleado(rs.getInt("idEmpleado"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en select usuarios");
		}

		return usuarios;
	}

	public ArrayList<Producto> recibirProducto() {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM producto");
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

	public ArrayList<Avisos> recibirAvisos() {
		ArrayList<Avisos> avisos = new ArrayList<Avisos>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM avisos");
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

	public ArrayList<Cliente> recibirClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cliente");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(rs.getInt("idCliente"));
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

	public ArrayList<Copia> recibirCopia() {
		ArrayList<Copia> copias = new ArrayList<Copia>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM copia");
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
					"INSERT INTO cliente (idCliente,nombre,direccion,telefono,nickname,contrasenya) VALUES (?,?,?,?,?,?);");
			ps.setInt(1, clienteNuevo.getIdCliente());
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
	

//	class Persona {
//	    String nombre;
//	    Persona(String nombre) { this.nombre = nombre; }
//	}
//
//	class Producto {
//	    String nombre;
//	    Producto(String nombre) { this.nombre = nombre; }
//	}
//
//	public class Main {
//	    public static void main(String[] args) {
//	        ArrayList<Object> lista = new ArrayList<>();
//
//	        Persona p = new Persona("Juan");
//	        Producto prod = new Producto("Laptop");
//
//	        lista.add(p);
//	        lista.add(prod);
//
//	        for (Object obj : lista) {
//	            if (obj instanceof Persona) {
//	                Persona persona = (Persona) obj;
//	                System.out.println("Persona: " + persona.nombre);
//	            } else if (obj instanceof Producto) {
//	                Producto producto = (Producto) obj;
//	                System.out.println("Producto: " + producto.nombre);
//	            }
//	        }
//	    }
//	}

}
