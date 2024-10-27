package com.mycompany.ProductoPromocionales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=ProductosPromocionales;encrypt=true;trustServerCertificate=true"; // O usa encrypt=false si estás en desarrollo
    private static final String USER = "sa";
    private static final String PASSWORD = "lab1med";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
