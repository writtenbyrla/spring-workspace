<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="signIn" method="post">
		아이디 : <input type="text" name="id" required><br>
		비밀번호 : <input type="password" name="pwd" required>
		<input type="submit" value="로그인">
	</form>
</body>
</html>