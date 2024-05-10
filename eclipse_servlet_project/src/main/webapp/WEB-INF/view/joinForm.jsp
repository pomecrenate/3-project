<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<p>
			아이디:<br> <input type="text" name="id" value="${ param.id }">
			<c:if test="${ errors.id }">아이디를 입력하세요.</c:if>
			<c:if test="${ errors.duplicateId }">이미 사용 중인 아이디입니다.</c:if>
		</p>
		<p>
			이름:<br> <input type="text" name="name" value="${ param.name }">
			<c:if test="${ errors.name }">이름을 입력하세요.</c:if>
		</p>
		<p>
			암호:<br> <input type="password" name="password">
			<c:if test="${ errors.password }">암호를 입력하세요.</c:if>
		</p>
		<p>
			암호 확인:<br> <input type="password" name="confirmPassword">
			<c:if test="${ errors.confirmPassword }">암호를 확인하세요.</c:if>
			<c:if test="${ errors.notMatch }">암호가 일치하지 않습니다.</c:if>
		</p>
		<p>
			회사명:<br> <input type="text" name="companyName"
				value="${joinRequest.companyName}">
			<c:if test="${errors.companyName}">회사명을 입력하세요.</c:if>
		</p>
		<p>
			대표자명:<br> <input type="text" name="ceoName"
				value="${joinRequest.ceoName}">
			<c:if test="${errors.ceoName}">대표자명을 입력하세요.</c:if>
		</p>
		<p>
			사업자 번호:<br> <input type="text" name="businessNumber"
				value="${joinRequest.businessNumber}">
			<c:if test="${errors.businessNumber}">사업자 번호를 입력하세요.</c:if>
		</p>
		<p>
			법인 등록 번호:<br> <input type="text" name="corporateNumber"
				value="${joinRequest.corporateNumber}">
			<c:if test="${errors.corporateNumber}">법인 등록 번호를 입력하세요.</c:if>
		</p>
		<p>
			설립일:<br> <input type="date" name="establishmentDate"
				value="${joinRequest.establishmentDate}" required>
			<c:if test="${errors.establishmentDate}">설립일을 입력하세요.</c:if>
		</p>
		<p>
			업태:<br> <select name="businessTypeCode">
				<option value="0">--업태--</option>
				<c:forEach var="businessType" items="${businessTypes}">
					<option value="${businessType.key}"
						${businessType.key == param.businessTypeCode ? 'selected' : ''}>
						${businessType.value}</option>
				</c:forEach>
			</select>
			<c:if test="${errors.businessTypeCode}">업태를 선택하세요.</c:if>
		</p>
		<p>
			종목:<br> <select name="businessItemCode">
				<option value="0">--종목--</option>
				<c:forEach var="businessItem" items="${businessItems}">
					<option value="${businessItem.key}"
						${businessItem.key == param.businessItemCode ? 'selected' : ''}>
						${businessItem.value}</option>
				</c:forEach>
			</select>
			<c:if test="${errors.businessItemCode}">종목을 선택하세요.</c:if>
		</p>
		<p>
			홈페이지:<br> <input type="text" name="website"
				value="${joinRequest.website}">
			<c:if test="${errors.website}">홈페이지를 입력하세요.</c:if>
		</p>
		<p>
			주소:<br> <input type="text" name="address"
				value="${joinRequest.address}">
			<c:if test="${errors.address}">주소를 입력하세요.</c:if>
		</p>
		<p>
			전화번호:<br> <input type="text" name="phoneNumber"
				value="${joinRequest.phoneNumber}">
			<c:if test="${errors.phoneNumber}">전화번호를 입력하세요.</c:if>
		</p>
		<p>
			팩스 번호:<br> <input type="text" name="faxNumber"
				value="${joinRequest.faxNumber}">
			<c:if test="${errors.faxNumber}">팩스 번호를 입력하세요.</c:if>
		</p>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>