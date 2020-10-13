package com.cos.blog_1013.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog_1013.model.RoleType;
import com.cos.blog_1013.model.User;
import com.cos.blog_1013.repository.UserRepository;

@RestController
public class DummyTestController {

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("Date : " + user.getCreateDate());
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료";
		
	}

	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("찾을수없음");
		});
		return user;
	}
	
}
