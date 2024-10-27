package com.mycompany.ProductoPromocionales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CompraProductos {
    private Scanner scanner;

    public CompraProductos() {
        this.scanner = new Scanner(System.in);
    }

    public void agregarCompra() {
        System.out.print("Ingrese el nombre del producto: ");
        String producto = scanner.nextLine();

        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese el nombre del proveedor: ");
        String proveedor = scanner.next();

        String insertQuery = "INSERT INTO Compras (Producto, Proveedor, Cantidad, Precio) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, producto);
            preparedStatement.setString(2, proveedor);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.setDouble(4, precio);
            
            preparedStatement.executeUpdate();
            System.out.println("Compra agregada con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la compra a la base de datos: " + e.getMessage());
        }
    }
}
