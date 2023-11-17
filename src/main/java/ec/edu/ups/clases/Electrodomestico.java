package ec.edu.ups.clases;

import java.util.GregorianCalendar;

public class Electrodomestico extends Producto{
	private GregorianCalendar fechaFabricacion;
	private int añosGarantia;
	
	//constructor
	public Electrodomestico(int diaFa, int mesFa, int añoFa, int añosGarantia, double precio, String codigo, 
			String nombre, String marca) {
		super(codigo, nombre, marca, precio);
		this.fechaFabricacion = new GregorianCalendar(añoFa,mesFa,diaFa);
		this.añosGarantia = añosGarantia;
	}

	@Override
	public String toString() {
		return super.toString()+"\n\tCaracterísticas-> Fecha de Fabricacion=" + 
				fechaFabricacion.get(GregorianCalendar.DAY_OF_MONTH)+"/" + fechaFabricacion.get(GregorianCalendar.MONTH)+"/" + 
				fechaFabricacion.get(GregorianCalendar.YEAR) + ", Años de Garantia=" + añosGarantia + "\n";
	}
	
}
