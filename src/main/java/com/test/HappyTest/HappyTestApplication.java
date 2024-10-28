package com.test.HappyTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class HappyTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyTestApplication.class, args);
	}
}