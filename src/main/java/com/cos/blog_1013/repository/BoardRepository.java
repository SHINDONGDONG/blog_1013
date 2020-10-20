package com.cos.blog_1013.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog_1013.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
}
