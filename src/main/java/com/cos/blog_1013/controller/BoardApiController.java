package com.cos.blog_1013.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog_1013.config.auth.PrincipalDetails;
import com.cos.blog_1013.dto.ResponseDTO;
import com.cos.blog_1013.model.Board;
import com.cos.blog_1013.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDTO<Integer> save(@RequestBody Board board,@AuthenticationPrincipal PrincipalDetails principal){
		boardService.save(board,principal.getUser());
		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDTO<Integer> delete(@PathVariable int id){
		System.out.println("게시글삭제");
			boardService.delete(id);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDTO<Integer> update(@PathVariable int id,@RequestBody Board board){
			boardService.modify(id,board);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(),1);
	}
}
