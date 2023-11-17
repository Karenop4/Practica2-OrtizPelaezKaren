package ec.edu.ups.clases;

import java.util.GregorianCalendar;

public class Electronico extends Producto {
	private GregorianCalendar fechaFabricacion;
	private int añosGarantia;
	private String version;
	
	//constructor
	public Electronico(double precio, String codigo, String nombre, String marca,int diaFa, int mesFa, int añoFa,
			int añosGarantia, String version) {
		
		super(codigo, nombre, marca, precio);
		this.fechaFabricacion = new GregorianCalendar(añoFa, mesFa, diaFa);
		this.añosGarantia = añosGarantia;
		this.version = version;
	}

	@Override
	public String toString() {
		return super.toString()+"\n\t Características-> fechaFabricacion=" + fechaFabricacion.get(GregorianCalendar.DAY_OF_MONTH)+
				"/" + fechaFabricacion.get(GregorianCalendar.MONTH)+"/" + fechaFabricacion.get(GregorianCalendar.YEAR) +
				", añosGarantia=" + añosGarantia + ", version=" + version + "\n";
	}
}
