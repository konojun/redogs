<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
	<meta charset="UTF-8">
</head>
<body>
	<header>
			<li class="homebutton">
				<a href="Home">Re:dogs</a>
			</li>
			<li class="loginbutton">
				<a href="Login">ログイン</a>
			</li>
			<li class="entrybutton">
				<a href="">新規登録</a>
			</li>
	</header>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script>
  	$(function(){
  		$(document).ready(function(){
  				$("header").css("background-color", "rgba(0, 0, 0, 0.0)");
  		});

	  var startPosition = 0
	  var winScrollPosition = 0;

	$(window).scroll(function() {
		// 上スクロール時ヘッダー表示, 下スクロール時ヘッダー非表示
		winScrollPosition = $(this).scrollTop();

		if(winScrollPosition > startPosition){
			$("header").slideUp(100);
			$("a").slideUp(100);
		}else{
			$("header").slideDown(100);
			$("a").slideDown(100);
		}
		if(winScrollPosition == 0){
			$("header").css("background-color", "rgba(0, 0, 0, 0.0)");
		}else{
			$("header").css("background-color", "white");
		}
		startPosition = winScrollPosition;
	});

  });
  </script>
</body>
</html>