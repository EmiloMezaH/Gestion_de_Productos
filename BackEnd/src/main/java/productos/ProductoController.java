package productos;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200") // o "*" para todos
@RestController
class ProductoController {


    private final ProductoRepository repository;
    private final ProductoModelAssembler assembler;

    ProductoController(ProductoRepository repository, ProductoModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/productos")
    List<Producto> all() {
        return repository.findAll();
    }


    @PostMapping("/productos")
    ResponseEntity<?> newProducto(@RequestBody Producto newProducto) {
        EntityModel<Producto> entityModel = assembler.toModel(repository.save(newProducto));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/productos/{id}")
    EntityModel<Producto> one(@PathVariable int id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));

        return assembler.toModel(producto);
    }

    @PutMapping("/productos/{id}")
    ResponseEntity<?> replaceProducto(@RequestBody Producto newProducto, @PathVariable int id) {
        Producto updatedProducto = repository.findById(id)
                .map(producto -> {
                    producto.setNombre_producto(newProducto.getNombre_producto());
                    producto.setPrecio_unitario(newProducto.getPrecio_unitario());
                    return repository.save(producto);
                })
                .orElseGet(() -> {
                    newProducto.setId_producto(id);
                    return repository.save(newProducto);
                });

        EntityModel<Producto> entityModel = assembler.toModel(updatedProducto);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/productos/{id}")
    ResponseEntity<?> deleteProducto(@PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

