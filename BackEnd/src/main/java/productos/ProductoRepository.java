package productos;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
