<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	
	<c:if test="${principal.user.id == board.user.id}">
	<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정하기</a>
	<button id="btn-delete" class="btn btn-danger">삭제하기</button>
	</c:if>
	<br /><br />
	<form>
	<div>
		글번호 : <span id="id">${board.id}</span> 작성자 : <span><i>${board.user.username}</i></span>
	</div>
		<div class="form-group">
			<label for="title">Title</label>
			<h3>${board.title}</h3>
		</div>

		<div class="form-group">
			<label for="content">Description</label>
			<h3>${board.content}</h3>
		</div>
	</form>



</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
