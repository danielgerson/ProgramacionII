package com.mycompany.ProductoPromocionales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FacturacionVenta {
    private int idFacVen; 
    private int idVenta;
    private String producto;
    private int cantidad;
    private double precio;

    public void realizarFacturacionVentas() {
        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            // Consulta a la tabla Ventas para obtener información
            ResultSet resultSet = statement.executeQuery("SELECT IdVenta, Producto, Cantidad, Precio FROM Ventas");

            System.out.println("\n=== Lista de Ventas ===");
            while (resultSet.next()) {
                idVenta = resultSet.getInt("IdVenta");
                producto = resultSet.getString("Producto");
                cantidad = resultSet.getInt("Cantidad");
                precio = resultSet.getDouble("Precio");

                System.out.println("ID Venta: " + idVenta + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: $" + precio);
            }

            System.out.print("Seleccione la ID de la venta que desea facturar: ");
            int idSeleccionada = scanner.nextInt();

            // Obtiene los detalles de la venta seleccionada
            resultSet = statement.executeQuery("SELECT IdVenta, Producto, Cantidad, Precio FROM Ventas WHERE IdVenta = " + idSeleccionada);

            // Verifica si se encontró la venta
            if (resultSet.next()) {
                idVenta = resultSet.getInt("IdVenta");
                producto = resultSet.getString("Producto");
                cantidad = resultSet.getInt("Cantidad");
                precio = resultSet.getDouble("Precio");

                // Mostrar información de la venta
                System.out.println("\n=== Información de la Venta Seleccionada ===");
                System.out.println("ID Venta: " + idVenta);
                System.out.println("Producto: " + producto);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Precio: $" + precio);
            } else {
                System.out.println("No se encontró la venta con ID: " + idSeleccionada);
                return; // Salimos del método si no encontramos la venta
            }

            // Validar que no haya valores nulos antes de realizar la inserción
            if (producto == null || producto.isEmpty()) {
                System.out.println("Error: el nombre del producto no puede ser nulo o vacío.");
                return;
            }
            if (precio <= 0) {
                System.out.println("Error: el precio no puede ser nulo o menor o igual a cero.");
                return;
            }
            if (cantidad <= 0) {
                System.out.println("Error: la cantidad no puede ser nula o menor o igual a cero.");
                return;
            }

            // Inserción en la tabla de FacturacionVenta
            String insertQuery = "INSERT INTO FacturacionVenta (IdVenta, Cantidad, Precio, Producto) VALUES ("
                                 + idVenta + ", " + cantidad + ", " + precio + ", '" + producto + "')";
            statement.executeUpdate(insertQuery);
            System.out.println("Facturación realizada con éxito para la venta ID: " + idVenta);

        } catch (SQLException e) {
            System.out.println("Error en la conexión o consulta: " + e.getMessage());
        }
    }
}
