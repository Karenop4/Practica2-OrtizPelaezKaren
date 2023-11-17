package ec.edu.ups.clases;

public class Producto {
	private String codigo;
	private String nombre;
	private String marca;
	private double precio;
	
	//Constructores
	public Producto() {
	}
	
	public Producto(String codigo, String nombre, String marca, double precio) { 
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}
	
	//Getter
	public double getPrecio() {
		return precio;
	}
	
	
	@Override
	public String toString() {
		return "\nProducto-> Codigo=" + codigo + ", Nombre=" + nombre + ", Marca=" + marca + ", Precio=" + precio;
	}
}
