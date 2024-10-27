package com.mycompany.ProductoPromocionales;

import java.util.Scanner;

public class MainTienda {
    private Scanner scanner;

    public MainTienda() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Menú Tienda ===");
            System.out.println("1. Realizar Compra");
            System.out.println("2. Realizar Venta");
            System.out.println("3. Realizar Facturación de Compras");
            System.out.println("4. Realizar Facturación de Ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarCompra();
                    break;
                case 2:
                    realizarVenta();
                    break;
                case 3:
                    realizarFacturacionCompras();
                    break;
                case 4:
                    realizarFacturacionVentas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema, Hasta Pronto");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }

    private void realizarCompra() {
        CompraProductos compraProductos = new CompraProductos();
        compraProductos.agregarCompra();
    }

    private void realizarVenta() {
        Ventas ventas = new Ventas();
        ventas.realizarVenta();
    }

    private void realizarFacturacionCompras() {
        Facturacion facturacion = new Facturacion();
        facturacion.realizarFacturacion();
    }

    private void realizarFacturacionVentas() {
        FacturacionVenta facturacionVenta = new FacturacionVenta();
        facturacionVenta.realizarFacturacionVentas();
    }

    public static void main(String[] args) {
        MainTienda menu = new MainTienda();
        menu.mostrarMenu();
    }
}
