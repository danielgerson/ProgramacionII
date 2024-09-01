package com.mycompany.ProductoPromocionales;

import java.util.ArrayList;

public class Facturacion {
    private int numeroOrden;
    private ArrayList<TipoProducto> productosComprados;
    private ArrayList<Integer> cantidadesCompradas;

    public Facturacion(int numeroOrden) {
        this.numeroOrden = numeroOrden;
        productosComprados = new ArrayList<>();
        cantidadesCompradas = new ArrayList<>();
    }

    public void agregarProducto(TipoProducto producto, int cantidad) {
        productosComprados.add(producto);
        cantidadesCompradas.add(cantidad);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < productosComprados.size(); i++) {
            total += productosComprados.get(i).getPrecio() * cantidadesCompradas.get(i);
        }
        return total;
    }

    public void mostrarFactura(ProduccionEImportacion produccionEImportacion) {
        System.out.println("**** Factura ****");
        System.out.println("Número de Orden: " + numeroOrden);
        double total = 0;
        for (int i = 0; i < productosComprados.size(); i++) {
            TipoProducto producto = productosComprados.get(i);
            int cantidad = cantidadesCompradas.get(i);
            double subtotal = producto.getPrecio() * cantidad;
            System.out.println(producto.getNombre() + " - Cantidad: " + cantidad + " - Subtotal: Q" + subtotal);
            total += subtotal;
        }
        System.out.println("Total a pagar: Q" + total);
        produccionEImportacion.mostrarEstadoProductos(this);
    }

    public ArrayList<TipoProducto> getProductosComprados() {
        return productosComprados;
    }
}
