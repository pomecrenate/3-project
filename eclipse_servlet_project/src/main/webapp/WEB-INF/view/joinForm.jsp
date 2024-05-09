<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<p>
			아이디:<br><input type="text" name="id" value="${ param.id }">
			<c:if test="${ errors.id }">아이디를 입력하세요.</c:if>
			<c:if test="${ errors.duplicateId }">이미 사용 중인 아이디입니다.</c:if>
		</p>
		<p>
			이름:<br><input type="text" name="name" value="${ param.name }">
			<c:if test="${ errors.name }">이름을 입력하세요.</c:if>
		</p>
		<p>
			암호:<br><input type="password" name="password">
			<c:if test="${ errors.password }">암호를 입력하세요.</c:if>
		</p>
		<p>
			암호 확인:<br><input type="password" name="confirmPassword">
			<c:if test="${ errors.confirmPassword }">암호를 확인하세요.</c:if>
			<c:if test="${ errors.notMatch }">암호가 일치하지 않습니다.</c:if>
		</p>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>