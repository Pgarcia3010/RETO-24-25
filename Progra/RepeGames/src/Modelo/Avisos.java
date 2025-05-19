package Modelo;

/**
 * Se crea un objeto Aviso.
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class Avisos {
	private String idProducto;
	private String nombreProducto;
	private int stock;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * Avisos.
	 * 
	 * @param idProducto     La idProducto es un String que indica la id del
	 *                       producto.
	 * @param nombreProducto El nombreProducto es un String que indica el nombre del
	 *                       producto.
	 * @param stock          El stock es un int que indica el stock de un producto.
	 */
	public Avisos(String idProducto, String nombreProducto, int stock) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
	}

	/**
	 * Este constructor esta vacio.
	 */
	public Avisos() {
	}

	/**
	 * recibe la idProducto
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
	 * @return nombreProducto El nombreProducto es un String que indica el nombre
	 *         del producto.
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * modifica nombreProducto
	 * 
	 * @param nombreProducto El nombreProducto es un String que indica el nombre del
	 *                       producto.
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/**
	 * recibe stock
	 * 
	 * @return stock El stock es un int que indica el stock de un producto.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * modifica stock
	 * 
	 * @param stock El stock es un int que indica el stock de un producto.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano
	 */
	public String toString() {
		return "Aviso:\nidProducto: " + idProducto + "\nnombreProducto: " + nombreProducto + "\nstock: " + stock;
	}

}
