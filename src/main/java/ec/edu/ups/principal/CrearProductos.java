package ec.edu.ups.principal;

import java.util.ArrayList;

import ec.edu.ups.clases.Producto;
import ec.edu.ups.clases.Electronico;
import ec.edu.ups.clases.Electrodomestico;
import ec.edu.ups.clases.Ropa;

public class CrearProductos {
	//Creación de productos de forma manual
	public ArrayList <Producto> crearListaProductos() {
		Electronico computadora = new Electronico(1015.65,"CMP001","LAPTOP DELL INSPIRON 3525","DELL",30,5,2018,2,
												"Version 8gb de Ram");
		Electronico telefono = new Electronico(1599.00,"TLF001","IPHONE 15 PRO","APPLE",15,9,2023,1,"Version 512gb");
		Electrodomestico lavadora = new Electrodomestico(12,04,2006,3,568.71,"LVDR001","LAVADORA 40 LB","LG");
		Electrodomestico refrigeradora = new Electrodomestico(23,11,2010,4,449.11,"RFR001","REFRIGERADORA PLATINUM 250L","MABE");
		Ropa camiseta = new Ropa(43.00,"CMS001","POLO REGULAR FIT","H&M","L","ALGODON");
		Ropa pantalon = new Ropa(63.60,"PNT001","501 ORIGINAL FIT WOMEN'S JEANS","LEVIS","32","ALGODON");
		
		ArrayList <Producto> listaProductos = new ArrayList();
		
		listaProductos.add(computadora);
		listaProductos.add(telefono);
		listaProductos.add(lavadora);
		listaProductos.add(refrigeradora);
		listaProductos.add(camiseta);
		listaProductos.add(pantalon);
		
		return listaProductos;
	}
	
}
