package com.db.tradingstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.db.tradingstore.repository")
@SpringBootApplication
public class TradingstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingstoreApplication.class, args);
	}

}
