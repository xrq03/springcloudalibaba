package ruida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EntityScan("com.ruida.domain")
@SpringBootApplication
@EnableDiscoveryClient
public class ProductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class);
    }
}
