package com.mycompany.ProductoPromocionales;

import java.util.Scanner;
import java.util.ArrayList;

public class MainTienda {
    private static ArrayList<TipoProducto> productosDisponibles = new ArrayList<>();
    private static int numeroOrdenActual = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ProduccionEImportacion produccionEImportacion = new ProduccionEImportacion();
        ModificacionProductos modificacionProductos = new ModificacionProductos();

        establecerEstadosDeProduccion(produccionEImportacion);

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarProducto(scanner);
                    break;
                case 2:
                    comprarProductos(scanner);
                    break;
                case 3:
                    realizarFacturacion(scanner, produccionEImportacion);
                    break;
                case 4:
                    produccionEImportacion.mostrarEstadoProductos(null);
                    break;
                case 5:
                    modificarProducto(scanner, modificacionProductos);
                    break;
                case 6:
                    System.out.println("Hasta Pronto");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("**** Menú Principal ****");
        System.out.println("1. Ingresar producto");
        System.out.println("2. Comprar productos");
        System.out.println("3. Facturación");
        System.out.println("4. Producción e importación");
        System.out.println("5. Modificación de productos");
        System.out.println("6. Salir");
    }

    public static void ingresarProducto(Scanner scanner) {
        System.out.println("\nIngrese los datos del nuevo producto:");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        TipoProducto nuevoProducto = new TipoProducto(codigo, nombre, precio, cantidad, categoria);
        productosDisponibles.add(nuevoProducto);

        System.out.println("\nProducto ingresado con exito:");
        nuevoProducto.mostrarInformacion();
    }

    public static void comprarProductos(Scanner scanner) {
        if (productosDisponibles.isEmpty()) {
            System.out.println("\nNo hay productos disponibles para comprar.");
            return;
        }

        CompraProductos compra = new CompraProductos();

        String seguirComprando;
        do {
            System.out.println("\nProductos disponibles para la compra:");
            for (int i = 0; i < productosDisponibles.size(); i++) {
                TipoProducto producto = productosDisponibles.get(i);
                System.out.println((i + 1) + ". " + producto.getNombre() + " - Precio: Q" + producto.getPrecio() + " - Cantidad disponible: " + producto.getCantidad());
            }

            System.out.print("\nSeleccione el número del producto que desea comprar: ");
            int seleccion = scanner.nextInt();
            scanner.nextLine();

            if (seleccion < 1 || seleccion > productosDisponibles.size()) {
                System.out.println("Selección no válida.");
                return;
            }

            TipoProducto productoSeleccionado = productosDisponibles.get(seleccion - 1);

            System.out.print("Ingrese la cantidad que desea comprar: ");
            int cantidadCompra = scanner.nextInt();

            if (cantidadCompra > productoSeleccionado.getCantidad()) {
                System.out.println("Cantidad no disponible. Solo hay " + productoSeleccionado.getCantidad() + " unidades disponibles.");
                return;
            }

            compra.agregarProducto(productoSeleccionado, cantidadCompra);
            productoSeleccionado.setCantidad(productoSeleccionado.getCantidad() - cantidadCompra);

            System.out.println("Producto agregado al carrito con exito.");

            System.out.print("\n¿Desea comprar otro producto? (s/n): ");
            seguirComprando = scanner.next();
            scanner.nextLine();

        } while (seguirComprando.equalsIgnoreCase("s"));

        compra.mostrarResumenCompra();
    }

    public static void realizarFacturacion(Scanner scanner, ProduccionEImportacion produccionEImportacion) {
        if (productosDisponibles.isEmpty()) {
            System.out.println("\nNo hay productos disponibles para facturar.");
            return;
        }

        Facturacion factura = new Facturacion(numeroOrdenActual++);
        String seguirFacturando;
        do {
            System.out.println("\nProductos disponibles para la facturación:");
            for (int i = 0; i < productosDisponibles.size(); i++) {
                TipoProducto producto = productosDisponibles.get(i);
                System.out.println((i + 1) + ". " + producto.getNombre() + " - Precio: Q" + producto.getPrecio() + " - Cantidad disponible: " + producto.getCantidad());
            }

            System.out.print("\nSeleccione el número del producto que desea facturar: ");
            int seleccion = scanner.nextInt();
            scanner.nextLine();

            if (seleccion < 1 || seleccion > productosDisponibles.size()) {
                System.out.println("Selección no válida.");
                return;
            }

            TipoProducto productoSeleccionado = productosDisponibles.get(seleccion - 1);

            System.out.print("Ingrese la cantidad que desea facturar: ");
            int cantidadCompra = scanner.nextInt();

            if (cantidadCompra > productoSeleccionado.getCantidad()) {
                System.out.println("Cantidad no disponible. Solo hay " + productoSeleccionado.getCantidad() + " unidades disponibles.");
                return;
            }

            factura.agregarProducto(productoSeleccionado, cantidadCompra);
            productoSeleccionado.setCantidad(productoSeleccionado.getCantidad() - cantidadCompra);

            System.out.println("Producto agregado a la factura con exito.");

            System.out.print("\n¿Desea facturar otro producto? (s/n): ");
            seguirFacturando = scanner.next();
            scanner.nextLine();

        } while (seguirFacturando.equalsIgnoreCase("s"));

        factura.mostrarFactura(produccionEImportacion);
    }

    public static void modificarProducto(Scanner scanner, ModificacionProductos modificacionProductos) {
        if (productosDisponibles.isEmpty()) {
            System.out.println("\nNo hay productos disponibles para modificar.");
            return;
        }

        System.out.println("\nProductos disponibles para modificar:");
        for (int i = 0; i < productosDisponibles.size(); i++) {
            TipoProducto producto = productosDisponibles.get(i);
            System.out.println((i + 1) + ". " + producto.getNombre());
        }

        System.out.print("\nSeleccione el número del producto que desea modificar: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > productosDisponibles.size()) {
            System.out.println("Selección no válida.");
            return;
        }

        TipoProducto productoSeleccionado = productosDisponibles.get(seleccion - 1);

        modificacionProductos.modificarProducto(scanner, productoSeleccionado);
    }

    public static void establecerEstadosDeProduccion(ProduccionEImportacion produccionEImportacion) {
        for (TipoProducto producto : productosDisponibles) {
            if (producto.getCantidad() > 10) {
                produccionEImportacion.establecerEstadoProducto(producto, "Terminados");
            } else {
                produccionEImportacion.establecerEstadoProducto(producto, "En Produccion");
            }
        }
    }
}
