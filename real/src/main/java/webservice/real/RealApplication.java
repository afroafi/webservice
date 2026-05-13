package webservice.real;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "webservice.real")
public class RealApplication {

	public static void main(String[] args) {

		SpringApplication.run(
				RealApplication.class,
				args
		);
	}
}