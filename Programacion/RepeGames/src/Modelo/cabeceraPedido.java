package Modelo;

import java.sql.Date;

public class cabeceraPedido {

	private int numPedido;
	private int idCliente;
	private double precioTotal;
	private Date fechaPedido;

	public cabeceraPedido(int numPedido, int idCliente, double precioTotal, Date fechaPedido) {
		this.numPedido = numPedido;
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.fechaPedido = fechaPedido;
	}

	public cabeceraPedido() {
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	@Override
	public String toString() {
		return "cabeceraPedido [numPedido=" + numPedido + ", idCliente=" + idCliente + ", precioTotal=" + precioTotal
				+ ", fechaPedido=" + fechaPedido + "]";
	}

}
