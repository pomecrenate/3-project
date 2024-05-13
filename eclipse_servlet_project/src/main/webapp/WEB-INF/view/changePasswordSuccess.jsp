<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>パスワード変更完了</title>
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

    .container {
        background-color: #ffffff;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .link {
        margin-top: 20px;
    }

    .link a {
        color: #007bff;
        text-decoration: none;
    }

    .link a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <p>パスワードを変更しました。</p>
        <div class="link">
            <a href="login.do">ログインフォームに戻る</a>
        </div>
    </div>
</body>
</html>
