package com.mycompany.ProductoPromocionales;

import java.util.HashMap;

public class ProduccionEImportacion {
    private HashMap<TipoProducto, String> estadoProductos;

    public ProduccionEImportacion() {
        estadoProductos = new HashMap<>();
    }

    public void establecerEstadoProducto(TipoProducto producto, String estado) {
        estadoProductos.put(producto, estado);
    }

    public String obtenerEstadoProducto(TipoProducto producto) {
        return estadoProductos.getOrDefault(producto, "Estado desconocido");
    }

    public void mostrarEstadoProductos(Facturacion factura) {
        System.out.println("**** Estado de Producción e Importación ****");
        for (TipoProducto producto : factura.getProductosComprados()) {
            String estado = obtenerEstadoProducto(producto);
            System.out.println("Producto: " + producto.getNombre() + " - Estado: " + estado);
        }
    }
}
