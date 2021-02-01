<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="POST">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="password" placeholder="비밀번호">
		<input type="password" name="password2" placeholder="비밀번호 확인">
		<input type="text" name="name" placeholder="이름">
		<input type="email" name="email" placeholder="이메일">
		<input type="submit" value="전송">  
	</form>
</body>
</html>