package com.cos.blog_1013.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog_1013.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
//	User findByUsernameAndPassword(String name,String password);
	User findByUsername(String username);
	
}
