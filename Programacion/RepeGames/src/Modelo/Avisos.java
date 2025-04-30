package Modelo;

/**
 * @author Paul Garcia
 */
public class Avisos {
	private String idProducto;
	private String nombreProducto;
	private int stock;

	public Avisos(String idProducto, String nombreProducto, int stock) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.stock = stock;
	}

	public Avisos() {
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Avisos [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", stock=" + stock + "]";
	}

}
