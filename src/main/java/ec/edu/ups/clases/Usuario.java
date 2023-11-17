package ec.edu.ups.clases;

public class Usuario {
	private String nombre;
	private String usuario;
	private String contrasena;
	private String correoElectronico;
	private String pais;
	private String ciudad;
	private String direccion;
	private Pedido unPedido;
	private Carrito unCarrito;
	
	//Constructor
	public Usuario() {
		
	}

	//Getters y Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Pedido getUnPedido() {
		return unPedido;
	}

	public void setUnPedido(Pedido unPedido) {
		this.unPedido = unPedido;
	}

	public Carrito getUnCarrito() {
		return unCarrito;
	}

	public void setUnCarrito(Carrito unCarrito) {
		this.unCarrito = unCarrito;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	@Override
	public String toString() {
		return "Nombre=" + nombre + "\nCorreo Electronico=" + correoElectronico + "\nPaís=" + pais + "\nCiudad="
				+ ciudad + "\nDirección=" + direccion + "\nPedido=" + unPedido + "]";
	}
}
