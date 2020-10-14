<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />
<link href="https://fonts.googleapis.com/css2?family=Sansita+Swashed:wght@600&display=swap" rel="stylesheet"><meta charset="UTF-8">
<title>Re:dogs</title>
<style type="text/css">
	h1, h2, h3, h4, h5, h6 { margin-top: 0; margin-bottom: 0 }
	p { margin-top: 0; margin-bottom: 0 }
</style>
</head>
<body>
	<div class="main-background scroll main-img">

	<h1 class="maintitle scroll">Re:dogs</h1>
	<div class="poem">
		<p class="subtitle">&emsp;愛犬との思い出で繋がる。</p>
	</div>
	</div>
	<div class="sub-background">
	<div class="subtitle1 fadein">
	<h2>愛犬との思い出をクラウド上に保存</h2>
		<p>&emsp;&emsp;Re:dogs&nbsp;では、大切な愛犬との思い出をクラウド上に保存することができます。</p>
	</div>

	<div class="subtitle2 fadein">
	<h2>可愛いわんちゃんを全国で共有</h2>
		<p>&emsp;&emsp;Re:dogsでは、自身がアップした愛犬の写真や動画を全国のユーザーに公開することができます。</p>
		<p>&emsp;&emsp;全国の可愛いわんちゃんの写真や動画を共有して癒されましょう！</p>
	</div>
	</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
  <script>
  	$(function(){
  		$(".maintitle").hide();
  		$(".maintitle").fadeIn(1000);

  		 var startPosition = 0
  		  var winScrollPosition = 0;

  		$(window).scroll(function() {
  			// ヘッダーON/OFF
  			winScrollPosition = $(this).scrollTop();

  			if(winScrollPosition > startPosition){
  				$("header").slideUp(100);
  				$("li+a").show("slide", {direction: "down"}, 1000);
  			}else{
  				$("header").slideDown(100);
  				$("li+a").show("slide", {direction: "down"}, 1000);
  			}
  			if(winScrollPosition == 0){
  				$("header").removeClass("headerIn");
  				$("li").find("a").removeClass("bottomColor");
  				$("header").addClass("headerOut");
  				$("li").find("a").addClass("topColor");
  			}else{
  				$("header").removeClass("headerOut");
  				$("li").find("a").removeClass("topColor");
  				$("header").addClass("headerIn");
  				$("li").find("a").addClass("bottomColor");
  			}
  			startPosition = winScrollPosition;


  			/* スクロール時フェードイン */
  			jQuery('.fadein').each(function(){
  	            var targetPosition = $(this).offset().top;
  	            var windowHeight = $(window).height();
  	            if (winScrollPosition > targetPosition - windowHeight + 100){
  	                jQuery(this).addClass('scrollin');
  	            }
  	        });

  		});
  	});
  </script>
</body>
</html>