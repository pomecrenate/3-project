<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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

    input[type="text"],
    input[type="password"],
    input[type="submit"],
    .register-link {
        width: 100%;
        padding: 10px 20px;
        margin-top: 5px;
        margin-bottom: 10px;
        border: none;
        border-radius: 4px;
        box-sizing: border-box;
        text-align: center;
        cursor: pointer;
        text-decoration: none;
        display: inline-block;
    }

    input[type="text"],
    input[type="password"] {
        border: 1px solid #ccc;
    }

    input[type="submit"],
    .register-link {
        background-color: #007bff;
        color: white;
    }

    input[type="submit"]:hover,
    .register-link:hover {
        background-color: #0056b3;
    }

    .error {
        color: red;
    }

    .register-link {
        margin-top: 10px;
    }

    .register-link a {
        color: white;
        text-decoration: none;
    }

    .register-link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <form action="login.do" method="post">
        <c:if test="${ errors.idOrPasswordNotMatch }">ユーザー名またはパスワードが一致しません。</c:if>
        <p>
            ユーザー名:<br><input type="text" name="id" value="${ param.id }">
            <c:if test="${ errors.id }"><span class="error">ユーザー名を入力してください。</span></c:if>
        </p>
        <p>
            パスワード:<br><input type="password" name="password">
            <c:if test="${ errors.password }"><span class="error">パスワードを入力してください。</span></c:if>
        </p>
        <input type="submit" value="ログイン">
        <a href="join.do" class="register-link">社員登録</a>
    </form>
</body>
</html>
