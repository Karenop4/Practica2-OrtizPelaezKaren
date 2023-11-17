package ec.edu.ups.clases;

public class Pedido {
	private int numeroPedido;
	
	//Constructor
	public Pedido() {
	}
	
	//Getters y Setters
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	@Override
	public String toString() {
		return " -> Numero de Pedido=" + numeroPedido + "]";
	}
	
}
