<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	input[type="text"]{
	width: 100%;
	box-sizing: border-box;
	}
	input[type="text"]:focus{
	width: 100%;
	box-sizing: border-box;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../registration" method="post">
	<label for="user">User:</label>
	<input id = "user" type="text" name="name" placeholder="Enter UserName">
		<label for="email">Email:</label>
	<input id = "email" type="text" name="email" placeholder="Enter Email Address">
		<label for="password">Password:</label>
	<input id = "password" type="text" name="password" placeholder="Enter Password">
			<label for="re-password">Re-Enter Password:</label>
	<input id = "re-password" type="text" name="password2" placeholder="Enter Password Again">
	<input type = "submit" placeholder="Sign Ups">
	</form>
</body>
</html>