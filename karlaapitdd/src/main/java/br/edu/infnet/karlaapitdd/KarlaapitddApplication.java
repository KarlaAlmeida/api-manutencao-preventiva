package br.edu.infnet.karlaapitdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KarlaapitddApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarlaapitddApplication.class, args);
	}

}
