package productos;

class ProductoNotFoundException extends RuntimeException {

    ProductoNotFoundException(int id) {
        super("No se pudo encontrar el producto con id: " + id);
    }
}
