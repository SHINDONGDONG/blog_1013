package com.cos.blog_1013.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return "회원가입이 완료";
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public String update(@PathVariable int id,@RequestBody User requestUser) {
		System.out.println("id : " + requestUser.getId());
		System.out.println("name : " + requestUser.getUsername());
		System.out.println("pw : " + requestUser.getPassword());
		System.out.println("em : " + requestUser.getEmail());
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("회원님을 찾을 수 없습니다");
		});
		user.setUsername(requestUser.getUsername());
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		return user.getId() + " 님의 회원정보가 수정 되었습니다.";
	}
	
	@Transactional
	@DeleteMapping("/dummy/user/{id}")
	public String deleteId(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("삭제에 실패 하였습니다 : 이유 + " + e.getMessage());
		}
		return "회원 삭제에 성공 하였습니다";
	}

	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("찾을수없음");
		});
		return user;
	}
	
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2,sort ="id",direction = Sort.Direction.DESC)Pageable page){
		Page<User> users = userRepository.findAll(page); 
		List<User> list = users.getContent();
		return list;
	}
}
