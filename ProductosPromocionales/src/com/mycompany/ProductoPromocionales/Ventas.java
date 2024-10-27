package com.mycompany.ProductoPromocionales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ventas {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarProductosDisponibles() {
        String query = "SELECT idCompra, Producto, Cantidad, Precio FROM Compras"; 
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("\n=== Productos Disponibles ===");
            while (resultSet.next()) {
                int idCompra = resultSet.getInt("idCompra");
                String producto = resultSet.getString("Producto");
                int cantidad = resultSet.getInt("Cantidad");
                double precio = resultSet.getDouble("Precio");

                System.out.println("ID Compra: " + idCompra + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: $" + precio);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los productos disponibles: " + e.getMessage());
        }
    }

    public void realizarVenta() {
        mostrarProductosDisponibles();

        System.out.print("Ingrese el ID del producto que desea vender: ");
        int idCompraSeleccionada = scanner.nextInt();
        System.out.print("Ingrese la cantidad a vender: ");
        int cantidadAVender = scanner.nextInt();

        String query = "SELECT Producto, Precio, Cantidad FROM Compras WHERE idCompra = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setInt(1, idCompraSeleccionada);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String producto = resultSet.getString("Producto");
                double precio = resultSet.getDouble("Precio");
                int cantidadDisponible = resultSet.getInt("Cantidad");

                if (cantidadAVender > cantidadDisponible) {
                    System.out.println("Error: No hay suficiente cantidad disponible para vender.");
                    return;
                }

               
                String insertQuery = "INSERT INTO Ventas (IdCompra, Producto, Precio, Cantidad) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                    insertStatement.setInt(1, idCompraSeleccionada);
                    insertStatement.setString(2, producto);
                    insertStatement.setDouble(3, precio);
                    insertStatement.setInt(4, cantidadAVender);
                    insertStatement.executeUpdate();
                    System.out.println("Venta realizada con éxito.");
                }
            } else {
                System.out.println("Error: Producto no encontrado con ID: " + idCompraSeleccionada);
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar la venta: " + e.getMessage());
        }
    }
}
