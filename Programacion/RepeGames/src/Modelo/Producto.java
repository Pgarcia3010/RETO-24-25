package Modelo;

public class Producto {

	private String id_producto;
	private String nombre_producto;
	private double precio;
	private int stock;
	public Producto(String id_producto, String nombre_producto, double precio, int stock) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto() {
		super();
	}
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
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
		return "Producto [id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", precio=" + precio
				+ ", stock=" + stock + "]";
	}
	
	
	
}
