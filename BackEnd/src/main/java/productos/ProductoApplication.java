package productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class ProductoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductoApplication.class, args);
    }

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI().info(new Info()
                            .title("Servicio de Gestión de productos")
                            .description("Servicio creado por González Rojas Alma Cristina y Meza Hernández Emilio"));
    }

    /* Link para ingresar: http://localhost:8081/swagger-ui/index.html#/ */
}


