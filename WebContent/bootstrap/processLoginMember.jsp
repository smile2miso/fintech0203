<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ProcessLoginMember.jsp</title>
	</head>
	<body>
		<%@ include file="dbConn.jsp" %>
		
		<sql:query var="rs" dataSource="${dataSource}">
			select * from member where id=? and password=?
			<sql:param value="<%=id %>"/>
			<sql:param value="<%=pw %>"/>			
		</sql:query>
		<%-- executeQuery() --%>
		<c:if test="${rs.rowCount>0}">
			<%
				//정상 로그인일 경우, 입력받은 id를 세션의 id로 저장!
				session.setAttribute("sessionId", id);
			%>
			<c:redirect url="menu.jsp"/>
		</c:if>
		<c:if test="${rs.rowCount eq 0}">
			<c:redirect url="resultMember.jsp?gubun=LoginError"/>
		</c:if>
	</body>
</html>