package com.wifi.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppClientApplication  {

	// 여기가 서버가.. 이 어플리케이션이 실행하는 포인트.
	public static void main(String[] args) {
		SpringApplication.run(AppClientApplication.class, args);
	};
	
}
