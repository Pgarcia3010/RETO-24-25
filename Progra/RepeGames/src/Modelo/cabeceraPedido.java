package Modelo;

import java.sql.Date;

/**
 * Se crea un objeto cabeceraPedido.
 * 
 * @author Paul Garcia
 * @version 1.0
 */
public class cabeceraPedido {

	private int numPedido;
	private String id;
	private double precioTotal;
	private Date fechaPedido;

	/**
	 * El constructor registra los parametros de la base de datos en la tabla de
	 * cabeceraPedido
	 * 
	 * @param numPedido   El numPedido es un int que indica el numero de pedido.
	 * @param id   La idCliente es un int que indica la id del cliente.
	 * @param precioTotal El precioTotal es un double que indica el precio total del
	 *                    pedido.
	 * @param fechaPedido La fechaPedido es un date que indica la fecha de cuando se
	 *                    realizo el pedido.
	 */
	public cabeceraPedido(int numPedido, String id, double precioTotal, Date fechaPedido) {
		this.numPedido = numPedido;
		this.id = id;
		this.precioTotal = precioTotal;
		this.fechaPedido = fechaPedido;
	}

	/**
	 * El constructor esta vacio
	 */
	public cabeceraPedido() {
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
	 * recibe id
	 * 
	 * @return id La idCliente es un int que indica la id del cliente. 
	 */
	public String getId() {
		return id;
	}

	/**
	 * modifica id
	 * 
	 * @param id La idCliente es un int que indica la id del cliente. 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * recibe precioTotal
	 * 
	 * @return precioTotal El precioTotal es un double que indica el precio total del pedido.
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * modifica precioTotal
	 * 
	 * @param precioTotal El precioTotal es un double que indica el precio total del pedido.
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * recibe fechaPedido
	 * 
	 * @return fechaPedido La fechaPedido es un date que indica la fecha de cuando se realizo el pedido.
	 */
	public Date getFechaPedido() {
		return fechaPedido;
	}

	/**
	 * modifica fechaPedido
	 * 
	 * @param fechaPedido La fechaPedido es un date que indica la fecha de cuando se realizo el pedido.
	 */
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	/**
	 * @return El toString genera el contenido del objeto en una linea de texto
	 *         creada a mano
	 */
	public String toString() {
		return "cabeceraPedido:\nnumPedido: " + numPedido + "\nid: " + id + "\nprecioTotal: "
				+ precioTotal + "\nfechaPedido: " + fechaPedido;
	}

}
