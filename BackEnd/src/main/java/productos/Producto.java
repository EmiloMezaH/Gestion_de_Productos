package productos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Producto {

    private @Id @GeneratedValue int id_producto;
    private String nombre_producto;
    private double precio_unitario;

    Producto() {}

    Producto(String nombre_producto, double precio_unitario) {
        this.nombre_producto = nombre_producto;
        this.precio_unitario = precio_unitario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return id_producto == producto.id_producto &&
                Double.compare(producto.precio_unitario, precio_unitario) == 0 &&
                Objects.equals(nombre_producto, producto.nombre_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_producto, nombre_producto, precio_unitario);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", nombre_producto='" + nombre_producto + '\'' +
                ", precio_unitario=" + precio_unitario +
                '}';
    }
}

