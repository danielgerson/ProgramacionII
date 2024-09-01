package com.mycompany.ProductoPromocionales;

import java.util.Scanner;

public class ModificacionProductos {
    public void modificarProducto(Scanner scanner, TipoProducto producto) {
        System.out.println("*** Modificar Producto ****");
        System.out.println("Producto actual: ");
        producto.mostrarInformacion();

        System.out.println("\nSeleccione el atributo que desea modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Precio");
        System.out.println("3. Cantidad");
        System.out.println("4. Categoría");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                producto.setNombre(nuevoNombre);
                System.out.println("Nombre modificado con éxito.");
                break;
            case 2:
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                producto.setPrecio(nuevoPrecio);
                System.out.println("Precio modificado con éxito.");
                break;
            case 3:
                System.out.print("Nueva cantidad: ");
                int nuevaCantidad = scanner.nextInt();
                producto.setCantidad(nuevaCantidad);
                System.out.println("Cantidad modificada con éxito.");
                break;
            case 4:
                System.out.print("Nueva categoría: ");
                String nuevaCategoria = scanner.nextLine();
                producto.setCategoria(nuevaCategoria);
                System.out.println("Categoría modificada con éxito.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        System.out.println("\nProducto modificado: ");
        producto.mostrarInformacion();
    }
}
