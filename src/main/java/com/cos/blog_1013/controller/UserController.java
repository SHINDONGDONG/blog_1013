package com.cos.blog_1013.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog_1013.config.auth.PrincipalDetails;

@Controller
public class UserController {

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@GetMapping("/test/login")
	public @ResponseBody String testLogin(Authentication authentication
			,@AuthenticationPrincipal PrincipalDetails userDetails) {
		System.out.println("=====================================");
//		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
//		System.out.println("Authentication : " + principalDetails.getUser());
		System.out.println("authentication : "+ userDetails.getAttributes());
		System.out.println("=====================================");
		return "세션정보확인";
	}
	
}
