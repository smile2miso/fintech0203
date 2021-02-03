<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login.jsp</title>
	</head>
	<body>
		<jsp:include page="menu.jsp"/>
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">로그인</h1>
			</div>
		</div>
		
		<div class="container" align="center">
			<%-- 부트스트랩 가로는 12등분을 함 --%>
			<div class="col-md-4 col-md-offset-4">
				<h3 class="form-signin-heating">Please Sign In</h3>
				<%
					String error = request.getParameter("error");
					
					// 에러가 있으면
					if(error != null)
					{
						//alert-danger : 색상을 빨강색으로 표시하겠다는 의미
						out.println("<div class='alert alert-danger'>");
						out.println("아이디와 비밀번호를 입력하세요!");
						out.println("</div>");
					}
				%>
				<form class="form-signin" action="processLoginMember.jsp" method="post">
					<div class="form-group">
						<label for="id" class="sr-only">
							User Name
						</label>
						<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="id" id="id" required autofocus/>
					</div>
					<div class="form-group">
						<label for="pw" class="sr-only">
							User Password
						</label>
						<input type="password" class="form-control" name="pw" id="pw" required autofocus/>
					</div>
					<button class="btn btn-lg btn-success btn-block" type="submit">
						로그인
					</button>
				</form>
			</div>
		</div>
	</body>
</html>