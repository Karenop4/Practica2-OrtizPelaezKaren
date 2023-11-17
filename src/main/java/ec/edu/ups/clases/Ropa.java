package ec.edu.ups.clases;

public class Ropa extends Producto{
	private String talla;
	private String material;
	
	//constructor
	public Ropa(double precio, String codigo, String nombre, String marca, String talla, String material) {
		super(codigo, nombre, marca, precio);
		this.talla = talla;
		this.material = material;
	}

	@Override
	public String toString() {
		return super.toString()+ "\n\t Características-> talla=" + talla + ", material=" + material + "\n";
	}
}
