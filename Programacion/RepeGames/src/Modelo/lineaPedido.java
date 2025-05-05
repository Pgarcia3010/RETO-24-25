package Modelo;

public class lineaPedido {
	private int numPedido;
	private int numLinea;
	private String idProducto;
	private int cantidadProducto;

	public lineaPedido(int numPedido, int numLinea, String idProducto, int cantidadProducto) {
		this.numPedido = numPedido;
		this.numLinea = numLinea;
		this.idProducto = idProducto;
		this.cantidadProducto = cantidadProducto;
	}

	public lineaPedido() {
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public int getNumLinea() {
		return numLinea;
	}

	public void setNumLinea(int numLinea) {
		this.numLinea = numLinea;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	@Override
	public String toString() {
		return "lineaPedido:\nnumPedido: " + numPedido + "\nnumLinea: " + numLinea + "\nidProducto: " + idProducto
				+ "\ncantidadProducto" + cantidadProducto;
	}

}
