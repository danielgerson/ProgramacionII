public class ProductoRopa implements Producto {
    private String nombre;
    private double precio;

    public ProductoRopa(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Producto de Ropa - Nombre: " + nombre + ", Precio: $" + precio);
    }
}
