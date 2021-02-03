<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>dbConn.jsp</title>
	</head>
	<body>
		<sql:setDataSource
			var="dataSource"
			url="jdbc:oracle:thin:@localhost:1521:orcl"
			driver="oracle.jdbc.driver.OracleDriver"
			user="fintech2"
			password="fintech2"
		/>
	</body>
</html>