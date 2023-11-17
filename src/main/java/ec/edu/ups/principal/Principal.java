package ec.edu.ups.principal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import ec.edu.ups.clases.*;

public class Principal {

	public static void main(String[] args) {
		CrearProductos crear = new CrearProductos();//Se crea un objeto que sirve crear la lista productos para la venta
		IniciarSesion iniciar= new IniciarSesion();//Se crea un objeto que sirve para buscar un usuario en la lista de usuarios
		
		//crea la lista de productos existentes en el sistema
		ArrayList <Producto> listaProductosExistentes = new ArrayList(); 
		listaProductosExistentes = crear.crearListaProductos();
		
		//Crea la lista de usuarios
		ArrayList <Usuario> listaUsuarios = new ArrayList();
		
		Usuario usuario = new Usuario();//Se crea un nuevo usuario
		Pedido pedido = new Pedido();//Se crea un pedido
		Carrito carrito= new Carrito();//Se crea un carrito
		
		Scanner sc = new Scanner(System.in);//se instancia un objeto de tipo Scanner para la entrada de datos
		int opc;//Opción del menú
		int bandera=-1;//Sirve para validar la existencia de datos
		
		do {
			System.out.println("          MENU");
			System.out.println("========================");
			System.out.println("1.Registrar Usuario");
			System.out.println("2.Inicio de sesion");
			System.out.println("3.Tienda");
			System.out.println("4.Agregar Productos");
			System.out.println("5.Eliminar Productos");
			System.out.println("6.Realizar Pedido");
			System.out.println("7.Salir");
			System.out.println("========================");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1://Registrar usuario
					sc.nextLine();
					System.out.println("  Creación de Usuario");
					System.out.println("========================");
					System.out.print("Nombre: ");
					usuario.setNombre(sc.nextLine());
					System.out.print("Usuario: ");
					usuario.setUsuario(sc.nextLine());
					System.out.print("Contraseña: ");
					usuario.setContrasena(sc.nextLine());
					System.out.print("E-mail: ");
					usuario.setCorreoElectronico(sc.nextLine());
					System.out.print("Pais: ");
					usuario.setPais(sc.nextLine());
					System.out.print("Ciudad: ");
					usuario.setCiudad(sc.nextLine());
					System.out.print("Direccion: ");
					usuario.setDireccion(sc.nextLine());
					usuario.setUnCarrito(carrito);
					usuario.setUnPedido(pedido);
					
					listaUsuarios.add(usuario);
					System.out.println(usuario.getNombre() + " Registrado con exito");
					
					break;
				
				case 2://Inicio de sesion
					sc.nextLine();
					System.out.println("Ingrese su usuario");
					String usuarioIngresado= sc.nextLine();
					System.out.println("Ingrese su contraseña");
					String contrasena = sc.nextLine();
					
					/*
					 * llama a una funcioin para corroborar si existe el usuario ingresado y si
					 * devuelve true, fue encontrado
					*/
					if(iniciar.buscarUsuario(usuarioIngresado, contrasena, listaUsuarios)) {
						bandera=1;
						System.out.println("Sesion iniciada");
					}else {
						System.out.println("Usuario no encontrado");
					}
					
					break;
				
				case 3://Tienda
					//Muestra los productos disponibles
					//Para ver los productos no es nesario iniciar sesion
					for (int i=0; i<listaProductosExistentes.size(); i++) {
						System.out.print((i+1)+". ");
						System.out.println(listaProductosExistentes.get(i));
					}
					
					break;
				case 4://Comprar
					if (bandera == 1) {//Solo si existe un usuario iniciado
						System.out.println("______________________________________________________________");
						System.out.print("Ingrese el numero de producto para agregar al carrito\n-> ");
						int numeroProducto=sc.nextInt();
						
						//Valida que no ingrese un numero de elemento equivocado
						if(numeroProducto>0 && numeroProducto<=listaProductosExistentes.size()) { 
							
							//Agrega producto seleccionado a la lista de compra del cliente
							usuario.getUnCarrito().agregarProducto(listaProductosExistentes.get(numeroProducto-1));
							//Cambia el estado del carrito para poder finalizar la compra
							usuario.getUnCarrito().setEstadoCarrito(true);
							
						}else {
							System.out.println("Producto no encontrado");
						}
						
					}else {
						System.out.println("Primero inicie sesion");
						
					}
					break;
				
				case 5: //Eliminar productos
					if(bandera==1) {//Solo si existe un usuario iniciado
						if(usuario.getUnCarrito().getEstadoCarrito()) {//Solo si existen items agregados al carrito
							
							//Imprime los productos de la lista de comprados
							for (int i=0; i<usuario.getUnCarrito().getListaProductosComprados().size(); i++) {
								System.out.print((i+1)+". ");
								System.out.println(usuario.getUnCarrito().getListaProductosComprados().get(i));
							}
							
							System.out.println("______________________________________________________________");
							System.out.print("Ingrese el numero de producto para eliminar del carrito\n-> ");
							int numeroProducto=sc.nextInt();
							
							//Valida que no ingrese un numero de elemento equivocado
							if(numeroProducto>0 && numeroProducto<=usuario.getUnCarrito().getListaProductosComprados().size()) { 
								usuario.getUnCarrito().getListaProductosComprados().remove(numeroProducto-1);//elimina el producto
								
								if(usuario.getUnCarrito().getListaProductosComprados().size()==0) {
									/*
									 *Si la lista esta vacia el estado del carrito pasa a falso 
									*/
									usuario.getUnCarrito().setEstadoCarrito(false);
								}
								
							}else {
								System.out.println("Producto no encontrado");
							}
							
						}else {
							System.out.println("No hay productos en el carrito");
						}
					}else {
						System.out.println("Primero inicie sesion");
					}
					
					break;
				
				case 6://Realizar pedido
					if(carrito.getEstadoCarrito()) {//Solo si existen productos en el carrito
						double totalPagar=0;
						
						Random random = new Random();
						//En el numero de pedido se puso un numero aleatorio entre 1010 hasta 101010
						usuario.getUnPedido().setNumeroPedido(random.nextInt(101010) + 1010);
						
						//De los productos seleccionados se hace la suma del total a pagar
						for(int i=0;i<usuario.getUnCarrito().getListaProductosComprados().size();i++) {
							
							/*Se buscado en la lista de productos existente y se lo guarda en un producto temporal, 
						     * para que el poder abstraer los atributos, en específico el precio
						     */
							Producto productoTemporal = new Producto();
							productoTemporal=usuario.getUnCarrito().getListaProductosComprados().get(i);
						    totalPagar=totalPagar+productoTemporal.getPrecio();
						    
						}
						usuario.getUnCarrito().setTotalPagar(totalPagar);//Se establece la suma a pagar
						
						//Se muestra los datos del usuario, lo que compró y el total a pagar
						System.out.println("Datos de envío y facturación:");
						System.out.println(usuario.toString());
						System.out.println("Lista de compras");
						System.out.println(usuario.getUnCarrito().getListaProductosComprados());
						System.out.print("Total a Pagar: ");
						System.out.printf("%.2f",usuario.getUnCarrito().getTotalPagar());
						
						//Opcicón para confirmar la compra o seguir comprando
						System.out.println("Desea finalizar la compra\n ->1.Si  2.No");
						opc=sc.nextInt();
						
						if(opc==1) {//Finaliza la compra
							System.out.println("Pedido #"+usuario.getUnPedido().getNumeroPedido());
							System.out.printf("Total a pagar %.2f \nFinalizado con exito\n ",usuario.getUnCarrito().getTotalPagar());
							carrito.getListaProductosComprados().clear();
							carrito.setListaProductosComprados(carrito.getListaProductosComprados());
							carrito.setEstadoCarrito(false);
						}else{//Continua comprando
							System.out.println("Regreso menu principal para continuar con la compra");
						}
						
					}else if(bandera==1) {//Si es que no existen productos agregados en el carrito
						System.out.println("Agregue productos al carrito");
					}else { // Si es que no se no se inició sesión con un usuario
						System.out.println("Primero inicie sesion");
					}
					
					break;
				case 7://Salir
					System.out.println("Programa Cerrado");
					break;
				default:
					System.out.println("ERROR! Escoja otra opción");
			}
		}while(opc!=7);
		
		sc.close();
	}

}
