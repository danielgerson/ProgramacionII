package com.mycompany.ProductoPromocionales;

public class TipoProducto extends Productos {
    private String categoria;

    public TipoProducto(String codigo, String nombre, double precio, int cantidad, String categoria) {
        super(codigo, nombre, precio, cantidad);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Categoría: " + categoria);
    }
}
