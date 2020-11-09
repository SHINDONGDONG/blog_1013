<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<form action="/auth/loginProc" method="post">
  <div class="form-group">
    <label for="Username">Username:</label>
    <input type="text" name="username" class="form-control" placeholder="Username" id="username">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
  <a href="/oauth2/authorization/google" class="btn btn-danger">구글 로그인</a>
</form>
</div>
<br />
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
</body>
</html>
