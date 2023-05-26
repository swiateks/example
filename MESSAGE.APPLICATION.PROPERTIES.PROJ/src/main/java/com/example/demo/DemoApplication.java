package com.example.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import com.example.demo.service.Service;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class DemoApplication implements CommandLineRunner {
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(environment.getProperty("welcome")+" ");
		System.out.println(environment.getProperty("msg")+" ");
//		System.out.println(new Integer(128) == new Integer(128));
//		StringBuilder s1 = new StringBuilder("Java");
//		String s2 = "Love";
//		s1.append(s2);
//		s2.substring(4);
//		int found = s1.indexOf(s2);
//		System.out.println(found);
		
	}
}

//public class DemoApplication {
//	public static void main(String[] args) {
//		Service service = null;
//		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(DemoApplication.class, args);
//		service = (Service) context.getBean("service");
//	}
//}
