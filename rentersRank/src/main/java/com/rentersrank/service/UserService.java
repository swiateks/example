//package com.rentersrank.service;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//
//import com.rentersrank.entity.User;
//import com.rentersrank.exception.RentersRankException;
//import com.rentersrank.repository.UserRepository;
//
//@Service(value="userService")
//@Transactional
//@Validated
//@PropertySource("classpath:UserMessages.properties")
//public class UserService {
//
////	@Autowired
////	private Environment environment;
//	
//	@Autowired
//	private UserRepository repo;
//	
//	public String addUser(User user) throws RentersRankException {
//		
////		if(repo.findByUsername(user.getUsername())!=null) 
////			throw new RentersRankException("UserService.USERNAME_TAKEN");
//		
//		repo.save(user);
//		
//		return user.getUsername();
//	}
//}
