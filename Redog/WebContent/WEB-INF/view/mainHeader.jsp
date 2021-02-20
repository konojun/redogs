<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainHeader.css">
<meta charset="UTF-8">
</head>
<body>
		<a href="Logout" class="logoutBtn">ログアウト</a>
	<header>
		<div class="menu">
			<div class="top">
			    <label for="menu_bar01">TOP</label>
			    <input type="checkbox" id="menu_bar01" class="accordion" />
			    <ul id="links01">
			        <li><a href="Main">ホーム</a></li>
			    </ul>
		    </div>
		    <div class="post">
		    	<label for="menu_bar02">投稿</label>
		    	<input type="checkbox" id="menu_bar02" class="accordion" />
			    <ul id="links02">
			        <li><a href="Submission">投稿</a></li>
			        <li><a href="SubmissionDetail">過去の投稿</a></li>
			    </ul>
			</div>
			<div class="ranking">
			    <label for="menu_bar03">ランキング</label>
			    <input type="checkbox" id="menu_bar03" class="accordion" />
			    <ul id="links03">
			        <li><a href="">人気ランキング</a></li>
			    </ul>
			</div>
			<div class="friend">
		    <label for="menu_bar04">フレンド</label>
		    <input type="checkbox" id="menu_bar04" class="accordion" />
		    <ul id="links04">
		        <li><a href="">フレンド一覧</a></li>
		    </ul>
		    </div>
		    <div class="profile">
			    <label for="menu_bar05">プロフィール</label>
			    <input type="checkbox" id="menu_bar05" class="accordion" />
			    <ul id="links05">
			        <li><a href="Profile">プロフィール設定</a></li>
			    </ul>
			</div>
		</div>
	</header>
<!--
	<footer>
		<ul class="footer">
			<li>Home</li>
			<li>お問い合わせ</li>
		</ul>
	</footer> -->
</body>
</html>