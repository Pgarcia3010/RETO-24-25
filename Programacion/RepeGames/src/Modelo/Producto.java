package Modelo;

public class Producto {

	private String idProducto;
	private String nombreProducto;
	private double precio;
	private int stock;

	public Producto(String idProducto, String nombreProducto, double precio, int stock) {
		this.idProducto = idProducto;
		this.idProducto = idProducto;
		this.precio = precio;
		this.stock = stock;
	}

	public Producto() {
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto:\nidProducto: " +idProducto+"\nnombreProducto: "+nombreProducto+"\nprecio: "+precio+"\nstock: "+stock;
	}

}