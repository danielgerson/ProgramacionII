package com.mycompany.ProductoPromocionales;

import java.util.ArrayList;

public class CompraProductos {
    private ArrayList<TipoProducto> productosComprados;
    private ArrayList<Integer> cantidadesCompradas;

    public CompraProductos() {
        productosComprados = new ArrayList<>();
        cantidadesCompradas = new ArrayList<>();
    }

    public void agregarProducto(TipoProducto producto, int cantidad) {
        productosComprados.add(producto);
        cantidadesCompradas.add(cantidad);
    }

    public void mostrarResumenCompra() {
        System.out.println("*** Resumen de Compra ****");
        double total = 0;
        for (int i = 0; i < productosComprados.size(); i++) {
            TipoProducto producto = productosComprados.get(i);
            int cantidad = cantidadesCompradas.get(i);
            double subtotal = producto.getPrecio() * cantidad;
            System.out.println(producto.getNombre() + " - Cantidad: " + cantidad + " - Subtotal: Q" + subtotal);
            total += subtotal;
        }
        System.out.println("Total a pagar: Q" + total);
    }
}
