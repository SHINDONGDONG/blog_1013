<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<form>
  <div class="form-group">
  	<input type="hidden" id="id" value="${principal.user.id}">
    <label for="Username">Username:</label>
    <input type="text" class="form-control"  value="${principal.user.username}" id="username" readonly="readonly">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control"  value="${principal.user.email}" id="email">
  </div>
</form>
  <button type="button" id="btn-update" class="btn btn-primary">수정하기</button>
</div>
<br />
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>
