<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Re:dogs ログイン</title>
<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<meta charset="UTF-8">
</head>
<body>
	<header>
		<ul>
			<li class="homebutton">
				<a class="homeColor" href="Home">Re:dogs&nbsp;</a>
			</li>
		</ul>
	</header>
	<h1>ログイン</h1>
		<form method="post" action="Login">
			<div class="border">
				<c:if test="${!userCheckFlg}">
					<p class="error">※ユーザー名 または パスワードが間違っています</p>
				</c:if>
				<p>&emsp;ユーザーID</p>
				<input type="text" name="userId" value="${formUserId}" class="user" pattern="^[0-9A-Za-z]+$" title="半角英数字で入力して下さい。" required>
				<br>
				<p>&emsp;パスワード</p>
				<input type="password" name="password" class="pass" required>
				<p class="entry"><a href="Create">アカウントをお持ちでない方はこちら</a></p>
				<p><input class="loginsubmit" type="submit" value="ログイン"/></p>
			</div>
		</form>

	<footer>
		<ul class="footer">
			<li><a href="Home">Home</a></li>
			<li>お問い合わせ</li>
		</ul>
	</footer>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
  <script>
  	$(function(){

  	});
  </script>
</body>
</html>