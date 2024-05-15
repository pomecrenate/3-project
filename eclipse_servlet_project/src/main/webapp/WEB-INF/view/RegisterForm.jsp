<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録</title>
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
<h2>社員登録</h2>
<form action="register.do" method="post">
    
    <label for="departmentCode">部署</label>
    <select name="departmentCode" required>
        <option value="0">--部署--</option>
        <c:forEach var="department" items="${departments}">
            <option value="${department.key}" ${department.key == param.departmentCode ? 'selected' : ''}>${department.value}</option>
        </c:forEach>
    </select>
    
    <label for="positionCode">職位:</label>
    <select name="positionCode" required>
        <option value="0">--職位--</option>
        <c:forEach var="position" items="${positions}">
            <option value="${position.key}" ${position.key == param.positionCode ? 'selected' : ''}>${position.value}</option>
        </c:forEach>
    </select>
    
    <label for="employeeName">名前:</label>
    <input type="text" id="employeeName" name="employeeName" required>
    
   <label for="employmentType">雇用形態:</label>
<select name="employmentType" required>
    <option value="0">--雇用形態--</option>
    <option value="正社員">正社員</option>
    <option value="契約職">契約職</option>
    <option value="臨時職">臨時職</option>
    <option value="派遣職">派遣職</option>
    <option value="委嘱職">委嘱職</option>
    <option value="日雇い">日雇い</option>
</select>

    
    <label for="address">住所:</label>
    <input type="text" id="address" name="address" required>
    
    <label for="phoneNumber">電話番号:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required>
    
    <label for="email">Eメール:</label>
    <input type="text" id="email" name="email" required>
    
    <label for="birthNumber">生年月日:</label>
    <input type="text" id="birthNumber" name="birthNumber" required>
    
    <label for="residentNumber">住民番号:</label>
    <input type="text" id="residentNumber" name="residentNumber" required>
    
    <label for="hireDate">入社日:</label>
    <input type="date" id="hireDate" name="hireDate" required>
    
    <input type="submit" value="登録">
</form>

</body>
</html>
