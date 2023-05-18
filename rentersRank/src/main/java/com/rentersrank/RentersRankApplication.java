package com.rentersrank;


import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rentersrank.dto.LandlordDTO;
import com.rentersrank.repository.LandlordRepository;
import com.rentersrank.repository.RenterRepository;
import com.rentersrank.service.LandlordService;
import com.rentersrank.service.RenterService;
import com.rentersrank.service.RenterServiceImpl;

import java.util.*;
//below added
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class RentersRankApplication {
	
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(RentersRankApplication.class, args);
		
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
