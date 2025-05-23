package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Se especifican y realizan las operaciones CRUD mediante SQL
 * 
 * @author Paul Garcia
 * @version 1.6
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
				cliente.setId(rs.getString("id"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setTelefono(rs.getString("telefono"));
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
			PreparedStatement ps = this.conexion.prepareStatement(
					"INSERT INTO cliente (id,nombre,direccion,telefono,nickname,contrasenya) VALUES (?,?,?,?,?,?);");
			ps.setString(1, clienteNuevo.getId());
			ps.setString(2, clienteNuevo.getNombre());
			ps.setString(3, clienteNuevo.getDireccion());
			ps.setString(4, clienteNuevo.getTelefono());
			ps.setString(5, clienteNuevo.getNickname());
			ps.setString(6, clienteNuevo.getContrasenya());
			ps.execute();
			
			File file = new File("./src/Ficheros/insert.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("ID: " + clienteNuevo.getId()+",");
			bw.write("Nombre: " + clienteNuevo.getNombre()+",");
			bw.write("Direccion: " + clienteNuevo.getDireccion()+",");
			bw.write("Telefono: " + clienteNuevo.getTelefono()+",");
			bw.write("Nickname: " + clienteNuevo.getNickname()+",");
			bw.write("Contraseña " + clienteNuevo.getContrasenya()+",");
			bw.newLine();
			
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
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
			
			File file = new File("./src/Ficheros/insert.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("idProducto: " + productoNuevo.getIdProducto()+",");
			bw.write("nombreProducto: " + productoNuevo.getNombreProducto()+",");
			bw.write("Precio: " + productoNuevo.getPrecio()+",");
			bw.write("Stock: " + productoNuevo.getStock()+",");
			bw.newLine();
			
			bw.close();
			
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
			
			File file = new File("./src/Ficheros/insert.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("IdProducto: " + avisoNuevo.getIdProducto()+",");
			bw.write("NombreProducto: " + avisoNuevo.getNombreProducto()+",");
			bw.write("Stock: " + avisoNuevo.getStock()+",");
			bw.newLine();
			
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertAviso");
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
			
			File file = new File("./src/Ficheros/insert.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("IdCopia: " + copiaNueva.getIdCopia()+",");
			bw.write("NombreCopia: " + copiaNueva.getNombre()+",");
			bw.write("FechaCopia: " + copiaNueva.getFecha()+",");
			bw.write("UbicacionCopia: " + copiaNueva.getUbicacion()+",");
			bw.newLine();
			
			bw.close();
			
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
			
			File file = new File("./src/Ficheros/insert.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("NumeroPedido" + cabeceraNueva.getNumPedido()+",");
			bw.write("IdCliente: " + cabeceraNueva.getId()+",");
			bw.write("PrecioTotal: " + cabeceraNueva.getPrecioTotal()+",");
			bw.write("FechaPedido: " + cabeceraNueva.getFechaPedido()+",");
			bw.newLine();
			
			bw.close();
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

			File file = new File("./src/Ficheros/insert.txt");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("NumeroPedido: " + lineaNueva.getNumPedido()+",");
			bw.write("NumeroLinea: " + lineaNueva.getNumLinea()+",");
			bw.write("IdProducto: " + lineaNueva.getIdProducto()+",");
			bw.write("Cantidad: " + lineaNueva.getCantidadProducto()+",");
			bw.newLine();
			
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en insertLinea");
		}
	}

//-------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Se modifica el contenido de producto
	 * 
	 * @param productoCambiado objeto de tipo producto que sera el nuevo objeto
	 *                         introducido en la base de datos
	 * @param productoViejo    objeto de tipo producto que es el que sera
	 *                         reemplazado
	 */
	public void updateProductos(Producto productoCambiado, Producto productoViejo) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement(
					"UPDATE producto SET idProducto = ?, nombreProducto = ?, precio = ?, stock =? WHERE idProducto = ?;");
			ps.setString(1, productoCambiado.getIdProducto());
			ps.setString(2, productoCambiado.getNombreProducto());
			ps.setDouble(3, productoCambiado.getPrecio());
			ps.setInt(4, productoCambiado.getStock());
			ps.setString(5, productoViejo.getIdProducto());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en updateProductos");
		}
	}

	/**
	 * Se modifica el contenido de cabeceraPedido
	 * 
	 * @param cabeceraCambiada objeto de tipo cabecera que sera el nuevo objeto
	 *                         introducido en la base de datos
	 * @param cabeceraVieja    objeto de tipo cabecera que es el que sera
	 *                         reemplazado
	 */
	public void updateCabecera(cabeceraPedido cabeceraCambiada, cabeceraPedido cabeceraVieja) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement(
					"UPDATE cabecerapedido SET numPedido = ?, id = ?, precioTotal = ?, fechaPedido =? WHERE id = ? AND numPedido = ?;");
			ps.setInt(1, cabeceraCambiada.getNumPedido());
			ps.setString(2, cabeceraCambiada.getId());
			ps.setDouble(3, cabeceraCambiada.getPrecioTotal());
			ps.setDate(4, cabeceraCambiada.getFechaPedido());
			ps.setString(5, cabeceraVieja.getId());
			ps.setInt(6, cabeceraVieja.getNumPedido());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en updateCabecera");
		}
	}

	/**
	 * Se modifica el contenido de lineaPedido
	 * 
	 * @param lineaCambiada objeto de tipo linea que sera el nuevo objeto
	 *                      introducido en la base de datos
	 * @param lineaVieja    objeto de tipo linea que es el que sera reemplazado
	 */
	public void updateLinea(lineaPedido lineaCambiada, lineaPedido lineaVieja) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement(
					"UPDATE lineapedido SET numPedido = ?, numLinea = ?, idProducto = ?, cantidadProducto =? WHERE numPedido = ? AND numLinea = ?;");
			ps.setInt(1, lineaCambiada.getNumPedido());
			ps.setInt(2, lineaCambiada.getNumLinea());
			ps.setString(3, lineaCambiada.getIdProducto());
			ps.setInt(4, lineaCambiada.getCantidadProducto());
			ps.setInt(5, lineaVieja.getNumPedido());
			ps.setInt(6, lineaVieja.getNumLinea());
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en updateLinea");
		}
	}

//----------------------------------------------------------------------------------------------------------------------------
	/**
	 * Se eliminara contenido de producto
	 * 
	 * @param productoBorrado objeto de tipo producto que sera eliminado
	 */
	public void eliminarProducto(Producto productoBorrado) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM producto WHERE idProducto = ?;");
			ps.setString(1, productoBorrado.getIdProducto());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en eliminarProducto");
		}

	}

	/**
	 * Se eliminara contenido de lineaPedido
	 * 
	 * @param lineaBorrada objeto de tipo linea que sera eliminado
	 */
	public void eliminarLinea(lineaPedido lineaBorrada) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM lineaPedido WHERE numLinea = ?;");
			ps.setInt(1, lineaBorrada.getNumLinea());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en eliminarLinea");
		}
	}

	/**
	 * Se eliminara contenido de cabeceraPedido
	 * 
	 * @param cabeceraBorrada objeto de tipo cabecera que sera eliminado
	 */
	public void eliminarCabecera(cabeceraPedido cabeceraBorrada) {
		try {
			PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM cabeceraPedido WHERE id = ?;");
			ps.setString(1, cabeceraBorrada.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error en eliminarCabecera");
		}
	}
}
