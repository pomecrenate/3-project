<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: #ffffff;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    p {
        margin-bottom: 15px;
    }

    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    .error {
        color: red;
    }
</style>
</head>
<body>
    <form action="changePassword.do" method="post">
        <p>
            現在のパスワード:<br><input type="password" name="currentPassword">
            <c:if test="${ errors.currentPassword }"><span class="error">現在のパスワードを入力してください。</span></c:if>
            <c:if test="${ errors.invalidPassword }"><span class="error">現在のパスワードが一致しません。</span></c:if>
        </p>
        <p>
            新しいパスワード:<br><input type="password" name="newPassword">
            <c:if test="${ errors.newPassword }"><span class="error">新しいパスワードを入力してください。</span></c:if>
        </p>
        <input type="submit" value="パスワード変更">
    </form>
</body>
</html>
