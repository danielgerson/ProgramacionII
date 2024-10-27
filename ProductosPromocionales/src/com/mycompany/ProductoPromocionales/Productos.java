package com.mycompany.ProductoPromocionales;

public class Productos {
    private int idCompras; 
    private String proveedor;
    private String producto;
    private String categoria;
    private int cantidad; 
    private double precio;

    public Productos(int idCompras, String proveedor, String producto, String categoria, int cantidad, double precio) {
        this.idCompras = idCompras;
        this.proveedor = proveedor;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void mostrarInformacion() {
        System.out.println("ID Compra: " + idCompras);
        System.out.println("Proveedor: " + proveedor);
        System.out.println("Producto: " + producto);
        System.out.println("Categoría: " + categoria);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: Q" + precio);
    }
}

