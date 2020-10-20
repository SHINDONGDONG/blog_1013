package com.cos.blog_1013.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog_1013.model.User;
import com.cos.blog_1013.repository.UserRepository;

@Service
public class PrincipalService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("+****************username : " +username);
		User principal = userRepository.findByUsername(username).orElseThrow(()->{
			return new UsernameNotFoundException("유저 아이디를 찾지 못하였습니다." +  username);
		});
		
		return new PrincipalDetails(principal);
	}

}
