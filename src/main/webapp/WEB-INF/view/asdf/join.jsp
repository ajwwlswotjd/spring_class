<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("msg") != null){ %>
	<script>
		alert("<%= session.getAttribute("msg")  %>");				
	</script>
		<% session.removeAttribute("msg");
	} %>
	<div class="container py-4">
		<h1>회원가입</h1>
		<form method="POST">
			<div class="mb-3">
		    	<label for="userid" class="form-label">아이디 </label>
    			<input type="text" class="form-control" id="userid" name="userid">
  			</div>
  			<div class="mb-3">
				<label for="username" class="form-label">사용자 이름</label>
    			<input type="text" class="form-control" id="username" name="username">
			</div>
  			<div class="mb-3">
    			<label for="password" class="form-label">비밀번호</label>
    			<input type="password" class="form-control" id="password" name="password">
  			</div>
			<div class="mb-3">
				<label for="password_check" class="form-label">비밀번호 확인</label>
    			<input type="password" class="form-control" id="password_check" name="password_check">
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>	
		</form>
	</div>
</body>
</html>