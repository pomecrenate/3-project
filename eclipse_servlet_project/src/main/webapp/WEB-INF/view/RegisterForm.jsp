<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }
    h2 {
        color: #333;
        text-align: center;
        margin-top: 20px;
    }
    form {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        margin: 20px auto;
    }
    label {
        font-weight: bold;
        margin-bottom: 5px;
    }
    input[type="text"],
    input[type="date"],
    select {
        width: 100%;
        padding: 10px;
        margin: 5px 0 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>


</head>
<body>
<h2>사원 등록</h2>
<form action="register.do" method="post">
    
    <label for="departmentCode">부서 코드:</label>
    <select name="departmentCode" required>
        <option value="0">--부서 코드--</option>
        <c:forEach var="department" items="${departments}">
            <option value="${department.key}" ${department.key == param.departmentCode ? 'selected' : ''}>${department.value}</option>
        </c:forEach>
    </select>
    
    <label for="positionCode">직위 코드:</label>
    <select name="positionCode" required>
        <option value="0">--직위 코드--</option>
        <c:forEach var="position" items="${positions}">
            <option value="${position.key}" ${position.key == param.positionCode ? 'selected' : ''}>${position.value}</option>
        </c:forEach>
    </select>
    
    <label for="employeeName">이름:</label>
    <input type="text" id="employeeName" name="employeeName" required>
    
   <label for="employmentType">고용 형태:</label>
<select name="employmentType" required>
    <option value="0">--고용 형태--</option>
    <option value="정규직">정규직</option>
    <option value="계약직">계약직</option>
    <option value="임시직">임시직</option>
    <option value="파견직">파견직</option>
    <option value="위촉직">위촉직</option>
    <option value="일용직">일용직</option>
</select>

    
    <label for="address">주소:</label>
    <input type="text" id="address" name="address" required>
    
    <label for="phoneNumber">전화번호:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required>
    
    <label for="email">이메일:</label>
    <input type="text" id="email" name="email" required>
    
    <label for="birthNumber">생년월일:</label>
    <input type="text" id="birthNumber" name="birthNumber" required>
    
    <label for="residentNumber">주민번호:</label>
    <input type="text" id="residentNumber" name="residentNumber" required>
    
    <label for="hireDate">입사일:</label>
    <input type="date" id="hireDate" name="hireDate" required>
    
    <input type="submit" value="등록">
</form>

</body>
</html>
