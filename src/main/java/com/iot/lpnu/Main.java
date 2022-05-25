package com.iot.lpnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.iot.lpnu.controller","com.iot.lpnu.services"})
public class Main {

	public static void main(String[] args){
	    SpringApplication.run(Main.class, args);	
	}
}
