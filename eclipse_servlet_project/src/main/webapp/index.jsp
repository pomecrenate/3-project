<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 게시판</title>
</head>
<body>s
	<u:isLogin>
		${ authUser.name }님, 안녕하세요.
		<a href="logout.do">[로그아웃하기]</a>
		<a href="changePassword.do">[암호 변경하기]</a>
		<a href="article/list.do">[게시판]</a>
	</u:isLogin>
	<u:notLogin>
		<a href="join.do">[회원가입하기]</a>
		<a href="login.do">[로그인하기]</a>
	</u:notLogin>
	<br>
</body>
</html>