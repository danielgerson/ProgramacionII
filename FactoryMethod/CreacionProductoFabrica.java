public class ProductoElectronicoFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio) {
        return new ProductoElectronico(nombre, precio);
    }
}
