<%@page import="auth.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員登録完了</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        text-align: center;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #333;
    }
    p {
        color: #666;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #4caf50;
        color: white;
        text-decoration: none;
        border-radius: 3px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h1>社員登録が完了しました!</h1>
     <a href="getCompany.do">メインページ</a>
</div>
</body>
</html>
