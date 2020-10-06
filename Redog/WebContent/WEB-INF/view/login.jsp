<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Re:dogs ログイン</title>
<link rel="icon" type="img/x-icon" href="image/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<meta charset="UTF-8">
</head>
<body>


	<h1>ログイン</h1>
	<form method="post" action="Login">
	<div class="border">
		<c:if test="${!inputCheckFlg}">
			<p class="error">※ユーザーID または パスワードを入力してください</p>
		</c:if>
		<c:if test="${!userCheckFlg}">
			<p class="error">※ユーザー名 または パスワードが間違っています</p>
		</c:if>
		<p>&emsp;ユーザーID</p>
		<input type="text" name="userId" value="${form_userId}">
		<br>
		<p>&emsp;パスワード</p>
		<input type="password" name="password">
		<p class="entry"><a href="Entry">アカウントをお持ちでない方は新規登録あなる</a></p>
		<p><input class="loginsubmit" type="submit" value="ログイン"/></p>
	</div>
	</form>
</body>
</html>