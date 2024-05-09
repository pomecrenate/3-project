<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="value" type="java.lang.String" required="true"%>
<% // 사용자가 입력한 특수문자가 제대로 출력되도록 치환하는 커스텀 태그
	value = value.replace("&", "&amp;");
	value = value.replace("<", "&lt;");
	value = value.replace(" ", "&nbsp;");
	value = value.replace("\n", "\n<br>");
%>
<%= value %>