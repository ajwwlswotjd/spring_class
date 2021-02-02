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
	<div class="container">
		
		<div class="card" style="width: 18rem;">
  			<div class="card-body">
    			<h5 class="card-title">유저 정보</h5>
    			<h6 class="card-text">아이디 : ${ user.id }</h6>
    			<p class="card-text">비밀번호 : ${ user.password }</p>
  			</div>	
		</div>
		
	</div>
</body>
</html>