package ec.edu.ups.clases;

import java.util.ArrayList;

public class Carrito {
	private int numeroProductos;
	private boolean estadoCarrito = false;
	private double totalPagar;
	private ArrayList<Producto> listaProductosComprados = new ArrayList();
	
	//Constructor
	public Carrito() {
	}
	
	//Getters y Setters

	public int getNumeroProductos() {
		return numeroProductos;
	}
	
	public void setNumeroProductos(int numeroProductos) {
		this.numeroProductos = numeroProductos;
	}

	public boolean getEstadoCarrito() {
		return estadoCarrito;
	}

	public void setEstadoCarrito(boolean estadoCarrito) {
		this.estadoCarrito = estadoCarrito;
	}

	public double getTotalPagar() {
		return totalPagar;
	}
	
	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	public ArrayList<Producto> getListaProductosComprados() {
		return listaProductosComprados;
	}
	
	public void setListaProductosComprados(ArrayList<Producto> listaProductosComprados) {
		this.listaProductosComprados = listaProductosComprados;
	}
	
	////////////Operaciones/////////////////////

	//Agrega a la lista de compra los productos seleccionados
	public void agregarProducto(Producto producto) {
		listaProductosComprados.add(producto);
	}
	
	@Override
	public String toString() {
		return "Carrito [numeroProductos=" + numeroProductos + ", estadoCarrito=" + estadoCarrito + ", totalPagar="
				+ totalPagar + " listaProductos=" + listaProductosComprados + "]";
	}
	
}
