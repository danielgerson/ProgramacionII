public class ProductoRopaFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio) {
        return new ProductoRopa(nombre, precio);
    }
}
