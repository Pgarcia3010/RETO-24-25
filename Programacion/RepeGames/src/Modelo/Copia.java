package Modelo;

import java.sql.Date;

public class Copia {
	private int idCopia;
	private String nombre;
	private Date fecha;
	private String ubicacion;

	public Copia(int idCopia, String nombre, Date fecha, String ubicacion) {
		this.idCopia = idCopia;
		this.nombre = nombre;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
	}

	public Copia() {
	}

	public int getIdCopia() {
		return idCopia;
	}

	public void setIdCopia(int idCopia) {
		this.idCopia = idCopia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Copia: \nidCopia: "+idCopia+"\nnombre: "+nombre+"\nfecha: "+fecha+"\nubicacion: "+ubicacion;
	}

}
