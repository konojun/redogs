<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="mainHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Re:dogs 投稿</title>
<link rel="icon" type="image/x-icon" href="img/favicon.JPG">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/submission.css">
</head>
<body>
	<h1>Re:dogs</h1>
	<h2>投稿</h2>
		<div class="submission">
			<form action="Submission" enctype="multipart/form-data" method="post">
				<div>
			        タイトル<br><input class="title" type="text" name="title" required/>
			    </div>
			    <br>
			    <div>
			    	記事<br><textarea class="article" name="article" required ></textarea>
			    </div>
			    <br>
			    <div>
			        <input type="file" name="file" required />
			        <input class="submitBtn" type="submit" value="投稿" />
			    </div>
			</form>
		</div>
</body>
</html>