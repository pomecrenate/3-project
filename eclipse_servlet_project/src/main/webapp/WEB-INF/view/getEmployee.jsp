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
			<td>사원 번호</td>
			<td>${ employee.employeeCode }</td>
		</tr>
		<tr>
			<td>사원명</td>
			<td>${ employee.employeeName }</td>
		</tr>
		<tr>
			<td>부서명</td>
			<td>${ employee.department.departmentName }</td>
		</tr>
	</table>
</body>
</html>