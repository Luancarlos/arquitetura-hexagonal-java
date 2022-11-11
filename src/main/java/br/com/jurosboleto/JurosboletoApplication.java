package br.com.jurosboleto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JurosboletoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JurosboletoApplication.class, args);
	}

}
