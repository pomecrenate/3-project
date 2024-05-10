<%@ tag body-content="scriptless" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<% // 세션이 없거나 로그인 성공 인증이 없으면 body를 실행하는 커스텀 태그
	HttpSession httpSession = request.getSession(false);
	if (httpSession == null || httpSession.getAttribute("authUser") == null) {
%>
<jsp:doBody />
<%
	}
%>