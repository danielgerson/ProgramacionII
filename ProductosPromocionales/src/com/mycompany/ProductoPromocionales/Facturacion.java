package com.mycompany.ProductoPromocionales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Facturacion {
	public void realizarFacturacion() {
	    Scanner scanner = new Scanner(System.in);

	    try {
	        Connection connection = DatabaseConnection.getConnection();
	        Statement statement = connection.createStatement();

	        // Consulta a la tabla Compras para obtener IdCompra, Producto, Cantidad y Precio
	        ResultSet resultSet = statement.executeQuery("SELECT IdCompra, Producto, Cantidad, Precio FROM Compras");

	        System.out.println("\n=== Lista de Compras ===");
	        while (resultSet.next()) {
	            int idCompra = resultSet.getInt("IdCompra");
	            String producto = resultSet.getString("Producto");
	            int cantidad = resultSet.getInt("Cantidad");
	            double precio = resultSet.getDouble("Precio");

	            System.out.println("ID Compra: " + idCompra + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: Q" + precio);
	        }

	        System.out.print("Seleccione la ID de la compra que desea facturar: ");
	        int idSeleccionada = scanner.nextInt();

	        // Obtiene los detalles de la compra seleccionada
	        resultSet = statement.executeQuery("SELECT IdCompra, Producto, Cantidad, Precio FROM Compras WHERE IdCompra = " + idSeleccionada);
	        
	        // Verifica si se encontró la compra
	        if (resultSet.next()) {
	            // Información de la compra seleccionada
	            int idCompra = resultSet.getInt("IdCompra");
	            String nombreProducto = resultSet.getString("Producto");
	            int cantidadSeleccionada = resultSet.getInt("Cantidad");
	            double precioSeleccionado = resultSet.getDouble("Precio");

	            // Mostrar información de la compra
	            System.out.println("\n=== Información de la Compra Seleccionada ===");
	            System.out.println("ID Compra: " + idCompra);
	            System.out.println("Producto: " + nombreProducto);
	            System.out.println("Cantidad: " + cantidadSeleccionada);
	            System.out.println("Precio: Q" + precioSeleccionado);

	            // Validar que no haya valores nulos o incorrectos
	            if (nombreProducto == null || nombreProducto.isEmpty()) {
	                System.out.println("Error: el nombre del producto no puede ser nulo o vacío.");
	                return;
	            }
	            if (precioSeleccionado <= 0) {
	                System.out.println("Error: el precio no puede ser nulo o menor o igual a cero.");
	                return;
	            }
	            if (cantidadSeleccionada <= 0) {
	                System.out.println("Error: la cantidad no puede ser nula o menor o igual a cero.");
	                return;
	            }

	            // Inserción en la tabla de Facturacion
	            String insertQuery = "INSERT INTO Facturacion (IdCompra, Producto, Precio, Cantidad) VALUES ("
	                                 + idSeleccionada + ", '" + nombreProducto + "', " + precioSeleccionado + ", " + cantidadSeleccionada + ")";
	            statement.executeUpdate(insertQuery);
	            System.out.println("Facturación realizada con éxito para la compra ID: " + idSeleccionada);
	        } else {
	            System.out.println("No se encontró la compra con ID: " + idSeleccionada);
	        }

	    } catch (SQLException e) {
	        System.out.println("Error en la conexión o consulta: " + e.getMessage());
	    }
	}


}
