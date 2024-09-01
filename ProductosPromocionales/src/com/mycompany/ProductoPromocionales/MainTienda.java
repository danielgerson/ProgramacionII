package com.mycompany.ProductoPromocionales;
import java.util.Scanner;

public class MainTienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner consola = new Scanner(System.in);
		Integer opcionMenu;
		boolean salir = false;
		
		do {
			Menu();
			System.out.println("Por favor ingrese una opcion: ");
			opcionMenu = consola.nextInt();
			System.out.println();
			
			switch(opcionMenu) {
				case 1:
					System.out.println("Opcion 1");
					System.out.println();
					IngresarProducto();
					break;
				case 2:
					System.out.println("Opcion 2");
					System.out.println();
					break;
				case 3:
					System.out.println("Opcion 3");
					System.out.println();
					break;
				case 4:
					System.out.println("Opcion 4");
					System.out.println();
					break;
				case 5:
					System.out.println("Opcion 5");
					System.out.println();
					break;
				case 6:
					System.out.println("Opcion 6");
					System.out.println();
					break;
				case 7:
					System.out.println("Opcion 7");
					System.out.println();
					salir = true;
					break;
			}
			
			
		} while(salir != false);
		
		consola.close();
	}
	
	public static void Menu() {
		System.out.println("**** Bienvenido a Tienda de Souvenirs ****");
		System.out.println("""
				1. Ingreso Productos
				2. Compra Productos
				3. Ventas
				4. Facturacion
				5. Produccion e importacion
				6. Modificacion Productos
				7. Salir
				""");
	}
	
	public static void IngresarProducto() {
		Scanner consola = new Scanner(System.in);
		char opcion = 'n';
		String codigo;
		String nombre;
		Integer precio = 0;
		Integer cantidad = 0;
		
		TipoProducto sombrilla = new TipoProducto();
		
		System.out.print("Ingrese Codigo:" );
		codigo = consola.next();
		sombrilla.setCodigo(codigo);
		System.out.println();
		
		System.out.print("Ingrese Nombre:" );
		nombre = consola.next();
		sombrilla.setNombre(nombre);
		System.out.println();
		
		System.out.print("Ingrese Precio: ");
		precio = consola.nextInt();
		sombrilla.setPrecio(precio);
		System.out.println();
		
		System.out.print("Ingrese Cantidad: ");
		cantidad = consola.nextInt();
		sombrilla.setCantidad(cantidad);
		System.out.println();
		
		System.out.println("Codigo: " + sombrilla.getCodigo());
		System.out.println("Nombre: " + sombrilla.getNombre());
		System.out.println("Precio: " + sombrilla.getPrecio());
		System.out.println("Cantidad: " + sombrilla.getCantidad());
		
		System.out.print("Desea Ingresar mas productos s/n ?: ");
		opcion = consola.next().charAt(0);
	}

}
