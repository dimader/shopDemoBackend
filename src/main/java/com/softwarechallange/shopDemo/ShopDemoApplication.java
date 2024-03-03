package com.softwarechallange.shopDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Shop Demo Application.
 */
@SpringBootApplication(scanBasePackages = { "com.softwarechallange.shopDemo" })
@EnableJpaRepositories(basePackages = { "com.softwarechallange.shopDemo.repository" })
@EntityScan(basePackages = { "com.softwarechallange.shopDemo.entities" })
public class ShopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopDemoApplication.class, args);
	}
}
