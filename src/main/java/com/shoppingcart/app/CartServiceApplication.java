package com.shoppingcart.app;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages= {"com.shoppingcart.app"})
@EntityScan(basePackages = { "com.shoppingcart.app" })
@EnableTransactionManagement
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}
	
	@Value("$app.url")
	private static String appURL;

 
	 @Bean
	    ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
}
