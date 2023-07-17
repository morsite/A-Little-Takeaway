package com.tk.takeaway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tk.takeaway.mapper")
@SpringBootApplication
public class TakeawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeawayApplication.class, args);
	}

}
