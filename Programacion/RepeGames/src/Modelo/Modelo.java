package Modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Se especifican y realizan las operaciones CRUD mediante SQL
 * 
 * @author Paul Garcia
 * @version 1.4
 */
public class Modelo extends Conector {
	/**
	 * Se recogen todos los datos de la tabla usuarios donde el id comience por "E"
	 * 
	 * @return empleados Arraylist de tipo empleados, crucial para el funcionamiento
	 *         del programa
	 */
	public ArrayList<Empleados> recibirEmpleados() {
		ArrayList<Empleados> empleados = new ArrayList<Empleados>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE id LIKE 'E%';");
			while (rs.next()) {
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

	/**
	 * Se recogen todos los datos de la tabla cliente
	 * 
	 * @return clientes Arraylist de tipo clientes, crucial para el funcionamiento
	 *         del programa
	 */
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

	/**
	 * Se recogen todos los datos de la tabla producto
	 * 
	 * @return productos Arraylist de tipo producto, crucial para el funcionamiento
	 *         del programa
	 */
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

	/**
	 * Se recogen todos los datos de la tabla cabeceraPedido
	 * 
	 * @return cabeceras Arraylist de tipo cabecera, crucial para el funcionamiento
	 *         del programa
	 */
	public ArrayList<cabeceraPedido> recibirCabeceras() {
		ArrayList<cabeceraPedido> cabeceras = new ArrayList<cabeceraPedido>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cabeceraPedido;");
			while (rs.next()) {
				cabeceraPedido cabecera = new cabeceraPedido();
				cabecera.setNumPedido(rs.getInt("numPedido"));
				cabecera.setId(rs.getString("id"));
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

	/**
	 * Se recogen todos los datos de la tabla lineaPedido
	 * 
	 * @return lineas Arraylist de tipo cabecera, crucial para el funcionamiento del
	 *         programa
	 */
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

	/**
	 * Se recogen todos los datos de la tabla avisos
	 * 
	 * @return avisos Arraylist de tipo aviso, crucial para el funcionamiento del
	 *         programa
	 */
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

	/**
	 * Se recogen todos los datos de la tabla copia
	 * 
	 * @return copias Arraylist de tipo copias, crucial para el funcionamiento del
	 *         programa
	 */
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
	/**
	 * Se añaden nuevos clientes.
	 * 
	 * @param clienteNuevo Objeto de tipo cliente para guardar los datos que seran
	 *                     introducidos en la base de datos.
	 */
	public void insertCliente(Cliente clienteNuevo) {
		try {
//			
//			  clienteNuevo se crea en el controlador, como un metodo, lo hare a
//			  continuacion
//			 
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

	/**
	 * Se añaden nuevos productos
	 * 
	 * @param productoNuevo Objeto de tipo producto para guardar los datos que seran
	 *                      introducidos en la base de datos.
	 */
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

	/**
	 * Se añaden nuevos avisos
	 * 
	 * @param avisoNuevo Objeto de tipo aviso para guardar los datos que seran
	 *                   introducidos en la base de datos.
	 */
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

	/**
	 * Se añaden nuevos usuarios
	 * 
	 * @param usuarioNuevo Objeto de tipo usuario para guardar los datos que seran
	 *                     introducidos en la base de datos.
	 */
	public void insertUsuario(Usuarios usuarioNuevo) {
		try {
			PreparedStatement ps = this.conexion
					.prepareStatement("INSERT INTO usuarios(id,nickname,constrasenya) VALUES (?,?,?);");
			ps.setString(1, usuarioNuevo.getId());
			ps.setString(2, usuarioNuevo.getNickname());
			ps.setString(2, usuarioNuevo.getContrasenya());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertUsuario");
		}
	}

	/**
	 * Se añaden nuevas copias.
	 * 
	 * @param copiaNueva Objeto de tipo copia para guardar los datos que seran
	 *                   introducidos en la base de datos.
	 */
	public void insertCopia(Copia copiaNueva) {
		try {
			PreparedStatement ps = this.conexion
					.prepareStatement("INSERT INTO copia(idCopia,nombre,fecha,ubicacion) VALUES (?,?,?,?);");
			ps.setInt(1, copiaNueva.getIdCopia());
			ps.setString(2, copiaNueva.getNombre());
			ps.setDate(3, copiaNueva.getFecha());
			ps.setString(4, copiaNueva.getUbicacion());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertCopia");
		}
	}

	/**
	 * Se añaden nuevas cabeceras de pedido
	 * 
	 * @param cabeceraNueva Objeto de tipo cabecera para guardar los datos que seran
	 *                      introducidos en la base de datos.
	 */
	public void insertCabecera(cabeceraPedido cabeceraNueva) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement(
					"INSERT INTO cabeceraPedido(numPedido,id,precioTotal,fechaPedido) VALUES (?,?,?,?);");
			ps.setInt(1, cabeceraNueva.getNumPedido());
			ps.setString(2, cabeceraNueva.getId());
			ps.setDouble(3, cabeceraNueva.getPrecioTotal());
			ps.setDate(4, cabeceraNueva.getFechaPedido());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertCabecera");
		}
	}

	/**
	 * Se añaden nuevas lineas de pedido
	 * 
	 * @param lineaNueva Objeto de tipo linea para guardar los datos que seran
	 *                   introducidos en la base de datos.
	 */
	public void insertLinea(lineaPedido lineaNueva) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement(
					"INSERT INTO lineaPedido(numPedido,numLinea,idProducto,cantidadProducto) VALUES (?,?,?,?);");
			ps.setInt(1, lineaNueva.getNumPedido());
			ps.setInt(2, lineaNueva.getNumLinea());
			ps.setString(3, lineaNueva.getIdProducto());
			ps.setInt(4, lineaNueva.getCantidadProducto());
			ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertLinea");
		}
	}

//-------------------------------------------------------------------------------------------------------------------------------

}
