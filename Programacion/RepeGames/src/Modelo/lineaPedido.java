package Modelo;

/**
 * Se crea un objeto lineaPedido
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class lineaPedido {
	private int numPedido;
	private int numLinea;
	private String idProducto;
	private int cantidadProducto;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * lineaPedido.
	 * 
	 * @param numPedido        El numPedido es un int que indica el numero de
	 *                         pedido.
	 * @param numLinea         El numLinea es un int que indica el numero de la
	 *                         linea de pedido.
	 * @param idProducto       La idProducto es un String que indica la id del
	 *                         producto.
	 * @param cantidadProducto La cantidadProducto es un int que indica la cantidad
	 *                         de producto en un pedido.
	 */
	public lineaPedido(int numPedido, int numLinea, String idProducto, int cantidadProducto) {
		this.numPedido = numPedido;
		this.numLinea = numLinea;
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
	}

	/**
	 * El constructor esta vacio
	 */
	public lineaPedido() {
	}

	/**
	 * recibe numPedido
	 * 
	 * @return numPedido El numPedido es un int que indica el numero de pedido.
	 */
	public int getNumPedido() {
		return numPedido;
	}

	/**
	 * modifica numPedido
	 * 
	 * @param numPedido El numPedido es un int que indica el numero de pedido.
	 */
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	/**
	 * recibe numLinea
	 * 
	 * @return numLinea El numLinea es un int que indica el numero de la linea de
	 *         pedido.
	 */
	public int getNumLinea() {
		return numLinea;
	}

	/**
	 * modifica numLinea
	 * 
	 * @param numLinea El numLinea es un int que indica el numero de la linea de
	 *                 pedido.
	 */
	public void setNumLinea(int numLinea) {
		this.numLinea = numLinea;
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
	 * recibe cantidadProducto
	 * 
	 * @return cantidadProducto La cantidadProducto es un int que indica la cantidad
	 *         de producto en un pedido.
	 */
	public int getCantidadProducto() {
		return cantidadProducto;
	}

	/**
	 * modifica catidadProducto
	 * 
	 * @param cantidadProducto La cantidadProducto es un int que indica la cantidad
	 *                         de producto en un pedido.
	 */
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano
	 */
	public String toString() {
		return "lineaPedido:\nnumPedido: " + numPedido + "\nnumLinea: " + numLinea + "\nidProducto: " + idProducto
				+ "\ncantidadProducto" + cantidadProducto;
	}

}
