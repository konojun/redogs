<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Re:dogs 新規登録</title>
<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create.css" />
</head>
<body>
	<h1>新規登録</h1>
		<form method="post" action="Create">
		<div>
			<c:if test="${dupFlg}">
				<p class="error">※ユーザIDは既に使用されています。</p>
			</c:if>
			<input type="text" name="userId" value="${userId}" class="userId" pattern="^[0-9A-Za-z]+$" title="半角英数字で入力して下さい。" placeholder="ユーザーID" required  maxlength=11>
			<br>
			<input type="text" name="password" class="pass" placeholder="パスワード" required>
			<br>
			<input type="text" name="nickname" value="${nickname}" class="nickname" placeholder="ニックネーム" required maxlength=20>
			<br>
			<input type="text" name="mailAddress" value="${mailAddress}" class="mail" placeholder="メールアドレス" required>
		</div>
			<input class="entrybutton" type="submit" value="登録"/>
		</form>

		<a href="Home">キャンセル</a>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
  <script>
  	$(function(){

  	});
  </script>
</body>
</html>