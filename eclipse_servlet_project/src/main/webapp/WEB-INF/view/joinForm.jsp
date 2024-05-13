<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
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
	width: 400px;
}

p {
	margin-bottom: 15px;
}

input[type="text"], input[type="password"], input[type="submit"] {
	width: calc(100% - 22px); /* 너비 조정 */
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

select {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.error {
	color: red;
}
</style>
<style>
.form-container {
	display: flex;
	justify-content: space-between;
}

.form-container .left-column, .form-container .right-column {
	width: 45%; /* 좌우 여백을 주기 위해 45%로 설정합니다. */
}
</style>
</head>
<body>
	<form action="join.do" method="post">
		<div class="form-container">
			<div class="left-column">
				<p>
					ユーザーID：<br> <input type="text" name="id" value="${ param.id }">
					<c:if test="${ errors.id }">
						<span class="error">ユーザーIDを入力してください。</span>
					</c:if>
					<c:if test="${ errors.duplicateId }">すでに使用されているユーザーIDです。</c:if>
				</p>
				<p>
					名前：<br> <input type="text" name="name" value="${ param.name }">
					<c:if test="${ errors.name }">
						<span class="error">名前を入力してください。</span>
					</c:if>
				</p>
				<p>
					パスワード：<br> <input type="password" name="password">
					<c:if test="${ errors.password }">
						<span class="error">パスワードを入力してください。</span>
					</c:if>
				</p>
				<p>
					パスワード確認：<br> <input type="password" name="confirmPassword">
					<c:if test="${ errors.confirmPassword }">
						<span class="error">パスワードを確認してください。</span>
					</c:if>
					<c:if test="${ errors.notMatch }">パスワードが一致しません。</c:if>
				</p>
				<p>
					会社名：<br> <input type="text" name="companyName"
						value="${joinRequest.companyName}">
					<c:if test="${errors.companyName}">会社名を入力してください。</c:if>
				</p>
				<p>
					代表者名：<br> <input type="text" name="ceoName"
						value="${joinRequest.ceoName}">
					<c:if test="${errors.ceoName}">代表者名を入力してください。</c:if>
				</p>
				<p>
					事業者番号：<br> <input type="text" name="businessNumber"
						value="${joinRequest.businessNumber}">
					<c:if test="${errors.businessNumber}">事業者番号を入力してください。</c:if>
				</p>
				<p>
					法人登録番号：<br> <input type="text" name="corporateNumber"
						value="${joinRequest.corporateNumber}">
					<c:if test="${errors.corporateNumber}">法人登録番号を入力してください。</c:if>
				</p>
			</div>
			<div class="right-column">
				<p>
					設立日：<br> <input type="date" name="establishmentDate"
						value="${joinRequest.establishmentDate}" required>
					<c:if test="${errors.establishmentDate}">設立日を入力してください。</c:if>
				</p>
				<p>
					業種：<br> <select name="businessTypeCode">
						<option value="0">--業種--</option>
						<c:forEach var="businessType" items="${businessTypes}">
							<option value="${businessType.key}"
								${businessType.key == param.businessTypeCode ? 'selected' : ''}>
								${businessType.value}</option>
						</c:forEach>
					</select>
					<c:if test="${errors.businessTypeCode}">業種を選択してください。</c:if>
				</p>
				<p>
					事業内容：<br> <select name="businessItemCode">
						<option value="0">--事業内容--</option>
						<c:forEach var="businessItem" items="${businessItems}">
							<option value="${businessItem.key}"
								${businessItem.key == param.businessItemCode ? 'selected' : ''}>
								${businessItem.value}</option>
						</c:forEach>
					</select>
					<c:if test="${errors.businessItemCode}">事業内容を選択してください。</c:if>
				</p>
				<p>
					ウェブサイト：<br> <input type="text" name="website"
						value="${joinRequest.website}">
					<c:if test="${errors.website}">ウェブサイトを入力してください。</c:if>
				</p>
				<p>
					住所：<br> <input type="text" name="address"
						value="${joinRequest.address}">
					<c:if test="${errors.address}">住所を入力してください。</c:if>
				</p>
				<p>
					電話番号：<br> <input type="text" name="phoneNumber"
						value="${joinRequest.phoneNumber}">
					<c:if test="${errors.phoneNumber}">電話番号を入力してください。</c:if>
				</p>
				<p>
					FAX番号：<br> <input type="text" name="faxNumber"
						value="${joinRequest.faxNumber}">
					<c:if test="${errors.faxNumber}">FAX番号を入力してください。</c:if>
				</p>
			</div>
		</div>
		<input type="submit" value="登録">
	</form>
</body>
</html>
