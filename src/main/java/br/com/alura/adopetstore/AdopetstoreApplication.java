package br.com.alura.adopetstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AdopetstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopetstoreApplication.class, args);
	}

}
