package com.github.acticfox.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class DubboServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboServerApplication.class, args);
	}


}
