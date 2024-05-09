<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 조회</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>사원번호</td>
			<td>${ employee.employeeCode }</td>
		</tr>
		<tr>
			<td>부서이름</td>
			<td>${ employee.department.departmentName }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><c:out value="${ employee.phoneNumber }"></c:out></td>
		</tr>
	</table>
	
</body>
</html>