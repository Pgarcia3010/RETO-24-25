package Modelo;

/**
 * Se crea un objeto Producto.
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class Producto {

	private String idProducto;
	private String nombreProducto;
	private double precio;
	private int stock;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * Producto.
	 * 
	 * @param idProducto La idProducto es un String que indica la id del producto.
	 * @param nombreProducto El nombreProduto es un int que indica el nombre del producto.
	 * @param precio El precio es un double que indica el precio del producto.
	 * @param stock El stock es un int que indica el stock del producto.
	 */
	public Producto(String idProducto, String nombreProducto, double precio, int stock) {
		this.idProducto = idProducto;
		this.idProducto = idProducto;
		this.precio = precio;
		this.stock = stock;
	}

	/**
	 * El constructor esta vacio
	 */
	public Producto() {
	}

	/**
	 * recibe idProducto
	 * 
	 * @return idProducto La idProducto es un String que indica la id del producto.
	 */
	public String getIdProducto() {
		return idProducto;
	}

	/**
	 * modifica idProducto
	 * 
	 * @param idProducto La idProducto es un String que indica la id del producto.
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * recibe nombreProducto
	 * 
	 * @return nombreProducto El nombreProduto es un int que indica el nombre del producto.
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * modifica nombreProducto
	 * 
	 * @param nombreProducto El nombreProduto es un int que indica el nombre del producto.
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/**
	 * recibe precio
	 * 
	 * @return precio El precio es un double que indica el precio del producto.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * modifica precio
	 * 
	 * @param precio El precio es un double que indica el precio del producto.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * recibe stock
	 * 
	 * @return stock El stock es un int que indica el stock del producto.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * modifica stock
	 * 
	 * @param stock El stock es un int que indica el stock del producto.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano
	 */
	public String toString() {
		return "Producto:\nidProducto: " + idProducto + "\nnombreProducto: " + nombreProducto + "\nprecio: " + precio
				+ "\nstock: " + stock;
	}

}