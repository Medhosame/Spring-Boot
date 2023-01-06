package ressource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingdataserviceRectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingdataserviceRectApplication.class, args);
	}

}
