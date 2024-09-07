public class ProductoElectronico implements Producto {
    private String nombre;
    private double precio;

    public ProductoElectronico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Producto Electrónico - Nombre: " + nombre + ", Precio: $" + precio);
    }
}
