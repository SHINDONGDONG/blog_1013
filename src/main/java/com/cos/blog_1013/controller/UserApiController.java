package com.cos.blog_1013.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog_1013.dto.ResponseDTO;
import com.cos.blog_1013.model.RoleType;
import com.cos.blog_1013.model.User;
import com.cos.blog_1013.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

	@Transactional
	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		System.out.println("user api save 호출함");
		user.setRole(RoleType.USER);
		userService.save(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/user")
	public ResponseDTO<Integer> update(@RequestBody User user){
		System.out.println("user api update 호출함");
		userService.updateUser(user);
		
		Authentication authentication = authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
		
	}

//	@PostMapping("/api/user/login")
//	public ResponseDTO<Integer> login(@RequestBody User user, HttpSession session) {
//		System.out.println("user api login 호출함");
//		User principal = userService.login(user);
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
//	}

}
