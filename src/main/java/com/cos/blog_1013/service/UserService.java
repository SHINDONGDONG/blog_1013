package com.cos.blog_1013.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog_1013.model.RoleType;
import com.cos.blog_1013.model.User;
import com.cos.blog_1013.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public void save(User user) {
		String encPass = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encPass);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	@Transactional(readOnly = true)
	public User findUser(String username) {
		User user = userRepository.findByUsername(username).orElseGet(()->{
			return new User();
		});
		return user;
	}
//	@Transactional(readOnly = true)
//	public User login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//	}
	
	@Transactional
	public void updateUser(User requestUser) {
		User user = userRepository.findById(requestUser.getId()).orElseThrow(()->{
			return new IllegalArgumentException("유저를 찾지못하여 수정에 실패함");
		});
		String rawPass = requestUser.getPassword();
		String encPass = bCryptPasswordEncoder.encode(rawPass);
		user.setPassword(encPass);
		user.setEmail(requestUser.getEmail());
	}
	
}
