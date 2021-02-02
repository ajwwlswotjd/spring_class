<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("login_msg") != null){ %>
	<script>
		alert("<%= session.getAttribute("login_msg")  %>");				
	</script>
		<% session.removeAttribute("login_msg");
	} %>
	<form method="POST">
		<input type="text" placeholder="아이디" name="id">
		<input type="password" placeholder="비밀번호" name="password">
		<input type="submit" value="전송">
	</form>
</body>
</html>