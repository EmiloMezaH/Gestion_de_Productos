# Productos - Backend 
Este servicio implementa el backend para la gestión de productos utilizando Spring Boot. Proporciona servicios REST.  

Los Endpoints principales son: 
1. GET/productos - Recupera la lista completa de productos registrados. 
2. GET/productos/{id} - Obtener un producto en específico por medio de su id
3. POST/productos - Crea un nuevo producto 
4. PUT/productos/{id} - Modificar y actualizar un producto ya existente por el id 
5. DELETE/facturas/{id} - Eliminar un producto por medio de id 

## Tecnologías utilizadas

- Java
- Spring web
- Spring Data JPA
- H2 Database
- MYSQL como la base de datos
- Postman para pruebas 

## Estructura general
- Producto.java: Entidad principal que representa un producto. Contiene atributos como: id_producto, nombre_producto y precio_unitario.
- ProductoController.java: Controlador REST que maneja todas las solicitudes relacionadas con productos.
- ProductoRepository.java: Interfaz que extiende JpaRepository, proporcionando acceso a la base de datos para operaciones CRUD.
- ProductoModelAssembler.java: Clase que convierte instancias de Producto, facilitando la navegación entre recursos en las respuestas API.
- ProductoNotFoundException.java y ProductoNotFoundAdvice.java: Manejo de excepciones que capturan errores cuando un producto no es encontrado.
- ProductosApplication.java
Clase principal para ejecutar la aplicación de Spring Boot.
- LoadDatabase.java : Carga de datos para probar el servicio en Postman.